package lab0;

public class Variant9 {

    /**
     *
     * @param x is an integer with absoulute value < 1000 and > 99
     * @return first digit of the number
     */

    public int integerNumbersTask(int x) {
        assert Math.abs(x) > 99 && Math.abs(x) < 1000: "99 < |x| < 999";
        System.out.println("Integer task for " + x + " = " + x / 100);
        return x / 100;
    }

    /**
     *
     * @param a, b are integer numbers
     * @return true, if number is possitive
     */
    public boolean booleanTask(int a, int b) {
        boolean c = a % 2 == 1 || b % 2 == 1;
        System.out.println("Boolean task for " + a + " & " + b + " - " + c);
        return c;
    }

    /**
     *
     * @param a, b are double numbers
     * @return lowest between these 2 numbers assigned to a
     */
    public double ifTask(double a, double b) {
        if(a > b){
            double temp;
            temp = a;
            a = b;
            b = temp;
        }
        System.out.println("If task new a,b: " + a + " " + b);
        return a;
    }

    /**
     *
     * @param d, m are integers representing day and month respectively
     * @return tommorow's date in format {d,m}
     */
    public String caseTask(int d, int m) {
        assert m >= 1 && m <= 12 && d >= 1 && d <= 31: "Invalid day or month";
        int day = d, month = m;
        switch(m){
            case 2:
                if(d == 28){
                    day = 1;
                    month = 3;
                }
                else{
                    day++;
                }
                break;
            case 12:
                if(d == 31){
                    day = 1;
                    month = 1;
                }
                else{
                    day++;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = d == 30 ? 1 : ++day;
                month = day > d ? month : ++month;
                break;
            default:
                day = d == 31 ? 1 : ++day;
                month = day > d ? month : ++month;
                break;
        }
        String res = "" + String.valueOf(day) + " " + String.valueOf(month);
        System.out.println("Case task: " + d + " " + m + " -> " + res);
        return res;
    }

    /**
     *
     * @param a, b are integer numbers
     * @return sum of squares all integers in the interim [a, b]
     */
    public int forTask(int a, int b) {
        assert a < b: "a must be less than b";
        int sum = 0;
        for (int i = a; i <= b; i++){
            sum += i * i;
        }
        System.out.println(a + "^2 + ... + " + b + "^2 = " + sum);
        return sum;
    }

    /**
     *
     * @param n is an integer
     * @return find the lowest integer k which satisfies condition 3*k > n
     */
    public int whileTask(int n) {
        assert (n > 1): "n should be more than 1";
        int k = 1, a = 3;
        while (a <= n){
            a *= 3;
            k++;
        }
        System.out.println("Min k which satisfies 3^k > " + n + " = " + k);
        return k;
    }

    /**
     *
     * @param arr is an array of integers
     * @return string that contains all even numbers from the arr in reverse order and count of them
     */
    public String arrayTask(int[] arr) {
        String res = "[ ";
        int count = 0;
        for (int j = arr.length-1; j >= 0; j--) {
            if(arr[j] % 2 == 0){
                res += String.valueOf(arr[j]) + " ";
                count++;
            }
        }
        res += "] count = " + String.valueOf(count);
        System.out.println("All even numbers in reverse and quantity of them: " + res);
        return res;
    }

    /**
     *
     * @param array - matrix of integers
     * @return matrix of rows with even indices
     */
    public String twoDimensionArrayTask(int[][] array) {
        String res = "", str = "";
        System.out.println("Array task:");
        for(int i = 1; i < array.length; i+= 2){
            for (int item : array[i]) {
                str += item + " ";
            }
            System.out.println(str);
            res += str + "\n";
            str = "";
        }
        System.out.println();
        return res.substring(0, res.length()-1);
    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }
}
