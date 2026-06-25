package com.openlgu.shared.exception;

public class FileProcessingException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileProcessingException() {
		super(ErrorCode.FILE_PROCESSING_ERROR.getCode(), ErrorCode.FILE_PROCESSING_ERROR.getDefaultMessage());
	}

	public FileProcessingException(Throwable e) {
		super(ErrorCode.FILE_PROCESSING_ERROR.getCode(), ErrorCode.FILE_PROCESSING_ERROR.getDefaultMessage(), e);
	}

}
