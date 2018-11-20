import java.util.*;

class Account {
    String eMail;   // 電子郵件
    int passwd;     // 密碼
    String addr;    // 住址

    Account(String em, int p, String ad) {
        eMail = em;  passwd = p;  addr = ad;
    }

    Account(Account acc) { // copy constructor
        eMail = acc.eMail;  passwd = acc.passwd;   addr = acc.addr;
    }

    // -- 只用eMail, passwd欄位做為equals() 比較的依據
    public boolean equals(Object o) {
        if(this==o)return true;
        if(!(o instanceof Account))return false;
        Account a2 = (Account)o;
        //Account a2 = new Account((Account) o);
        if (!(this.eMail.equals(a2.eMail)))return false;
        if(!(this.passwd==a2.passwd))return false;
        return true ;
    }

    public String toString() {
        return "(EMAIL:" + eMail + ", PASSWD" + passwd + ", ADDR:" + addr + ")";
    }
}

public class HWK3_405410068_陳睿瑜_02 {
    // -- accList串列儲存合法帳號(cache)，供登入時比對之用 --
    static ArrayList<Account> accList = new ArrayList<Account>();

    public static void main(String[] args) {
        // --- 建立20個測試帳號 ----
        buildAccountList(20);
        //-- 場景: 配合使用者歷次登入，查詢list中的資料，決定是否為合法帳戶 --
        Account[] queryData = {
                new Account("acc_0@tku.edu.tw", 1000, "addr"), //存在
                new Account("acc_4@tku.edu.tw", 1004, "addr"), //存在
                new Account("acc_8@tku.edu.tw", 1008, "addr"), //存在
                new Account("acc_8@tku.edu.tw", 1055, "addr"), //不存在
                new Account("acc8@tku.edu.tw", 1008, "addr"), //不存在
        };
        //-- 在accList中搜尋比對，看看登入帳號是否合法?
        for (int i = 0; i < queryData.length; i++) {
            int index = accList.indexOf(queryData[i]);
            if (index != -1) { // 在list中有找到queryData[i]
                System.out.println(accList.get(index));
            }
        }
    }

    public static void buildAccountList(int no) {
        // 建立no個測試帳號
        for (int i = 0; i < no; i++) {
            accList.add(new Account("acc_" + i
                    + "@tku.edu.tw", 1000 + i, "Passwed"));
        }
    }
}
