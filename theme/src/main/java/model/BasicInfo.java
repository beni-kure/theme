package model;

public class BasicInfo {
	String title;
	String name;
	String sex;
	String genre;
	String freeword;
	String color;
	String pattern;
	
	public String getColor() {
		return color;
	}

	public String getPattern() {
		return pattern;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public BasicInfo(String title,String name,String sex,String genre,String freeword){
		this.title=title;
		this.name=name;
		this.sex=sex;
		this.genre=genre;
		this.freeword=freeword;
	}
	
	public BasicInfo(String title,String sex,String genre,String freeword,String color,String pattern){
		this.title=title;
		this.sex=sex;
		this.genre=genre;
		this.freeword=freeword;
		this.color=color;
		this.pattern=pattern;
	}
	
	public BasicInfo(String title,String name) {
		this.title=title;
		this.name=name;
	}

	public String getTitle() {
		if(title.isEmpty()) {
			return null;
		}
		return title;
	}

	public String getName() {
		if(name.isEmpty()) {
			return null;
		}
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getGenre() {
			return genre;
	}

	public String getFreeword() {
		if(freeword.isEmpty()) {
			return null;
		}
		return freeword;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setFreeword(String freeword) {
		this.freeword = freeword;
	}
	
}
