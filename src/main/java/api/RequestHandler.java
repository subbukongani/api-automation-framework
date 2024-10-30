package api;

import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * RequestHandler is responsible for handling HTTP requests using the
 * RestAssured library. It provides methods for sending GET, POST, PUT, and
 * DELETE requests to a specified base URI.
 */
public class RequestHandler {
	private final String baseUri; // Base URI for the API requests

	/**
	 * Constructor for RequestHandler.
	 * 
	 * @param baseUri The base URI to be used for all API requests.
	 */
	public RequestHandler(String baseUri) {
		this.baseUri = baseUri; // Initialize the base URI
		RestAssured.baseURI = baseUri; // Set RestAssured's base URI
	}

	/**
	 * Sends a GET request to the specified path with optional headers and query
	 * parameters.
	 * 
	 * @param path        The API endpoint path (e.g., "/posts").
	 * @param headers     Optional map of headers to be included in the request. If
	 *                    null, an empty map will be used.
	 * @param queryParams Optional map of query parameters to be appended to the
	 *                    request URL. If null, no query parameters will be
	 *                    included.
	 * @return Response object containing the server's response to the GET request.
	 */
	public Response get(String path, Map<String, String> headers, Map<String, String> queryParams) {
		return RestAssured.given().headers(headers != null ? headers : Map.of()) // Use an empty map if headers are null
				.queryParams(queryParams != null ? queryParams : Map.of()) // Use an empty map if queryParams are null
				.get(baseUri + path); // Perform the GET request
	}

	/**
	 * Sends a POST request to the specified path with optional headers and a
	 * request body.
	 * 
	 * @param path    The API endpoint path (e.g., "/posts").
	 * @param headers Optional map of headers to be included in the request. If
	 *                null, an empty map will be used.
	 * @param body    The request body to be sent with the POST request. Can be any
	 *                object.
	 * @return Response object containing the server's response to the POST request.
	 */
	public Response post(String path, Map<String, String> headers, Object body) {
		return RestAssured.given().headers(headers != null ? headers : Map.of()) // Use an empty map if headers are null
				.body(body) // Set the request body
				.post(baseUri + path); // Perform the POST request
	}

	/**
	 * Sends a PUT request to the specified path with optional headers, request
	 * body, and path parameters.
	 * 
	 * @param path       The API endpoint path (e.g., "/posts/{id}").
	 * @param headers    Optional map of headers to be included in the request. If
	 *                   null, an empty map will be used.
	 * @param body       The request body to be sent with the PUT request. Can be
	 *                   any object.
	 * @param pathParams Optional map of path parameters to be included in the
	 *                   request URL. If null, no path parameters will be included.
	 * @return Response object containing the server's response to the PUT request.
	 */
	public Response put(String path, Map<String, String> headers, Object body, Map<String, String> pathParams) {
		return RestAssured.given().headers(headers != null ? headers : Map.of()) // Use an empty map if headers are null
				.body(body) // Set the request body
				.pathParams(pathParams != null ? pathParams : Map.of()) // Use an empty map if pathParams are null
				.put(baseUri + path); // Perform the PUT request
	}

	/**
	 * Sends a DELETE request to the specified path with optional headers and path
	 * parameters.
	 * 
	 * @param path       The API endpoint path (e.g., "/posts/{id}").
	 * @param headers    Optional map of headers to be included in the request. If
	 *                   null, an empty map will be used.
	 * @param pathParams Optional map of path parameters to be included in the
	 *                   request URL. If null, no path parameters will be included.
	 * @return Response object containing the server's response to the DELETE
	 *         request.
	 */
	public Response delete(String path, Map<String, String> headers, Map<String, String> pathParams) {
		return RestAssured.given().headers(headers != null ? headers : Map.of()) // Use an empty map if headers are null
				.pathParams(pathParams != null ? pathParams : Map.of()) // Use an empty map if pathParams are null
				.delete(baseUri + path); // Perform the DELETE request
	}
}
