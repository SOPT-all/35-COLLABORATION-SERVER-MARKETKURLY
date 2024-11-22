package sopt.market.common.exception.errorcode;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메서드입니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "요청한 리소스를 찾을 수 없습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.");

    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus status, String message){
        this.httpStatus = status;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
