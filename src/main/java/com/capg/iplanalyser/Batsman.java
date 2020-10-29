package com.capg.iplanalyser;

import com.opencsv.bean.CsvBindByName;

public class Batsman {

	@CsvBindByName(column = "PLAYER", required = true)
	private String name;

	@CsvBindByName(column = "Mat", required = true)
	private int matchesPlayed;

	@CsvBindByName(column = "Inns", required = true)
	private int inniginsPlayed;

	@CsvBindByName(column = "NO", required = true)
	private int NO;

	@CsvBindByName(column = "Runs", required = true)
	private int runsScored;

	@CsvBindByName(column = "HS", required = true)
	private String highestScore;

	@CsvBindByName(column = "Avg")
	private double average;

	@CsvBindByName(column = "BF", required = true)
	private int bf;

	@CsvBindByName(column = "SR", required = true)
	private double StrikeRate;

	@CsvBindByName(column = "100", required = true)
	private int centuries;

	@CsvBindByName(column = "50", required = true)
	private int fifties;

	@CsvBindByName(column = "4s", required = true)
	private int fours;

	@CsvBindByName(column = "6s", required = true)
	private int sixes;

	public String getName() {
		return name;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public int getInniginsPlayed() {
		return inniginsPlayed;
	}

	public int getNO() {
		return NO;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public String getHighestScore() {
		return highestScore;
	}

	public double getAverage() {
		return average;
	}

	public int getBf() {
		return bf;
	}

	public double getStrikeRate() {
		return StrikeRate;
	}

	public int getCenturies() {
		return centuries;
	}

	public int getFifties() {
		return fifties;
	}

	public int getFours() {
		return fours;
	}

	public int getSixes() {
		return sixes;
	}

	public int getBoundries() {
		return this.fours + this.sixes;
	}
}
