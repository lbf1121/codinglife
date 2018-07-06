package src;

public class FindMaxLengthSubstring {

    static String findMaxSub(String s){
        if(s!=null && s.length()>0){
            for(int i=0;i<s.length();i++){
                char tempA = s.charAt(i);
                for(int j=i+1;j<s.length();j++){
                    String tempB = s.substring(i,j);
                    tempB.codePoints().forEach(c -> {
                        System.out.print(Character.toChars(c));
                        System.out.print("_");
                    });
                    System.out.println("");
                    System.out.println("sub string:"+tempB);
                }
            }
        }
        return "";
    }

    public static void main(String[] args){

        String s = "fdwlkgjlsdkfew";
//        int cp = s.codePointAt(2);
//        System.out.println(cp);
//        System.out.println(Character.toChars(cp));
//        System.out.println(s.charAt(2));
        findMaxSub(s);
    }
}
