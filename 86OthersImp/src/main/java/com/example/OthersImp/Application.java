package com.example.OthersImp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {


		//SpringApplication.run(Application.class, args);

		System.out.println("\n------------------------------\n");

		System.out.println(new Date(System.currentTimeMillis()+20000));

		System.out.println("\n------------------------------\n");

		NoOpPasswordEncoder demo = (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
		System.out.println(demo.encode("admin"));

		System.out.println("\n------------------------------\n");

		BCryptPasswordEncoder bcp =new BCryptPasswordEncoder();
		System.out.println(bcp.encode("admin"));

		System.out.println("\n------------------------------\n");

		Base64.Encoder encoder = Base64.getUrlEncoder();
		String str1 = encoder.encodeToString
				("http://www.javatpoint.com/java-tutorial/".getBytes());
		System.out.println(str1);
		Base64.Decoder decoder = Base64.getUrlDecoder();
		String str2 = new String(decoder.decode(str1));
		System.out.println("Decoded URL: "+str2);

		System.out.println("\n------------------------------Random\n");

		System.out.println(UUID.randomUUID().toString().substring(0,5));

		System.out.println("\n------------------------------\n");

		String randomStr = "";
		String possibleChars = "`!@#$%^&*(_+|}{:ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 5; i++)
			randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
		System.out.println(randomStr);

		System.out.println("\n------------------------------\n");

		System.out.println(new Random().nextInt(10));

		System.out.println("\n------------------------------\n");

		System.out.println(String.valueOf(new Random().nextInt() * 10000 -1000)+ 1000);
		System.out.println(String.valueOf((int)(Math.random()*(10000-1000)))+1000);

		System.out.println("\n------------------------------http\n");

		URL url =new URL("https://www.google.com");
		URLConnection con = url.openConnection();
		con.connect();
		System.out.println("now u r connect...");

		System.out.println("\n------------------------------\n");

		HttpURLConnection conn = (HttpURLConnection) new URL
				("https://api.textlocal.in/send/?").openConnection();
		conn.setRequestMethod("POST");
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		System.out.println("\n------------------------------\n");

		HttpURLConnection conn2 = (HttpURLConnection) new URL
				("http://cloud.fowiz.com/api/message_http_api.php?username="+"ajendra"
				+"&phonenumber="+786876876+"&message="+"hello"+"&passcode="+"687687")
				.openConnection();
		conn2.setRequestMethod("GET");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));

		System.out.println("\n------------------------------\n");

		//HttpClient client = new DefaultHttpClient();
		//HttpGet request = new HttpGet("http://");
		//HttpResponse response= client.execute(request);
		//BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		System.out.println("\n------------------------------\n");

	}

}
