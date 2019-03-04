package test;

import java.util.*;

public class GenericMethodTest<J> {
	private J t;

	public void add(J t) {
		this.t = t;
	}

	public J get() {
		return t;
	}

	// 泛型方法 printArray
	public static <E> void printArray(E[] inputArray) {
		// 输出数组元素
		for (E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	// "extends"如何使用在一般意义上的意思"extends"（类）或者"implements"（接口）
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x; // 假设x是初始最大值
		if (y.compareTo(max) > 0) {
			max = y; // y 更大
		}
		if (z.compareTo(max) > 0) {
			max = z; // 现在 z 更大
		}
		return max; // 返回最大对象
	}

	public static void getData(List<?> data) {
		System.out.println("data :" + data.get(0));
	}

	public static void main(String args[]) {
		// 使用泛型方法打印不同字符串的元素
		// 创建不同类型数组： Integer, Double 和 Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("整型数组元素为:");
		printArray(intArray); // 传递一个整型数组

		System.out.println("\n双精度型数组元素为:");
		printArray(doubleArray); // 传递一个双精度型数组

		System.out.println("\n字符型数组元素为:");
		printArray(charArray); // 传递一个字符型数组
		// "extends"如何使用在一般意义上的意思"extends"（类）或者"implements"（接口）
		System.out.printf("%d, %d 和 %d 中最大的数为 %d\n\n", 3, 4, 5, maximum(3, 4, 5));

		System.out.printf("%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

		System.out.printf("%s, %s 和 %s 中最大的数为 %s\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));

		// 泛型类
		GenericMethodTest<Integer> integerBox = new GenericMethodTest<Integer>();
		GenericMethodTest<String> stringBox = new GenericMethodTest<String>();

		integerBox.add(new Integer(10));
		stringBox.add(new String("菜鸟教程"));

		System.out.printf("整型值为 :%d\n\n", integerBox.get());
		System.out.printf("字符串为 :%s\n", stringBox.get());

		// 类型通配符一般是使用?代替具体的类型参数
		List<String> name = new ArrayList<String>();
		List<Integer> age = new ArrayList<Integer>();
		List<Number> number = new ArrayList<Number>();

		name.add("icon");
		age.add(18);
		number.add(314);

		getData(name);
		getData(age);
		getData(number);
	}
}
