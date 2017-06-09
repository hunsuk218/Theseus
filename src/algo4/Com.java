package algo4;
public class Com extends User{
	/*
	 * Com Class
	 * User 상속
	 * Player의 위치에 따라 Com의 행동 변화
	 */

	public Com(int x, int y, Map map) {super(x, y, map);}
	//생성자
	
	public void run(Player p)
	{
		/*
		 * 왼 오 위 아래 순으로 if문 써서 가능한 거 있으면 행동
		 * if문 조건은 갈 수 있고, 지금의 위치 보다 바뀐 위치가 더 크면 행동
		 */
		int distance = distance(p);
		
		if(canGo(1) && (distance > distance(p,1)))
		{ 
			go(1);
		}
		else if(canGo(2) && (distance > distance(p,2)))
		{
			go(2);
		}
		else if(canGo(4) && (distance > distance(p,4)))
		{
			go(4);
		}
		else if(canGo(8) && (distance > distance(p,8)))
		{   
			go(8);
		}
	}

	public boolean catchPlayer(Player p)
	{
		/*
		 * Com가 Player를 잡으면 true, 아니면 false 반환
		 */
		if(p.getX() == this.x && p.getY() == this.y){
			return true;
		}
		else
			return false;
	}

	public int distance(Player p)
	{
		//com 위치와 player 위치 거리 값 반환
		int distance = Math.abs(this.x - p.getX()) + Math.abs(this.y - p.getY());
		return distance;
	}

	public int distance(Player p,int x,int y)
	{
		int distance = Math.abs(x-p.getX()) + Math.abs(y-p.getY());

		return distance;
	}

	public int distance(Player p, int loc)
	{
		switch(loc)
		{
		case 1:
			return distance(p,this.x, this.y - 1);
		case 2:
			return distance(p,this.x, this.y + 1);
		case 4:
			return distance(p,this.x - 1, this.y);
		case 8:
			return distance(p,this.x + 1, this.y);
		}
		return 0;
	}
}
