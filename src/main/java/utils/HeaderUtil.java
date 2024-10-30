package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * HeaderUtil is a utility class that manages headers for API requests. It
 * provides methods to retrieve default headers and authentication headers.
 * 
 * @author subramanyamkongani
 */
public class HeaderUtil {

	/**
	 * Retrieves default headers for API requests.
	 * 
	 * @return A map containing default headers, including Content-Type.
	 */
	public static Map<String, String> getDefaultHeaders() {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json"); // Default content type for JSON APIs
		return headers;
	}

	/**
	 * Retrieves authentication headers, including the Authorization header.
	 * 
	 * @param authToken The token used for Bearer authentication.
	 * @return A map containing default headers along with the Authorization header.
	 */
	public static Map<String, String> getAuthHeaders(String authToken) {
		Map<String, String> headers = getDefaultHeaders(); // Get default headers
		headers.put("Authorization", "Bearer " + authToken); // Add the Authorization header
		return headers;
	}
}
