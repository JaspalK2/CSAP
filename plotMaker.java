import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class plotMaker extends Application {
    public static Double[][] Percent;
    public static int num;
    @Override public void start(Stage stage) {
        stage.setTitle("Scatter Chart Sample");
        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
        final NumberAxis yAxis = new NumberAxis(0, 10, 1);        
        final ScatterChart<Number,Number> sc = new
            ScatterChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Score");                
        yAxis.setLabel("Rounds");
        sc.setTitle("Score Vs. Rounds");
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Equities");
        for(int i = 0; i<num; i++){
            series1.getData().add(new XYChart.Data(Percent[i][0], Percent[i][1]));
        
        }
        series1.getData().add(new XYChart.Data(4.2, 193.2));
        
        
 
        sc.getData().addAll(series1);
        Scene scene  = new Scene(sc, 500, 400);
      
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        MemoryGameGUI x = new MemoryGameGUI();
        boolean isHard = x.Easy_Hard();
        boolean isRandomized = x.isRand2();
        int numRounds = x.numRounds();
        Double[][] Percentage = new Double[numRounds][2];
        if(isHard){
            MemoryGame y = new MemoryGame();
            y.setRand(isRandomized);
            int j = 0;
            for(int i = 0; i < numRounds; i++){
             y.V2();
             
             Double score = new Double(y.getScore());
             Double rounds = new Double(y.getRounds());
             Percentage[i][j]= score;
             j++;
             Percentage[i][j] = rounds;
             j--;
               
             
            }
           
        }
        else{

            MemoryGame y = new MemoryGame();
            
            int j = 0;
            for(int i = 0; i < numRounds; i++){
             y.v1();
             
             Double score = new Double(y.getScore());
             Double rounds = new Double(y.getRounds());
             Percentage[i][j]= score;
             j++;
             Percentage[i][j] = rounds;
             j--;
             
            }
            
        }
        x.conclusion(Percentage, numRounds);
        Percent = Percentage;
        num = numRounds;
        launch(args);
    }
}
