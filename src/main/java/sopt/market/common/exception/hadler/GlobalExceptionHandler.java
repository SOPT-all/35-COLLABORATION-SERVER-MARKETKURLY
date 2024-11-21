package sopt.market.common.exception.hadler;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import sopt.market.common.dto.BaseResponse;
import sopt.market.common.dto.ErrorResponse;
import sopt.market.common.exception.errorcode.ErrorCode;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<BaseResponse> Exception(Exception exception) {
        logger.log(Level.WARNING,exception.getMessage());
        ErrorCode errorCode = ErrorCode.SERVER_ERROR;
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<BaseResponse> handleMethodNotAllowed(HttpRequestMethodNotSupportedException exception) {
        logger.log(Level.WARNING,exception.getMessage());
        ErrorCode errorCode = ErrorCode.METHOD_NOT_ALLOWED;
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<BaseResponse> handleNullPointer(NullPointerException exception) {
        logger.log(Level.WARNING,exception.getMessage());
        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<BaseResponse> handleNotFound(ChangeSetPersister.NotFoundException exception) {
        logger.log(Level.WARNING,exception.getMessage());
        ErrorCode errorCode = ErrorCode.NOT_FOUND;
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }

}
