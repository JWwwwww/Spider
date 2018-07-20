package com.newer.spider.Spider;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {

		List<Film> list = Collections.synchronizedList(new LinkedList<>());

		String url = "https://www.bilibili.com/ranking/all/0/0/30";

		ExecutorService pool = Executors.newCachedThreadPool();

		pool.execute(new Spider(url, list));
		pool.shutdown();

		while (true) {
			if (pool.isTerminated()) {
				ExecutorService pool2 = Executors.newCachedThreadPool();
				pool2.execute(new Loder(list));
				pool2.shutdown();
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
