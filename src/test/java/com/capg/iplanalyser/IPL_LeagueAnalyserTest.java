package com.capg.iplanalyser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class IPL_LeagueAnalyserTest {

	private static final String BATSMAN_DATA_PATH = "./src/test/resources/BatsmanData.csv";

	IPL_LeagueAnalyser ipl_LeagueAnalyser = null;

	@Before
	public void setUp() {
		ipl_LeagueAnalyser = new IPL_LeagueAnalyser();
		try {
			ipl_LeagueAnalyser.loadBatsmanData(BATSMAN_DATA_PATH);
		} catch (IPLAnalyserException e) {
		}
	}

	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_TopBattingAverages() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getBestBattingAveragesCricketers();
		Batsman[] sortedBatsmanArray = new Gson().fromJson(sortedBatsmanData, Batsman[].class);
		System.out.println(sortedBatsmanArray[0].getAverage());
		assertEquals("MS Dhoni", sortedBatsmanArray[0].getName());
	}

	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_TopStrikingRates() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getBestStrikeRateCricketers();
		Batsman[] sortedBatsmanArray = new Gson().fromJson(sortedBatsmanData, Batsman[].class);
		System.out.println(sortedBatsmanArray[0].getName());
		assertEquals("Ishant Sharma", sortedBatsmanArray[0].getName());
	}
}
