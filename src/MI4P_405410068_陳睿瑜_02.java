import java.util.* ;
class Item <O1,O2,O3> implements Comparable {
    O1 id ;    O2 name ;    O3 price ;
    Item() { }
    Item(O1 i, O2 n, O3 p) {
        id=i; name=n; price=p ;
    }
    private O1 getId(){
        return id;
    }
    private O2 getName(){
        return name;
    }
    private O3 getPrice(){
        return price;
    }
    public String toString() {
        return "("+id+","+name+","+price+")" ;
    }
    int[][] arr= new int[3][3];
    @Override
    public int compareTo(Object o) {
        if(this==o)return 0;
        if (!(o instanceof Item))return -1;
        Item i2 = (Item)o;

        if(!(this.id.equals(i2.id)))return this.getId().toString().compareTo(i2.getId().toString()) ;
        if(!(this.name.equals(i2.name)))return this.getName().toString().compareTo(i2.getName().toString());
        if(!(this.price.equals(i2.price)))return this.getPrice().toString().compareTo(i2.getPrice().toString());
        return 0;
    }
}
public class MI4P_405410068_陳睿瑜_02 {
    public static void main(String[] args) {
        // ----------- part I: Generic basic --------
        Item<Integer, String, Double> item1 = new Item(1001,"Pencil", 3.5) ;
        Item<String, String, Float> item2 = new Item("A1002","Ball Pen", 5.5f) ;
        System.out.println("item1 = "+item1) ;
        System.out.println("item2 = "+item2) ;

        // ----------- part 2: Generic and Comparable --------
        System.out.println("---- test sort -------") ;
        Item[] items = new Item[5] ;
        items[0] = new Item("A1007", "A", 4.5);
        items[1] = new Item("A1013", "B", 7.7);
        items[2] = new Item("A1002", "C", 4.5);
        items[3] = new Item("A1006", "D", 2.8);
        items[4] = new Item("A1010", "E", 7.7);
        Arrays.sort(items);
        for (int i = 0 ; i<items.length; i++)
            System.out.println("items["+i+"]="+items[i]) ;
    }

}
