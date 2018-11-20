class Person { // 父類別
    private int id ;
    private String name ;

    // constructors
    Person() { }
    Person(int id, String n) { this.id = id ; this.name = n; }
    Person(Person p) { this.id = p.id; this.name = p.name; }
    // access functions
    int getID() { return id; }
    String getName() { return name; }
    void setID(int id) { this.id = id; }
    void setName(String n) { this.name=n;}
}

class Worker extends Person { // 子類別，繼承Person
    int lenOfService ; // 年資

    Worker() { }
    //  === 請依照main()中需求，完成二種版本的建構式 ===
    Worker(int id, String n, int los) { // DIY
        setID(id);
        setName(n);
        this.lenOfService=los;
    }
    Worker(Worker w) { // DIY

        setID(w.getID());
        setName(w.getName());
        this.lenOfService=w.lenOfService;
    }
    void set(int id, String n, int los) {
        setID(id);
        setName(n);
        this.lenOfService=los;
        // DIY
    }
    void print(String msg) {
        System.out.println(msg+"id="+String.valueOf(getID())+", name="+getName()+", length of services="+String.valueOf(this.lenOfService)+" year");
        // DIY
    }
}
public class HWK2_405410068_陳睿瑜_04 {
    public static void main(String[] args) {
        Worker w1 = new Worker(1001, "Peter", 10) ;
        w1.print("w1=");
        w1.set(1002, "Mary", 8);
        w1.print("w1=");

        Worker w2 = new Worker(w1) ;
        w2.print("w2=") ;
    }
}
/* [程式輸出]
w1=id=1001, name=Peter, length of services=10 years
w1=id=1002, name=Mary, length of services=8 years
w2=id=1002, name=Mary, length of services=8 years
*/

