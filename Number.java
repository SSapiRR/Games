
/**
 * Write a description of class Number here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Number
{
    public int _num;
    private final static int DIGITS=4;

    public Number () {
        int n;
        do{
            n= (int)(Math.random()*Math.pow(10,DIGITS));
        }while(!isValid(n));
        _num=n;
    }

    public Number(int n) {
        if (isValid(n))
            _num = n;
        else 
            _num = 1000;
    }

    public int howManyHits(Number other) {
        int count=0;
        for (int i=1; i<=DIGITS;i++) 
            if (getNthDigit(i)==other.getNthDigit(i))
                count++;
        return count;
    }

    public int howManyAlmost(Number other) {
        int count=0;
        for (int i=1; i<=DIGITS;i++) {
            int d= getNthDigit(i);
            for (int j=1; j<=DIGITS;j++)
                if (i!=j&&d==other.getNthDigit(j))
                    count++;
        }
        return count;
    }

    private boolean isValid(int n) {
        if (n<Math.pow(10,DIGITS-1)||n>Math.pow(10,DIGITS))
            return false;

        while (n>0)
        {
            int digit = n%10;
            int temp = n/10;
            while (temp>0)
            {
                int d = temp %10;
                if (d==digit)
                    return false;
                temp/=10;
            }
            n/=10;
        }
        return true;
    }

    private int getNthDigit(int ind) {
        if (ind <1||ind >DIGITS)
            return -1;
        int temp = _num;
        temp/=Math.pow(10, DIGITS-ind);
        return temp%10;

    }
}
