public class CountPrimes {

    public static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int i = 2;
        int cnt = 0;
        while (i <= n) {
            int flag = 0;
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                cnt++;
            }
            i++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(5));
    }
}
