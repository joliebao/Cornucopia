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
        boolean full = false;

        x = (int) (Math.random() * gridNum);
        y = (int) (Math.random() * gridNum);

        for (int i = 0; i < gridNum; i++) {
            for (int i2 = 0; i2 < gridNum; i2++) {
                if (i2 == x && i == y && !cornPlanted) {
                    mapping += "C";

                    cornPlanted = true;

                    y += (int) (Math.random() * gridNum / bombNum);
                    x = (int) (Math.random() * gridNum);
                } else {
                    mapping += "-";
                }
            }
        }

        // ONLY IN THE FIRST ROW --> FIX
        while (bombCount < bombNum) {
            bombCount++;
            mapping = mapping.replaceFirst("-","B");
            y = (int) (Math.random() * gridNum);
            x = (int) (Math.random() * gridNum);
        }

        return mapping.toString();
    }

    // NEED TO UPDATE THE GRID FOR USER TO SEE AFTER EVERY GUESS --> FIX THIS USING SAME STRATEGY AS CHANGING THE HIDDEN GRID
    public String changeGrid(){
        // replace X with following -, B, C at guess
        mapping = hiddenGrid();
        grid = shownGrid();
        String result = gridChecker();
        int counter = 0;

        if (result == "Found corn"){
            while (counter < (x + gridNum * (y - 1))) {
                counter++;
            }
            grid = grid.substring(0,counter) + " C " + grid.substring(counter+1);
        } else if (result == "Found bomb"){
            grid = grid.substring(0,counter) + " C " + grid.substring(counter+1);
        } else if (result.equals("Found nothing")){
            grid = grid.substring(0,counter) + " - " + grid.substring(counter+1);
        }
        return grid;
    }

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

    //METHOD PROBLEMS: runs hiddenGrid() each time --- it should only run once. -> fix it
    //                 does not work sometimes if corn is there

    public String gridChecker() {
        int x = getX();
        int y = getY();
        int counter = 0;
        String sensor = "placeholder";
        String result = "";

        String hGrid = hiddenGrid();

        while (counter < (x + gridNum * (y - 1))) {
            counter++;
        }

        sensor = (hGrid.substring(counter, counter + 1));

        if (sensor.equals("C")) {
            result = "Found corn";
        } else if (sensor.equals("B")) {
            result = "Found bomb";
        } else if (sensor.equals("-")){
            if (hGrid.charAt(counter - 1) == 'B' || hGrid.charAt(counter + 1) == 'B'){
                result += "WOOO WOOO WOOO \nCareful! Your bomb radar is going off!";
            }
            if (hGrid.charAt(counter - 1) == 'C' || hGrid.charAt(counter + 1) == 'C'){
                result += "WOOO WOOO WOOO \nYour corn radar is going off!";
            }
            else {
                result = "Found Nothing";
            }
        }
        return result;
    }

    // game keeps ending after one round (?) -> fix
    public String decisionMaker(){
        String result = gridChecker();
        String end = "";

        if (result.equals("Found bomb")){
            end = "You lost! You stepped on a bomb.\nOh man...\nYour mom is not going to be happy...";
        } else if (result.equals("Found corn")){
            end = "You won!\nThe corn was the star of the Thanksgiving Dinner.";
        } else {
            end = "";
        }
        return end;
    }

}
