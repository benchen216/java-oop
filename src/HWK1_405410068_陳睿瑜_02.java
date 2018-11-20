class Polygon { //多邊型
    Point[] points ; //記錄多邊形的各頂點座標, 請使用第一題的Point

    Polygon() { }
    Polygon(Point[] ps) {
        // 使用深度copy, 將ps複製至points
        // points = ps ; // 這行是錯的, 不要這麼寫
        this.points = new Point[ps.length];
        //System.arraycopy(ps,0,this.points,0,ps.length);
        for (int i = 0; i < ps.length; i++){
            this.points[i] = new Point(ps[i]);
        }
    }
    double border() {
        double border1=0;
        for(int i=1;i<points.length;i++){
            border1+=points[i-1].distance(points[i]);
            if(i==points.length-1){
                border1+=points[i].distance(points[0]);
            }
        }
        // DIY: 計算並回傳此多邊型的周長
        return border1 ;
    }
    double area() {
        double areaA=0;
        for (int i=0;i<points.length-2;i++){
            areaA+=triarea(points[0],points[i],points[i+1]);
        }
        // DIY: 計算並回傳此多邊型的面積
        return areaA ;
    }


    double triarea(Point a1, Point point, Point a){
        Point [] aa = new Point[3];
        aa[0]=a1;
        aa[1]=point;
        aa[2]=a;
        double[] p = new double[3];
        for(int i=0;i<3;i++){
            if(i!=2) {
                p[i] = points[i].distance(points[i + 1]);
            }else {
                p[i]=points[0].distance(points[2]);
            }
        }
        double s=(p[0]+p[1]+p[2])/2;
        return Math.sqrt(s*(s-p[0])*(s-p[1])*(s-p[2]));
    }
    void print(String msg) {
        System.out.print(msg) ;
        // DIY: 依照程式輸出印出多邊形
        for (int i=0;i<points.length;i++){
            System.out.print(points[i].toString());
        }
        System.out.println() ;
    }
}

public class HWK1_405410068_陳睿瑜_02 {
    // ------ 測試程式 ----------
    public static void main(String[] args) {
        Point[] ps1 = {new Point(1,0), new Point(4,0), new Point(1,4)} ;
        Polygon pg1 = new Polygon(ps1) ;
        ps1[0] = ps1[1]= ps1[2]=null ;

        pg1.print("pg1=") ;
        System.out.println("border of pg1="+pg1.border());
        System.out.println("area of pg1="+pg1.area());

        Point[] ps2 = {new Point(2,2), new Point(5,0), new Point(10,1), new Point(8,7), new Point(3,9)} ;
        Polygon pg2 = new Polygon(ps2) ;
        pg2.print("pg2=") ;
        System.out.println("border of pg2="+pg2.border());
        System.out.println("area of pg2="+pg2.area());
    }

}
