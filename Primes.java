public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        if (n < 2) {
            System.out.println("Prime numbers up to " + n + ":");
            System.out.println("There are 0 primes between 2 and " + n + " (0% are primes)");
            return;
        }

        boolean[] isPrime = new boolean[n + 1];

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int p = 2;
        while (p * p <= n) {
            for (int i = p * p; i <= n; i += p) {
                isPrime[i] = false;
            }
            p++;
            while (p <= n && isPrime[p] == false) {
                p++;
            }
        }

        System.out.println("Prime numbers up to " + n + ":");

        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                count++;
            }
        }

        int percent = (count * 100) / n;

        System.out.println("There are " + count + " primes between 2 and " + n + " (" + percent + "% are primes)");
    }
}
