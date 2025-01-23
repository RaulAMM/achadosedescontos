package br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model.Cupom;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.cupom.CupomRepositoryQuery;

public interface CupomRepository extends JpaRepository<Cupom, Long>, CupomRepositoryQuery {


}
