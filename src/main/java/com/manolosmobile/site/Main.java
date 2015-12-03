package com.manolosmobile.site;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		staticFileLocation("/static");
		get("/", (req, res) -> renderHtmlContent("/static/index.html"));
	}
	
	private static String renderHtmlContent(String htmlFile) {
		try {
			return new String(Files.readAllBytes(Paths.get(Main.class.getResource(htmlFile).toURI())), StandardCharsets.UTF_8);
		} catch (IOException | URISyntaxException e) {
			return "error ):";
			// handle this
		}
	}
	
}
