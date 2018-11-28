import java.util.* ;
class Course implements Comparable { //代表學生所修的一門課
    String courseName ; // 課名
    int score ; // 分數
    int credit ; //學分數

    Course() { }
    Course(String n, int s, int c) {
        courseName = n; score =s ; credit = c ;
    }
    Course(Course c2) {
        courseName = c2.courseName; score=c2.score; credit=c2.credit ;
    }
    Course(String s) { // 5%
        // [功能]: 剖析s字串，將內容填入個欄位中, 使用s.split()
        // [格式]: 例如"(Math,75,2)" -> "Math" 75 2
        String a[];
        a=s.split("\\(")[1].split("\\)")[0].split(",");
        courseName=a[0];
        score=Integer.valueOf(a[1]);
        credit=Integer.valueOf(a[2]);
    }

    public boolean equals(Object obj) { // 5%
        // 完成equals()，逐欄位比較相等性
        if(this==obj)return true;
        if(!(obj instanceof Course))return false;
        Course c2 = (Course)obj;
        if(!this.courseName.equals(c2.courseName))return false;
        if(this.score!=c2.score)return false;
        if(this.credit!=c2.credit)return false;
        return true ;
    }

    public int compareTo(Object obj) {  // 5%
        // 完成compareTo()
        // 逐欄位比較大小，決定次序如下: courseName->score->credit
        if(this==obj)return 0;
        if(!(obj instanceof Course))return -1;
        Course c2 = (Course)obj;
        if(!this.courseName.equals(c2.courseName))return this.courseName.compareTo(c2.courseName);
        if(this.score!=c2.score)return this.score-c2.score;
        if(this.credit!=c2.credit)return this.credit-c2.credit;
        return 0;
    }
    public String toString() {
        return "("+courseName+","+score+","+credit+")" ;
    }
}
class EMBACourse extends Course {
    int expense ; // 學分費
    EMBACourse(Course c, int e) { // 3%
        // [建構式]: c初始化父類別，e初始化expense
        courseName=c.courseName;
        score=c.score;
        credit=c.credit;
        expense=e;
    }

    // -- 撰寫equals()--- 7%
    // [特點]: 1. EMBACouse物件可以和Course物件比較，只比父類別的三個欄位
    //        2. 請務必用分層負責的方式來進行比較，不要直接存取父類別變數
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if (!(obj instanceof Course))return false;
        if((obj instanceof EMBACourse)){
            EMBACourse e2 = (EMBACourse)obj;
           if(!super.equals(e2)) return false;
           if(this.expense!=e2.expense)return false;
           return true;
        }

        Course c2 = (Course) obj;
        if(!super.equals(c2)) return false;

        return true ;
    }
    public String toString() {
        String s = super.toString() ;
        return s.substring(0,s.length()-1)+","+expense+")" ;
    }
}

public class MI4P_405410068_陳睿瑜_03 {
    public static void main(String[] args) {
        Course[] cs = {new Course("Math",95,3), new Course("Math",75,2), new Course("Math",95,2),
                new Course("Physics",89,3), new Course("Eng",77,2), new Course("Physics",89,3)};
        System.out.println("--- test Course's equals() ---");
        for (int i=0; i<cs.length; i++)
            for (int j=i+1; j<cs.length; j++){
                if (cs[i].equals(cs[j]))
                    System.out.println("cs["+i+"] equals to cs["+j+"]") ;
            }
        System.out.println("--- test Course's compareTo() ---");
        Arrays.sort(cs) ;
        for (int i = 0 ; i<cs.length; i++)
            System.out.print(cs[i]) ;
        System.out.println() ;

        System.out.println("--- test Course's Constructor ---");
        Course c2 = new Course(cs[0].toString());
        System.out.println("c2="+c2) ;

        System.out.println("--- test EMBACourse's equals() ---");
        EMBACourse ec1 = new EMBACourse(cs[0], 6000) ;
        EMBACourse ec2 = new EMBACourse(cs[1], 6000) ;
        if (ec1.equals(ec2)) System.out.println(ec1+" equals to "+ ec2) ;
        if (ec1.equals(cs[0])) System.out.println(ec1+" equals to "+cs[0]) ;

    }
}
