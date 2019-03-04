package test;

//StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
public class StringBufferTest {
	public static void main(String args[]) {
		StringBuffer sBuffer = new StringBuffer("菜鸟教程官网：");
		sBuffer.append("www");
		sBuffer.append(".runoob");
		sBuffer.append(".com");
		System.out.println(sBuffer);

		StringBuilder sBuffer2 = new StringBuilder("菜鸟教程官网：");
		sBuffer2.append("www");
		sBuffer2.append(".runoob");
		sBuffer2.append(".com");
		System.out.println(sBuffer2);
	}
}
