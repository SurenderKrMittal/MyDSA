public class baic_patterns{
    public static void main(String[] args) {
        
        int n = 4;

        // for(int line = 1; line <= n; line ++) {
        //     for(int star = 1; star <= line; star ++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //good logic
        // for(int line = 1; line <= n; line++) {
        //     for(int star = 1; star <= n-line+1; star++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        char ch = 'A';
        for(int line = 1; line <= n; line++) {
            for(int chars = 1; chars <= line; chars++) {
                System.out.print(ch);
                ch ++;
            }
            System.out.println();
        }
    }
}