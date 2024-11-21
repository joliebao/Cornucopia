import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
//        System.out.println("CORNUCOPIA - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
//        System.out.println();
//        System.out.println("It is Thanksgiving morning, and your mom forgot to pick up the corn cobs!\n" +
//                "You can't have a Thanksgiving dinner without her legendary roasted corn!\nShe sends you outside to go get them.");
//        System.out.println();
//
//        TimeUnit.SECONDS.sleep(5);
//
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println(".");
//        System.out.println();
//
//        System.out.println("Instructions:\nBackyard, there is a corn maze (grid).\nYou will explore the maze and search for the single corn cob." +
//                "(Searching comes in the form of coordinate points)\n" +
//                "Your neighbor is tired of pesky thieves raiding the corn maze of its maize.\n" +
//                "He has set up some flour bombs to keep them out.\nNot to worry, you have permission! Just be careful to not get exploded by one of them!");
//        System.out.println();
//
//        TimeUnit.SECONDS.sleep(12);

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

        System.out.println();
        boolean loop = true;
        System.out.println(a.shownGrid());
        System.out.println(a.hiddenGrid());

        while (loop){
            System.out.println();
            // the first one always prints one extra "give a coordinate... " -> fix it
            System.out.print("Give a coordinate in the form (x,y): ");
            String g = s.nextLine();

            if (!(g == "")) {
                a.GridReceiver(g);
                int x = a.getX();
                int y = a.getY();
                if (x > gridNum || y > gridNum) {
                    while (x > gridNum || y > gridNum) {
                        System.out.println("Too big! Stay inside the maze!");
                        System.out.print("Give a coordinate in the form (x,y): ");
                        a.GridReceiver(g);
                        g = s.nextLine();
                        x = a.getX();
                        y = a.getY();
                    }
                }

                a.gridChecker();
//                System.out.println(a.decisionMaker());
                System.out.println(a.changeGrid());

//
//                if (!(a.decisionMaker().isEmpty())) {
//                    loop = false;
//                }
            }
        }
        s.close();
    }
}