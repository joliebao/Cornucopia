import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean end = false;
        System.out.println("CORNUCOPIA");
        System.out.println();

        // get grid value (gridNum * gridNum) -- ex (7 by 7)
        int gridNum = 0;
        while (gridNum < 5) {
            System.out.print("Enter a grid size (integers only): ");
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
//        String g = "";

        while (!end){
            System.out.println();
            // the first one always prints one extra "give a coordinate... " -> fix it
            System.out.print("Give a coordinate in the form (x,y): ");
            String g = s.nextLine();

            if (g != "") {
                a.GridReceiver(g);
                a.getX();
                a.getY();
                System.out.println(a.gridChecker());
                System.out.println(a.decisionMaker());
                if (!(a.decisionMaker().equals(""))){
                    end = true;
                }
            }
        }

    }
}