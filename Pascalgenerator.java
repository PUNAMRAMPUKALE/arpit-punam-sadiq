import java.math.BigInteger;

class pascalgenerator {
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
    //Main method
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
    }
}
