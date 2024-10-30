package utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.restassured.response.Response;

public class ApiLogger {
    private static final Logger logger = LoggerFactory.getLogger(ApiLogger.class);

    public static void logRequest(String method, String uri, Map<String, String> headers, Object body) {
        logger.info("Request Method: {}", method);
        logger.info("Request URI: {}", uri);
        logger.info("Request Headers: {}", headers);
        if (body != null) {
            logger.info("Request Body: {}", body);
        }
    }

    public static void logResponse(Response response) {
        logger.info("Response Status Code: {}", response.getStatusCode());
        logger.info("Response Body: {}", response.getBody().asString());
        logger.info("Response Headers: {}", response.getHeaders());
    }
}
