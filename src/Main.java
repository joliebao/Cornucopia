import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("CORNUCOPIA - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();

        System.out.println("Do you want the instructions? (Yes/No) ");
        String confirmation = s.nextLine().toLowerCase();
        System.out.println();
        if (confirmation.equals("yes")){
            Instructions directions = new Instructions();
            System.out.println(directions.instruct());
            System.out.println();
        }
        while (!confirmation.equals("no") && !confirmation.equals("yes")){
            System.out.println("Not an option!");
            System.out.println("Do you want the instructions? (Yes/No) ");
            confirmation = s.nextLine().toLowerCase();
            System.out.println();
        }

//        String result = "";
        // get grid value (gridNum * gridNum) -- ex (7 by 7)
        int gridNum = 0;

//        try {
//            gridNum = s.nextInt();
//        } catch (NumberFormatException e) {
//            result = "Isn't num";
//        }
//
//        while (result.equals("Isn't num")){ // just needs parenthesis form
//                System.out.println("Must be a integer!");
//                System.out.println("Try again!");
//                System.out.print("Enter a grid size (integers only): ");
//                gridNum = s.nextInt();
//            }
        while (gridNum < 5 || gridNum > 10) {
            System.out.print("Enter a grid size (integers only): ");
            gridNum = s.nextInt();
            if (gridNum < 5) {
                System.out.println("Too small!");
                System.out.println();
            }
            else if (gridNum > 10){
                System.out.println("Where do you think you live? A plantation?");
                System.out.println("Too big!");
                System.out.println();
            }
        }

        int bombNum = 2 + ((gridNum - 5)/2);

        // CODE TESTING _____________
        GridMaker a = new GridMaker(gridNum, bombNum);

        System.out.println();
        boolean loop = true;
        System.out.println(a.shownGrid());
        a.hiddenGrid();

        while (loop){
            System.out.println();
            System.out.print("Give a coordinate in the form (x,y): ");
            String g = s.next();
            a.gridReceiver(g);
            System.out.println();
//
//            try {
//                a.GridReceiver(g);
//                int test = a.getX();
//                result = "Is coordinate";
//            } catch (NumberFormatException e) {
//                result = "Isn't coordinate";
//            }
//
//            if (result.equals("Isn't coordinate")){ // just needs parenthesis form
//                System.out.println("Must be in the form of (x,y)!");
//                System.out.println("Try again!");
//                System.out.print("Give a coordinate in the form (x,y): ");
//                g = s.nextLine();
//            }

            if (!(g == "")) {
                a.gridReceiver(g);
                int x = a.getX();
                int y = a.getY();
                while (x < 0 || y < 0) {
                    System.out.println("Too small! Stay inside the maze!");

                    System.out.print("Give a coordinate in the form (x,y): ");
                    g = s.next();
                    a.gridReceiver(g);

                    x = a.getX();
                    y = a.getY();
                }
                while (x > gridNum || y > gridNum) {
                    System.out.println("Too big! Stay inside the maze!");

                    System.out.print("Give a coordinate in the form (x,y): ");
                    g = s.next();
                    a.gridReceiver(g);

                    x = a.getX();
                    y = a.getY();
                }

                System.out.println(a.gridChecker());
                System.out.println(a.changeGrid());

                if (!(a.decisionMaker().isEmpty())) {
                    loop = false;
                }
            }
        }
        System.out.println(a.decisionMaker());
        s.close();
    }
}