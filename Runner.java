public class Runner{
    public static void main(String[] args) {
       
        Double[][] Percentage = new Double[2][2];
        MemoryGameGUI x = new MemoryGameGUI();
        boolean isHard = x.Easy_Hard();
        boolean isRandomized = x.isRand2();
        
        if(isHard){
            MemoryGame y = new MemoryGame();
            y.setRand(isRandomized);
            int j = 0;
            for(int i = 0; i < 2; i++){
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
            for(int i = 0; i < 2; i++){
             y.v1();
             
             Double score = new Double(y.getScore());
             Double rounds = new Double(y.getRounds());
             Percentage[i][j]= score;
             j++;
             Percentage[i][j] = rounds;
             j--;
             
            }
            
        }
        x.conclusion(Percentage, 2);

       

    }
}