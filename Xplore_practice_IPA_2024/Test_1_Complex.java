/*
 int id 
 String name 
 int runs 
 String playerType 
 String matchType
 
  
  take a value from user for player type to find with lowest runs : Bastman 
  Enter match type to find players : ODI
  
  
  input 
  
  3
  1
  John 
  350
  Bastman 
  ODI
  2
  Mike 
  200
  Bowler 
  T20 
  3
  Steve 
  400
  Bastman 
  ODI
  Bastman 
  ODI 
 
 
 
 lowest run by player of type batsman
350

(player with match type ODi: (Decending Order)
3
1
  */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test_1_Complex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		List<Cricket> players = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int id = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			int run = sc.nextInt();
			sc.nextLine();
			String playerType = sc.nextLine();
			String matchType = sc.nextLine();

			players.add(new Cricket(id, name, run, playerType, matchType));

		}

		String pType = sc.nextLine();
		String matchType = sc.nextLine();
		
		int lowestRun = lowestRunByPlayerType(players, pType);
//		System.out.println("Lowest Run : " + lowestRun);
		if (lowestRun == Integer.MAX_VALUE) {
			System.out.println("No Such Type of Player Type Exist");
		} else {
			System.out.println(lowestRun);
		}

		Cricket matchTypeIds[] = playerWithMatchTypeIdsInDecendingOrder(players, matchType);
		if (matchTypeIds == null) {
			System.out.println("No Match Type match");
		} else {
			for (Cricket id : matchTypeIds) {
				System.out.println(id.getId());
			}
		}
	}

	public static int lowestRunByPlayerType(List<Cricket> players, String playerType) {
		int lowestRun = Integer.MAX_VALUE;
		for (Cricket p : players) {
			if (p.getPlayerType().equalsIgnoreCase(playerType)) {
//				 System.out.println("Available player type: " + p.getPlayerType());
				if (p.getRun() < lowestRun) {
					lowestRun =  p.getRun();
				}
			}
		}
		return lowestRun ;
	}

	public static Cricket[] playerWithMatchTypeIdsInDecendingOrder(List<Cricket> players, String matchType) {
//		List<Cricket> matchTypeIds = new ArrayList<>();
		Cricket matchTypeIds[] = new Cricket[0];
		for (Cricket p : players) {
			if (p.getMatchtype().equalsIgnoreCase(matchType)) {
//				matchTypeIds.add(p);
				matchTypeIds = Arrays.copyOf(matchTypeIds, matchTypeIds.length + 1);
				matchTypeIds[matchTypeIds.length - 1] = p;
			}
		}

		Arrays.sort(matchTypeIds, Comparator.comparingInt(Cricket::getId).reversed());

		return matchTypeIds.length > 0 ? matchTypeIds : null;
	}
}

class Cricket {
	private int id;
	private String name;
	private int run;
	private String playerType;
	private String matchType;

	public Cricket(int id, String name, int run, String playerType, String matchType) {
		this.id = id;
		this.name = name;
		this.run = run;
		this.playerType = playerType;
		this.matchType = matchType;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getRun() {
		return run;
	}

	public String getPlayerType() {
		return playerType;
	}

	public String getMatchtype() {
		return matchType;
	}
}
//3
//101
//Divyen
//300
//bowler
//ABC
//102
//Hiren
//200
//batsman
//DEF
//103
//Jay
//400
//bwler
//ABC
//Bowler
//Abc
//300
//103
//101