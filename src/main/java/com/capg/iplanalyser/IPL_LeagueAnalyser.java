package com.capg.iplanalyser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;

public class IPL_LeagueAnalyser {
	private List<Batsman> batsmanList = null;
	private List<Bowler> bowlerList = null;

	public void getBatsmanData(String PATH) throws IPLAnalyserException {
		batsmanList = new BatsmanCSV().loadBatsmanList(PATH);
	}
	public void getBowlerData(String BOWLER_CSV_PATH) throws IPLAnalyserException {
		bowlerList = new BowlerCSV().loadBowlerList(BOWLER_CSV_PATH);
	}

	public String getPlayerWithBestBattingAverages() {
		List<Batsman> sortedStateBatsmanList = batsmanList.stream()
				.sorted(Comparator.comparing(Batsman::getAverage).thenComparing(Batsman::getStrikeRate).reversed())
				.collect(Collectors.toList());
		return toJson(sortedStateBatsmanList);
	}

	public String getPlayerWithBestStrikeRate() {
		List<Batsman> sortedStateBatsmanList = batsmanList.stream()
				.sorted(Comparator.comparing(Batsman::getStrikeRate).thenComparing(Batsman::getBoundries).reversed())
				.collect(Collectors.toList());
		return toJson(sortedStateBatsmanList);
	}

	public String getPlayerWithMaximumBoundries() {
		List<Batsman> sortedStateBatsmanList = batsmanList.stream()
				.sorted(Comparator.comparing(Batsman::getBoundries).reversed()).collect(Collectors.toList());
		return toJson(sortedStateBatsmanList);
	}

	public String getPlayerWithMaximumRuns() {
		List<Batsman> sortedStateBatsmanList = batsmanList.stream()
				.sorted(Comparator.comparing(Batsman::getRunsScored).thenComparing(Batsman::getAverage).reversed())
				.collect(Collectors.toList());
		return toJson(sortedStateBatsmanList);
	}

	public String getPlayerWithMaximumBowlingAverage() {
		List<Bowler> sortedBowlerList = bowlerList.stream().filter(n -> n.getAverage() > 0)
				.sorted(Comparator.comparing(Bowler::getAverage).thenComparing(Bowler::getStrikeRate))
				.collect(Collectors.toList());
		return toJson(sortedBowlerList);
	}
	
	public String getPlayerWithMaximumBowlingStrikeRates() {
		List<Bowler> sortedBowlerList = bowlerList.stream()
				.filter(n -> n.getStrikeRate()>0)
				.sorted(Comparator.comparing(Bowler::getStrikeRate).thenComparing(Bowler::getHauls))
				.collect(Collectors.toList());
		return toJson(sortedBowlerList);
	}
	
	public String getPlayerWithBestEconomy() {
		List<Bowler> sortedBowlerList = bowlerList.stream().sorted(Comparator.comparing(Bowler::getStrikeRate))
				.collect(Collectors.toList());
		return toJson(sortedBowlerList);
	}
	
	public String getPlayerMaximumWickets() {
		List<Bowler> sortedBowlerList = bowlerList.stream().filter(n -> n.getStrikeRate() > 0)
				.sorted(Comparator.comparing(Bowler::getWicketsTaken).thenComparing(Bowler::getAverage).reversed())
				.collect(Collectors.toList());
		return toJson(sortedBowlerList);
	}
	
	public List<All_Rounder> getAllRounderPlayers(){
		List<All_Rounder> allRounderList = new ArrayList<All_Rounder>();
		Map<String, Batsman> batsmanMap = new HashMap<String, Batsman>();
		Map<String, Bowler> bowlerMap = new HashMap<String, Bowler>();
		batsmanList.forEach(n -> batsmanMap.put(n.getName(), n));
		bowlerList.forEach(n -> bowlerMap.put(n.getName(), n));
		
		batsmanMap.forEach((k,v)-> {
						if(bowlerMap.containsKey(k)) {
							All_Rounder a = new All_Rounder();
							a.setName(k);
							a.setBattingAverage(v.getAverage());
							a.setRunsScored(v.getRunsScored());
							a.setBowlingAverage(bowlerMap.get(k).getAverage());
							allRounderList.add(a);
						}
				});
		allRounderList.forEach(n -> {
						n.setWicketsTaken(bowlerMap.get(n.getName()).getWicketsTaken());
		});
		return allRounderList;
	}
	
	public String getPlayerWithBattingAndBowlingAverages() {
		List<All_Rounder> allRounderList = getAllRounderPlayers();
		
		List<All_Rounder> battingAllRounderList = allRounderList.stream()
				.filter(n -> n.getBowlingAverage() > 0 & n.getBattingAverage() > 0)
					  .sorted(Comparator.comparing(All_Rounder::getBattingAverage).reversed())
					  .collect(Collectors.toList());
		
		List<All_Rounder> bowlingAllRounderList = allRounderList.stream()
				.filter(n -> n.getBowlingAverage() > 0 & n.getBattingAverage() > 0)
				  .sorted(Comparator.comparing(All_Rounder::getBowlingAverage))
				  .collect(Collectors.toList());
		List<All_Rounder> sortedAllRounderList = new ArrayList<>();
		sortedAllRounderList.add(battingAllRounderList.get(0)); 
		sortedAllRounderList.add(bowlingAllRounderList.get(0));
		return toJson(sortedAllRounderList);
	}
	
	public String getPlayerWithMostRunsAndWickets() {
		List<All_Rounder> allRounderList = getAllRounderPlayers();
		
		List<All_Rounder> battingAllRounderList = allRounderList.stream()
				.filter(n -> n.getBowlingAverage() > 0 & n.getBattingAverage() > 0)
					  .sorted(Comparator.comparing(All_Rounder::getRunsScored).reversed())
					  .collect(Collectors.toList());
		
		List<All_Rounder> bowlingAllRounderList = allRounderList.stream()
				.filter(n -> n.getBowlingAverage() > 0 & n.getBattingAverage() > 0)
				  .sorted(Comparator.comparing(All_Rounder::getWicketsTaken).reversed())
				  .collect(Collectors.toList());

		List<All_Rounder> sortedAllRounderList = new ArrayList<>();
		sortedAllRounderList.add(battingAllRounderList.get(0)); 
		sortedAllRounderList.add(bowlingAllRounderList.get(0));
		return toJson(sortedAllRounderList);
	}
	
	public String getPlayerWithMaximumHundreds() {
		List<Batsman> sortedBatsmanList = batsmanList.stream()
				.filter(n -> n.getCenturies() > 0)
				.sorted(Comparator.comparing(Batsman::getCenturies).reversed()
				.thenComparing(Batsman::getAverage).reversed())
				.collect(Collectors.toList());
		return toJson(sortedBatsmanList);
	}
	

	public String getPlayerBestBattingAverageNoFifty() {
		List<Batsman> sortedBatsmanList = batsmanList.stream()
				.filter(n -> n.getCenturies() == 0 && n.getFifties() == 0)
				.sorted(Comparator.comparing(Batsman::getAverage).reversed())
				.collect(Collectors.toList());
		return toJson(sortedBatsmanList);
	}
	
	public <E> String toJson(List<E> list) {
		return new Gson().toJson(list);
	}

}
