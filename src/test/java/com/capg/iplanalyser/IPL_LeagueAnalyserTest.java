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
			ipl_LeagueAnalyser.getBatsmanData(BATSMAN_DATA_PATH);
			ipl_LeagueAnalyser.getBowlerData(BOWLER_DATA_CSV_PATH);
		} catch (IPLAnalyserException e) {
		}
	}

	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_TopBattingAverages() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getPlayerWithBestBattingAverages();
		Batsman[] sortedBatsmanArray = new Gson().fromJson(sortedBatsmanData, Batsman[].class);
		assertEquals("MS Dhoni", sortedBatsmanArray[0].getName());
	}

	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_TopStrikingRates() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getPlayerWithBestStrikeRate();
		Batsman[] sortedBatsmanArray = new Gson().fromJson(sortedBatsmanData, Batsman[].class);
		assertEquals("Andre Russell", sortedBatsmanArray[0].getName());
	}

	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumBoundries() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getPlayerWithMaximumBoundries();
		Batsman[] sortedBatsmanArray = new Gson().fromJson(sortedBatsmanData, Batsman[].class);
		assertEquals("Andre Russell", sortedBatsmanArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumRuns_WithBestAverages() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getPlayerWithMaximumRuns();
		Batsman[] sortedBatsmanArray = new Gson().fromJson(sortedBatsmanData, Batsman[].class);
		assertEquals("David Warner", sortedBatsmanArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumBowlingAverages_WithBestStrikeRate() {
		String sortedBowlerData = ipl_LeagueAnalyser.getPlayerWithMaximumBowlingAverage();
		Bowler[] sortedBowlerArray = new Gson().fromJson(sortedBowlerData, Bowler[].class);
		assertEquals("Anukul Roy", sortedBowlerArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumBowlingStrikeRatesAndHauls() {
		String sortedBowlerData = ipl_LeagueAnalyser.getPlayerWithMaximumBowlingStrikeRates();
		Bowler[] sortedBowlerArray = new Gson().fromJson(sortedBowlerData, Bowler[].class);
		assertEquals("Alzarri Joseph", sortedBowlerArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_BestEconomy() {
		String sortedBowlerData = ipl_LeagueAnalyser.getPlayerWithBestEconomy();
		Bowler[] sortedBowlerArray = new Gson().fromJson(sortedBowlerData, Bowler[].class);
		assertEquals("Shivam Dube", sortedBowlerArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumWickets_WithBestBowlingAverages() {
		String sortedBowlerData = ipl_LeagueAnalyser.getPlayerMaximumWickets();
		Bowler[] sortedBowlerArray = new Gson().fromJson(sortedBowlerData, Bowler[].class);
		assertEquals("Imran Tahir", sortedBowlerArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_BattingAndBowlingAverages() {
		String sortedAllRounderData = ipl_LeagueAnalyser.getPlayerWithBattingAndBowlingAverages();
		All_Rounder[] sortedAllRounderArray = new Gson().fromJson(sortedAllRounderData, All_Rounder[].class);
		assertEquals("Andre Russell", sortedAllRounderArray[0].getName());
		assertEquals("Kagiso Rabada", sortedAllRounderArray[1].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MostRunsAndWickets() {
		String sortedAllRounderData = ipl_LeagueAnalyser.getPlayerWithMostRunsAndWickets();
		All_Rounder[] sortedAllRounderArray = new Gson().fromJson(sortedAllRounderData, All_Rounder[].class);
		assertEquals("Kagiso Rabada", sortedAllRounderArray[1].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_MaximumHundredsAnd_BestBattingAverages() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getPlayerWithMaximumHundreds();
		Bowler[] sortedBowlerArray = new Gson().fromJson(sortedBatsmanData, Bowler[].class);
		assertEquals("David Warner", sortedBowlerArray[0].getName());
	}
	
	@Test
	public void givenCSVFile_shouldReturn_CricketersWith_ZeroHundredsAndFiftiesBut_BestBattingAverages() {
		String sortedBatsmanData = ipl_LeagueAnalyser.getPlayerBestBattingAverageNoFifty();
		Bowler[] sortedBowlerArray = new Gson().fromJson(sortedBatsmanData, Bowler[].class);
		assertEquals("Marcus Stoinis", sortedBowlerArray[0].getName());
	}
}
