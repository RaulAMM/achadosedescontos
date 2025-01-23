package br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.cupom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model.Cupom;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.filter.CupomFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CupomRepositoryImpl implements CupomRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Cupom> filter(CupomFilter cupomFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cupom> criteria = builder.createQuery(Cupom.class);
		Root<Cupom> root = criteria.from(Cupom.class);
		
		Predicate[] predicates = createConstraints(cupomFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Cupom> query = manager.createQuery(criteria);
		addPaginationConstraints(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, totalPages(cupomFilter));
	}

	private Predicate[] createConstraints(CupomFilter cupomFilter, CriteriaBuilder builder, Root<Cupom> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(cupomFilter.getUser() != null) {
			predicates.add(builder.equal(
					root.get("user"), cupomFilter.getUser()));
		}
		
		if(cupomFilter.getType() != null) {
			predicates.add(builder.equal(
					root.get("tipo"), cupomFilter.getType())); 
		}
		
		if(cupomFilter.getTitle() != null && !cupomFilter.getTitle().isEmpty()) {
			predicates.add(
					builder.like(root.get("titulo"), "%" + cupomFilter.getTitle() + "%"));
		}
		
		if (cupomFilter.getStartDate() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get("dataInicial"), cupomFilter.getStartDate())); // Mudança para "dataInicial"
		}
		
		if (cupomFilter.getExpirationDate() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get("dataFinal"), cupomFilter.getExpirationDate())); // Mudança para "dataFinal"
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void addPaginationConstraints(TypedQuery<Cupom> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRecordsPerPage = pageable.getPageSize();
		int firstPageRecord = currentPage * totalRecordsPerPage;
		
		query.setFirstResult(firstPageRecord);
		query.setMaxResults(totalRecordsPerPage);
	}
	
	private Long totalPages(CupomFilter cupomFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Cupom> root = criteria.from(Cupom.class);
		
		Predicate[] predicates = createConstraints(cupomFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
