package services;

import com.fasterxml.jackson.databind.JsonNode;
import api.UserApi;
import io.restassured.response.Response;
import utils.JsonUtil;

import static org.hamcrest.MatcherAssert.assertThat; // For Hamcrest assertions
import static org.hamcrest.Matchers.equalTo; // For using equalTo matcher
import constants.StatusCodes; // Import the StatusCodes enum

/**
 * UserLib is a utility class that provides methods to perform operations on
 * user-related data through the UserApi class. It abstracts the complexity of
 * making API calls by providing simple methods for GET, POST, PUT, and DELETE
 * requests, returning JsonNode types.
 * 
 * @author subramanyamkongani
 */
public class UserLib {

	private final UserApi userApi; // Instance for UserApi to manage API Interactions

	/**
	 * Constructor for UserLib Initializes the UserApi instance
	 */
	public UserLib() {
		userApi = new UserApi(); // Initialize UserApi to use its methods
	}

	/**
	 * Return all Posts from the userApi
	 * 
	 * @return JsonNode - The API response containing all posts of a json node
	 */
	public JsonNode getAllPosts() {
		Response response = userApi.getAllPosts();
		assertThat("Status code should be 200", response.getStatusCode(), equalTo(StatusCodes.OK.getCode())); // Directly
																												// use
																												// StatusCodes.OK.code
		return JsonUtil.convertResponseToJsonNode(response);
	}

	public JsonNode getPostsById(int id) {
		Response response = userApi.getPostById(id);
		assertThat("Status code should be 200", response.getStatusCode(), equalTo(StatusCodes.OK.getCode())); // Directly
																												// use
																												// StatusCodes.OK.code
		return JsonUtil.convertResponseToJsonNode(response);
	}

	/**
	 * Creates a new post with the specified body.
	 * 
	 * @param body - the content of the post to create
	 * @return JsonNode - the API response after creating the post as a JsonNode
	 */
	public JsonNode createPost(Object body) {
		Response response = userApi.createPost(body); // Call the UserApi method
		assertThat("Status code should be 201", response.getStatusCode(), equalTo(StatusCodes.CREATED.getCode())); // Directly
																													// use
																													// StatusCodes.CREATED.code
		return JsonUtil.convertResponseToJsonNode(response); // Convert Response to JsonNode
	}

	/**
	 * Updates an existing post identified by its ID.
	 * 
	 * @param id   - the ID of the post to update
	 * @param body - the updated content of the post
	 * @return JsonNode - the API response after updating the post as a JsonNode
	 */
	public JsonNode updatePost(int id, Object body) {
		Response response = userApi.updatePost(id, body); // Call the UserApi method
		assertThat("Status code should be 200", response.getStatusCode(), equalTo(StatusCodes.OK.getCode())); // Directly
																												// use
																												// StatusCodes.OK.code
		return JsonUtil.convertResponseToJsonNode(response); // Convert Response to JsonNode
	}

	/**
	 * Deletes a post identified by its ID.
	 * 
	 * @param id - the ID of the post to delete
	 * @return JsonNode - the API response after attempting to delete the post as a
	 *         JsonNode
	 */
	public JsonNode deletePost(int id) {
		Response response = userApi.deletePost(id); // Call the UserApi method

		System.out.println("Response Status Code: " + response.getStatusCode());
		System.out.println("Response Body: " + response.getBody().asString());
		assertThat("Status code should be 204", response.getStatusCode(), equalTo(StatusCodes.NO_CONTENT.getCode())); // Directly
																														// use
																														// StatusCodes.NO_CONTENT.code
		return JsonUtil.convertResponseToJsonNode(response); // Convert Response to JsonNode
	}
}
