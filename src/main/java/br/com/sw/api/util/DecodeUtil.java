package br.com.sw.api.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodeUtil {
	
	public static String decode(String text) {
		try {
			text = URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			text = "";
		}
		return text;
	}

}
