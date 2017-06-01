package algo4;
public class Node {
	/*
	 * 리스트에 넣는 Node
	 * 리스트는 중복을 없애기 위해서 존재
	 * --> 무한 루프 방지
	 * 
	 */
	
	private int px;
	private int py;
	private int cx;
	private int cy;
	
	public Node(Player p, Com c)
	{
		/*
		 * Player와 Com 플레이어를 받으면 해당 X,Y 값을 각각 저장
		 */
		this.px = p.getX();
		this.py = p.getY();
		this.cx = c.getX();
		this.cy = c.getY();
	}

	public int getPx(){return px;}
	public int getPy(){return py;}
	public int getCx(){return cx;}
	public int getCy(){return cy;}
	
	public boolean equals(Node a)
	{
		if(this.px == a.getPx() && this.py == a.getPy() && this.cx == a.getCx() && this.cy == a.getCy())
			return true;
		
		return false;
	}
	
}
