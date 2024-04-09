public class NQueens {
    private static final int N = 8;

    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }


        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }


        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }


    private static boolean solveNQueensUtil(int[][] board, int col) {
        if (col >= N) {
            return true;
        }

        // Tentar colocar a rainha em todas as linhas nesta coluna
        for (int i = 0; i < N; i++) {
            // Verificar se a rainha pode ser colocada em board[i][col]
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueensUtil(board, col + 1)) {
                    return true;
                }

                // Se colocar a rainha em board[i][col] não leva a uma solução, então retira a rainha
                board[i][col] = 0;
            }
        }

        return false;
    }
    public static void solveNQueens() {
        int[][] board = new int[N][N];

        if (!solveNQueensUtil(board, 0)) {
            System.out.println("Não há solução");
            return;
        }

        printSolution(board);
    }

    public static void main(String[] args) {
        solveNQueens();
    }
}
