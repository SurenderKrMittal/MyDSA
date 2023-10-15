public class Main {

    public static boolean armstrong(int n) {
        int org = n;
        int sum = 0;
        while(n > 0) {
            int ld = n % 10;
            sum += (int)(Math.pow(ld,3));
            n /= 10;
        }
        if(org == sum) {
            return true;
        }
        return false;
    }

    public static void all3digitarmstrong(){
        for(int i = 100; i <= 999; i++){
            if(armstrong(i)) {
                System.out.print(i + " ");
            } else {
                continue;
            }
        }
    }



    public static void main(String[] args) {
        all3digitarmstrong();

    }
}