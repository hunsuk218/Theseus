import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	/*
	 * Main Class
	*/
	
	public static void main(String args[]) throws IOException
	{	
		Scanner scan = new Scanner(System.in);
		System.out.println("���� �̸��� �Է��ϼ���");
		String fileName = scan.nextLine();
		
		algo4 algo = OpenMapFile.getAlgo(fileName);
		//algo �ν��Ͻ� ����
		
		algo.run();
		
		System.out.println("��� ���");
		algo.print();
	}
	
}
