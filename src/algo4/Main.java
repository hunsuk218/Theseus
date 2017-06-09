package algo4;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	/*
	 * Main Class
	*/
	
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException
	{	
		Scanner scan = new Scanner(System.in);
		System.out.println("파일 이름을 입력하세요");
		String fileName = scan.nextLine();
		
		algo4 algo = OpenMapFile.getAlgo(fileName);
		//algo 인스턴스 생성
		
		algo.run();
		
		System.out.println("경로 출력");
		algo.print();
	}	
}
