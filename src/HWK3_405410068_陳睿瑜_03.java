import java.util.* ;
import java.math.BigInteger;
public class HWK3_405410068_陳睿瑜_03 {
    public static void main(String[] args) {
        for (int i = 10; i<=100; i+=10) {
            System.out.println(i+"!=") ;
            // 10!, 20!, ..., 100!
            primeFactoring(factorial(i));
        }
        //primeFactoring(Integer.MAX_VALUE-1) ;
    }
    public static BigInteger factorial(int n) { // 計算 n!, n太大無法計算
        BigInteger fac = BigInteger.valueOf(1);
        for (int i=2; i<=n; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac ;
    }

    public static void primeFactoring(BigInteger x) {
        x.abs() ;
        BigInteger divisor = BigInteger.valueOf(2); // 除數
        //System.out.print(x+"=") ;
        while (x.compareTo(BigInteger.valueOf(2))>=0 && x.compareTo(divisor)>=0) {
            int cnt = 0 ; // 記錄次方數
            while (x.mod(divisor).equals(BigInteger.valueOf(0))) {
                x = x.divide(divisor) ;
                cnt++ ;
            }
            if (cnt!=0) { // 此處的divisor湊巧都會是質數，why?
                System.out.print("("+divisor+"^"+cnt+")") ;
            }
            divisor=divisor.add(BigInteger.valueOf(1)) ;
        }
        System.out.println() ;
    }
}

