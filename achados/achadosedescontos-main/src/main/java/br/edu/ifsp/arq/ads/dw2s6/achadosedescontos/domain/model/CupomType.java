package br.edu.ifsp.arq.ads.dw2s6.achadosedescontos.domain.model;

public enum CupomType {

    DESCONTO("Desconto"),
    FRETE_GRATIS("Frete Grátis"),
    CASHBACK("Cashback"),
    PROMOCAO("Promoção");

    private String type;

    CupomType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
