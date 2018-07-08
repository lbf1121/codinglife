package src;


public class LengthOfLongestSubstring {

    static int lengthOfLongestSubstring(String s){
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
    }

    public static void main(String[] args){

        String s = "dddd";
        //s = "opkacnjulzandrpvgogaxfzbqjdctukklxmpkvlxvlkaebvlrbnrimsbwvfrrqdeppvblgygtliaodlggyxrk";
        s = "tyzztjsnopyagetjfqiexqroiayrojhjhgiarcpgrniysdhztpfqhwhpyfioopxxvgxniovabdatgjszazsiwzz";
//        int cp = s.codePointAt(2);
//        System.out.println(cp);
//        System.out.println(Character.toChars(cp));
//        System.out.println(s.charAt(2));
          int len = lengthOfLongestSubstring(s);
          System.out.println("len="+len);
    }
}
