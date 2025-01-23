package br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model.Cupom;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.CupomRepository;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.filter.CupomFilter;

@Service
public class CupomService {
	
	@Autowired
	private CupomRepository cupomRepository;
	
	public Cupom save(Cupom cupom) {
		cupom.setTitle(cupom.getTitle());
		cupom.setId(cupom.getId());
		return cupomRepository.save(cupom);
	}
	
	public Cupom update(Long id, Cupom cupom) {
		Cupom cupomSaved = findCupomById(id);
		BeanUtils.copyProperties(cupom, cupomSaved, "id");
		return cupomRepository.save(cupomSaved);
	}
	
	public Cupom findCupomById(Long id) {
		Cupom cupomSaved = cupomRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return cupomSaved;
	}

	public Page<Cupom> search(CupomFilter cupomFilter, Pageable pageable){
		return cupomRepository.filter(cupomFilter, pageable);
	}
}
