import java.util.* ;
class Number {
    int x ;
    Number() { }
    Number(int a) {x=a; }
    Number(Number n) {this.x=n.x;}

    @Override
    public String toString() {
        return String.valueOf(x);
    }
}
class MyScore2 {
    // --- 將元素加入LinkedList中請用add() --
    private LinkedList<Number> scoreList = new LinkedList<Number>() ;
    private int rank = -1 ;

    MyScore2(int[] score, int rank) {
        // conversion constructor
        for (int i:score){
            scoreList.add(new Number(i));
        }
        this.rank = rank;

        // DIY: deep copy
    }
    MyScore2(MyScore2 ms2) { // copy constructor
        // DIY: deep copy
        rank=ms2.rank;
        this.scoreList.addAll(ms2.scoreList);//!!!
    }
    public void clear() {
        scoreList.clear(); rank=-1;
    }
    public String toString() {
        String tem = "[";
        for(int i = 0; i<scoreList.size();i++){
            if(i!=scoreList.size()-1)tem += scoreList.get(i).toString()+",";
            else tem += scoreList.get(i).toString();
        }

        // DIY: 格式請參考main()中的指示
        return tem+"]" +"(r:"+rank+")";
    }
}
public class HWK5_405410068_陳睿瑜_02 {
    public static void main(String[] args){
        int[] ss = {77, 99, 88, 66} ;
        MyScore2 ms1 = new MyScore2(ss, 8) ;
        System.out.println("ms1="+ms1) ; // 印出[77,99,88,66] (r:8)
        MyScore2 ms2 = new MyScore2(ms1) ;
        ms1.clear() ; // 本行不可刪除
        System.out.println("ms2="+ms2) ; // 印出[77,99,88,66] (r:8)
    }
}