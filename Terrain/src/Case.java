
public class Case {
	
	Integer x;
	
	Integer y;
	
	String typeBiome;

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public String getTypeBiome() {
		return typeBiome;
	}

	public void setTypeBiome(String typeBiome) {
		this.typeBiome = typeBiome;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
	
	
	

}
