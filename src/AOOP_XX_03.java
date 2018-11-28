import java.util.* ;
class Score2 { // 分數只能為0,1,2,…,99,100
	private int v ; // 儲存分數
	static Score2[] value = new Score2[101] ; // 儲存並控制物件的單一性
	static { // 4%, 初始化value[]
           for (int i=0; i<value.length; i++) 
               value[i] = new Score2(i) ;
	} 
	public static Score2 valueOf(int v){ // 4%,  static factory methods
            if (v<0) v=0 ; 
            if (v>100)v=100 ;
            return value[v]; // 自行修改本行
	}
	private Score2(int v) { this.v = v ; }
	public int value() { return v; }
}
public class AOOP_XX_03 {
    public static void main(String[] args) {
	Random r = new Random(111) ;
        Score2[] scores = new Score2[50] ; //全班有50個人
        System.out.print("score[]=");
        for (int i=0; i<scores.length; i++) {
            scores[i] = Score2.valueOf(r.nextInt(101)) ;
            System.out.print(scores[i].value()+" ") ;
        }
        System.out.println() ;
        // 以亂數產生[0,100]之間的分數(對應之Score物件)存於scores[]中，再將其印出
        // DIY here, 4%
    }
}
/* [程式輸出]
score[]=2 98 24 6 75 84 53 38 90 66 83 28 0 7 37 69 65 31 66 55 5 30 94 45 22 68 94 86 44 35 27 98 85 90 8 92 72 49 2 60 40 12 57 78 63 15 4 82 8 45 
*/
