import java.util.* ;
public class MI4P_405410068_陳睿瑜_01 {
    public static String purify(String str) { // 5%
    // [功能]: 傳回一字串，只包含str中的大小寫字元、數字與空白字元
        char[] cs = new char[str.length()];
        int cnt = 0;
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(Character.isUpperCase(c)||Character.isLowerCase(c)||Character.isDigit(c)||Character.isSpaceChar(c)){
                cs[cnt++] += c;
            }
        }


    return String.valueOf(cs,0,cnt) ;
    }
    public static void count(String doc, HashMap<String, Integer> dict) { // 6%
        // 分析doc中各單字出現的次數，並以(K,V)=(單字,出現字數)的格式將其儲存在dict中
        String [] words = doc.split(" ");

        for (String word:words){
            if(dict.get(word)==null){
                dict.put(word,1);
            }else {
                int t = dict.get(word)+1;
                dict.put(word,t);
            }
        }
    }

    public static void main(String[] args) {
        String news = "The White House revoked Jim Acosta’s press credentials Wednesday after he had a heated exchange with President Donald Trump at a news conference and an intern tried to grab a microphone from the CNN reporter.\n" +
                "\"As a result of today’s incident, the White House is suspending the hard pass of the reporter involved until further notice,\" White House press secretary Sarah Huckabee Sanders told reporters. \n"
                + "Acosta also tweeted that he had been denied entrance to the White House, where he was scheduled to film a spot for CNN, a network Trump has repeatedly targeted as \"fake news.\" \n"  ;
        System.out.println("Original New=\n"+news) ;
        news = purify(news) ;
        System.out.println("After purify=\n"+news) ;

        HashMap<String,Integer> hm = new HashMap() ;
        count(news,hm) ;
        // DIY : 印出hm中，出現次出超過2次以上的key(英文單字), 4%
        //      [提示]: 可配合用HashMap之keySet函數
        //System.out.println(hm) ; // 自行修改此行
        System.out.print("hm(occurence>=2)={");
        for (String t:hm.keySet()){
            if(hm.get(t)>1){
                System.out.print(t+":"+hm.get(t)+" ");
            }
        }
        System.out.print("}");



    }
}
