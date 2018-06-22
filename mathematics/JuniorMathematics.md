初中数学
============
1.因数、倍数、完全数
------------
  概念：2 * 6 = 12，2、6 是 12 的因数，12 是 2、6 的倍数。 完全数：6 = 1 + 2 + 3

  [java] 查找1000以下的完全数。<br>
  解析：迭代每一个数，并计算出所有小于当前数并能被这个数模运算等于0的数的和，如果和等于这个数，那么这个数就是完全数。<br>
  ```java
  static List findPerfectNumber(int num){
        List rs = new ArrayList();<
        for(int i=2;i<=num;i++){
            int a = i;
            int sum = 0;<br>
            for(int j=1;j<i;j++){
                if(a%j==0){
                    sum += j;
                }
            }

            if(a==sum){
                rs.add(a);
            }
        }
        return rs;
   }
   ```