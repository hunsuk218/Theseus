package algo4;
public class Player extends User{
	
	/*
	 * Player Class
	 * User Class�� ��ӹ���
	 */

	public Player(int x, int y,Map map) {
		super(x, y,map);
	}
	
	public boolean goal(){
		/*
		 * Map�� �������� �����ϸ� true ��ȯ, �ƴϸ� false ��ȯ
		 */
		if(map.getGoalX() == x && map.getGoalY() == y)
		{
			return true;
		}
		return false;
	}
}
