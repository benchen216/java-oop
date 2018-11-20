class Student {
    int id ;
    String name ;
    double gpa ;
    double[] scores ; // 歷年平均成績

    Student setID(int id) { this.id = id ; return this;}
    Student setName(String name) { this.name=name ;return this; }
    Student setGpa(double gpa) { this.gpa =gpa ;return this; }
    void setScores(double[] scs) {
        scores = scs ;
        System.arraycopy(scs,0,scores,0,scs.length);
        // DIY: 使用deep copy 將scs[]複製到scores[]
    }
    void print() {
        System.out.print(id+","+name+","+gpa+",scores=") ;
        for (int i = 0 ; i<scores.length; i++) {
            System.out.print(scores[i]+" ");
        }
        System.out.println() ;
    }
}
public class HWK2_405410068_陳睿瑜_02 {
    public static void main(String[] args) {
        Student s = new Student() ;
        double[] scores = {89.8, 79.6, 87.8, 80.7} ;
        s.setID(1001).setName("Peter").setGpa(4.1).setScores(scores);

        s.print();

        // ---- try this
//        s.id(1002) ;
//        s.print();
//      why not using s.id = 1001 ;

        // ---- and try this
//        s.id(1001).name("Peter").gpa(4.1).scores(scores) ;
//        s.print() ;
    }

}
