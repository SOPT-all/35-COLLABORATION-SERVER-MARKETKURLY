package sopt.market.like.message;

public enum SuccessMessage {

    ADD_INTEREST("찜 목록에 추가 성공"),
    DELETE_INTEREST("찜 목록 제거 성공"),
    GET_INTERESTS("찜 목록 불러오기 성공")
    ;

    SuccessMessage(final String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
