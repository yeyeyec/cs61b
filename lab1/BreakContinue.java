public class BreakContinue{
    public static void windowPosSum(int[] a, int n){
        for (int i = 0;i<a.length;i=i+1){
            if (a[i]<0){
                continue;
            }else{
                int sum=a[i];
                for (int j =i+1;j<=i+n;j=j+1){
                    if (j>=a.length){
                        break;
                    }else{
                        sum = sum+a[j];
                    }
                }
                a[i] = sum;
            }
        }
    }
    public static void main(String[] args){
        int[] a = {1,2,-3,4,5,4};
        int n = 3;
         windowPosSum(a,n);

        System.out.println(java.util.Arrays.toString(a));
    }
}