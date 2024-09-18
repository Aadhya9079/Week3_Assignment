/***
 * Problem-Statement : Write a java code to build a "Cricket Match Scorer App".
 * Owner-Name : Aadhya Goyal
 * Date Of Creation : 17-09-24
 */

import java.util.Scanner;

public class CricketMatchScorer {


    public static void main(String[] args) {
        CricketMatchScorer scorer = new CricketMatchScorer();

        while (true) {
            System.out.println(Constant.StartMessage);

            scorer.CreateTeam();

            scorer.Runs();

            scorer.Score();

            System.out.print(Constant.YesOrNoMessage);
            String cont = scorer.scanner.nextLine();
            if (!cont.equalsIgnoreCase("yes")) {
                System.out.println("Exiting......");
                break;
            }
        }
    }

    private final Scanner scanner;
    private int TotalRuns;
    private final int TotalWickets;
    private int TotalOvers;
    private int BallsInCurrentOver;

    public CricketMatchScorer() {
        this.scanner = new Scanner(System.in);
        this.TotalRuns = 0;
        this.TotalWickets = 0;
        this.TotalOvers = 0;
        this.BallsInCurrentOver = 0;
    }

    //Method  to Create Team
    public void CreateTeam(){
        int PlayerInput = -1;

        while(PlayerInput < 11 || PlayerInput > 30) {
            System.out.println(Constant.CreateTeamMessage);
            String input = scanner.nextLine();

            try {
                PlayerInput = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            if (PlayerInput < 11 || PlayerInput > 30) {
                System.out.println(Constant.InvalidMessage);
                PlayerInput = -1;
            }
        }

            System.out.println("Your 11 active team players are:");
            for (int i = 0; i < 11; i++) {
                System.out.println((i + 1) + ". " + Constant.Player1[i]);
            }
            System.out.println("Number of substitute players are:" + (PlayerInput - 11));

            System.out.println("Opponent's 11 active team players are:");
            for (int i = 0; i < 11; i++) {
                System.out.println((i + 1) + ". " + Constant.Player2[i]);
            }

    }

    //Method to calculate Runs
    public void CountRuns(int runs) {
        if (runs < 0) {
            System.out.println(Constant.InvalidRunCount);
        }
        TotalRuns += runs;
    }

    public void Runs(){
        System.out.println(Constant.RunInput);
        for(int i = 1; i <=6; i++) {
            System.out.print("Ball " + i + ":");
            String RunInput = scanner.nextLine();

            if (RunInput.equals("wide")) {
               TotalRuns++;
            System.out.println("Wide ball. 1 run added.");
            }
            else if(RunInput.equals("no ball")){
                TotalRuns++;
                System.out.println("No ball. 1 run added. ");
            }
            else{
                try{
                    int runs = Integer.parseInt(RunInput);
                    CountRuns(runs);
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid input.Please enter a valid run count.");
                    continue;
                }
            }

            BallsInCurrentOver++;
            if(BallsInCurrentOver >= 6){
                TotalOvers++;
                BallsInCurrentOver = 0;
                System.out.println("Over Completed..");
                break;
            }
        }
    }

    //Method to Score
    public void Score(){
        System.out.println("Total score is:" + TotalRuns + "/" + TotalWickets);
        System.out.println("Total overs are:" + TotalOvers + "." + BallsInCurrentOver);
    }
}