package algo4;
public class Player extends User{
	
	/*
	 * Player Class
	 * User Class를 상속받음
	 */

	public Player(int x, int y,Map map) {
		super(x, y,map);
	}
	
	public boolean goal(){
		/*
		 * Map의 목적지에 도착하면 true 반환, 아니면 false 반환
		 */
		if(map.getGoalX() == x && map.getGoalY() == y)
		{
			return true;
		}
		return false;
	}
}
