import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    ////// CREATE JAVADOCS LATER __________________________________________

    // constructor :)
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

    public void GridReceiver(String guess){
        this.guess = guess;
    }

    // creates the grid of X's :)
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

    // creates the grid with B's and C's :)
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

    // NEED TO UPDATE THE GRID FOR USER TO SEE AFTER EVERY GUESS --> FIX THIS USING SAME STRATEGY AS CHANGING THE HIDDEN GRID
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

    public int getX(){
        int from = guess.indexOf("(");
        int to = guess.indexOf(",");
        x = Integer.parseInt(guess.substring(from+1, to));
        return x;
    }

    public int getY(){
        int from = guess.indexOf(",");
        int to = guess.indexOf(")");
        y = Integer.parseInt(guess.substring(from+1, to));
        return y;
    }

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
