package com.interview.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QurieyParser {

	enum ParserType {
		RAW_SQL, MONGO_DB, ELASTIC_SEARCH
	}

	public static void main(String[] args) {
// quries
		String searchStirng = "(Java AND Spring) OR (Python AND Django) OR (Ruby AND (\"Ruby on Rails\" OR ROR))";
//		String searchStirng = "(\"Ruby on Rails\" OR ROR)";
//		String searchStirng = "'Ruby on Rails' OR ROR";
//		String searchStirng = "Java AND Spring";
		seperateQuries(searchStirng);
//		parser(searchStirng, ParserType.RAW_SQL);
//		System.out.println(printSubsInDelimiters(searchStirng));

	}

	/**
	 * 
	 * Java <br>
	 * Java OR python <br>
	 * (Java AND Spring) OR (Python AND Django) OR (Ruby AND ("Ruby on Rails" OR
	 * ROR))
	 * 
	 * @param searchStirng
	 */
	static void seperateQuries(String searchStirng) {
		StringBuilder where = new StringBuilder();
//		String res = searchStirng.substring(searchStirng.indexOf("(")+1,searchStirng.indexOf(")"));
//		System.out.println(res);
//		Matcher m = Pattern.compile("\\((.*?)\\)").matcher(searchStirng);
//		while(m.find()) 
//        {
//            System.out.println(m.group(1));
//        }
		List<String> subStringList = printSubsInDelimiters("(" + searchStirng + ")");
//		System.out.println(subStringList);
		for (String subString : subStringList) {
			System.out.println(subString);
		}
	}

	static StringBuilder getQuery(StringBuilder searchWord, ParserType parserType) {
		StringBuilder query = new StringBuilder();
		switch (parserType) {
		case RAW_SQL:
			query.append(" (name LIKE \"%").
			append(searchWord).append("%\" OR text LIKE \"%").
			append(searchWord)
					.append("%\") ");
			break;
		case MONGO_DB:
			query.append("{$or: [{ name: /")
			.append(searchWord)
			.append("/} , {text: /")
			.append(searchWord)
			.append("/}]}");
			break;

		case ELASTIC_SEARCH:

			break;

		default:
			break;
		}

		return query;
	}
	

	static void parser(String searchStirng, ParserType parserType) {
		StringBuilder where = new StringBuilder();
		String[] searchStirngArr = searchStirng.split(" ");
		System.out.println(Arrays.toString(searchStirngArr));
//		[(Java, AND, Spring), OR, (Python, AND, Django), OR, (Ruby, AND, ("Ruby, on, Rails", OR, ROR))]

		for (int i = 0; i < searchStirngArr.length; i++) {

			String subString = searchStirngArr[i];
			if (subString.equals("AND") || subString.equals("OR")) {
				if(parserType == ParserType.RAW_SQL) {
					where.append(" " + subString + " ");
				} else if(parserType == ParserType.MONGO_DB) {
					
				}
				continue;
			}

			int pos = -1;
			StringBuilder word = new StringBuilder();
			for (int j = 0; j < subString.length(); j++) {
				if (subString.charAt(j) == '(') {
					where.append("(");
					pos = j;
				} else if (subString.charAt(j) == '\"') {
					if (subString.charAt(subString.length() - 1) != '\"') {
						word.append(subString.substring(j + 1) + " ");
						i++;
						while (!searchStirngArr[i].contains("\"")) {
							word.append(searchStirngArr[i] + " ");
							i++;
						}
						subString = searchStirngArr[i];
						int quotesPos = subString.indexOf('\"');
						word.append(subString.substring(0, quotesPos));
						where.append(getQuery(word, parserType));
						if (subString.substring(quotesPos).length() > 1) {
							where.append(subString.substring(quotesPos));
						}
						where.append(" ");
						break;
					}
				} else if (subString.charAt(j) == '\'') {
					if (subString.charAt(subString.length() - 1) != '\'') {
						word.append(subString.substring(j + 1) + " ");
						i++;
						while (!searchStirngArr[i].contains("'")) {
							word.append(searchStirngArr[i] + " ");
							i++;
						}
						subString = searchStirngArr[i];
						int quotesPos = subString.indexOf('\'');
						word.append(subString.substring(0, quotesPos));
						where.append(getQuery(word, parserType));
						if (subString.substring(quotesPos).length() > 1) {
							where.append(subString.substring(quotesPos));
						}
						where.append(" ");
						break;
					}
				} else if (pos == -1 && !subString.contains(")")) {
					where.append(getQuery(new StringBuilder(subString), parserType));
					break;
				} else if (pos != -1 && !subString.contains(")")) {
					where.append(getQuery(new StringBuilder(subString.substring(pos + 1)), parserType));
					break;
				} else if (pos != -1 && subString.contains(")")) {
					where.append(getQuery(new StringBuilder(subString.substring(pos + 1, subString.indexOf(')'))),
							parserType));
					break;
				} else if (subString.contains(")")) {
					where.append(
							getQuery(new StringBuilder(subString.substring(0, subString.indexOf(")"))), parserType));
					where.append(subString.substring(subString.indexOf(")")) + " ");
					break;
				}
			}
		}
		System.out.println(where);
	}

	static List<String> printSubsInDelimiters(String str) {

		// Stores the indices of
		List<String> res = new LinkedList<>();
		Stack<Integer> dels = new Stack<Integer>();
		for (int i = 0; i < str.length(); i++) {

			// If opening delimiter
			// is encountered
			if (str.charAt(i) == '(') {
				dels.add(i);
			}

			// If closing delimiter
			// is encountered
			else if (str.charAt(i) == ')' && !dels.isEmpty()) {

				// Extract the position
				// of opening delimiter
				int pos = dels.peek();

				dels.pop();

				// Length of subString
				int len = i - 1 - pos;

				// Extract the subString
				String ans = str.substring(pos + 1, pos + 1 + len);

				res.add(ans);
//				System.out.print(ans + "\n");
			}
		}
		return res;
	}

}
