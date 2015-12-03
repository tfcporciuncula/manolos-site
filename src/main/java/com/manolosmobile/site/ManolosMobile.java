package com.manolosmobile.site;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManolosMobile {

	public static void main(String[] args) {
		setPortFromEnvVariable();
		staticFileLocation("/static");
		
		String message = "";
		URL url = ManolosMobile.class.getResource("/static/index.html");
		if (url == null) {
			message += "url is null ";
		} else {
			message += "url:" + url.toString();
		}
		
		final String finalMessage = message;
		get("/", (req, res) -> finalMessage);
	}

	private static void setPortFromEnvVariable() {
        String port = System.getenv("PORT");
        if (port != null && !port.trim().isEmpty()) {
            port(Integer.parseInt(port));
        } else {
            port(8080);
        }
    }
	
	private static String renderHtmlContent(String htmlFile) {
		try {
			return new String(Files.readAllBytes(Paths.get(ManolosMobile.class.getResource(htmlFile).toURI())), StandardCharsets.UTF_8);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
			return "Error :(";
		}
	}
	
}
