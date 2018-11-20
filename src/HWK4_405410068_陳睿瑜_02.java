class A {
    private int[] a = new int[5];
    A(){}
    A(int[] x) {
        for (int i = 0 ; i<a.length; i++) { a[i] = x[i] ; }
    }
    int getLen() { return a.length; }

    @Override
    public String toString(){
        String output = "";
        for (int i:a){
            output+=i+" ";
        }
        return output;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        //if(!(obj instanceof A))return false;
        A a2 = (A)obj;

        for (int i = 0;i<this.getLen();i++){
            if(a2.a[i]!=this.a[i])return false;
        }
        return true;
    }
    // --- DIY: 自行加上equals()與toString()
    // [注意]: 本類別中不可加入getXXX(), setXXX()等accessor functions
}
class B extends A {
    private int[] b = new int[3] ;
    private int[] a = new int[5] ;
    B() {}
    B(int[] ab) {
        super(ab);
        /*for (int i=0;i<5;i++){
            a[i]=ab[i];
        }*/
        for (int i=0;i<3;i++){
            b[i]=ab[5+i];
        }
        // DIY: ab[]的前5個元素初始化a[], 其餘的初始化b[]
    }

    public String toString(){
        String output = "";
        for (int i:a){
            output+=i+" ";
        }
        for (int i:b){
            output+=i+" ";
        }
        return output;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof B))return false;
        B a2 = (B)obj;
        for (int i = 0;i<this.getLen();i++){
            if(a2.a[i]!=this.a[i])return false;
        }
        for (int i = 0;i<this.getLen();i++){
            if(a2.b[i]!=this.b[i])return false;
        }
        return true;
    }

    // -- 自行加上equals()與toString()
}
public class HWK4_405410068_陳睿瑜_02 {
    public static void main(String[] args) {
        int[] ab = {1,2,3,4,5,6,7,8} ;
        B b1 = new B(ab) ; // 將{1,2,3,4,5},{6,7,8}分別填入a[],b[]
        B b2 = new B(new int[]{1,2,3,4,5,6,7,9}) ;
        System.out.println("b1="+b1) ;
        System.out.println("b2="+b2) ;
        A a = new A(ab) ;
        System.out.println("a="+a) ;
        if (b1.equals(b1)) System.out.println("b1 equals b1") ;
        if (!b1.equals(b2)) System.out.println("b1 not equals b2") ;
        if (!b1.equals(a)) System.out.println("b1 not equals to a") ;
        if (a.equals(b2)) System.out.println("a equals to b2") ;
    }
}
