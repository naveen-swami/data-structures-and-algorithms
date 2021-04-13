package com.stack.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import com.stack.service.StackService;

public class StackProblemSolverController {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StackService stackService = new StackService();

	public static void main(String[] args) throws NumberFormatException, IOException {
//		int size = Integer.parseInt(reader.readLine());
		// String[] expressions = reader.readLine().split(" ");
		String str = reader.readLine();
		System.out.println(stackService.infixToPostFix(str));
		// System.out.println(stackService.postfixExpression(expressions));
		// fifaFever();
	}

	/**
	 * https://my.newtonschool.co/playground/code/8qolz8oy1w/
	 * 
	 * <p>
	 * Ronaldo has challenged Messi to beat his team in the upcoming “Friendly”
	 * fixture. But both these legends are tired of the original football rules, so
	 * they decided to play Football with a twist. Each player is assigned an ID,
	 * from 1 to 10^6. Initially Ronaldo has the ball in his posession. Given a
	 * sequence of N passes, help Messi Know which ID player has the ball, after N
	 * passes.
	 * 
	 * Note: Passes are of two types :
	 * 
	 * i) P ID, which means the player currently having the ball passes it to Player
	 * with identity ID. ii) B, which means the player currently having the ball
	 * passes it back to the Player he got the Pass From.
	 * 
	 * Also, It is guaranteed that the given order of passes will be a valid order.
	 * Input The first line of input contains number of testcases T. The 1st line of
	 * each testcase, contains two integers, N and ID1, denoting the total number of
	 * passes and the ID of Ronaldo. Respectively. Each of the next N lines,
	 * contains the information of a Pass which can be either of the above two
	 * types, i.e:
	 * 
	 * 1) P ID 2) B
	 * 
	 * Constraints 1 <= T <= 100 1 <= N <= 10^5 1 <= IDs <= 10^6 Sum of N for every
	 * test case is less than 10^6 Output For each testcase you need to print the ID
	 * of the Player having the ball after N passes.
	 * </p>
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void fifaFever() throws NumberFormatException, IOException {
		int testCase = Integer.parseInt(reader.readLine());
		while (testCase-- > 0) {
			Stack<Integer> playerPassesStack = new Stack<>();

			String[] readLine = reader.readLine().split(" ");
			int totalPasses = Integer.parseInt(readLine[0]);
			playerPassesStack.add(1);
			boolean isBack = false;
			int lastPlayer = 0;
			while (totalPasses-- > 0) {
				readLine = reader.readLine().split(" ");
				char playerName = readLine[0].charAt(0);
				if (playerName == 'P') {
					int id = Integer.parseInt(readLine[1]);
					playerPassesStack.add(id);
				} else {
					if (!isBack) {
						lastPlayer = playerPassesStack.pop();
					} else if (lastPlayer != 0) {
						playerPassesStack.add(lastPlayer);
					}
					isBack = !isBack;
				}

			}
			System.out.println(playerPassesStack.isEmpty() ? 0 : playerPassesStack.peek());
		}
	}
}
