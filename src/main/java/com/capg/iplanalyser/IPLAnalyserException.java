package com.capg.iplanalyser;

public class IPLAnalyserException extends Exception {
	public IPLAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public enum ExceptionType {
		FILE_NOT_FOUND, UNABLE_TO_PARSE, NO_DATA, CSV_FILE_INTERNAL_ISSUES
	}

	public ExceptionType type;
}