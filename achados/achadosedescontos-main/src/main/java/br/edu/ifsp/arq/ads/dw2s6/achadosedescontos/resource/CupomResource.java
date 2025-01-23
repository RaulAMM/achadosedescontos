package br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model.Cupom;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.CupomRepository;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.filter.CupomFilter;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.service.CupomService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cupom")
public class CupomResource {

	@Autowired
	private CupomRepository cupomRepository;
	
	@Autowired
	private CupomService cupomService;	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_CUPOM') and hasAuthority('SCOPE_read')")
	public Page<Cupom> search(CupomFilter cupomFilter, Pageable pageable){
		return cupomService.search(cupomFilter, pageable);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_CUPOM') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Cupom> findById(@PathVariable Long id) {
		Optional<Cupom> cupom = cupomRepository.findById(id);
		if(cupom.isPresent()) {
			return ResponseEntity.ok(cupom.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_CUPOM') and hasAuthority('SCOPE_write')")
	public Cupom create(@Valid @RequestBody Cupom cupom) {
		return cupomService.save(cupom);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_CUPOM') and hasAuthority('SCOPE_write')")
	public void delete(@PathVariable Long id) {
		cupomRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_CUPOM') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Cupom> update(@PathVariable Long id, @Valid @RequestBody Cupom cupom) {
		Cupom cupomSaved = cupomService.update(id, cupom);
		return ResponseEntity.ok(cupomSaved);
	}
	
}
