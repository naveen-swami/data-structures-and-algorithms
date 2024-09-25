package test;

import java.util.LinkedList;
import java.util.List;

public class FindUniqueCombinationOfTargetSum {

	public static void main(String[] args) {

		int[] arr = {2, 3, 5, 7};
		getUniqueCombinationOfTargetSum(arr, 0, new LinkedList<Integer>(), 0, 7);
		System.out.print(result);
	}

	/**
	 * 
	 * Given an array of integers and a target sum, find all unique combinations of
	 * elements in the array that add up to the target sum. The elements can be used
	 * repeatedly, but the combinations should be unique. Input nums = [2, 3, 5, 7]
	 * target = 7 Output:[[2, 2, 3], [5, 2], [7]]
	 * 
	 * @param arr
	 * @return
	 */
	
	static List<List<Integer>> result = new LinkedList<>();
	static void getUniqueCombinationOfTargetSum(int[] arr, int start, List<Integer> sumList, int sum, int target) {

		
		for(int i = start; i < arr.length; i++) {
			
			if(sum+arr[i] > target) {
				//getUniqueCombinationOfTargetSum(arr, start+1, sumList, sum, target);
				continue;
			}
			sumList.add(arr[i]);
			sum = sum+arr[i];
			if(sum == target) {
				result.add(new LinkedList<Integer>(sumList));
				continue;
			} else {
				getUniqueCombinationOfTargetSum(arr, start, sumList, sum, target);
			}
		}
		if(!sumList.isEmpty()) {
			sumList.remove(sumList.size()-1);
		}
		return;
		
	}
	
	

}
