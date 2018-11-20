class Score{
    int id;
    String name;
    int[] avgScore;
    void set(int d, String n, int[] sco){
        this.id = d;
        this.name = n;
        this.avgScore = new int[sco.length];
        System.arraycopy(sco, 0, this.avgScore, 0, sco.length);
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj)return true;
        if (!(obj instanceof Score))return false;
        Score s2 = (Score)obj;
        if (this.id!=s2.id)return false;
        if (this.avgScore.length!=s2.avgScore.length)return false;
        for (int i = 0;i<this.avgScore.length;i++){
            if(this.avgScore[i]!=s2.avgScore[i])return false;
        }
        return true;
    }
}
public class HWK3_405410068_陳睿瑜_01 {
    public static void main(String[] arg){
        Score s1 = new Score(), s2 = new Score();
        Score s3 = new Score(), s4 = new Score();
        int[] a = {58,77,85,79};
        int[] b = {58,77,80,70};
        s1.set(1001,"Peter",a);
        s2.set(1001,"Peter",a);
        s3.set(1001,"Peter",b);
        s4.set(1002,"Mary",b);
        if (s1.equals(s2)) System.out.println("s1 equals to s2");
        if (s1.equals(s3)) System.out.println("s1 equals to s3");
        if (s1.equals(s4)) System.out.println("s1 equals to s4");
        if (s1.equals(s1)) System.out.println("s1 equals to s1");
    }
}
