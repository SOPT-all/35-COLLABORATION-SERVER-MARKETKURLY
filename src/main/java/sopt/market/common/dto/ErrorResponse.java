package sopt.market.common.dto;

import sopt.market.common.util.NullValidator;

public record ErrorResponse(
	Integer status,
	boolean success,
	String message
) implements BaseResponse {

	public static ErrorResponse of(final Integer status, final String message) {
		NullValidator.valid(message);
		return new ErrorResponse(status, false, message);
	}
}
