import java.util.Arrays;
class Student_2 implements Comparable {

    String name ; int score ;
    Student_2() { }
    Student_2(String y, int x) { score= x; name=y; }
    Student_2(Student_2 stu) { score=stu.score; name=stu.name; }

    public int compareTo(Object o) {
        if(this==o)return 0;
        if (!(o instanceof Student_2))return -1;
        Student_2 s2 = (Student_2)o;
        if(this.score>s2.score)return 1;
        if(this.score<s2.score)return -1;
        return this.name.compareTo(s2.name);
        // 先比score，若相等，再比name
    }
    public String toString() { return "("+name+","+score+")";}
}
// --- 使用繼承 ---
class ParttimeStudent extends Student_2 {
    double salary ; // key-3
    ParttimeStudent() { }

    public ParttimeStudent(Student_2 s1, int salary) {
        super(s1);
        this.salary = salary;
    }

    // DIY: 參考main()中的需求，自行加入合適的建構式

    public int compareTo(Object o) { // DIY
        if(this==o)return 0;
        if(!(o instanceof Student_2))return -1;
        int cr = super.compareTo(o);
        if(cr!=0)return cr;
        ParttimeStudent p2 = (ParttimeStudent) o ;
        if(this.score>p2.score)return 1;
        if(this.score<p2.score)return -1;
        if (this.name.compareTo(p2.name)!=0)return this.name.compareTo(p2.name);
        if(this.salary>p2.salary)return 1;
        if(this.salary<p2.salary)return -1;
        // 若id, name相同，則以salary決定大小
        return 0 ;
    }

    @Override
    public String toString() {
        return "("+name+","+score+","+salary+")";
    }
    // DIY: 自行加入toString(), 格式自行設計
}
// --- 使用聚合 ---
class ParttimeStudentX implements Comparable {
    Student_2 stu ;
    double salary ; // key-3
    ParttimeStudentX() { }

    public ParttimeStudentX(Student_2 s2, int salary) {
        this.stu=s2;
        this.salary=salary;
    }

    // DIY, 參考main()中的需求，自行加入合適的建構式

    public int compareTo(Object o) {
        /* DIY here */
        if(this==o)return 0;
        if(!(o instanceof ParttimeStudentX))return -1;
        ParttimeStudentX p2 = (ParttimeStudentX) o ;
        int cr = this.stu.compareTo(p2.stu) ;
        if(cr!=0)return cr;
        if (this.salary>p2.salary)return 1;
        if (this.salary<p2.salary)return -1;

        return 0 ;
    }

    @Override
    public String toString() {
        return "("+stu.name+","+stu.score+","+salary+")";
    }

    // DIY: 自行加入toString(), 格式自行設計
}
public class HWK6_405410068_陳睿瑜_01 {
    public static void main(String[] args) {
        Student_2 s1 = new Student_2("Mary",85) ;
        Student_2 s2 = new Student_2("Peter",73) ;
        Student_2 s3 = new Student_2("Mary",93) ;
        Student_2[] stus = {s1,s2,s3} ;
        Arrays.sort(stus) ;
        System.out.println(Arrays.asList(stus)) ;

        ParttimeStudent ps1 = new ParttimeStudent(s1,35000) ;
        ParttimeStudent ps2 = new ParttimeStudent(s2,25000) ;
        ParttimeStudent ps3 = new ParttimeStudent(s2,29000) ;
        ParttimeStudent[] pss = {ps1,ps2,ps3} ;
        Arrays.sort(pss) ;
        System.out.println(Arrays.asList(pss)) ;

        ParttimeStudentX psx1 = new ParttimeStudentX(s1,35000) ;
        ParttimeStudentX psx2 = new ParttimeStudentX(s2,25000) ;
        ParttimeStudentX psx3 = new ParttimeStudentX(s2,29000) ;
        ParttimeStudentX[] psxs = {psx1,psx2,psx3} ;
        Arrays.sort(psxs) ;
        System.out.println(Arrays.asList(psxs)) ;
    }
}
