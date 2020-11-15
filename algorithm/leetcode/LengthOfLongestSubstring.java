package leetcode;


import java.util.HashMap;

public class LengthOfLongestSubstring {
    /**
     * 我的解法
     * */
    /*static int lengthOfLongestSubstring(String s){
        if(s!=null && s.length()>0){
            int len = 0;
            for(int i=0;i<s.length();i++){
                for(int j=s.length();j>i;j--){
                    String tempB = s.substring(i,j);
                    if(tempB.length()<len){
                       break;
                    }
                    int count = 0;
                    char[] c = tempB.toCharArray();
                    for(int k=0;k<c.length;k++){
                        char cc = c[k];
                        if(tempB.indexOf(cc)!=tempB.lastIndexOf(cc)){
                            count++;
                            break;
                        }
                    }

                    if(count==0){
                        len = tempB.length();
                        break;
                    }
                }
            }

            return len;

        }
        return 0;
    }*/

    /**
     * 原作者思路：the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values,
     * and keep two pointers which define the max substring. move the right pointer to scan through the string ,
     * and meanwhile update the hashmap. If the character is already in the hashmap,
     * then move the left pointer to the right of the same character last found.
     * Note that the two pointers can only move forward.
     * 我的理解：无法理解
     * @param s
     * @return
     */
    static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            System.out.println(s.charAt(i)+"+++++++++++++");
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
                System.out.println(j+"###############");
            }
            System.out.println(s.charAt(i)+"*************"+i);
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
            System.out.println(max+"##########");

        }
        return max;
    }

    public static void main(String[] args){

        String s = "dddd";
        //s = "opkacnjulzandrpvgogaxfzbqjdctukklxmpkvlxvlkaebvlrbnrimsbwvfrrqdeppvblgygtliaodlggyxrk";
        s = "tyzztjsnopyagetjfqiexqroiayrojhjhgiarcpgrniysdhztpfqhwhpyfioopxxvgxniovabdatgjszazsiwzz";
        s = "ulppbaysfnpefzlxcxnnkdcfvjhbezkamcppenhkczqjabgdztsjxuqudxxjyijlmaaqpkculsdlwkqvdigc";
//        int cp = s.codePointAt(2);
//        System.out.println(cp);
//        System.out.println(Character.toChars(cp));
//        System.out.println(s.charAt(2));
          int len = lengthOfLongestSubstring(s);
          System.out.println("len="+len);
    }
}
