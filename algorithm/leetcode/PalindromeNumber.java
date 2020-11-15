package leetcode;

/**
 * 功能说明：Determine whether an integer is a palindrome.
 *          An integer is a palindrome when it reads the same backward as forward.
 *
 * @auther liubf
 * @date 2018/9/3
 * @throws
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else if(x/10==0){
            return true;
        }else{
            String xStr = String.valueOf(x);
            int len = xStr.length();
            int remainder = len % 2;
            String first = "";
            String second = "";
            if(remainder==0){//even
                first = xStr.substring(0,len/2);
                second = xStr.substring(len/2);
            }else{
                first = xStr.substring(0,len/2+1);
                second = xStr.substring(len/2);
            }
            StringBuffer temp = new StringBuffer(first);
            temp = temp.reverse();
            if(temp.toString().equals(second)){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args){
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x = 12321;
        boolean isPalindrome = palindromeNumber.isPalindrome(x);
        System.out.println(isPalindrome);

    }
}
