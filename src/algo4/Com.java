package algo4;
public class Com extends User{
	/*
	 * Com Class
	 * User ���
	 * Player�� ��ġ�� ���� Com�� �ൿ ��ȭ
	 */

	public Com(int x, int y, Map map) {super(x, y, map);}
	//������
	
	public void run(Player p)
	{
		/*
		 * �� �� �� �Ʒ� ������ if�� �Ἥ ������ �� ������ �ൿ
		 * if�� ������ �� �� �ְ�, ������ ��ġ ���� �ٲ� ��ġ�� �� ũ�� �ൿ
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
		 * Com�� Player�� ������ true, �ƴϸ� false ��ȯ
		 */
		if(p.getX() == this.x && p.getY() == this.y){
			return true;
		}
		else
			return false;
	}

	public int distance(Player p)
	{
		//com ��ġ�� player ��ġ �Ÿ� �� ��ȯ
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
