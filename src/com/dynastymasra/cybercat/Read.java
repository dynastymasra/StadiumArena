package com.dynastymasra.cybercat;

import java.net.*;
import java.io.*;

public class Read {
	private String url;
	
	public Read(String url) {
		this.url = url;
	}
	
	public String getHtml() {
		String content ="";
		try {
			URL urlExc = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(urlExc.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null){
				content += inputLine;
			}
			in.close();
		}
		catch(Exception ex) {
			System.out.println("Error=" + ex.getMessage());
		}
		return content;
	}
}
