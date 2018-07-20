package com.newer.spider.Spider;

public class Film implements Comparable<Film>{

	int id;
	String img;
	String title;
	String view;
	String author;
	int score;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String toString() {
		return "Film [id=" + id + ", img=" + img + ", title=" + title + ", view=" + view + ", author=" + author
				+ ", score=" + score + "]";
	}
	
	public int compareTo(Film o) {
		return this.score-o.score;
	}
	
}
