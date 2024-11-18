import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean end = false;
        String g = "";   // the guess

        // get grid value (gridNum * gridNum) -- ex (7 by 7)
        int gridNum = 0;
        while (gridNum < 5) {
            System.out.print("Grid size? ");
            gridNum = s.nextInt();
            if (gridNum < 5) {
                System.out.println("Too small!");
                System.out.println();
            }
        }

        int bombNum = 2 + ((gridNum - 5)/2);

        // CODE TESTING _____________
        GridMaker a = new GridMaker(gridNum, bombNum);
        System.out.println(a.shownGrid());
        while (!end) {
            System.out.println();
            System.out.print("Give a coordinate in the form (a,b): ");
            g = s.nextLine();
            String mapping = a.hiddenGrid();

            if (g != "") {
                a.GridReceiver(g);
                a.getX();
                a.getY();
                System.out.println(a.gridChecker(mapping));

            }
        }

    }
}