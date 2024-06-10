package Concepts;

import org.json.simple.JSONObject;
import java.lang.Integer;
import java.lang.Double;
import java.lang.Boolean;

public class JsonJava {

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();

		obj.put("name", "foo");
		obj.put("num", 100);
		obj.put("balance", 1000.21);
		obj.put("is_vip", true);

		System.out.print(obj);
	}

}
