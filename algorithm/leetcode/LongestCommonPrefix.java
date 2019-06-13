package src;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        //1.find the shortest child in String[]
        String shortStr = shortestStr(strs);
        String r = "";
        for (int i = 0; i < shortStr.length(); i++) {
            String s = shortStr.substring(0,i+1);
            //2.
            String s1 = getLongestStr(strs,s,i+1);
            if(s1!=""){
                r = s1;
            }else{
                return r;
            }
        }
       return r;
    }
    /**
     * 找到最短字符串与其他子字符串的longest common prefix string
     * **/
    private String getLongestStr(String[] strs,String s,int index){
        //System.out.println(s +"======="+index);
        for (String item: strs) {
            if(!s.equals(item.substring(0,index))){
                return "";
            }
        }
        return s;
    }

    private String shortestStr(String[] strs){
        int len = strs[0].length();
        String r = "";
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            if(s.length()<=len){
                len = s.length();
                r = s;
            }
        }
        //System.out.println("==short==="+r);
        return r;
    }

    public static void main(String[] args){
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] arrs = {"flower","flow","flight"};
        arrs = new String[]{"dog","double","d"};
        System.out.println(lcp.longestCommonPrefix(arrs));
    }
}
