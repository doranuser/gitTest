package test;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class urlEncode {
	
	public static String UrlEncode(String inputString) {
		String outputString = null;
	
	try {
		outputString = URLEncoder.encode(inputString, "UTF-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
		return outputString;
	}
	public static String UrlDecode(String inputString) {
		String outputString = null;
	
	try {
		outputString = URLDecoder.decode(inputString, "UTF-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
		return outputString;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url ="name=John Smith&address=500 1/2 Main Street";
		url =UrlEncode(url);
		
		System.out.println(url);
		url =UrlDecode(url);
		
		System.out.println(url);
		

	}

}
