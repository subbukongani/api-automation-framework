package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * QueryParamUtil is a utility class that provides methods to create and manage
 * query parameters for API requests.
 * 
 * This class helps in constructing key-value pairs representing query
 * parameters that can be used in HTTP GET requests.
 * 
 * Example usage: Map<String, String> params =
 * QueryParamUtil.createParams("search", "test");
 * 
 * This will create a query parameter map with a single entry: {"search":
 * "test"}
 * 
 * Author: subramanyamkongani
 */
public class QueryParamUtil {

	/**
	 * Creates a map of query parameters with a single key-value pair.
	 * 
	 * @param key   The query parameter name, typically a string that identifies the
	 *              parameter in the URL (e.g., "search", "page").
	 * @param value The value associated with the key, typically a string that
	 *              provides the information for the parameter (e.g., "test", "1").
	 * @return A Map<String, String> containing the provided key-value pair. This
	 *         map can be passed to an API request to form the query string.
	 * 
	 *         Example: If the method is called as createParams("id", "123"), the
	 *         returned map will be: {"id": "123"}
	 */
	public static Map<String, String> createParams(String key, String value) {
		// Create a new HashMap to store query parameters
		Map<String, String> params = new HashMap<>();

		// Add the key-value pair to the map
		params.put(key, value);

		// Return the map containing the single query parameter
		return params;
	}
}
