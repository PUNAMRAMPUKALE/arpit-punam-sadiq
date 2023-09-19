import java.math.BigInteger;

class pascalgenerator {

    //----------------------  PascalTriangleGenerator  ------------------ 

    //Method to iterate rows
    int[][] generateTriangle(int rows) {
        int[][] triangle = new int[rows][];
        for (int i = 0; i < rows; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                //add row into array
                triangle[i][j] = nCr(i, j);
            }
        }
        return triangle;
    }

    //Method to generate a single row
    private int nCr(int n, int r) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < r; i++) {
            result = result.multiply(BigInteger.valueOf(n - i))
                .divide(BigInteger.valueOf(i + 1));
        }
        return result.intValue();
    }


    // -------------- Given a number n, determine what the nth prime --------


    //calculate Nth Prime
    public int nth(int nth) {
        if (nth <= 0) {
            //error handling
            throw new IllegalArgumentException("Input must be a positive integer.");
        }

        int count = 0;
        int number = 2;

        while (true) {
            if (isPrime(number)) {
                count++;
                if (count == nth) {
                    return number;
                }
            }
            number++;
        }
    }

    //recursive function to check if it is a prime number
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    //main method
    public static void main(String[] args) {
        int rows = 5;
        pascalgenerator generator = new pascalgenerator();
        int[][] triangle = generator.generateTriangle(rows);

        // Print Pascal's triangle 
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
        // Print Nth Prime Number
        int nthPrime = generator.nth(6);
        System.out.println("The 6th prime number is: " + nthPrime);
    }
}
