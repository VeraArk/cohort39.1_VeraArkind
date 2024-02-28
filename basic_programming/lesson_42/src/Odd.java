public class Odd {
    public static void main(String[] args) {
        int [] ar = {20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};
        System.out.println(findIt(ar));
    }
        public static int findIt(int[] a) {
            int odd=0;
            int count =1;
            for (int i =0; i<a.length; i++){
                for(int j =i+1; i<a.length-1; i++){
                    if(a[i]==a[j]){
                        count++;
                    }
                } if((count%2) !=0){
                    odd = a[i];
                    break;
                } else count =0;
            }
            return odd;
        }
    }

