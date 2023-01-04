package CodingTestPractice;

import java.util.Stack;

public class Practice008 {
	/**
	 * 1. index j -> 층
	 * 2. index i -> 칸
	 * 
	 * 해당 칸에 값이 0이 아닐 때(비어있지 않을 때) 해당 값을 stack에 넣는다.
	 * 만약 가져온 값이 스택에 있다면 두 값을 모두 제거한다.
	 * 해당하는 칸에 값이 없는 경우 한 층 내려간다.
	 */
}

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int[] floor = new int[board[0].length];
		Stack<Integer> bucket = new Stack<>();
		
		for (int i = 0; i < moves.length; i++) {
			int move = moves[i] - 1;
			for (int j = 0; j < board[0].length; j++) {
				if (floor[move] < board[0].length) {
					if (board[floor[move]][move] == 0) {
						floor[move]++;
						continue;
					}
					if (bucket.isEmpty()) {
						bucket.push(board[floor[move]][move]);
						floor[move]++;
						break;
					}
					if (bucket.peek() == board[floor[move]][move]) {
						bucket.pop();
						answer+=2;
						floor[move]++;
						break;
					}
				}
			}
		}
		return answer;
	}
}
