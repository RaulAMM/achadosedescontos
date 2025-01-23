package br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cupom")
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(name = "title", unique = true)
    private String title;

    @NotNull
    @Column(name = "expiration_date")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate expirationDate;

    @NotNull
    private Double discount_value;

    @NotNull
    private String link;
    
    @NotNull
    private User user_id;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
		this.id = id;
	}

    public LocalDate getDataExpiracao() {
        return expirationDate;
    }

    public void setDataExpiracao(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getDiscount_value() {
		return discount_value;
	}

	public void setDiscount_value(Double discount_value) {
		this.discount_value = discount_value;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	

	@Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cupom other = (Cupom) obj;
        return Objects.equals(id, other.id);
    }
}
