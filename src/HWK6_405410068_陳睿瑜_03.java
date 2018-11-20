import java.util.*;
class Student3 {
    int id; String name ; double gpa ;
    Student3() { }
    Student3(int _x, String _y, double g) { id= _x; name=_y; gpa=g;}
    public String toString() {
        return "("+id+","+name+","+gpa+")";
    }
}

class IDComparator implements Comparator<Student3> {
    public int compare(Student3 s1, Student3 s2) {
        if (s1.id>s2.id) return 1 ;
        if (s1.id<s2.id) return -1 ;
        return s1.name.compareTo(s2.name) ;
    }
}
class GPAComparator implements Comparator<Student3>{

    @Override
    public int compare(Student3 s1, Student3 s2) {
        if (s1.gpa>s2.gpa) return 1 ;
        if (s1.gpa<s2.gpa) return -1 ;
        return s1.name.compareTo(s2.name) ;
    }
}
public class HWK6_405410068_陳睿瑜_03 {
    public static void main(String[] args) {
        Student3[] studs= new Student3[10] ;
        for (int i = 0 ; i<studs.length; i++)
            studs[i] = new Student3((int)(Math.random()*1000),
                    ("Name_"+i),(2.5+(int)(Math.random()*5)*0.5)) ;

        System.out.println("Before Sort(): "+Arrays.asList(studs)) ;
        Arrays.sort(studs, new IDComparator()) ;
        System.out.println("After Sort(): "+Arrays.asList(studs)) ;
    }
}
