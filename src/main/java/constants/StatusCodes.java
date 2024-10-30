package constants;

public enum StatusCodes {

	OK(200),
	CREATED(201),
	BAD_REQUEST(400),
	UNAUTHORIZED(401),
	FORBIDDEN(403),
	INTERNAL_SERVER_ERROR(500),
	NO_CONTENT(204);

	private final int code; // Keep this field private

	StatusCodes(int code) {
		this.code = code;
	}

	public int getCode() { // Provide a public method to access the code
		return code;
	}
}
