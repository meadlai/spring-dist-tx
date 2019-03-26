package com.example;

import static org.toilelibre.libe.curl.Curl.$;

public class TestData {

	public static void main(String[] args) {
		testOK();
		testFailed();
	}
	
	public static void testOK() {
		String r1 = $("curl -X GET http://127.0.0.1:8080/api/list");
		System.out.println(r1);
	}
	
	public static void testFailed() {
		String r1 = $("curl -X GET http://127.0.0.1:8080/api/list?exception=yes");
		System.out.println(r1);
	}

}
