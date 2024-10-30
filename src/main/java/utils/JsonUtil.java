package utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

/**
 * JsonUtil provides methods to work with JSON data.
 * 
 * @author subramanyamkongani
 *
 */
public class JsonUtil {
	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * Reads a JSON file from the given file path and returns it as a JsonNode.
	 * 
	 * @param filePath - The path to the JSON file.
	 * @return JsonNode - The parsed JSON as a JsonNode, or null if an error occurs.
	 */

	public static JsonNode readJsonFile(String filePath) {
		try {
			// Correctly call readTree on on the ObjectMapper instance
			return mapper.readTree(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Converts response object to JsonNode
	 * @param response The response object from the api call
	 * @return JsonNode - The parsed JSON response, or null if conversion fails.
	 */
	public static JsonNode convertResponseToJsonNode(Response response) {
		try {
			return mapper.readTree(response.getBody().asInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
