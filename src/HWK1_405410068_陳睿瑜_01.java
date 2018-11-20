class Point {
    // instance variables
    private double x, y ;

    // --- constructor
    Point() { }
    Point(double a, double b){ this.x = a; this.y=b;}
    Point(Point p2) { this.x = p2.x; this.y=p2.y;}
    // --- accessor functions
    double getX() { return this.x ; }
    double gety() { return this.y ; }
    // ---- utility functions
    double distance(Point p2) {

        return Math.sqrt((this.x-p2.x)* (this.x-p2.x)+(this.y-p2.y)*(this.y-p2.y)) ;
    }
    public String toString() {  return "("+this.x+","+this.y+")" ; }   // DIY
}

public class HWK1_405410068_陳睿瑜_01 {
    public static void main(String[] args) {
        Point p1 = new Point(2,7), p2 = new Point(15,-8) ;
        double dist = p1.distance(p2) ;
        System.out.println("distance of "+p1+" and "+p2+" is "+dist) ;
    }

}
