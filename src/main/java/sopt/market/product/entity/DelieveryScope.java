package sopt.market.product.entity;

public enum DelieveryScope {
    EXPRESS("express"),
    NORMAL("normal");

    private final String delieveryType;

    DelieveryScope(final String delieveryType){
        this.delieveryType = delieveryType;
    }
}
