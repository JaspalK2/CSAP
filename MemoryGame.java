public class MemoryGame{
    MemoryGame(){
        
    }
    private int finalScore;
    private int finalRounds;
    public void v1() {
       String[] memString = {"a", "b", "c"};
        MemoryGameGUI x = new MemoryGameGUI();
        x.createBoard(3, false);
        boolean isPlay = true;
        int rounds = 0;
        int score = 0;
        while(isPlay == true){
          String[] rand = new String[3];
          int[] randNum = RandomPermutation.next(3);
          for(int i = 0; i< randNum.length;i++){
              randNum[i] -=1;
          }
          for(int i = 0; i< randNum.length; i++){
              rand[i] = memString[randNum[i]];
          }
           String response = x.playSequence(rand, 0.5);
           boolean doesMatch = true;
           for(int i =0; i< rand.length;i++){
               if (!(rand[i].equals(response.substring(i,i+1)))){
                   doesMatch  =false;
                   break;
               }
           }
           if(doesMatch == true){
               x.matched();
               score++;
               rounds++;
           }
           else{
               x.tryAgain();
               rounds++;

           }
           finalScore = score;
           finalRounds = rounds;
           isPlay = x.playAgain();
         
        }

          
          
          x.showScore(score, rounds);
      }
      private String[] memString1 = {"a", "b", "c", "d", "e", "f", "g", "h", "0", "1", "2", "3", "4"};
      private boolean isRand = false;
      void setRand(boolean x){
          isRand = x;
      }
    public void V2() {
        String[] memString = new String[13];
        // defining a string with 13 letters
        if(isRand == true){
            String[] rand = new String[13];
            // creating a new string with the same length
            int randNumGen[] = RandomPermutation.next(13);
            
            for(int i = 0; i< randNumGen.length;i++){
                randNumGen[i] -=1;
            }
            for(int i = 0; i < randNumGen.length; i++){
                rand[i] = memString1[randNumGen[i]];
            }
            for(int i = 0; i < memString.length; i++){
                memString[i] = rand[i];
            }
        }
        // delay time can be reduced, more tiles can be added
        //System.out.println("your retarted lol");
        int initial = 3;
        int ending = 13;
        int rounds = 0;
        int score = 0;
        
        MemoryGameGUI x = new MemoryGameGUI();
        boolean isDelay = x.ChangeTime();
        boolean y = x.isRand();
        boolean isPlay = true;
        double delay = 0.4;
        
        while(isPlay && initial <= ending){
            if(isDelay){
                if(y)
                x.createBoard(initial, true);
                else
                x.createBoard(initial, false);

               String[] rand = new String[initial];
               int[] randNum = RandomPermutation.next(initial);
               for(int i = 0; i< randNum.length;i++){
                   randNum[i] -=1;
               }
               for(int i = 0; i< randNum.length; i++){
                   rand[i] = memString[randNum[i]];
               }
                String response = x.playSequence(rand, 0.5);
                boolean doesMatch = true;
                for(int i =0; i< rand.length;i++){
                    if(rand.length != response.length()){
                       doesMatch = false;
                       break;
                    }
                    if (!(rand[i].equals(response.substring(i,i+1)))){
                        doesMatch  =false;
                        break;
                    }
                }
                if(doesMatch == true){
                    x.matched();
                    score++;
                    rounds++;
                    initial++;
                    delay -= 0.05;
                }
                else{
                    x.tryAgain();
                    rounds++;
                    initial++;
                    delay -= 0.05;
     
                }
                isPlay = x.playAgain();
            }
            else{
                x.createBoard(initial, false);
                String[] rand = new String[initial];
               int[] randNum = RandomPermutation.next(initial);
               for(int i = 0; i< randNum.length;i++){
                   randNum[i] -=1;
               }
               for(int i = 0; i< randNum.length; i++){
                   rand[i] = memString[randNum[i]];
               }
                String response = x.playSequence(rand, delay);
                boolean doesMatch = true;
                for(int i =0; i< rand.length;i++){
                    if (!(rand[i].equals(response.substring(i,i+1)))){
                        doesMatch  =false;
                        break;
                    }
                }
                if(doesMatch == true){
                    x.matched();
                    score++;
                    rounds++;
                    initial++;
                    delay -= 0.05;
                }
                else{
                    x.tryAgain();
                    rounds++;
                    initial++;
                    delay -= 0.05;
     
                }
                isPlay = x.playAgain();
            }
         

        }
        finalScore  = score;
        finalRounds = rounds;
        x.showScore(score, rounds);

    }
  
    public void setScore(int x, int y){
        finalScore = x;
        finalRounds = y;
    }
   
    public int getScore(){
        return finalScore;
    }
    public int getRounds(){
        return finalRounds;
    }
}