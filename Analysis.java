//Wyatt McCarthy, Benjamin King Final Project;
// Soccer Stats (Specific to NESCAC)
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;

public class Analysis {
    public static void main(String [] args) {
        Scanner siu = new Scanner(System.in);
        Scanner input = null;
        int op;
        int opteam;
        Character yn;
        //variables for controlling loops in various menu options

        try { input = new Scanner(new File("bigTest2.csv"));}
        catch (FileNotFoundException ex) {
            System.out.println( ex);
        }
        PrintWriter fout = null;
        try {
            File ballot = new File("output.txt");
            fout = new PrintWriter(ballot);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        List<PLayer> toAnalyze = new ArrayList<>(); //full player list
        List<String> initializer = new ArrayList<>(); //used to initialize team lists
        List<Team> teams = new ArrayList<>(); //list of teams

       while (input.hasNext()) {
            String n = input.nextLine();
            String[] toAdd = n.split(",");
            int num = Integer.parseInt(toAdd[0]);
            int GP = Integer.parseInt(toAdd[4]);
           int GS = Integer.parseInt(toAdd[5]);
            int MIN = Integer.parseInt(toAdd[6]);
            double G = Double.parseDouble(toAdd[7]);
            int A = Integer.parseInt(toAdd[8]);
            double SH = Double.parseDouble(toAdd[9]);
          double SOG = Double.parseDouble(toAdd[10]);
            int YC = Integer.parseInt(toAdd[11]);
            int RC = Integer.parseInt(toAdd[12]);
           PLayer newPlayer = new PLayer(num, toAdd[1], toAdd[3].substring(0, toAdd[3].length()-1), toAdd[2].substring(1), GP, GS, MIN, G, A, SH, SOG, YC, RC);
           toAnalyze.add(newPlayer);
    } //reads in the file converting every row to a player with corresponding stats filled

        for (int i = 0 ; i < toAnalyze.size(); i ++) { // creates mock teams and their list of players
            if (!initializer.contains(toAnalyze.get(i).teamname)) {
                initializer.add(toAnalyze.get(i).teamname);
            }
        }
        for (int c = 0; c < initializer.size(); c ++) { //converts mock teams to actual Team objects and adds that List<Team> teams
            Team newteam = new Team(initializer.get(c), new ArrayList<>());
            teams.add(newteam);
        }

        //unused code (i kept a lot of thinking process in the program)
       // for (int i = 0; i < toAnalyze.size(); i ++) {
       // for (int c = 0; c < teams.size(); c ++) {
        //    if (toAnalyze.get(i).teamname.equals(teams.get(c).name)) {
       //         teams.get(c).players.add(toAnalyze.get(i));
       //     }
       // }}
        //input all players in caac, with stats
        // input all teams
        //sort through teams, add each player to whole conference list of players
        //

        do { //main do, while loop for the entire program, consists of 15 different options / layouts to view stats

            System.out.println("Menu (Enter a number above 15 to quit) \n1. Top Scorers \n2. Top Assisters \n3. Most Yellowcards \n4. Most Redcards \n5. Most Shots" +
                    "\n6. Most Shots on Target \n7. Most Accurate Shooter \n8. Best Conversion Rate \n9. Most Goal Contributions \n10. Best Goals per min \n11. Goal Contributions per Min \n12. Select Team to Limit Analysis Pool \n13. Select Player \n14. See Team Stats \n15. NESCAC Player of the Year Vote ");
            op = siu.nextInt();
            switch(op) {
                case 1:
                    Collections.sort(toAnalyze, PLayer.goalComp);
                    int rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                    System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + (int)toAnalyze.get(i).goals + " goals");
                    rank ++;
                }
                    break;
                case 2:
                    Collections.sort(toAnalyze, PLayer.assistComp);
                    rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + toAnalyze.get(i).assists + " assists");
                    rank++;
                    }
                    break;
                case 3:
                    Collections.sort(toAnalyze, PLayer.yellowCards);
                    rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + toAnalyze.get(i).yellowcards + " yellow cards");
                    rank++;
                    }
                    break;
                case 4:
                    Collections.sort(toAnalyze, PLayer.redCards);
                    rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + toAnalyze.get(i).redcards + " red cards");
                    rank++;
                    }
                    break;
                case 5:
                    Collections.sort(toAnalyze, PLayer.shotsComp);
                    rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + (int)toAnalyze.get(i).shots + " shots");
                    rank++;
                    }
                    break;
                case 6:
                    Collections.sort(toAnalyze, PLayer.shotstargetcomp);
                    rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + (int)toAnalyze.get(i).shotsontarget + " shots on target");
                    rank++;
                    }
                    break;
                case 7: Collections.sort(toAnalyze, PLayer.mostAccurate);
                rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + toAnalyze.get(i).shotaccur + " % shot accuracy");
                        rank++;
                    }
                    break;
                case 8:
                    Collections.sort(toAnalyze, PLayer.conversionrate);
                    rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + toAnalyze.get(i).conversion + " % conversion rate");
                        rank++;
                    }

                    break;
                case 9: Collections.sort(toAnalyze, PLayer.contributions);
                    rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + toAnalyze.get(i).goalcontributions + " goal contributions");
                        rank++;
                    }
                    break;
                case 10:
                    Collections.sort(toAnalyze, PLayer.goalsperminute);
                    rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + toAnalyze.get(i).goalspermin + " goals/90min");
                        rank++;
                    }
                    break;
                case 11: Collections.sort(toAnalyze, PLayer.goalcontribpermin);
                    rank = 1;
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        System.out.println(rank + ": " + toAnalyze.get(i).toString() + " " + toAnalyze.get(i).goalcontpermin + " goal contributions/90min");
                        rank++;
                    }
                    break;
                case 12 :
                    System.out.println("Give a team to narrow statistical analysis to just players from that team.");
                    siu.nextLine();
                    System.out.println("Here are all the teams for name reference: " + teams);
                    String teaminp = siu.nextLine();
                    List<PLayer> teamanal = new ArrayList<>();
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        if (toAnalyze.get(i).teamname.equals(teaminp)) {
                            teamanal.add(toAnalyze.get(i));
                        }
                    }
                    do { //sub do, while loop for narrowing the analysis to given teams players
                    System.out.println(teaminp + "\n1. Top Scorers \n2. Top Assisters \n3. Most Yellowcards \n4. Most Redcards \n5. Most Shots" +
                            "\n6. Most Shots on Target \n7. Most Accurate Shooter \n8. Best Conversion Rate \n9. Most Goal Contributions \n10. Best Goals per min \n11. Goal Contributions per Min");
                    opteam = siu.nextInt();
                    switch(opteam) {
                        case 1:
                            Collections.sort(teamanal, PLayer.goalComp);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + (int)teamanal.get(i).goals + " goals");
                                rank ++;
                            }
                            break;
                        case 2:
                            Collections.sort(teamanal, PLayer.assistComp);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + teamanal.get(i).assists + " assists");
                                rank++;
                            }
                            break;
                        case 3:
                            Collections.sort(teamanal, PLayer.yellowCards);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + teamanal.get(i).yellowcards + " yellow cards");
                                rank++;
                            }
                            break;
                        case 4:
                            Collections.sort(teamanal, PLayer.redCards);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + teamanal.get(i).redcards + " red cards");
                                rank++;
                            }
                            break;
                        case 5:
                            Collections.sort(teamanal, PLayer.shotsComp);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + (int)teamanal.get(i).shots + " shots");
                                rank++;
                            }
                            break;
                        case 6:
                            Collections.sort(teamanal, PLayer.shotstargetcomp);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + (int)teamanal.get(i).shotsontarget + " shots on target");
                                rank++;
                            }
                            break;
                        case 7: Collections.sort(teamanal, PLayer.mostAccurate);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + teamanal.get(i).shotaccur + " % shot accuracy");
                                rank++;
                            }
                            break;
                        case 8:
                            Collections.sort(teamanal, PLayer.conversionrate);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + teamanal.get(i).conversion + " % conversion rate");
                                rank++;
                            }

                            break;
                        case 9: Collections.sort(teamanal, PLayer.contributions);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + teamanal.get(i).goalcontributions + " goal contributions");
                                rank++;
                            }
                            break;
                        case 10:
                            Collections.sort(teamanal, PLayer.goalsperminute);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + teamanal.get(i).goalspermin + " goals/90min");
                                rank++;
                            }
                            break;
                        case 11: Collections.sort(teamanal, PLayer.goalcontribpermin);
                            rank = 1;
                            for (int i = teamanal.size()-1; i > 0; i --) {
                                System.out.println(rank + ": " + teamanal.get(i).toString() + " " + teamanal.get(i).goalcontpermin + " goal contributions/90min");
                                rank++;
                            }
                            break; }
                        System.out.println("If you like to continue analyzing this team type y, to return to the main menu, type anything else.");
                    yn = siu.next().charAt(0);
                    } while (yn == 'y');
                    break;
                case 13:
                    int track = 0;
                    System.out.println("Give a player to list all their stats.");
                    siu.nextLine();
                    System.out.println("Please give full name");
                    String name = siu.nextLine();

                    for (int i = 0; i < toAnalyze.size(); i ++) {
                        //unused code (i kept a lot of thinking process in the program)
                        //if (lastnamep2.isBlank()) {
                        //if (toAnalyze.get(i).name.contains(firstNameinp) && toAnalyze.get(i).name.contains(lastNameinp)) {
                        //    System.out.println(toAnalyze.get(i).toString() + "\nGoals: " + toAnalyze.get(i).goals + "\nAssists: " + toAnalyze.get(i).assists + "\nYellow Cards: " + toAnalyze.get(i).yellowcards + "\nRed Cards: " + toAnalyze.get(i).redcards + "\nShots: " +toAnalyze.get(i).shots + "\nShots on Target: " + toAnalyze.get(i).shotsontarget + "\nShot Accuracy: " + toAnalyze.get(i).shotaccur + "\nConversion Rate: " + toAnalyze.get(i).conversion + "\nGoal Contributions: " + toAnalyze.get(i).goalcontributions + "\nGoals per 90 minutes: " + toAnalyze.get(i).goalspermin + "\nGoal Contributions per 90 minutes: " + toAnalyze.get(i).goalcontpermin );
                        //}}
                        //else {
                         //   if (toAnalyze.get(i).name.contains(firstNameinp) && toAnalyze.get(i).name.contains(lastNameinp) && toAnalyze.get(i).lastname.contains(lastnamep2)) {
                         //       System.out.println(toAnalyze.get(i).toString() + "\nGoals: " + toAnalyze.get(i).goals + "\nAssists: " + toAnalyze.get(i).assists + "\nYellow Cards: " + toAnalyze.get(i).yellowcards + "\nRed Cards: " + toAnalyze.get(i).redcards + "\nShots: " +toAnalyze.get(i).shots + "\nShots on Target: " + toAnalyze.get(i).shotsontarget + "\nShot Accuracy: " + toAnalyze.get(i).shotaccur + "\nConversion Rate: " + toAnalyze.get(i).conversion + "\nGoal Contributions: " + toAnalyze.get(i).goalcontributions + "\nGoals per 90 minutes: " + toAnalyze.get(i).goalspermin + "\nGoal Contributions per 90 minutes: " + toAnalyze.get(i).goalcontpermin);
                        //    }
                        if (toAnalyze.get(i).name.contains(name)) {
                            System.out.println(toAnalyze.get(i).toString() + "\nGoals: " + toAnalyze.get(i).goals + "\nAssists: " + toAnalyze.get(i).assists + "\nYellow Cards: " + toAnalyze.get(i).yellowcards + "\nRed Cards: " + toAnalyze.get(i).redcards + "\nShots: " +toAnalyze.get(i).shots + "\nShots on Target: " + toAnalyze.get(i).shotsontarget + "\nShot Accuracy: " + toAnalyze.get(i).shotaccur + "%" + "\nConversion Rate: " + toAnalyze.get(i).conversion + "%" + "\nGoal Contributions: " + toAnalyze.get(i).goalcontributions + "\nGoals per 90 minutes: " + toAnalyze.get(i).goalspermin + "\nGoal Contributions per 90 minutes: " + toAnalyze.get(i).goalcontpermin);
                        track = i;
                        }
                    }
                    System.out.println("Would you like to change any stats? Type y for yes and anything else for no.");
                    yn = siu.next().charAt(0);
                    if (yn == 'y') {
                        System.out.println("Menu \n1. Change Goals \n2. Change Assists \n3. Change Yellow cards \n4. Change Red cards \n5. Change Shots \n6. Change Shots on Target \n7. Change Minutes");
                        op = siu.nextInt();
                        switch (op) {
                            case 1: //manually change stats that correspond
                                System.out.println("Enter what you would like to change goals to");
                                toAnalyze.get(track).goals = siu.nextDouble();
                                toAnalyze.get(track).goalcontributions = (int)toAnalyze.get(track).goals + toAnalyze.get(track).assists;
                                toAnalyze.get(track).goalspermin = (toAnalyze.get(track).goals/toAnalyze.get(track).minutes)*90;
                                toAnalyze.get(track).goalcontpermin = ((toAnalyze.get(track).goals + toAnalyze.get(track).assists)/toAnalyze.get(track).minutes)*90;
                                break;
                            case 2: System.out.println("Enter what you would like to change assists to");
                                toAnalyze.get(track).assists = siu.nextInt();
                                toAnalyze.get(track).goalcontributions = (int)toAnalyze.get(track).goals + toAnalyze.get(track).assists;
                                toAnalyze.get(track).goalcontpermin = ((toAnalyze.get(track).goals + toAnalyze.get(track).assists)/toAnalyze.get(track).minutes)*90;
                                break;
                            case 3: System.out.println("Enter what you would like to change yellow cards to");
                                toAnalyze.get(track).yellowcards = siu.nextInt();
                                break;
                            case 4: System.out.println("Enter what you would like to change red cards to");
                                toAnalyze.get(track).redcards = siu.nextInt();
                                break;
                            case 5: System.out.println("Enter what you would like to change shots to");
                                toAnalyze.get(track).shots = siu.nextDouble();
                                toAnalyze.get(track).shotaccur = (toAnalyze.get(track).shotsontarget/toAnalyze.get(track).shots)*100;
                                toAnalyze.get(track).conversion = (toAnalyze.get(track).goals/toAnalyze.get(track).shots)*100;
                                break;
                            case 6: System.out.println("Enter what you would like to change shots on target to");
                                toAnalyze.get(track).shotsontarget = siu.nextDouble();
                                toAnalyze.get(track).shotaccur = (toAnalyze.get(track).shotsontarget/toAnalyze.get(track).shots)*100;
                                break;
                            case 7:
                                System.out.println("Enter what you would like to change minutes to");
                                toAnalyze.get(track).minutes = siu.nextInt();
                                toAnalyze.get(track).goalspermin = (toAnalyze.get(track).goals/toAnalyze.get(track).minutes)*90;
                                toAnalyze.get(track).goalcontpermin = ((toAnalyze.get(track).goals + toAnalyze.get(track).assists)/toAnalyze.get(track).minutes)*90;
                                break;
                        }
                    }
                    break;
                case 14: //do instead by just sorting through like how you did with teamanal, try doing that, then making teamanal the list of players for team (instead of at beginning), then using same code as below
                    //if that doesn't work just add all stats through teamanal
                    System.out.println("Please give team to see it's stats");
                    siu.nextLine();
                    System.out.println("Here are all the teams for name reference: " + teams);
                    teaminp = siu.nextLine();
                    teamanal =  new ArrayList<>();
                    for (int i = toAnalyze.size()-1; i > 0; i --) {
                        if (toAnalyze.get(i).teamname.equals(teaminp)) {
                            teamanal.add(toAnalyze.get(i));
                        }
                    }
                    for (int c = 0; c < teams.size(); c ++) {
                        if (teams.get(c).name.equals(teaminp)) {
                            teams.remove(c);
                            teams.add(new Team (teaminp, teamanal));
                        }
                    }
                    for (int i = 0; i < teams.size(); i ++) {
                            if (teaminp.equals(teams.get(i).name)) {
                                System.out.println(teams.get(i).name + "\nGames Played: " + teams.get(i).gamesplayed + "\nGoals Scored: " + teams.get(i).totalgoals + "\nGoals per Game: " + teams.get(i).goalspergame + "\nTotal Shots: " + teams.get(i).totalshots + "\nTotal Shots on Target: " + teams.get(i).totalshotsontarget + "\nShot Accuracy: " + teams.get(i).shotaccurbyteam + "%" + "\nTeam Conversion Rate: " + teams.get(i).conversionratebyteam + "%" + "\nTotal Cards: " + teams.get(i).totalcards);
                            }
                    }
                    break;
                case 15:
                    System.out.println("Please submit your three NESCAC Player of the Year Nominations, in order:");
                    String a = siu.nextLine();
                    System.out.println("Number One: " );
                    String ballot1 = siu.nextLine();
                    System.out.println("Number Two: " );
                    String ballot2 = siu.nextLine();
                    System.out.println("Number Three: " );
                    String ballot3 = siu.nextLine();
                    System.out.println("What is your name?");
                    String ballotname = siu.nextLine();
                    fout.write(ballotname + "'s Ballot for NESCAC Player of the Year: \n" +
                            " 1. " + ballot1 + "\n 2. " + ballot2 + "\n 3. " + ballot3);
                    fout.close();
                    System.out.println("Thank you for submitting!");
                    System.exit(0);
                    break;
            }
        } while (op < 16);
    }
}
