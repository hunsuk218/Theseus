package algo4;
public class Map {
	/*
	 * Map class
	 * ���� ����
	 * ��, ��, ��, �Ʒ� �� ������� 1 2 4 8
	 * ������ �� �� ������ �ش� ���� ���ؼ� ���� ����
	 */
	
	int[][] map;	
	private int goalX;
	private int goalY;
	//��ǥ ��ġ x, y
	
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
		 * x, y, ������ �����ͼ� �� �� ������ true, �ƴϸ� false ����
		 */
		if(((map[x][y]/loc) % 2) == 1)
			return true;
		else
			return false;
	}
}
