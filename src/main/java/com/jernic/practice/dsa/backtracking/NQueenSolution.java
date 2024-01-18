package com.jernic.practice.dsa.backtracking;

import java.util.Arrays;

public class NQueenSolution {
	private final static int N = 8;
	private static int count=1;
	public static void main(String[] args) {
		int[][] board = new int[N][N];
		Arrays.stream(board).forEach(row -> Arrays.fill(row,0));
		System.out.println("Before NQueens Backtracking Sol:\n");
		printSolution(board);
		
		if(!solveNQueens(board, 0)) {
			System.out.println("\nThe Solution does not exists");
			return;
		}
		System.out.println("\n\n Solution:\n");
		printSolution(board);
	}
	
	private static boolean solveNQueens(int[][] board, int col) {
		if(col>=N) {
			return true;
		}
		for(int i=0; i<N; i++) {
			if(isSafe(board,i, col)) {
				board[i][col]=1;
				System.out.println("Inside Is SAFE- "+ count);
				count++;
				if(solveNQueens(board,col+1)) {
					return true;
				}else {
					board[i][col]=0;
					count--;
				}
			}
		}
		
		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col) {
		int i,j;
		
		for(i=0; i<col;i++) {
			if(board[row][i] == 1) {
				return false;
			}
		}
		
		for(i=row, j=col; i>=0 && j>=0; i--,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		
		for(i=row, j=col; j>=0 && i<N; i++, j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		return true;
	}

	public static void printSolution(int[][] board) {
		Arrays.stream(board).forEach(row -> {Arrays.stream(row).forEach(col -> System.out.print(col+ " "));
					System.out.println();
		});
	}
}
