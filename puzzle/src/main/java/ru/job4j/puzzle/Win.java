package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (checkHorizontal(board, i) || checkVertical(board, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHorizontal(int[][] board, int index) {
        for (int curValue : board[index]) {
            if (curValue != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkVertical(int[][] board, int index) {
        for (int[] curArray : board) {
            if (curArray[index] != 1) {
                return false;
            }
        }
        return true;
    }
}
