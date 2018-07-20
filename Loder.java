package com.newer.spider.Spider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Loder implements Runnable {

	List<Film> list;

	public Loder(List<Film> list) {
		this.list = list;
	}

	public void run() {
		File file = new File("img");
		if (!file.exists()) {
			file.mkdirs();
		}

		for (Film film : list) {
			String name = String.format("%03d_%s", film.getId(), film.getTitle());
			try {
				FileOutputStream out = new FileOutputStream(new File(file, name));
				byte[] data = new OkHttpClient.Builder().build()
						.newCall(new Request.Builder()
								.url(film.getImg()).build()).execute().body().bytes();
				System.out.println("写入"+film.getId());
				out.write(data);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
