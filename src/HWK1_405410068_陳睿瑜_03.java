import javax.lang.model.type.NullType;

class MyArrayList {
    private Object[] data = new Object[10]; //假設容量為10
    private int itemCnt = 0 ;

    void addLast(Object item) {
        // DIY: 將item加在串列末尾，若串列已滿，則將串列容量加倍
        if(this.itemCnt==this.data.length-1){
            Object[] tem = new Object[this.data.length];
            int t=this.data.length;
            System.arraycopy(data, 0, tem, 0, this.data.length);
            data = new Object[this.data.length*2];
            System.arraycopy(tem, 0, data, 0, t);
        }

        data[itemCnt++] = item ;
    }
    void insert(int index, Object item) {
        if(index<0||index>this.itemCnt){
            System.out.println("insert(): wrong index "+index);
        }else{
            if (this.itemCnt - index >= 0)
                System.arraycopy(this.data, index + 1, this.data, index + 1 + 1, this.itemCnt - index);
            this.data[index]=item;
            itemCnt++;

        }
        // DIY: 將item插入成為串列的第index個元素, 若串列已滿，則將串列容量加倍
        // 若index<0, 或index>itemCnt則只印出錯誤訊息，不進行插入動作
    }
    boolean isIdentical(MyArrayList L2) {
        // DIY: 比較本串列與L2是否相等，若是回傳true, 否則回傳false
        for (int i= 0;i<this.data.length;i++){
            if(data[i]!=L2.data[i])return false;
        }
        return true;
         //請刪除此行，自行作答
    }
    void print(String msg) {
        // DIY: 印出串列內容, 參考程式輸出
        System.out.print(msg);
        for(Object data1:data) {
            if(data1== null)break;
            System.out.print(" "+data1);
        }
        System.out.println();
    }
}
public class HWK1_405410068_陳睿瑜_03 {  // XX: 你的學號, YY: 姓名
    // ------------------------------
    public static void main(String[] args) {
        MyArrayList L1 = new MyArrayList() ;
        for (int i = 0 ; i<5; i++) {
            L1.addLast(100+i) ;
        }
        L1.print("L1=") ;

        L1.insert(0, 81); L1.insert(2, 82);
        L1.insert(7, 83); L1.insert(12, L1);
        L1.print("L1=") ;
        // -- 測試串列已滿的處理 ------
        for (int i = 0 ; i<5; i++) {
            L1.addLast(200+i) ;
        }
        L1.print("L1=") ;
        // ---------- identical -----------
        MyArrayList L2 = new MyArrayList() ;
        for (int i = 0 ; i<5; i++) {
            L2.addLast(100+i) ;
        }
        if (L2.isIdentical(L1)) System.out.println("L2 equals to L1.") ;
        if (L2.isIdentical(L2)) System.out.println("L2 equals to L2.") ;
    }
}

/*
L1=100 101 102 103 104
insert(): wrong index 12
L1=81 100 82 101 102 103 104 83
L1=81 100 82 101 102 103 104 83 200 201 202 203 204
L2 equals to L2.
*/