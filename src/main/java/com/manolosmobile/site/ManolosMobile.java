package com.manolosmobile.site;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import java.io.IOException;
import java.io.InputStream;

import spark.utils.IOUtils;

public class ManolosMobile {

	private static String indexHtmlContent;
	
	public static void main(String[] args) {
		setPortFromEnvVariable();
		staticFileLocation("/static");
		initIndexHtmlContent("/static/index.html");
		
		get("/", (req, res) -> indexHtmlContent);
	}

	private static void setPortFromEnvVariable() {
        String port = System.getenv("PORT");
        if (port != null && !port.trim().isEmpty()) {
            port(Integer.parseInt(port));
        } else {
            port(8090);
        }
    }
	
	private static void initIndexHtmlContent(String htmlFile) {
        try (InputStream htmlStream = ManolosMobile.class.getResourceAsStream(htmlFile)) {
			indexHtmlContent = IOUtils.toString(htmlStream);
		} catch (IOException e) {
			e.printStackTrace();
			indexHtmlContent = "Error :(";
		}
	}
	
}
