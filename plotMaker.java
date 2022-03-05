import edu.princeton.cs.algs4.LinearRegression;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class plotMaker extends Application {
   
    public static Double[][] Percent;
    public static int num;

    public static Double num2;
    public static double intercept;
    public static double slope;
    /**
   * takes in two lists to determine the overall correlation that the player had throughout the rounds based on their score vs rounds
   * @param xs will store the x array of values
   * @param ys will store the y array of values
   */
    public static double Correlation(int[] xs, int[] ys) {
        //TODO: check here that arrays are not null, of the same length etc
    
        double sx = 0.0;
        double sy = 0.0;
        double sxx = 0.0;
        double syy = 0.0;
        double sxy = 0.0;
    
        int n = xs.length;
    
        for(int i = 0; i < n; ++i) {
          double x = xs[i];
          double y = ys[i];
    
          sx += x;
          sy += y;
          sxx += x * x;
          syy += y * y;
          sxy += x * y;
        }
    
        // covariation
        double cov = sxy / n - sx * sy / n / n;
        // standard error of x
        double sigmax = Math.sqrt(sxx / n -  sx * sx / n / n);
        // standard error of y
        double sigmay = Math.sqrt(syy / n -  sy * sy / n / n);
    
        // correlation is just a normalized covariation
        return cov / sigmax / sigmay;
      }
    /**
   * This method will start the prodcution of the data using series for the scatter graph, it will use an Axis naming mechanisim, a series adding forloop with the data lists, and finally at the end it will save this all and display a plot when the "launch(args) command is played in the main function"
   */
      @Override public void start(Stage stage) {
        
        stage.setTitle("Scatter Chart Sample");
        final NumberAxis xAxis = new NumberAxis(0, num*2, 1);
        final NumberAxis yAxis = new NumberAxis(0, num*2, 1);        
        final ScatterChart<Number,Number> sc = new
            ScatterChart<Number,Number>(xAxis,yAxis);
            final LineChart<Number,Number> lc = new
        LineChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Score");                
        yAxis.setLabel("Rounds");
        sc.setTitle("Score Vs. Rounds, Correlation(R): "+ String.format("%.2f", num2)+", Linear Regression Line: "+ String.format("%.2f", slope)+"X +  "+String.format("%.2f", intercept));
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Total Score Vs. Total Round Points");
        for(int i = 0; i<num; i++){
            series1.getData().add(new XYChart.Data(Percent[i][0], Percent[i][1]));
        
        }
        series1.getData().add(new XYChart.Data(4.2, 193.2));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("line");
        for(int i = 0; i<num; i++){
            series2.getData().add(new XYChart.Data(Percent[i][0], Percent[i][1]));
        
        }
 
        sc.getData().addAll(series1);
        
        Scene scene  = new Scene(sc, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
   
 /**
   * This function will run the entire program, here it will run through all prefeerences that the user may want to select such as the easy or hard game mode, or the randomized words game mode, it will finally take all this, store it in a 2d array with the score and the rounds, and run the plot graph function along with the correaltion function to label the plot
   * 
   */
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
        int[] PercentX = new int[numRounds];
        int[] PercentY = new int[numRounds];
        for(int i = 0; i < numRounds;i++){
            int X = (int) Math.round(Percentage[i][0]);
            PercentX[i] = X;
            int Y = (int) Math.round(Percentage[i][1]);
            PercentY[i] = Y;

        }
        double[] xAxis = new double[numRounds];
        double[] yAxis = new double[numRounds];
        for(int i = 0; i < numRounds;i++){
             Double  X =  (double) Math.round(Percentage[i][0]);
            xAxis[i] = X;
            Double  Y =  (double) Math.round(Percentage[i][1]);
            yAxis[i] = Y;

        }
        Double value = Correlation(PercentX, PercentY);
        num2 = value;
        LinearRegression line  = new LinearRegression(xAxis, yAxis);
        slope = line.slope();
        intercept = line.intercept();

        launch(args);
       


    }
}
