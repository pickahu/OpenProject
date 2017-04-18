package pickahu.openproject.UniversalImageLoader.bean;

import java.io.Serializable;

public class Photo implements Serializable{
	private String name;
	private String path;
	private String dir;
	private String size;
	private String date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Photo(String name, String path, String dir, String size, String date) {
		super();
		this.name = name;
		this.path = path;
		this.dir = dir;
		this.size = size;
		this.date = date;
	}

}
