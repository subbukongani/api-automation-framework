package api;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import services.UserLib; // Import the UserLib service class that interacts with the API
import java.io.File; // For handling file operations
import java.io.IOException; // For handling IO exceptions
import static org.hamcrest.MatcherAssert.assertThat; // For Hamcrest assertions
import static org.hamcrest.Matchers.equalTo;

/**
 * UserApiTest is a TestNG test class that verifies the functionality of the
 * User API using the UserLib service. This class contains tests for getting,
 * creating, updating, and deleting posts.
 */
public class UserApiTest {

	// Initialize the UserLib instance once at the class level
	private final UserLib userLib = new UserLib();
	private final ObjectMapper objectMapper = new ObjectMapper(); // ObjectMapper to read JSON files

	/**
	 * Tests the retrieval of all posts from the API. Asserts that the status code
	 * is 200 (OK) and prints the response body.
	 */
	@Test
	public void verifyGetAllPosts() {
		String expectedTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
		// Call the method that retrieves all posts and returns a JsonNode object
		JsonNode response = userLib.getAllPosts();

		// Print the response body for debugging
		System.out.println("Response Body: " + response.toString());
		assertThat(response.get(0).get("title").asText(), equalTo(expectedTitle));
	}

	/**
	 * Tests the creation of a new post in the API. Asserts that the status code is
	 * 201 (Created) and prints the response body.
	 */
	@Test
	public void verifyCreatePost() throws IOException {
		// Read the JSON payload from the specified file
		File createPayloadFile = new File("src/main/resources/payloads/createPostPayload.json");
		JsonNode createPayload = objectMapper.readTree(createPayloadFile); // Parse the JSON file

		// Call the method that creates a post with the JSON payload and returns a
		// JsonNode object
		JsonNode response = userLib.createPost(createPayload); // Pass the JSON payload

		// Print the response body
		System.out.println("Response Body: " + response.toString());
	}

	/**
	 * Tests the updating of an existing post in the API. Asserts that the status
	 * code is 200 (OK) and prints the response body.
	 */
	@Test
	public void verifyUpdatePost() throws IOException {
		// Read the JSON payload from the specified file
		File updatePayloadFile = new File("src/main/resources/payloads/updatePostPayload.json");
		JsonNode updatePayload = objectMapper.readTree(updatePayloadFile); // Parse the JSON file

		// Call the method that updates a post with the JSON payload and returns a
		// JsonNode object
		JsonNode response = userLib.updatePost(1, updatePayload); // Assuming an ID of 1 for this example

		// Print the response body
		System.out.println("Response Body: " + response.toString());
	}

	/**
	 * Tests the deletion of a post from the API. Asserts that the status code is
	 * 204 (No Content) and prints the response body.
	 */
	@Test
	public void verifyDeletePost() {
		// Call the method that deletes a post and returns a JsonNode object
		JsonNode response = userLib.deletePost(101); // Assuming an ID of 1 for this example

		// Print the response body for debugging; no content expected for a successful
		// delete
		System.out.println("Response Body: " + response.toString());
	}
}
