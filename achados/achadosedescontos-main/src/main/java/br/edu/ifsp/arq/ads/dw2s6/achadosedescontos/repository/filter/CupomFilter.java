package br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model.CupomType;
import br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class CupomFilter {
    
    private User user;
    
    @Enumerated(EnumType.STRING)
    private CupomType type;  // Altere para CouponType se for necessário para o tipo de cupom
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate; // Altere o nome de 'initialDate' para 'startDate' para refletir melhor o início da validade
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;  // Alterei para 'expirationDate' para refletir a validade do cupom
    
    private String title; // Caso queira filtrar por título do cupom

    public CupomType getType() {
        return type;
    }

    public void setType(CupomType type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
