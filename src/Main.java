import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("CORNUCOPIA - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();

        System.out.println("Do you want the instructions? (Yes/No) ");
        String confirmation = s.nextLine().toLowerCase();

        if (confirmation.equals("yes")){
            Instructions directions = new Instructions();
            System.out.println(directions.instruct());
            System.out.println();
        }
        while (!confirmation.equals("no") && !confirmation.equals("yes")){
            System.out.println("Not an option!");
            System.out.println();
            System.out.println("Do you want the instructions? (Yes/No) ");
            confirmation = s.nextLine().toLowerCase();
        }

        System.out.println();

        // get grid value (gridNum * gridNum) -- ex (7 by 7)
        int gridNum = -100000;

        while (gridNum == -100000 || gridNum < 5 || gridNum > 10) {
            System.out.print("Enter a grid size (integers only): ");
            if (gridNum == -100000){
                try {
                    gridNum = Integer.parseInt(s.nextLine());
                }
                catch (NumberFormatException e) {
                    gridNum = 0;
                    System.out.println("This is not a number!");
                    System.out.println();
                }
            }

            if (gridNum != -100000 && gridNum < 5) {
                System.out.println("Too small!");
                System.out.println();
                gridNum = -100000;
            }
            else if (gridNum > 10){
                System.out.println("Where do you think you live? A plantation?");
                System.out.println("Too big!");
                System.out.println();
                gridNum = -100000;
            }
        }

        int bombNum = 2 + ((gridNum - 5)/2);
        boolean loop = true;

        // instantiates new object
        GridMaker a = new GridMaker(gridNum, bombNum);

        System.out.println();
        System.out.println("Find the 'C'!");
        System.out.println();
        System.out.println(a.shownGrid());
        a.hiddenGrid();

        // Until game ends!
        while (loop){
            System.out.println();

            // receive coordinates
            String coordinate = "not coordinate";
            String g = "";

            while (coordinate.equals("not coordinate")) {
                System.out.print("Give a coordinate in the form (x,y): ");
                try {
                    g = s.next();
                    a.gridReceiver(g);
                    a.getX();
                    a.getY();
                    coordinate = "coordinate!";
                } catch (Exception e) {
                    coordinate = "not coordinate";
                    System.out.println("Not in proper coordinate form!");
                    System.out.println();
                }

                if (coordinate.equals("coordinate!")) {
                    a.gridReceiver(g);
                    int x = a.getX();
                    int y = a.getY();

                    if (x < 0 || y < 0) {
                        System.out.println("Too small! Stay inside the maze!");
                        System.out.println();
                        coordinate = "not coordinate";
                    }

                    if (x > gridNum || y > gridNum) {
                        System.out.println("Too big! Stay inside the maze!");
                        System.out.println();
                        coordinate = "not coordinate";
                    }
                }
            }
            System.out.println();

            if (coordinate.equals("coordinate!")){
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