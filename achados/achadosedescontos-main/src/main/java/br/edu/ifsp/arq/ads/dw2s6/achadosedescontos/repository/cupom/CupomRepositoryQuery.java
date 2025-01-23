package br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.cupom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model.Cupom;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.filter.CupomFilter;

public interface CupomRepositoryQuery {
	
	Page<Cupom> filter(CupomFilter cupomFilter, Pageable pageable);

}
