public class GridMaker {
    private int gridNum;
    private int bombNum;
    private int x;
    private int y;
    private String grid;
    private String mapping;

    // constructor :)
    public GridMaker(int gridNum, int bombNum)
    {
        this.gridNum = gridNum;
        this.bombNum = bombNum;
        grid = "";
        mapping = "";
        int x = 0;
        int y = 0;
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
        int counter = 0;
        int bombCount = 0;

        for (int i = 0; i < gridNum; i++){

            x = (int) (Math.random() * gridNum) + 1;
            y = (int) (Math.random() * gridNum) + 1;

            mapping += "\n";
            System.out.println(bombNum);
            for (int i2 = 0; i2 < gridNum; i2++){
                if (counter != x * y) {
                    mapping += " - ";     // nothing is there
                } else if (counter == x * y && bombCount < bombNum){
                    bombCount++;
                    mapping += " B ";     // there is a bomb there
                    for (int i3 = 0; i3 <= bombNum; i3++){
                        int x1 = (int) (Math.random() * gridNum) + 1;
                        int y1 = (int) (Math.random() * gridNum) + 1;
                        if (x1 == x && y1 == y){
                            x1 = (int) (Math.random() * gridNum) + 1;
                            y1 = (int) (Math.random() * gridNum) + 1;
                        }
                        x = x1;
                        y = y1;;
                    }
                }
                counter ++;
            }
        }
        return mapping;
    }
}
