package algo4;
public class Map {
	/*
	 * Map class
	 * 맵을 만듬
	 * 왼, 오, 위, 아래 를 순서대로 1 2 4 8
	 * 다음을 갈 수 있으면 해당 값을 더해서 맵을 만듬
	 */
	
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
