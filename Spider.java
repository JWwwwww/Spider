package com.newer.spider.Spider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.newer.spider.Spider.Film;

public class Spider implements Runnable {

	String url;
	List<Film> list;

	public Spider(String url, List<Film> list) {
		this.url = url;
		this.list = list;
	}

	public void run() {
		try {
			Document doc = Jsoup.connect(url).get();
			Elements items = doc.select("item");
			for (int i = 0; i < items.size(); i++) {
				Element item = items.get(i);
				String id = item.select(".num").text();
				String img = item.select(".content img").attr("src");
				String title = item.select(".title").text();
				String view = item.select(".data-box").text();
				String author = item.select(".data-box").text();
				String score = item.select(".pts> div").first().text();

				Film film = new Film();

				film.setId(Integer.parseInt(id));
				film.setImg(img);
				film.setTitle(title);
				film.setView(view);
				film.setAuthor(author);
				film.setScore(Integer.parseInt(score));

				list.add(film);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
