import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Bienvenue dans Filler version minimale ");
        Scanner scan = new Scanner(System.in);
        Board board = new Board(13);
        board.oneDisplay();
        board.displayConsole();
        //board.play();

    }

}
