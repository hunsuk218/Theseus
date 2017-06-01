package algo4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class OpenMapFile {
	public static algo4 getAlgo(String fileName) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(fileName));

		String str;

		str = in.readLine();
		int arrSize1 = Integer.parseInt(str);
		str = in.readLine();
		int arrSize2 = Integer.parseInt(str);
		str = in.readLine();
		int goalX = Integer.parseInt(str);
		str = in.readLine();
		int goalY = Integer.parseInt(str);
		str = in.readLine();
		int pX = Integer.parseInt(str);
		str = in.readLine();
		int pY = Integer.parseInt(str);
		str = in.readLine();
		int cX = Integer.parseInt(str);
		str = in.readLine();
		int cY = Integer.parseInt(str);
		int[][] num = new int[arrSize1][arrSize2];
		int count = 0;
		
		System.out.println("초기 파일 상태:");
		
		while(true)
		{
			str = in.readLine();
			if(str == null)
				break;
			StringTokenizer tokens = new StringTokenizer(str);

			for(int i=0;i<arrSize2;i++)
			{
				num[count][i] = Integer.parseInt(tokens.nextToken("\t"));
				System.out.println(num[count][i]);
			}
			count++;
		}
		in.close();

		for(int i=0;i<arrSize1;i++)
		{
			for(int j=0;j<arrSize2;j++)
			{
				System.out.print(num[i][j] + "\t");
			}
			System.out.println();
		}
		
		Map map = new Map(num,goalX,goalY);
		Player p = new Player(pX,pY,map);
		Com c = new Com(cX,cY,map);
		algo4 algo = new algo4(p,c);
		map.printMap();
		System.out.println( arrSize1 + " " + arrSize2  + " " + goalX  + " " + goalY  + " " + pX  + " " + pY  + " " + cX  + " " + cY);
		return algo;
	}
}	