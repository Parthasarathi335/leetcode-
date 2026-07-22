class Solution {
    public boolean isSameAfterReversals(int num) {
        int reversed1=reverse(num);
        int reversed2=reverse(reversed1);
          
        return num == reversed2;
        
    }
    public int reverse(int n){

        int rev=0;

        while(n>0){

           int digit = n % 10;

            rev= rev * 10 + digit;

            n=n/10;


        }

        return rev;

    }
}