import java.util.Scanner;
/**
 * GameBullsAndCows.
 *
 * @author Sapir
 * @version 2/1/23
 */
public class GameBullsAndCows
{
    public static void main (String[]args) {
        Scanner scan = new Scanner (System.in);
        Number comp = new Number ();
        boolean win =false;
        final int DIG=4;
        int count=1;
        do{
            System.out.println ("Enter your guess, press -1 to exit");
            int n = scan.nextInt();
            if (n==-1)
                break;

            Number user = new Number(n);
            int hits = comp.howManyHits(user);
            int almost = comp.howManyAlmost(user);
            if (hits==DIG) {
                System.out.println("You won! The number is "+comp._num+
                ".\nit took u "+count+" guesses");
                win= true;
            }
            else {
                System.out.println ("Hits: "+hits+", Almost: "+almost);
                count++;
            }
        }while(!win);
    }
}
