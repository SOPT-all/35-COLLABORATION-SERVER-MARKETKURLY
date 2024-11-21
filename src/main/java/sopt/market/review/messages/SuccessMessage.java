package sopt.market.review.messages;

public enum SuccessMessage {

    GET_REVIEWS("리뷰 불러오기 성공");

    SuccessMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
