package br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model.Permission;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model.User;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.PermissionRepository;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	private PermissionRepository permissionRepository;
	
	public User save(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setPermissions(addCommonUserPermissions());
		return userRepository.save(user);
	}
	
	public List<Permission> addCommonUserPermissions(){
		List<Permission> permissions = new ArrayList<>();
		permissions.add(permissionRepository.findById(1L).get());
		permissions.add(permissionRepository.findById(3L).get());
		permissions.add(permissionRepository.findById(4L).get());
		permissions.add(permissionRepository.findById(5L).get());
		permissions.add(permissionRepository.findById(6L).get());
		return permissions;
	}
	
	public User update(Long id, User user) {
		User userSaved = findUserById(id);
		BeanUtils.copyProperties(user, userSaved, "id");
		return userRepository.save(userSaved);
	}

	public void updateActiveProperty(Long id, Boolean active) {
		User userSaved = findUserById(id);
		userSaved.setActive(active);
		userRepository.save(userSaved);
	}
	
	public User findUserById(Long id) {
		User userSaved = userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return userSaved;
	}

}




