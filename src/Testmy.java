
import java.lang.*;
import java.util.*;

class MyclassA implements Comparable{
    int id ;
    int score;
    MyclassA(){

    }
    MyclassA(int id){
this.id =id;
    }

    public MyclassA setId(int id) {
        this.id = id;
        return this;
    }

    public MyclassA setScore(int score) {
        this.score = score;
        return this;
    }

    @Override
    public String toString() {
        return "myclass";
    }

    @Override
    public int hashCode() {
        int code=0;
        code += code*37+this.id*37;
        long j = Double.doubleToLongBits(score);
        code += code*37+(int)j^(j>>>32);
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)return true;
        if(!(obj instanceof MyclassA))return false;
        return super.equals(obj);
    }

    @Override
    public int compareTo(Object o) {
        if(this == o)return 0;
        if(!(o instanceof MyclassA))return -1;
        MyclassA a2 = (MyclassA)o;
        if(this.id>a2.id)return 1;
        if(this.id<a2.id)return -1;
        return 0;
    }

}
class MyclassC implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
class MyclassB extends MyclassA{

    public ArrayList prime(int x){
        ArrayList<Integer> finded= new ArrayList();
        if(x<2)return finded;
        int a[] = new int[x+1];
        for (int i = 0;i<a.length;i++ )a[i]=0;
        for (int i = 2;i<=x;i++ ){
            if (a[i]==1)continue;
            int cnt = 2*i;
            while (cnt<=x){
                a[cnt]=1;
                cnt+=i;
            }
        }
        for (int i=2; i<a.length; i++)
            if (a[i]==0) finded.add(i) ;
        return finded ;
    }
    public int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}
class Suba{
    private final int i,j;

    private Suba(Builder builder) {
        this.i=builder.i;
        this.j=builder.j;
    }

    static public class Builder{
        private final int i;
        private int j;

        public Builder(int i) {
            this.i = i;
        }

        public Builder j(int j){this.j=j;return this;}
        public Suba build(){return new Suba(this);}
    }
}
public class Testmy {
    public static void main(String arg[]){
        HashSet<MyclassA> apple = new HashSet<MyclassA>();
        HashMap<Integer,MyclassA> banana = new HashMap<Integer, MyclassA>();
        apple.add(new MyclassA());
        banana.put(123,new MyclassA());

    }
}
