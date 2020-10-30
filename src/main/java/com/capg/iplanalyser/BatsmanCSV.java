package com.capg.iplanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.capg.iplanalyser.IPLAnalyserException.ExceptionType;
import com.opencsvbuilder.CSVBuilderFactory;
import com.opencsvbuilder.CSVException;
import com.opencsvbuilder.ICSVBuilder;

public class BatsmanCSV {
	public List<Batsman> loadBatsmanList(String BATSMAN_CSV_PATH) throws IPLAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(BATSMAN_CSV_PATH));) {
			ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
			List<Batsman> batsmanList = icsvBuilder.getCsvFileList(reader, Batsman.class);
			return batsmanList;
		} catch (IOException e) {
			throw new IPLAnalyserException(e.getMessage(), ExceptionType.FILE_NOT_FOUND);
		} catch (CSVException e) {
			throw new IPLAnalyserException(e.getMessage(), ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		} catch (RuntimeException e) {
			throw new IPLAnalyserException(e.getMessage(), ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
	}
}