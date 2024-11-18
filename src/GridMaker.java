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

    //METHOD PROBLEMS: runs hiddenGrid() each time --- it should only run once.
    //                 does not work if corn is there

    public String gridChecker(mapping) {
        int x = getX();
        int y = getY();
        int counter = 0;
        String sensor = "placeholder";
        String result = "";

        while (counter < (gridNum * (y - 1) + x)) {
            counter++;
        }
        if (mapping.substring(counter, counter + 1).equals("\n") || mapping.substring(counter, counter + 1).equals(" ")) {
            counter++;
        }
        sensor = (mapping.substring(counter, counter + 1));

        if (sensor.equals("C")) {
            result += "Found corn";
        } else if (sensor.equals("B")) {
            result += "Found bomb";
        } else if (sensor.equals("-")){
            sensor = (mapping.substring(counter-4, counter-3));
            System.out.println(sensor);
            result += "Found Nothing";
        }
//        if (grid.substring(x + 1, x + 2).equals("C") || grid.substring(x - 1, x).equals("C") || grid.substring(y + 1, y + 2).equals("C") || grid.substring(y - 1, y).equals("C")){
//            cornNearby = true;
//        }
//        if (grid.substring(x + 1, x + 2).equals("B") || grid.substring(x - 1, x).equals("B") || grid.substring(y + 1, y + 2).equals("B") || grid.substring(y - 1, y).equals("B")){
//            bombNearby = true;
//        }
        return result;
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
