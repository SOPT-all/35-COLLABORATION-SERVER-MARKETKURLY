package sopt.market.review.messages;

public enum successMessage {

    GET_REVIEWS("리뷰 불러오기 성공");

    successMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
