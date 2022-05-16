
public class Mathematics {

    private Mathematics(){}

    public static long factorial(int a) throws FactorialOverflowException{
        long res = 1;
        for(int i = 1; i <= a; i++){
            res *= i;
            if (res < 0) throw new FactorialOverflowException("Decrease in calculation accuracy occurred");
        }
        return res;
    }
}
