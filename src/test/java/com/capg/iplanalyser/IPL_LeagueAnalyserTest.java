package com.capg.iplanalyser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class IPL_LeagueAnalyserTest {

	private static final String BATSMAN_DATA_PATH = "./src/test/resources/BatsmanData.csv";
	private static final String BOWLER_DATA_CSV_PATH = "./src/test/resources/BowlerData.csv";

	IPL_LeagueAnalyser ipl_LeagueAnalyser = null;

	@Before
	public void setUp() {
		ipl_LeagueAnalyser = new IPL_LeagueAnalyser();
		try {
			ipl_LeagueAnalyser.loadBatsmanData(BATSMAN_DATA_PATH);
			ipl_LeagueAnalyser.loadBowlerData(BOWLER_DATA_CSV_PATH);
		} catch (IPLAnalyserException e) {
		}
	}

	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_TopBattingAverages() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getBestBattingAveragesCricketers();
		Batsman[] sortedBatsmanArray = new Gson().fromJson(sortedBatsmanData, Batsman[].class);
		assertEquals("MS Dhoni", sortedBatsmanArray[0].getName());
	}

	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_TopStrikingRates() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getBestStrikeRateCricketers();
		Batsman[] sortedBatsmanArray = new Gson().fromJson(sortedBatsmanData, Batsman[].class);
		assertEquals("Andre Russell", sortedBatsmanArray[0].getName());
	}

	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumBoundries() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getMaximumBoundriesCricketers();
		Batsman[] sortedBatsmanArray = new Gson().fromJson(sortedBatsmanData, Batsman[].class);
		assertEquals("Andre Russell", sortedBatsmanArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumRuns_WithBestAverages() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getMaximumRunsCricketers();
		Batsman[] sortedBatsmanArray = new Gson().fromJson(sortedBatsmanData, Batsman[].class);
		assertEquals("David Warner", sortedBatsmanArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumBowlingAverages_WithBestStrikeRate() {
		String sortedBowlerData = ipl_LeagueAnalyser.getMaximumBowlingAverageCricketers();
		Bowler[] sortedBowlerArray = new Gson().fromJson(sortedBowlerData, Bowler[].class);
		assertEquals("Anukul Roy", sortedBowlerArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumBowlingStrikeRatesAndHauls() {
		String sortedBowlerData = ipl_LeagueAnalyser.getMaximumBowlingStrikeRatesCricketers();
		Bowler[] sortedBowlerArray = new Gson().fromJson(sortedBowlerData, Bowler[].class);
		assertEquals("Alzarri Joseph", sortedBowlerArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_BestEconomy() {
		String sortedBowlerData = ipl_LeagueAnalyser.getBestEconomyCricketers();
		Bowler[] sortedBowlerArray = new Gson().fromJson(sortedBowlerData, Bowler[].class);
		assertEquals("Shivam Dube", sortedBowlerArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumWickets_WithBestBowlingAverages() {
		String sortedBowlerData = ipl_LeagueAnalyser.getMaximumWicketsCricketers();
		Bowler[] sortedBowlerArray = new Gson().fromJson(sortedBowlerData, Bowler[].class);
		assertEquals("Imran Tahir", sortedBowlerArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_BattingAndBowlingAverages() {
		String sortedAllRounderData = ipl_LeagueAnalyser.getBattingAndBowlingAveragesCricketers();
		AllRounder[] sortedAllRounderArray = new Gson().fromJson(sortedAllRounderData, AllRounder[].class);
		assertEquals("Andre Russell", sortedAllRounderArray[0].getName());
		assertEquals("Kagiso Rabada", sortedAllRounderArray[1].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MostRunsAndWickets() {
		String sortedAllRounderData = ipl_LeagueAnalyser.getMostRunsAndWicketsCricketers();
		AllRounder[] sortedAllRounderArray = new Gson().fromJson(sortedAllRounderData, AllRounder[].class);
		assertEquals("Kagiso Rabada", sortedAllRounderArray[1].getName());
	}
}
