class Student4 implements Comparable {
    int id ; // 學號
    String name ;   // 姓名
    double[] scores ;  // 各學期分數
    
    Student4() { }
    Student4(Student4 s2) { // 6%
        // copy constructor: use deep-copy
        id = s2.id ;
        name =s2.name ;
        scores = new double[s2.scores.length] ;
        System.arraycopy(s2.scores, 0, scores, 0, scores.length);
    }
    public boolean equals(Object o) { // 7%
        if (o==this) return true ;
        if (!(o instanceof Student)) return false ;
        Student s2 = (Student)o ;
        if (id!=s2.id) return false ;
        if (!name.equals(s2.name)) return false ;
        if (scores.length != s2.scores.length) return false ;
        for (int i = 0; i<scores.length; i++) {
            if (scores[i] != s2.scores[i]) return false ;
        }
        return true ;
    }
    public double avg(double[] a) {
        double total = 0 ;
        for (int i = 0 ; i<a.length; i++) total+=a[i] ;
        return total/a.length ;
    }
    public int compareTo(Object o) { // 8%
        // 先依照學號比大小，若相等，再依照姓名的字典順序
        // 若在相等，再依照平均分數
        if (o==this) return 0 ;
        if (!(o instanceof Student)) return -1 ;
        Student s2 = (Student)o ;
        if (id-s2.id!=0) return id-s2.id ;
        int nc = name.compareTo(s2.name);
        if (nc!=0) return nc ;
        double diff =avg(scores)-avg(s2.scores) ; 
        if (diff>0) return 1; 
        if (diff<0) return -1 ;
        return 0;
    }
    public String toString() { // 5%
        // s1 = [1001] Peter (85.6,76.0,93.7,82.1)
        String s = "["+id+"] "+name+" (" ;
        for (int i = 0 ; i<scores.length-1; i++)
            s+=(scores[i]+",") ;
        s+=scores[scores.length-1] ;
        // 格式請參考[程式輸出]
        return s+=")" ;
    }
}

public class AOOP_XX_02 {
    public static void main(String[] args) {
        Student4 s1 = new Student4() ;
        s1.id = 1001; s1.name="Peter"; 
        s1.scores = new double[]{85.6, 76.0, 93.7, 82.1} ;   
        System.out.println("-- test toString() ---") ;    
        System.out.println("s1 = "+s1) ;
        
        System.out.println("-- test copy constructor ---") ;
        Student4 s2 = new Student4(s1) ;
        System.out.println("s2 = "+s2) ; 

        System.out.println("--- test equals() ---") ;        
        if (s1.equals(s2)) System.out.println("s1 equals to s2") ;
        
        s1.name= "amy" ;
        System.out.println("modify s1, s1="+s1) ;
        if (s1.equals(s2)) System.out.println("s1 equals to s2") ;
        else System.out.println("s1 not equals to s2") ;
        
        System.out.println("---- test compareTo() -----") ;
        System.out.println("s1.compareTo(s1)="+s1.compareTo(s1)) ;
        System.out.println("s1.compareTo(s2)="+s1.compareTo(s2)) ;
        System.out.println("s1.compareTo(\"Peter\")="+s1.compareTo("Peter")) ;
    }
}

/*
[程式輸出]
-- test toString() ---
s1 = [1001] Peter (85.6,76.0,93.7,82.1)
-- test copy constructor ---
s2 = [1001] Peter (85.6,76.0,93.7,82.1)
--- test equals() ---
s1 equals to s2
modify s1, s1=[1001] Peter (85.6,76.0,80.3,82.1)
s1 not equals to s2
---- test compareTo() -----
s1.compareTo(s1)=0
s1.compareTo(s2)=-1
s1.compareTo("Peter")=1
*/
