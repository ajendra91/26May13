package com.example.GoogleSearch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class Application {

	public static String url = "https://ajax.googleapis.com/ajax/" +
			"services/search/web?v=1.0&q={query}";
	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";


	public static void main(String[] args) throws IOException {

		SpringApplication.run(Application.class, args);

		//usingAPI("");
		withoutAPI("android");
	}


	private static void usingAPI(String s) {

		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Add the String message converter
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		// Make the HTTP GET request, marshaling the response to a String
		String result = restTemplate.getForObject(url, String.class, s);
		System.out.println(result);
	}

	private static void withoutAPI(String s) throws IOException {

		String searchURL = GOOGLE_SEARCH_URL + "?q="+s+"&num="+10;
		//without proper User-Agent, we will get 403 error
		Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
		Elements results = doc.select("h3.r > a");
		for (Element result : results) {
			String linkHref = result.attr("href");
			String linkText = result.text();
			System.out.println("Text::" + linkText + ", URL::" + linkHref.substring(6, linkHref.indexOf("&")));
		}
	}

	@RequestMapping("/{s}")
	public String hello(@PathVariable String s) throws IOException {
		String searchURL = GOOGLE_SEARCH_URL + "?q="+s+"&num="+10;
		Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
		return doc.html();
	}


}
