
import java.util.* ;

public class AOOP_XX_01 { // XX:成績座號
    public static void main(String[] args) {
        System.out.println("gcd(84,98)="+gcd(84,98)) ; 
        
        ArrayList<Integer> primes = findPrime(100) ;
        System.out.println
        ("Prime in [1,100] = "+primes) ;
    }
    public static int gcd(int a, int b) { // 5%
        if (b==0)return a ;
        return gcd(b,a%b);  
    }
    public static ArrayList<Integer> findPrime(int x) { // 8 %
        // 找出小於等於x的所有質數, 並將結果存在ArrayList中傳回
        ArrayList<Integer> primes = new ArrayList() ;
        if (x<2) return primes ;
        int[] a = new int[x+1] ;
        for (int i=0; i<a.length; i++) a[i]=0 ;
        for (int i=2; i<=x; i++){
            if (a[i]==1) continue ;
            int cnt = i*2 ;
            while (cnt<=x){
                a[cnt] = 1 ;
                cnt+=i ;                
            }
        }
        for (int i=2; i<a.length; i++) 
            if (a[i]==0) primes.add(i) ;
        return primes ;
    }
}
/* [程式輸出]
gcd(84,98)=14
Prime in [1,100] = 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 
*/
