import java.util.*;
public class Team extends PLayer  {
    String name;
    List<PLayer> players;
    double totalgoals;
    double gamesplayed;
    double goalspergame;
    double totalshots;
    double totalshotsontarget;
    int totalcards;
    double shotaccurbyteam;
    double conversionratebyteam;

    public Team(String name, List<PLayer> players) {
        this.name = name;
        this.players = players;
        for (int i = 0 ; i < players.size(); i ++) {
            this.totalgoals += players.get(i).goals;
            this.totalcards += (players.get(i).yellowcards + players.get(i).redcards);
            this.totalshots += players.get(i).shots;
            this.totalshotsontarget += players.get(i).shotsontarget;
            Collections.sort(players, PLayer.gamesPlayed);
            this.gamesplayed = players.get(players.size()-1).gp;
        }
        this.shotaccurbyteam = (totalshotsontarget/totalshots) * 100;
        this.conversionratebyteam = (totalgoals/totalshots) * 100;
        this.goalspergame = (totalgoals/gamesplayed);

    }
    public String toString() {
        return name;
    }

}
