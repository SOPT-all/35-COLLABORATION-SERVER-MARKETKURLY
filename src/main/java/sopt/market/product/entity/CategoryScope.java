package sopt.market.product.entity;

public enum CategoryScope {
    DairyProduct("diaryProduct"), //유제품
    Convenience("convenience"), //간편식.밀키트.샐러드
    FruitsNutsRice("fruitsNutsRice"), //과일.견과.쌀
    SnacksRicecakes("snacksRicecakes"); //간식.과자.떡

    private final String category;

    CategoryScope(final String category){
        this.category = category;
    }
}
