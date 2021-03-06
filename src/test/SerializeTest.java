package test;

import java.io.*;

class Employee2 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public String name;
	public String address;
	public transient int SSN;// 因为该属性是短暂的，该值没有被发送到输出流
	public int number;

	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " " + address);
	}
}

public class SerializeTest {
	static void Serialize() {
		Employee2 e = new Employee2();
		e.name = "Reyan Ali";
		e.address = "Phokka Kuan, Ambehta Peer";
		e.SSN = 11122333;
		e.number = 101;
		try {
			FileOutputStream fileOut = new FileOutputStream("employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	static void Deserialize() {
		Employee2 e = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (Employee2) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Employee...");
		System.out.println("Name: " + e.name);
		System.out.println("Address: " + e.address);
		System.out.println("SSN: " + e.SSN);
		System.out.println("Number: " + e.number);
	}

	public static void main(String[] args) {
		Serialize();
		Deserialize();
	}
}
