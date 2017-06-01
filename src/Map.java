
public class Map {
	/*
	 * Map class
	 * 맵을 만듬
	 * 왼, 오, 위, 아래 를 순서대로 1 2 4 8
	 * 다음을 갈 수 있으면 해당 값을 더해서 맵을 만듬
	 */
	
	//기본예제 1
//	int[][] map = {
	//		{10, 3, 9, 0},
	//		{14, 1, 14, 3},
	//		{6 , 3, 5, 0}
	//		};
	
	//예제 1
	/*
	 * int[][] map = {
	 *
			{2,	3,	11,	9,	10,	9,	10,	3,	9},
			{10,9,	4,	12,	12,	12,	14,	1,	12},
			{12,6,	9,	14,	5,	6,	5,	10,	13},
			{6,	9,	12,	6,	9,	10,	3,	7,	5},
			{8,	12,	6,	11,	5,	6,	3,	3,	9},
			{14,5,	10,	5,	10,	11,	3,	3,	5},
			{12,8,	14,	1,	12,	6,	3,	3,	9},
			{4,	6,	7,	3,	7,	1,	2,	3,	5}
	};
	*/

	//예제 1 gaol
//	static int goalX = 1;
//	static int goalY = 3;
	
	int[][] map;	
	private int goalX;
	private int goalY;
	//목표 위치 x, y
	
	public Map(int[][] map, int goalX, int goalY)
	{
		this.map = map;
		this.goalX = goalX;
		this.goalY = goalY;
	}
	public Map()
	{
		//삭제할 예정
	}
	
	public int getGoalX(){return goalX;}
	public int getGoalY(){return goalY;}
	
	public void printMap()
	{
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length ;j++)
			{
				System.out.println("x = " + i + " y = " + j + " map = " + map[i][j]);
			}
		}
	}
	
	public boolean canGo(int x, int y, int loc){
		/*
		 * x, y, 방향을 가져와서 갈 수 있으면 true, 아니면 false 리턴
		 */
		if(((map[x][y]/loc) % 2) == 1)
			return true;
		else
			return false;
	}
}
