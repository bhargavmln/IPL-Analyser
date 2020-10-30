package com.capg.iplanalyser;

public class All_Rounder {

	private String name;
	private double battingAverage;
	private double bowlingAverage;
	private int runsScored;
	private int wicketsTaken;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBattingAverage() {
		return battingAverage;
	}

	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}

	public double getBowlingAverage() {
		return bowlingAverage;
	}

	public void setBowlingAverage(double bowlingAverage) {
		this.bowlingAverage = bowlingAverage;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
}
