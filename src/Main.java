import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("CORNUCOPIA");
        System.out.println();
        System.out.println("It is Thanksgiving morning, and you mom forgot to pick up the corn cobs!\n" +
                "You can't have a Thanksgiving dinner without her legendary roasted corn!\nShe sends you outside to go get them.");
        System.out.println();
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println();

        System.out.println("Instructions:\nBackyard, there is a corn maze (grid).\nYou will explore the maze and search for the single corn cob." +
                "(Searching comes in the form of coordinate points)\n" +
                "Your neighbor is tired of pesky thieves raiding the corn maze of the maize.\n" +
                "He has set up some flour bombs to keep them out.\nBe careful to not be one of them!");
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

        System.out.println();
        boolean loop = true;

        while (loop){
            System.out.println();
            System.out.println(a.shownGrid());
            // the first one always prints one extra "give a coordinate... " -> fix it
            System.out.print("Give a coordinate in the form (x,y): ");
            String g = s.nextLine();

            if (!(g == "")) {
                a.GridReceiver(g);
                a.getX();
                a.getY();
                System.out.println(a.gridChecker());
                System.out.println(a.decisionMaker());
                System.out.println(a.changeGrid());

                if (!(a.decisionMaker().isEmpty())) {
                    loop = false;
                }
            }
        }
        s.close();
    }
}