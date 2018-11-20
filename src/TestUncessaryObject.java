
public class TestUncessaryObject {
    public static void main(String[] arg){
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0L;i<=Integer.MAX_VALUE;i++){
            sum+=i;
        }
        System.out.println("sum:"+sum);
        long end = System.currentTimeMillis();
        System.out.printf("total time=%.3f",(end-start)/1000.0);


    }
}

