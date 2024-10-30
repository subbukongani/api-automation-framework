package api;

import java.util.Map;

import config.ConfigMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ApiLogger;

/**
 * UserApi provides methods to interact with the user-related API endpoints. 
 * It uses the RequestHandler to perform HTTP operations such as GET, POST, 
 * PUT, and DELETE.
 * 
 * @author subramanyamkongani
 */
public class UserApi {

    // Instance of RequestHandler to manage HTTP requests
    private final RequestHandler requestHandler;

    // Base URI for the API
    private final String baseUri;

    // API Endpoints
    private static final String GET_POSTS = "/posts";
    private static final String GET_POST_BY_ID = "/posts/{id}";
    private static final String CREATE_POST = "/posts";
    private static final String UPDATE_POST = "/posts/{id}";
    private static final String DELETE_POST = "/posts/{id}";

    /**
     * Constructor for UserApi. Initializes the RequestHandler with the base URL
     * retrieved from the configuration.
     */
    public UserApi() {
        // Retrieve the base URL from configuration properties
        baseUri = ConfigMapping.getConfigProperty("base.url");
        requestHandler = new RequestHandler(baseUri);
    }

    /**
     * Retrieves all posts from the API.
     * 
     * @return Response - the API response containing all posts
     */
    public Response getAllPosts() {
        Response response = requestHandler.get(GET_POSTS, null, null);
        ApiLogger.logResponse(response);
        return response;
    }

    /**
     * Retrieves a specific post by its ID.
     * 
     * @param id - the ID of the post to retrieve
     * @return Response - the API response containing the post with the specified ID
     */
    public Response getPostById(int id) {
        Map<String, String> pathParams = Map.of("id", String.valueOf(id));
        String fullUrl = constructFullUrl(GET_POST_BY_ID, pathParams);
        RequestSpecification requestSpec = getRequestSpec(GET_POST_BY_ID, null, null, pathParams);

        // Log the request details
        ApiLogger.logRequest("GET", fullUrl, null, null); // Log the full URL

        Response response = requestHandler.get(GET_POST_BY_ID, null, pathParams);
        ApiLogger.logResponse(response);
        return response;
    }

    /**
     * Creates a new post with the specified body.
     * 
     * @param body - the content of the post to create
     * @return Response - the API response after creating the post
     */
    public Response createPost(Object body) {
        String fullUrl = constructFullUrl(CREATE_POST, null);
        RequestSpecification requestSpec = getRequestSpec(CREATE_POST, null, body, null);

        // Log the request details
        ApiLogger.logRequest("POST", fullUrl, null, body); // Log the full URL

        Response response = requestHandler.post(CREATE_POST, null, body);
        ApiLogger.logResponse(response);
        return response;
    }

    /**
     * Updates an existing post identified by its ID.
     * 
     * @param id   - the ID of the post to update
     * @param body - the updated content of the post
     * @return Response - the API response after updating the post
     */
    public Response updatePost(int id, Object body) {
        Map<String, String> pathParams = Map.of("id", String.valueOf(id));
        String fullUrl = constructFullUrl(UPDATE_POST, pathParams);
        RequestSpecification requestSpec = getRequestSpec(UPDATE_POST, null, body, pathParams);

        // Log the request details
        ApiLogger.logRequest("PUT", fullUrl, null, body); // Log the full URL

        Response response = requestHandler.put(UPDATE_POST, null, body, pathParams);
        ApiLogger.logResponse(response);
        return response;
    }

    /**
     * Deletes a post identified by its ID.
     * 
     * @param id - the ID of the post to delete
     * @return Response - the API response after attempting to delete the post
     */
    public Response deletePost(int id) {
        Map<String, String> pathParams = Map.of("id", String.valueOf(id));
        String fullUrl = constructFullUrl(DELETE_POST, pathParams);
        RequestSpecification requestSpec = getRequestSpec(DELETE_POST, null, null, pathParams);

        // Log the request details
        ApiLogger.logRequest("DELETE", fullUrl, null, null); // Log the full URL

        Response response = requestHandler.delete(DELETE_POST, null, pathParams);
        ApiLogger.logResponse(response);
        return response;
    }

    // Unified method for creating a request specification for logging
    private RequestSpecification getRequestSpec(String path, Map<String, String> headers, Object body, Map<String, String> pathParams) {
        RequestSpecification requestSpec = RestAssured.given()
                .baseUri(baseUri)
                .basePath(path)
                .headers(headers != null ? headers : Map.of())
                .pathParams(pathParams != null ? pathParams : Map.of());

        // Only set the body if it's not null
        if (body != null) {
            requestSpec.body(body);
        }

        return requestSpec;
    }

    // Method to construct the full URL
    private String constructFullUrl(String path, Map<String, String> pathParams) {
        // Replace path parameters in the URL
        String url = baseUri + path;
        if (pathParams != null) {
            for (Map.Entry<String, String> entry : pathParams.entrySet()) {
                url = url.replace("{" + entry.getKey() + "}", entry.getValue());
            }
        }
        return url;
    }
}
