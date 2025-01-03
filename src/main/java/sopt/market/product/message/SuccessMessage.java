package sopt.market.product.message;

public enum SuccessMessage {
    GET_MAINDATAS("메인 화면 데이터 불러오기 성공"),
    GET_DETAILDATAS("상품 상세 데이터 불러오기 성공");

    SuccessMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
