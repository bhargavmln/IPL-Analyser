package com.capg.iplanalyser;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

public class IPL_LeagueAnalyser {
	private List<Batsman> batsmanList = null;

	public void loadBatsmanData(String PATH) throws IPLAnalyserException {
		batsmanList = new CSVBatsman().loadBatsmanList(PATH);
	}

	public String getBestBattingAveragesCricketers() {
		List<Batsman> sortedStateBatsmanList = batsmanList.stream()
				.sorted(Comparator.comparing(Batsman::getAverage).reversed()).collect(Collectors.toList());
		return toJson(sortedStateBatsmanList);
	}
	
	public String getBestStrikeRateCricketers() {
		List<Batsman> sortedStateBatsmanList = batsmanList.stream()
				.sorted(Comparator.comparing(Batsman::getStrikeRate).thenComparing(Batsman::getBoundries).reversed())
				.collect(Collectors.toList());
		return toJson(sortedStateBatsmanList);
	}
	
	public String getMaximumBoundriesCricketers() {
		List<Batsman> sortedStateBatsmanList = batsmanList.stream()
				.sorted(Comparator.comparing(Batsman :: getBoundries).reversed()).collect(Collectors.toList());
		return toJson(sortedStateBatsmanList);
	}

	public <E> String toJson(List<E> list) {
		return new Gson().toJson(list);
	}

}
