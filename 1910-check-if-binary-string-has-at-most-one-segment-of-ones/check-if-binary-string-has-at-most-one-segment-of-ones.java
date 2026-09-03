class Solution {
    public boolean checkOnesSegment(String s) {
        int count=0;

        for(int i=0;i<s.length();i++){
           if(s.charAt(i) == '1'){
             count+=1;
             while(i<s.length() && s.charAt(i) == '1'){
               i++;

             }
            i--;
            
            }
            if(count> 1){
                return false;
           }
          
        }
        return true;
    }
}