//public class GridReceiver {
//    private String guess;
//
//    public GridReceiver(String guess){
//        this.guess = guess;
//    }
//
//    public int getX(){
//        int from = guess.indexOf("(");
//        int x = Integer.parseInt(guess.substring(from+1,from+2));
//        return x;
//    }
//
//    public int getY(){
//        int to = guess.indexOf(",");
//        int y = Integer.parseInt(guess.substring(to+1,to+2));
//        return y;
//    }
//
//    // how to make these equal to the values in the string???
//    public Boolean gridChecker(){
//        Boolean bombNearby = false;
//        Boolean cornNearby = false;
//        Boolean onBomb = false;
//        Boolean onCorn = false;
//        int x = getX();
//        int y = getY();
//
//        // substring of mapping from x and y values == B or C ???
//        // how to get substring
//        // need to import the gridMaker class
//
//        String grid = GridMaker.hiddenGrid();
//        if (grid.substring(x, x+1).equals("C")){
//            onCorn = true;
//        }
//        if (grid.substring(x, x+1).equals("B")){
//            onBomb = true;
//        }
//        if (grid.substring(x + 1, x + 2).equals("C") || grid.substring(x - 1, x).equals("C") || grid.substring(y + 1, y + 2).equals("C") || grid.substring(y - 1, y).equals("C")){
//            cornNearby = true;
//        }
//        if (grid.substring(x + 1, x + 2).equals("B") || grid.substring(x - 1, x).equals("B") || grid.substring(y + 1, y + 2).equals("B") || grid.substring(y - 1, y).equals("B")){
//            bombNearby = true;
//        }
//        return onBomb; /// WILL FIX LATER THIS METHOD DEFINITELY DOESNT WORK YET
//    }
//
//    public String decisionMaker(){
//        gridChecker();
//        String end = "";
//        if (cornNearby){
//            end = "WOOO WOOO WOOO \nYour corn radar is going off!";
//        }
//        if (bombNeary){
//            end = "WOOO WOOO WOOO \nCareful! Your bomb radar is going off!";
//        }
//
//        if (onBomb){
//            end = "You lost! You stepped on a bomb.\nOh man...\nYour mom is not going to be happy...";
//        } else if (onCorn){
//            end = "You won!\nYou're mom is overjoyed that you will have a full Thanksgiving dinner.\nThe corn was the star of the meal.";
//        }
//        return end;
//    }
//
//}