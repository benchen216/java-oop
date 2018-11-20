import java.awt.Point ; // 內建的class Point有覆寫物件模型的各種函數
import java.util.* ;
class Polygon2 implements Comparable { // 多邊形
    Point[] points ; // 記錄多邊形的各頂點
    Polygon2() { }
    Polygon2(Point[] pa) { // 此處暫且使用shallow copy
        points = pa ;
    }
    // -- copy constructor ---
    Polygon2(Polygon2 pg2) {
        this.points = new Point[pg2.points.length];
        for (int i = 0; i < pg2.points.length; i++){
            this.points[i] = new Point(pg2.points[i]);
        }
        // DIY, 使用deep copy
    }
    public boolean equals(Object obj) {
        int c=0;
        if(this==obj)return true;
        if(!(obj instanceof Polygon2))return false;
        Polygon2 pg2 = (Polygon2)obj;
        if(pg2.points.length!= this.points.length)return false;
        for(Point i:pg2.points){
            for (int j=0;j<pg2.points.length;j++){
                if(this.points[j].equals(i))c++;
            }
        }
        if(c==pg2.points.length)return true;
        // DIY, 依序比較多邊形各頂點是否相同
        return false ;
    }
    public String toString() {
        String output = "";
        for (int i=0;i<this.points.length;i++){
            output+=("("+this.points[i].x+","+this.points[i].y+")");
            if(i!=points.length-1)output+=",";
        }
        // 格式請參考程式輸出
        return "{"+output+"}" ;
    }
    public double boundary() {
        double border1=0;
        for(int i=1;i<points.length;i++){
            border1+=points[i-1].distance(points[i]);
            if(i==points.length-1){
                border1+=points[i].distance(points[0]);
            }
        }
        // [功能]: 計算多邊形週長，供compareTo()呼叫
        return border1 ;
    }
    public int compareTo(Object obj) {
        // DIY: 以多邊形周長的大小做為比較的依據
        // 若本多邊形周長大於obj的周長則回傳1，相等回傳0，否則回傳-1
        if(!(obj instanceof Polygon2))return 1;
        if(((Polygon2)obj).boundary()==this.boundary())return 0;
        if(((Polygon2)obj).boundary()<this.boundary())return 1;
        return -1;
    }
    public int hashCode() {
        int hash=17;
        // 初始值17, 之後逐一累加Point之hashCode()，累加前先乘上37
        for (Point i:points){
            hash+=i.hashCode()*37;
        }
        return hash ;
    }
}

public class HWK4_405410068_陳睿瑜_01 {
    public static void main(String[] args) {
        Point[] ps1 = {new Point(0,0), new Point(4,0), new Point(6,2),
                new Point(4,6), new Point(1,6)};
        Point[] ps2 = { new Point(4,0), new Point(6,2), new Point(4,6),
                new Point(1,6), new Point(0,0)};
        Point[] ps3 = { new Point(-3,0), new Point(4,0), new Point(2,5)};
        System.out.println("--- test constructor,toString(),boundary(),hashCode() ---") ;
        Polygon2[] pgs = {new Polygon2(ps1), new Polygon2(ps2),
                new Polygon2(ps3), null } ;
        pgs[3] = new Polygon2(pgs[2]) ; // test copy constructor

        for (int i = 0 ; i<pgs.length; i++) {
            System.out.print("pgs["+i+"]="+pgs[i]);
            System.out.printf(" Boundary=%.3f",pgs[i].boundary()) ;
            System.out.printf(" hashCode=%d\n",pgs[i].hashCode()) ;
        }

        System.out.println("---- test equals()--- ") ;
        Polygon2 key = new Polygon2(new Point[]{
                new Point(6,2), new Point(4,6),
                new Point(1,6), new Point(0,0), new Point(4,0)}) ;
        System.out.println("key="+key) ;
        for (int i = 0 ; i<pgs.length; i++) {
            if (pgs[i].equals(key))
                System.out.println("found in pgs[], index="+i) ;
        }
        System.out.println("---- test Comparable ---") ;
        Arrays.sort(pgs) ;
        for (int i = 0 ; i<pgs.length; i++)
            System.out.println("pgs["+i+"]="+pgs[i]);

    }
}
