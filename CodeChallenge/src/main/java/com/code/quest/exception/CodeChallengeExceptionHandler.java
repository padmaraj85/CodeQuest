package com.code.quest.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.code.quest.ui.model.response.ErrorMessage;

@ControllerAdvice
public class CodeChallengeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		String errorMsgDesc = ex.getLocalizedMessage();
		if (errorMsgDesc == null)
			errorMsgDesc = ex.toString();
		logger.error(ex.getMessage(), ex);
		ErrorMessage errMsg = new ErrorMessage(new Date(), errorMsgDesc);

		return new ResponseEntity<>(errMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
