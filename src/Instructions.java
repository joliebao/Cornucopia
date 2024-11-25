import java.util.concurrent.TimeUnit;

public class Instructions {
    private String directions;
    public Instructions(){
        this.directions = "It is Thanksgiving morning, and your mom forgot to pick up the corn cobs!\n" +
                "You can't have a Thanksgiving dinner without her legendary roasted corn!\n" +
                "She sends you outside to go get them.\n" +
                "\n" +
                ".\n" +
                ".\n" +
                ".\n" +
                "\n" +
                "Instructions:\n" +
                "Backyard, there is a corn maze (grid).\n" +
                "You will explore the maze and search for the single corn cob. (Searching comes in the form of coordinate points)\n" +
                "Your neighbor is tired of pesky thieves raiding the corn maze of its maize.\n" +
                "He has set up some flour bombs to keep them out.\n" +
                "Not to worry, you have permission! Just be careful to not get exploded by one of them!" +
                "\n\n" +
                "Demo:\n" +
                "For a grid of 5 - O O O O O\n" +
                "                  O O O O O\n" +
                "                  0 0 0 0 0\n" +
                "                  O O O O O\n" +
                "                  O O O O O\n" +
                "You will then provide a coordinate, for example: (1,3)\n" +
                "                  O O O O O\n" +
                "                  O O O O O\n" +
                "                  / 0 0 0 0\n" +
                "                  O O O O O\n" +
                "                  O O O O O\n" +
                "The spot at (1,3) is then evaluated and crossed out.\n" +
                "Notice that the coordinate system starts from the top left, with that corner being (1,1)\n" +
                "You will continue to guess with coordinates until you find the corn 'C' or a bomb 'B'\n" +
                "If there is nothing there, but a bomb is nearby, you will be alerted\n" +
                "This will come in the form -   O\n" +
                "                              OBO\n" +
                "                               O\n" +
                "Any of the O's around the B will alert you\n" +
                "Be careful to remember which coordinate alerts you though, you will not have a reminder!";
    }

    public String instruct() {
        return directions;
    }

}
