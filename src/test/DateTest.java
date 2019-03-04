package test;

import java.util.*;
import java.text.*;

public class DateTest {
	public static void main(String args[]) {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("当前时间为: " + ft.format(date));

		// c的使用
		System.out.printf("全部日期和时间信息：%tc%n", date);
		// f的使用
		System.out.printf("年-月-日格式：%tF%n", date);
		// d的使用
		System.out.printf("月/日/年格式：%tD%n", date);
		// r的使用
		System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n", date);
		// t的使用
		System.out.printf("HH:MM:SS格式（24时制）：%tT%n", date);
		// R的使用
		System.out.printf("HH:MM格式（24时制）：%tR", date);

		// 使用toString()显示日期和时间
		System.out.printf("\n%1$s %2$tB %2$td, %2$tY", "Due date:", date);

		// 显示格式化时间
		// < 标志。它表明先前被格式化的参数要被再次使用
		System.out.printf("\n%s %tB %<te, %<tY", "Due date:", date);

		// b的使用，月份简称
		String str = String.format(Locale.US, "英文月份简称：%tb", date);
		System.out.println(str);
		System.out.printf("本地月份简称：%tb%n", date);
		// B的使用，月份全称
		str = String.format(Locale.US, "英文月份全称：%tB", date);
		System.out.println(str);
		System.out.printf("本地月份全称：%tB%n", date);
		// a的使用，星期简称
		str = String.format(Locale.US, "英文星期的简称：%ta", date);
		System.out.println(str);
		// A的使用，星期全称
		System.out.printf("本地星期的简称：%tA%n", date);
		// C的使用，年前两位
		System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n", date);
		// y的使用，年后两位
		System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n", date);
		// j的使用，一年的天数
		System.out.printf("一年中的天数（即年的第几天）：%tj%n", date);
		// m的使用，月份
		System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n", date);
		// d的使用，日（二位，不够补零）
		System.out.printf("两位数字的日（不足两位前面补0）：%td%n", date);
		// e的使用，日（一位不补零）
		System.out.printf("月份的日（前面不补0）：%te\n", date);

		// parse()，它试图按照给定的SimpleDateFormat 对象的格式化存储来解析字符串
		SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd");
		String input = args.length == 0 ? "1818-11-11" : args[0];
		System.out.print(input + " Parses as ");
		Date t;
		try {
			t = ft2.parse(input);
			System.out.println(t);
		} catch (ParseException e) {
			System.out.println("Unparseable using " + ft);
		}

		// 休眠3秒
		try {
			System.out.println(new Date() + "\n");
			Thread.sleep(1000 * 3); // 休眠3秒
			System.out.println(new Date() + "\n");
		} catch (Exception e) {
			System.out.println("Got an exception!");
		}

		// 表明如何测量时间间隔（以毫秒为单位）：
		try {
			long start = System.currentTimeMillis();
			System.out.println(new Date() + "\n");
			Thread.sleep(5 * 60 * 10);
			System.out.println(new Date() + "\n");
			long end = System.currentTimeMillis();
			long diff = end - start;
			System.out.println("Difference is : " + diff);
		} catch (Exception e) {
			System.out.println("Got an exception!");
		}

		// Calendar
		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		int year;
		// 初始化 Gregorian 日历
		// 使用当前时间和日期
		// 默认为本地时间和时区
		GregorianCalendar gcalendar = new GregorianCalendar();
		// 显示当前时间和日期的信息
		System.out.print("Date: ");
		System.out.print(months[gcalendar.get(Calendar.MONTH)]);
		System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
		System.out.println(year = gcalendar.get(Calendar.YEAR));
		System.out.print("Time: ");
		System.out.print(gcalendar.get(Calendar.HOUR) + ":");
		System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
		System.out.println(gcalendar.get(Calendar.SECOND));

		// 测试当前年份是否为闰年
		if (gcalendar.isLeapYear(year)) {
			System.out.println("当前年份是闰年");
		} else {
			System.out.println("当前年份不是闰年");
		}
	}
}
