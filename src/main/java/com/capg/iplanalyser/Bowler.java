package com.capg.iplanalyser;

import com.opencsv.bean.CsvBindByName;

public class Bowler {

	@CsvBindByName(column = "PLAYER", required = true)
	private String name;

	@CsvBindByName(column = "Mat", required = true)
	private int matchesPlayed;

	@CsvBindByName(column = "Inns", required = true)
	private int inniginsPlayed;

	@CsvBindByName(column = "Ov", required = true)
	private double oversBowled;

	@CsvBindByName(column = "Runs", required = true)
	private int runsGiven;

	@CsvBindByName(column = "Wkts", required = true)
	private int wicketsTaken;

	@CsvBindByName(column = "BBI", required = true)
	private int BBI;

	@CsvBindByName(column = "Avg")
	private double average;

	@CsvBindByName(column = "Econ", required = true)
	private double economy;

	@CsvBindByName(column = "SR")
	private double strikeRate;

	@CsvBindByName(column = "4W", required = true)
	private int haul_4W;

	@CsvBindByName(column = "5W", required = true)
	private int haul_5W;

	public String getName() {
		return name;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public int getInniginsPlayed() {
		return inniginsPlayed;
	}

	public double getOversBowled() {
		return oversBowled;
	}

	public int getRunsGiven() {
		return runsGiven;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public int getBBI() {
		return BBI;
	}

	public double getAverage() {
		return average;
	}

	public double getEconomy() {
		return economy;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public int getHaul_4W() {
		return haul_4W;
	}

	public int getHaul_5W() {
		return haul_5W;
	}
}
