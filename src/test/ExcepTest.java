package test;

public class ExcepTest{
	public static void exception1() {
		try{
			int a[] = new int[2];
			System.out.println("Access element three :" + a[3]);
		}catch(Exception e){
			System.out.println("Exception thrown  :" + e);
		}
     System.out.println("Out of the block");
	}
	public static void exception2() {
	    int a[] = new int[2];
	    try{
	       System.out.println("Access element three :" + a[3]);
	    }catch(ArrayIndexOutOfBoundsException e){
	       System.out.println("Exception thrown  :" + e);
	    }
	    finally{
	       a[0] = 6;
	       System.out.println("First element value: " +a[0]);
	       System.out.println("The finally statement is executed");
	    }
	}
	public static void main(String args[]){
		exception2();
	}
}
