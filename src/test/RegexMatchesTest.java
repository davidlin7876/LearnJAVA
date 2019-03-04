package test;

import java.util.regex.*;

public class RegexMatchesTest {
	private static final String REGEX = "\\bcat\\b";
	private static final String INPUT = "cat cat cat cattie cat";

	private static String REGEX2 = "dog";
	private static String INPUT2 = "The dog says meow. " + "All dogs say meow.";
	private static String REPLACE2 = "cat";

	private static String REGEX3 = "a*b";
	private static String INPUT3 = "aabfooaabfooabfoobkkk";
	private static String REPLACE3 = "-";

	public static void main(String args[]) {

		// 按指定模式在字符串查找
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(\\D*)(\\d+)(.*)";

		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);

		// 现在创建 matcher 对象
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
			System.out.println("Found value: " + m.group(3));
		} else {
			System.out.println("NO MATCH");
		}

		Pattern p = Pattern.compile(REGEX);
		m = p.matcher(INPUT); // 获取 matcher 对象
		int count = 0;

		while (m.find()) {
			count++;
			System.out.println("Match number " + count);
			System.out.println("start(): " + m.start());
			System.out.println("end(): " + m.end());
		}

		// replaceFirst 和 replaceAll
		p = Pattern.compile(REGEX2);
		// get a matcher object
		m = p.matcher(INPUT2);
		INPUT2 = m.replaceAll(REPLACE2);
		System.out.println(INPUT2);

		// appendReplacement 和 appendTail
		p = Pattern.compile(REGEX3);
		// 获取 matcher 对象
		m = p.matcher(INPUT3);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, REPLACE3);
		}
		m.appendTail(sb);
		System.out.println(sb.toString());
	}
}
