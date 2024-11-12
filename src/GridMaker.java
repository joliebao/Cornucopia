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
        int bombCount = 0;

        x = (int) (Math.random() * gridNum);
        y = (int) (Math.random() * gridNum);
        if (y > (gridNum/2)){
            y -= 1 + (Math.random() * (gridNum/bombNum));
        }

        System.out.println(bombNum);

        for (int i = 0; i < gridNum; i++) {
            mapping += "\n";
            for (int i2 = 0; i2 < gridNum; i2++){
                if (i2 == x && i == y && bombCount < bombNum) {
                    bombCount ++;
                    mapping += " B ";
                    System.out.println(bombCount);

                    y += (int) (Math.random() * gridNum/bombNum);
                    x = (int) (Math.random() * gridNum);

                } else {
                    mapping += " - ";
                }
            }
        }
        return mapping;
    }
}
