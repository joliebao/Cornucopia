import java.util.ArrayList;
import java.util.List;

/**
 * The GridMaker Class makes grids (sGrid, hGrid, grid1, grid2) and updates them based on inputted coordinates (guess).
 * A grid requires a size (gridNum), and coordinates require and x (x) and y value (y).
 * In this usage, two Grids are needed, one of the hidden values (whole grid) and one of the shown grids.
 */
public class GridMaker {
    private int gridNum;
    private int bombNum;
    private int x;
    private int y;
    private String sGrid;
    private String hGrid;
    private List<String> grid1 = new ArrayList<String>();
    private List<String> grid2 = new ArrayList<String>();
    private String guess;

    /**
     * Constructor for the GridMaker class. This creates a new instance of the GridMakers given
     * the below parameters.
     *
     * @param gridNum represents the size of the Grid
     * @param bombNum represents the number of Bombs based on the size of the grid
     *
     * It also instantiates the other variables and lists needed to operate the code
     */
    public GridMaker(int gridNum, int bombNum)
    {
        this.gridNum = gridNum;
        this.bombNum = bombNum;
        int x = 0;
        int y = 0;
        List grid1 = new ArrayList();
        sGrid = grid1.toString();
        List grid2 = new ArrayList();
        hGrid = grid2.toString();
    }

    /**
     * gridReceiver method for the GridMaker class. This method will take in the user's
     * coordinate guess.
     */
    public void gridReceiver(String guess){
        this.guess = guess;
    }

    /**
     * shownGrid method for the GridMaker class. This method will make a grid of X's based on the
     * user's choice of Grid Size, first as a List, and then change it into a String.
     *
     * @return returns a String in a properly formatted square grid
     * storing the original X's of the shown grid (sGrid). Note that this one will be printed.
     */
    public String shownGrid()
    {
        for (int i = 0; i < gridNum; i++){
            for (int i2 = 0; i2 < gridNum; i2++){
                grid1.add(" X");
            }
            grid1.add("\n");
        }
        sGrid = grid1.toString();
        sGrid = sGrid.replace(",","");
        sGrid = sGrid.replace("[","");
        sGrid = sGrid.replace("]","");
        sGrid = sGrid.trim();
        sGrid = "  " + sGrid;
        return sGrid;
    }

    /**
     * hiddenGrid method for the GridMaker class. This method will make a grid of X's based on the
     * user's choice of Grid Size, first as a List, and then change it into a String.
     * Before its conversion into a String, it will replace random indexes of the List with one 'C'
     * and the variable bombNum number of 'B's.
     *
     * @return returns a String of the hidden grid (hGrid) in a single line
     * Note that this one won't be printed.
     */
    public String hiddenGrid(){
        int bombCount = 0;
        boolean cornPlanted = false;

        for (int i = 0; i < gridNum; i++){
            grid2.add("\n");
            for (int i2 = 0; i2 < gridNum; i2++){
                grid2.add("-");
            }
        }

        int rand = (int) (Math.random() * (gridNum*gridNum));

        if (!cornPlanted) {
            grid2.remove(rand);
            grid2.add(rand, "C");
            rand = (int) (Math.random() * (gridNum*gridNum));
        }

        while (bombCount < bombNum) {
            bombCount++;
            grid2.remove(rand);
            grid2.add(rand, "B");
            rand = (int) (Math.random() * (gridNum*gridNum));
        }

        hGrid = grid2.toString();
        hGrid = hGrid.replace(",","");
        hGrid = hGrid.replace("[","");
        hGrid = hGrid.replace("]","");
        hGrid = hGrid.replaceAll("\\s+","");
        hGrid = hGrid.trim();
        return hGrid;
    }

    /**
     * changeGrid method for the GridMaker class. This method will change the original grid
     * from the shownGrid method first as a List, and then change it into a String.
     * It will replace specific indexes of the List with '-', 'B', or 'C'
     * based on the gridChecker method
     *
     * @return returns a String in a properly formatted square grid
     * storing the changed grid. Note that this one will be printed.
     */
    public String changeGrid(){
        // replace X with following -, B, C at guess
        String result = gridChecker();
        int counter = 0;

        while (counter < (x + (gridNum) * (y - 1))) {
            counter++;
        }
        counter += (y-1);
        counter --;

        // DOES NOT ADD THE / WHEN NECESSARY
        if (result.equals("Found bomb")){
            grid1.remove(counter);
            grid1.add(counter, " B");
        } else if (result.equals("Found corn")){
            grid1.remove(counter);
            grid1.add(counter, " C");
        } else {
            grid1.remove(counter);
            grid1.add(counter, " -");
        }

        sGrid = grid1.toString();
        sGrid = sGrid.replace(",","");
        sGrid = sGrid.replace("[","");
        sGrid = sGrid.replace("]","");
        sGrid = sGrid.trim();
        sGrid = "  " + sGrid;
        return sGrid;
    }

    /**
     * getX method for the GridMaker class. This method will take the guess from gridReceiver()
     * and take the integer x-value from the guess String.
     *
     * @return returns an int x that stores the x-value from the coordinate guessed.
     */
    public int getX(){
        int from = guess.indexOf("(");
        int to = guess.indexOf(",");
        x = Integer.parseInt(guess.substring(from+1, to));
        return x;
    }

    /**
     * getY method for the GridMaker class. This method will take the guess from gridReceiver()
     * and take the integer y-value from the guess String.
     *
     * @return returns an int y that stores the y-value from the coordinate guessed.
     */
    public int getY(){
        int from = guess.indexOf(",");
        int to = guess.indexOf(")");
        y = Integer.parseInt(guess.substring(from+1, to));
        return y;
    }

    /**
     * gridChecker method for the GridMaker class. This method will create an index based on
     * the grid size and coordinate guessed.
     * It will compare that index of the hidden grid with the characters '-', 'B', or 'C'
     *
     * @return returns a String response in variable result that stores a different
     * indicator based on what character the index is.
     * Note that this will be printed, and used for conditions in the changeGrid method and decisionMaker method.
     */
    public String gridChecker() {
        int counter = 0;
        String result = "";

        while (counter < (x + ((gridNum) * (y - 1)))) {
            counter++;
        }

        String sensor = (hGrid.substring(counter-1, counter));

        if (sensor.equals("C")) {
            result = "Found corn";
        } else if (sensor.equals("B")) {
            result = "Found bomb";
        } else if (sensor.equals("-")){
            if (grid2.get(counter - 1).equals("B") || grid2.get(counter + 1).equals("B") || (counter+gridNum < gridNum*gridNum) && grid2.get(counter + gridNum).equals("B") || (counter-gridNum > 0) && grid2.get(counter - gridNum).equals("B")){
                result += "WOOO WOOO WOOO \nCareful! Your bomb radar is going off!\n";
            } else {
                result += "Found Nothing";
            }
        }
        return result;
    }

    /**
     * decisionMaker method for the GridMaker class. This method will determine whether
     * the game has ended of not based on the returned response of GridChecker()
     *
     * @return returns a String response in variable end that stores a different
     * statement based on whether the player wins or loses.
     * Note that this will be printed and end the game.
     */
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
