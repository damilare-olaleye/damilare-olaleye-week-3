package com.revature.app;


import java.util.LinkedList;

import com.revature.controller.ArithmeticController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Application {

	public static void main(String[] args) {
		
		LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("ADE");
		ll.add("BEA");
		ll.addLast("CAT");
		ll.add(2, "EAT");
		
		System.out.println(ll);
		
		ll.remove("BAT");
		ll.remove(2);
		ll.removeFirst();
		
		System.out.println(ll);
		
		Javalin app = Javalin.create(config -> {
			config.addStaticFiles("/", Location.CLASSPATH);
		});
		
		// To instantiate Controller
		ArithmeticController arithmeticController = new ArithmeticController();
		arithmeticController.registerEndPoint(app);
		app.start(8080);

	}

}
