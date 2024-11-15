public class GridMaker {
    private int gridNum;
    private int bombNum;
    private int x;
    private int y;
    private String grid;
    private String guess;
    private String mapping;

    ////// CREATE JAVADOCS LATER __________________________________________

    // constructor :)
    public GridMaker(int gridNum, int bombNum)
    {
        this.gridNum = gridNum;
        this.bombNum = bombNum;
        grid = "";
        int x = 0;
        int y = 0;
        this.mapping = "";
    }

    public void GridReceiver(String guess){
        this.guess = guess;
    }


    // creates the grid of X's :)
    public String shownGrid()
    {
        for (int i = 0; i < gridNum; i++){
            grid += "\n";
            for (int i2 = 0; i2 < gridNum; i2++){
                grid += " X ";
            }
        }
        return grid;
    }

    // creates the grid with B's and C's :)
    public String hiddenGrid(){
        int bombCount = 0;
        boolean cornPlanted = false;

        x = (int) (Math.random() * gridNum);
        y = (int) (Math.random() * gridNum);

        System.out.println(bombNum); // for testing

        for (int i = 0; i < gridNum; i++) {
            mapping += "\n";
            for (int i2 = 0; i2 < gridNum; i2++) {
                if (i2 == x && i == y && !cornPlanted) {
                    mapping += " C ";

                    cornPlanted = true;

                    y += (int) (Math.random() * gridNum / bombNum);
                    x = (int) (Math.random() * gridNum);
                } else {
                    mapping += " - ";
                }
            }
        }

        // only in the first row....
        while (bombCount < bombNum) {
            bombCount++;
            mapping = mapping.replaceFirst("-", "B");

            y = (int) (Math.random() * gridNum);
            x = (int) (Math.random() * gridNum);
        }

        return mapping.toString();
    }

//    public String changeGrid(){
//        // replace X with following -, B, C at guess
//        mapping = hiddenGrid();
//        grid = shownGrid();
//        gridChecker();
//        return grid;
//    }

    public int getX(){
        int from = guess.indexOf("(");
        int to = guess.indexOf(",");
        int x = Integer.parseInt(guess.substring(from+1, to));
        return x;
    }

    public int getY(){
        int from = guess.indexOf(",");
        int to = guess.indexOf(")");
        int y = Integer.parseInt(guess.substring(from+1, to));
        return y;
    }
//
//    Boolean bombNearby = false;
//    Boolean cornNearby = false;
//    Boolean onBomb = false;
//    Boolean onCorn = false;
//
//    // how to make these equal to the values in the string???

    public Boolean gridChecker(){
        int x = getX();
        int y = getY();
        int counter = 0;
        String sensor = "";

        for (int i = 0; i < mapping.length(); i++){
            counter ++;
            if (counter == gridNum * (y - 1) + x){
                sensor = mapping.substring(counter, counter+1);
            }
        }

        if (sensor.equals("C")){
            return true; // will fix to appropriate conditions later
        }
        if (sensor.equals("B")){
            return true;
        }
//        if (grid.substring(x + 1, x + 2).equals("C") || grid.substring(x - 1, x).equals("C") || grid.substring(y + 1, y + 2).equals("C") || grid.substring(y - 1, y).equals("C")){
//            cornNearby = true;
//        }
//        if (grid.substring(x + 1, x + 2).equals("B") || grid.substring(x - 1, x).equals("B") || grid.substring(y + 1, y + 2).equals("B") || grid.substring(y - 1, y).equals("B")){
//            bombNearby = true;
//        }
        return false; /// WILL FIX LATER THIS METHOD DEFINITELY IT DOESNT WORK YET
    }
//
//    public String decisionMaker(){
//        gridChecker();
//        String end = "";
//        if (cornNearby){
//            end = "WOOO WOOO WOOO \nYour corn radar is going off!";
//        }
//        if (bombNearby){
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

}
