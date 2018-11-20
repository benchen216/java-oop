import java.util.*;
class Product_2 implements Comparable{
    int a, b, c ; // a*b*c
    Product_2(int _a, int _b, int _c) {a=_a; b=_b; c=_c;}

    // compareTo(): 比較乘積的大小

    public String toString() {
        return "("+a+","+b+","+c+")" ;
    }

    @Override
    public int compareTo(Object o) {
        if(this==o)return 0;
        if (!(o instanceof Product_2))return -1;
        Product_2 p2 = (Product_2) o;
        if((a*b*c)>(p2.a*p2.b*p2.c))return 1;
        if((a*b*c)<(p2.a*p2.b*p2.c))return -1;
        return 0;
    }
}
class ProductArray implements Comparable{
    TreeSet<Product_2> data =new TreeSet<Product_2>() ;
    // 提示: data.last()最大值, data.first()最小值
    void add(Product_2 p) { data.add(p);}

    // compareTo(): 以data中最大值(Product)做為比較大小的依據

    public String toString() { return data.toString(); }

    @Override
    public int compareTo(Object o) {
        if(this==o)return 0;
        if (!(o instanceof ProductArray))return -1;
        ProductArray p2 = (ProductArray) o;
        if(this.data.last().compareTo(p2.data.last())!=0)return this.data.last().compareTo(p2.data.last());
        return 0;
    }
}
public class HWK6_405410068_陳睿瑜_02 {
    public static void main(String[] args) {
        Random r = new Random(111) ;
        ProductArray[] pas = new ProductArray[4] ;
        // 亂數產生一個ProductArray的陣列
        for (int i=0; i<pas.length; i++) {
            pas[i] = new ProductArray() ;
            for (int j = 0; j<10; j++)
                pas[i].add(new Product_2(r.nextInt(101), r.nextInt(101), r.nextInt(101))) ;
            System.out.println("ProductArray-"+i+"="+pas[i]) ;
        }
        Arrays.sort(pas) ;
        // --- 印出pas[]中最大的ProductArray物件
        System.out.println(pas[pas.length-1]) ;
    }
}
