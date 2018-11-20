import java.util.*;
class Student2 { //假設每個欄位都有意義
    int id;    String name;    double[] gpa;

    Student2() {  }
    Student2(int a, String b, double[] c) {
        // DIY here
        this.id = a;
        this.name = b;
        this.gpa = c;
    }
    public int hashCode() { // DIY here

        int code = 17 ;

        code = code*37+id;
        code = code*37+name.hashCode();
        for (double i:gpa){
            long j = Double.doubleToLongBits(i);
            code = (code * 37) + (int) (j ^ (j >>> 32));
        }


        return code ;
    }

    @Override
    public String toString() {
        String tem = "("+id+","+name;
        for (double i : gpa){
            tem = tem + "," + i;
        }

        // DIY, 印出的格式自行設計，需印出gpa[]中的每個成績
        return tem+")";
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof Student2))return false;
        if(obj.hashCode()==this.hashCode())return true;

        return false;
    }
}
public class HWK5_405410068_陳睿瑜_01 {
    static HashSet<Student2> hs = new HashSet<Student2>();

    public static void main(String[] args) {
        buildHashSet() ;
        Student2 query = new Student2(1001, "Peter", new double[]{4.1,3.9,3.3}) ; ;

        if (hs.contains(query)) {
            System.out.println("Yes, hs contains "+query); // 應該印出這一行
        } else {
            System.out.println("No, "+query+" is not found in hs.");
        }
    }
    public static void buildHashSet()  {
        hs.add(new Student2(1001, "Peter", new double[]{4.1,3.9,3.3})) ;
        hs.add(new Student2(1002, "Mary", new double[]{4.2, 4.0, 4.2})) ;
        hs.add(new Student2(1003, "Paul", new double[] {3.7, 3.5, 3.3, 4.0})) ;
        System.out.println("Hash Set=" + hs);
    }
}
