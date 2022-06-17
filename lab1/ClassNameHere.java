public class ClassNameHere {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        if (m.length == 0){
            return 0;
        }else{
            int max_number_so_far = m[0];
            for (int count =0;count < m.length-1;count = count+1){
                if (m[count]>= max_number_so_far){
                    max_number_so_far = m[count];
                }
            }
            return max_number_so_far;
        }
        
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.println(max(numbers));     
    }
}