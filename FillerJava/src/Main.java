import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        /*
         Le premier parametre renseigne la dimension du plateau de jeux,
         ensuite le nombre de joueur humain puis le nombre d'IA

        /!\ Cependant la somme de joueur humain et d'ia ne doit pas exceder 4 /!\


         */


            Game game = new Game(6, 1, 1, true);


            //int result = 5%2;
            //System.out.println(result);





    }
}


//
//        Board board = new Board(20);
//        board.graphicDisplay();
//        Font font = new Font("Helvetica",1,18);
//        StdDraw.setFont(font);
//        StdDraw.setPenColor(Color.black);
//        StdDraw.text(0.85,1-0.7+4*0.16,"mon score est");
//        StdDraw.text(0.85,1-0.7+3*0.16,"mon score est");
//        StdDraw.text(0.85,1-0.7+2*0.16,"mon score est");
//        StdDraw.text(0.85,1-0.7+1*0.16,"mon score est");
//
//        StdDraw.text(0.5,0.20,"cliquez sur une couleur pour jouer :");
//
//        StdDraw.setPenColor(Color.gray);
//        StdDraw.filledSquare(0.125,0.125-0.09,0.125);
//        StdDraw.setPenColor(Color.red);
//        StdDraw.filledSquare(0.125*2+0.125,0.125-0.09,0.125);
//        StdDraw.setPenColor(Color.black);
//        StdDraw.filledSquare(0.125*4+0.125,0.125-0.09,0.125);
//        StdDraw.setPenColor(Color.green);
//        StdDraw.filledSquare(0.125*7,0.125-0.09,0.125);
//
//
//
//        while (true){
//            if (StdDraw.mousePressed()){
//                StdDraw.setPenColor(Color.white);
//                StdDraw.filledRectangle(0.5,0.20,0.4,0.04);
//                break;
//            }
//
//            try { Thread.sleep(80) ;  }  catch (InterruptedException e) {  }
//
//        }





