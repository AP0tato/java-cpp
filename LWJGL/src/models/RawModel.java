package models;

public class RawModel {
	
	private int vertexCount, vaoID;
	
	public RawModel(int vaoID, int vertexCount)
	{
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
	}
	
	public int getVertexCount() {
		return vertexCount;
	}
	
	public void setVertexCount(int vertexCount) {
		this.vertexCount = vertexCount;
	}
	
	public int getVaoID() {
		return vaoID;
	}
	
	public void setVaoID(int vaoID) {
		this.vaoID = vaoID;
	}
}
