package contro;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class util {
	static ObjectMapper mapper = new ObjectMapper();
	public static String toJson(Object obj) {
		String result = null;
		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static <T> T toObject(String json,Class<T> valueType) {
		T result=null;
		try {
			result=mapper.readValue(json,valueType);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
