package com.manolosmobile.site;

import static spark.Spark.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManolosMobile {

	public static void main(String[] args) {
		setPortFromEnvVariable();
		staticFileLocation("/static");
		
		get("/", (req, res) -> renderHtmlContent("/static/index.html"));
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
