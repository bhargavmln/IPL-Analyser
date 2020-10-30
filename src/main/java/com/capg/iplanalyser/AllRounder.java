package com.capg.iplanalyser;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class AllRounder {
	
	@CsvBindByName(column = "PLAYER", required = true)
	private String name;
	
	@CsvBindByPosition(position = 7)
	@CsvBindByName(column = "Avg")
	private double battingAverage;
	
	@CsvBindByPosition(position = 8)
	@CsvBindByName(column = "Avg")
	private double bowlingAverage;

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

	@Override
	public String toString() {
		return "AllRounder [name=" + name + ", battingAverage=" + battingAverage + ", bowlingAverage=" + bowlingAverage
				+ "]\n";
	}
}
