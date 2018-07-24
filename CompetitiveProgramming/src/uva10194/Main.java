package uva10194;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {

	static class Tournament {

		String tournamentName;
		Map<String,Integer> indexMap;
		Team[] teamArray;
		int teamCount;
		
		public Tournament(String str, int numTeams) {
		
			tournamentName = str;
			indexMap = new HashMap<>();
			teamArray = new Team[numTeams];
			teamCount = 0;
			
		}

		public void addTeam(Team team) {
			
			indexMap.put(team.teamName , teamCount);
			teamArray[teamCount++] = team;
			
		}

		public void addMatch(Match match) {
			
			String team1 = match.teams[0];
			teamArray[indexMap.get(team1)].addResult(match.goals[0],match.goals[1]);
			
			String team2 = match.teams[1];
			teamArray[indexMap.get(team2)].addResult(match.goals[1],match.goals[0]);
			
		}
		
		@Override
		public String toString() {
			
			StringBuilder sb = new StringBuilder();
			sb.append(tournamentName);
			sb.append('\n');
			for (Team t : teamArray) {
				t.finalizeScore();
			}
			Arrays.sort(teamArray);
			for (int teamIndex = 1 ; teamIndex <= teamCount ; teamIndex++) {
				
				sb.append(teamIndex);
				sb.append(") ");
				sb.append(teamArray[teamIndex-1].toString());
				sb.append('\n');
			}
			
			return sb.toString();
		}

		
		
	}
	
	static class Team implements Comparable<Team>{

		String teamName;
		int playedGames;
		int points;
		int wins;
		int ties;
		int losses;
		int goalsScored;
		int goalsAgainst;
		int goalDifference;
		
		public Team(String str) {
			
			teamName = str;
		}

		public void finalizeScore() {
			
			points = wins*3 + ties;
			goalDifference = goalsScored - goalsAgainst;
			
		}

		public void addResult(int i, int j) {
			
			playedGames++;
			goalsScored += i;
			goalsAgainst += j;
		
			if (i > j) {
				wins++;
			} else if (j > i) {
				losses++;
			} else {
				ties++;
			}
			
		}

		
		
		@Override
		public int compareTo(Team o) {
			
			if (this.points == o.points) {
				
				if (this.wins == o.wins) {
					
					if (this.goalDifference == o.goalDifference) {
						
						if (this.goalsScored == o.goalsScored) {
							
							if (this.playedGames == o.playedGames) {
								return this.teamName.compareToIgnoreCase(o.teamName);
							}
							else {
								return this.playedGames - o.playedGames;
							}
						}
						else {
							return o.goalsScored - this.goalsScored;
						}
					}
					else {
						return o.goalDifference - this.goalDifference;
					}
				}
				else {
					return o.wins  - this.wins;
				}
			}
			else {
				return o.points - this.points;
			}
		}
		
		@Override
		public String toString() {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(teamName);
			sb.append(' ');
			sb.append(points);
			sb.append("p, ");
			sb.append(playedGames);
			sb.append("g (");
			sb.append(wins);
			sb.append('-');
			sb.append(ties);
			sb.append('-');
			sb.append(losses);
			sb.append("), ");
			sb.append(goalDifference);
			sb.append("gd (");
			sb.append(goalsScored);
			sb.append('-');
			sb.append(goalsAgainst);
			sb.append(')');
			
			return sb.toString();
		}
		

	}
	
	static class Match {

		String[] teams;
		int[] goals;
		
		public Match(String str) {
			
			teams = new String[2];
			goals = new int[2];
			
			String[] spl1 = str.split("@");
			String[] spl2 = spl1[0].split("#");
			
			teams[0] = spl2[0];
			goals[0] = Integer.parseInt(spl2[1]);
			
			spl2 = spl1[1].split("#");
			
			teams[1] = spl2[1];
			goals[1] = Integer.parseInt(spl2[0]);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1"));
			
			String str = br.readLine();
			
			int tournamentCount = Integer.parseInt(str);
			
			for (int tournamentIndex = 0 ; tournamentIndex < tournamentCount ; tournamentIndex++) {
				
				if (tournamentIndex != 0)
					bw.write("\n");
				
				String tournamentName = br.readLine();
				str = br.readLine();
				int teamCount = Integer.parseInt(str);
				Tournament tournament = new Tournament(tournamentName,teamCount);
				
				for (int teamIndex = 0 ; teamIndex < teamCount ; teamIndex++) {
					
					str = br.readLine();
					
					Team team = new Team(str);
					tournament.addTeam(team);
					
				}
				
				str = br.readLine();
				
				int matchCount = Integer.parseInt(str);
				
				
				for (int matchIndex = 0 ; matchIndex < matchCount ; matchIndex++) {
					
					str = br.readLine();
					
					Match match = new Match(str);
					
					tournament.addMatch(match);
					
				}
				
				bw.write(tournament.toString());
			}
			bw.flush();
			
			
		}catch (IOException e) {}

	}

}
