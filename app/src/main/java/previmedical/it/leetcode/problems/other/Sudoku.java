package previmedical.it.leetcode.problems.other;

public class Sudoku {


    public int[][] sudoku(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        for (int i=0; i<matrix.length; i++) {
            if (matrix[0].length != matrix.length) {
                return null;
            }
        }

        int sqrt = (int) Math.sqrt(matrix.length);
        if ((sqrt * sqrt) != matrix.length) {
            return null; // Not a square
        }

        this.sudoku(matrix, 0, 0);

        if (this.isValidMatrix(matrix)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Unable to solve this sudoku");
        }

        return matrix;
    }

    private boolean sudoku(int[][] matrix, int i, int j) {
        if (i == matrix.length) {
            return true;
        }
        else {
            int nextJ = (j + 1) % matrix.length;
            int nextI = nextJ == 0 ? i + 1 : i;

            if (matrix[i][j] == 0) {

                for (int v = 1; v <= matrix.length; v++) {

                    if (isValid(matrix, i, j, v)) {
                        matrix[i][j] = v;
                        boolean output = sudoku(matrix, nextI, nextJ);
                        if (output) {
                            return true;
                        }
                    }
                }

                matrix[i][j] = 0;
                return false;
            }
            else {
                return sudoku(matrix, nextI, nextJ);
            }
        }
    }


    private boolean isValid(int[][] matrix, int i, int j, int value) {
        return this.notValueInColumn(matrix, value, j)
                && this.notValueInRow(matrix, value, i)
                && this.notValueInSquare(matrix, value, i, j);
    }

    private boolean notValueInRow(int[][] matrix, int value, int i) {
        for (int j=0; j<matrix.length; j++) {
            if (matrix[i][j] == value) {
                return false;
            }
        }
        return true;
    }

    private boolean notValueInColumn(int[][] matrix, int value, int j) {
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][j] == value) {
                return false;
            }
        }
        return true;
    }

    private boolean notValueInSquare(int[][] matrix, int value, int i, int j) {
        int squareSize = (int) Math.sqrt(matrix.length);
        int squareStartI = squareSize * (i / squareSize);
        int squareStartJ = squareSize * (j / squareSize);

        int squareEndI = squareStartI + squareSize;
        int squareEndJ = squareStartJ + squareSize;

        for (int sI = squareStartI; sI < squareEndI; sI++) {
            for (int sJ = squareStartJ; sJ < squareEndJ; sJ++) {
                if (matrix[sI][sJ] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                int value = matrix[i][j];
                matrix[i][j] = 0;
                boolean isValid = isValid(matrix, i, j,value);
                matrix[i][j] = value;
                if (!isValid) {
                    return false;
                }
            }
        }
        return true;
    }
}
