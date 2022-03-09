
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


class CricketData {

  int runs, wickets;
  float overs;

  CurrentScoreDisplay currentScoreDisplay;
  AverageScoreDisplay averageScoreDisplay;

  //Constructor
  CricketData(CurrentScoreDisplay currentScoreDisplay, AverageScoreDisplay averageScoreDisplay) {

    this.currentScoreDisplay = currentScoreDisplay;
    this.averageScoreDisplay = averageScoreDisplay;
  }

  int getLatestRuns() {

    return 90;
  }

  int getLatestWickets() {

    return 2;
  }


  float getLatestOvers() {
    return (float) 10.2;
  }


  public void dataChange() {
    runs = getLatestRuns();
    wickets = getLatestWickets();
    overs = getLatestOvers();

    currentScoreDisplay.update(runs, wickets, overs);
    averageScoreDisplay.update(runs, wickets, overs);
  }
}

class AverageScoreDisplay {
  private float runRate;
  private int predictedScore;


  public void update(int runs, int wickets, float overs) {
    this.runRate = (float) runs / overs;
    this.predictedScore = (int) (this.runRate * 50);
    display();
  }

  public void display() {
    System.out.println("\nAverage Score Display:\n" +
        "Run Rate: " + runRate +
        "\nPredictedScore: " + predictedScore);
  }
}

class CurrentScoreDisplay {
  private int runs, wickets;
  private float overs;

  public void update(int runs, int wickets, float overs) {

    this.runs = runs;
    this.wickets = wickets;
    this.overs = overs;
    display();
  }


  public void display() {
    System.out.println("\nCurrent Score Display: \n" +
        "Runs: " + runs + "\nWickets:"
        + wickets + "\nOvers: " + overs);
  }
}


public class ObservePattern {

  public static void main(String[] args) {

    AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
    CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

    CricketData cricketData = new CricketData(currentScoreDisplay, averageScoreDisplay);

    cricketData.dataChange();

    ObservePattern example = new ObservePattern();

  }

}

