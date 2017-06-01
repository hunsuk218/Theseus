
public class User {
	/*
	 * User class
	 * ��ġ ���� X, Y
	 * 
	 */

	protected int x;
	protected int y;
	protected Map map;

	public User(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public User(int x,int y, Map map)
	{
		this.x = x;
		this.y = y;
		this.map = map;
	}
	
	//get X, Y
	public int getX(){return this.x;}	
	public int getY(){return this.y;}
	//Set X, Y
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	
	public void go(int loc)
	{
		/*
		 * �̵��� �� ������ 
		 * loc �������� �̵�
		 * loc --> �� �� �� �Ʒ� ������
		 * ���� 1 2 4 8  
		 */
		if(!this.canGo(loc))
		{
			System.out.println("can't Go");
			return;
		}
		switch(loc)
		{
		case 1:
			this.y = this.y - 1;
			break;
		case 2:
			this.y = this.y + 1;
			break;
		case 4:
			this.x = this.x - 1;
			break;
		case 8:
			this.x = this.x + 1;
			break;
		}
	}
	
	public boolean canGo(int loc){
		/*
		 * Map�� ���غ��� ������ �̵��� �� ������ True, �ƴϸ� False ��ȯ
		 */
		return map.canGo(x, y, loc);
	}
}
