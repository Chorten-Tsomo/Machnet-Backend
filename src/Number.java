public class Number {
    private int num;

    public Number() {
        num = 421;
    }

    public Number(int n) {
        num = n;
    }

    public boolean isZero() {
        if (num == 0)
            return true;
        else
            return false;

    }

    public boolean isPositive() {
        if(num > 0)
            return true;
        else
            return false;
    }

    public boolean isNegative() {
        if(num < 0)
            return true;
        else
            return false;
    }

    public boolean isOdd() {
        if(num % 2 != 0)
            return true;
        else
            return false;
    }

    public boolean isEven() {
        if(num % 2 == 0)
            return true;
        else
            return false;
    }

    public boolean isPrime() {
        boolean flag = false;

        for(int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag)
            return true;
        else
            return false;

    }

    public boolean isAmstrong() {
        if(num == 0)
            return true;
        else
            return false;
    }

    public int getFactorial() {
        int fact = 1;

        for(int i = 1; i <= num; ++i) {
            fact= fact * i;
        }

        return fact;
    }

    public int getSqr() {
        int i = num * num;
        return i;
    }

    public int sumDigits() {
        int sum = 0;
        while( num != 0){
            sum = sum + num % 10;
            num = num/10;
        }

        return sum;
    }

    public int getReverse() {
        int reverse = 0;
        while(num !=0){
            int rem = num % 10;
            reverse = reverse * 10 + rem;
            num = num/10;
        }

        return reverse;
    }

    public double getSqrt() {
        double d = Math.sqrt(num);
        return d;
    }

    public static void main(String[] args) {
        Number number = new Number();
        System.out.println("isZero:" + number.isZero());
        System.out.println("isPositive:" + number.isPositive());
        System.out.println("isNegative:" + number.isNegative());
        System.out.println("isOdd:" + number.isOdd());
        System.out.println("isEven:" + number.isEven());
        System.out.println("isPrime:" + number.isPrime());
        System.out.println("isAmstrong:" + number.isAmstrong());
        System.out.println("getFactorial:" + number.getFactorial());
        System.out.println("getSqr:" + number.getSqr());
        System.out.println("sumDigits:" + number.sumDigits());
        System.out.println("getReverse:" + number.getReverse());
        System.out.println("getSqrt:" + number.getSqrt());
    }
}
