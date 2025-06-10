package com.ramrewa.api.util;

import java.io.*;
import java.net.HttpURLConnection;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.net.URL;
import java.util.*;
import java.util.logging.Logger;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;

public class RestInvocationUtil {

    private final static Logger logger = Logger.getLogger("RestInvocationUtil.class");
    private final Map<String, String> mapWebServiceResponse = new HashMap<>();
    public Response response;
    public ArrayList<String> endPoints = new ArrayList<>();
    public ArrayList<String> requests = new ArrayList<>();
    public ArrayList<Response> responses = new ArrayList<>();

    public Map<String, String> invokePostWithHeaders(String endPoint, String requestPayload, List<Header> headerList) {
        response = postRestWithBodyAndHeaders(endPoint, requestPayload, headerList);
        String strResponse = response.getBody().asString();
        mapWebServiceResponse.put("response", strResponse);
        mapWebServiceResponse.put("statusCode", Integer.toString(response.getStatusCode()));
        mapWebServiceResponse.put("contentType", (response.contentType()));
        endPoints.add(endPoint);
        requests.add(requestPayload);
        responses.add(response);
        return mapWebServiceResponse;

    }

    public Map<String, String> invokeGetWithHeaders(String endPoint, Map<String, ?> queryParams, List<Header> headerList) {
        response = getRestWithDynamicHeaders(endPoint, queryParams, headerList);
        String strResponse = response.getBody().asString();
        mapWebServiceResponse.put("response", strResponse);
        mapWebServiceResponse.put("statusCode", Integer.toString(response.getStatusCode()));
        mapWebServiceResponse.put("contentType", (response.contentType()));
        endPoints.add(endPoint);
        requests.add(queryParams.toString());
        responses.add(response);
        return mapWebServiceResponse;
    }

    public Map<String, String> invokeWithAPIKey(String endPoint, String requestPayload, String apiKey) {
        response = postRestWithBodyAndAPIkey(endPoint, requestPayload, apiKey);
        String strResponse = response.getBody().asString();
        mapWebServiceResponse.put("response", strResponse);
        mapWebServiceResponse.put("statusCode", Integer.toString(response.getStatusCode()));
        mapWebServiceResponse.put("contentType", (response.contentType()));
        endPoints.add(endPoint);
        requests.add(requestPayload);
        responses.add(response);
        return mapWebServiceResponse;
    }

    private Response postRestWithBodyAndHeaders(String endPoint, String requestPayload, List<Header> dynamicHeaderList) {
        try {
            baseURI = getBaseURL(endPoint);
            Headers headers = new Headers(dynamicHeaderList);
            response = given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .headers(headers)
                    .body(requestPayload)
                    .when()
                    .post(endPoint)
                    .then()
                    .extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Endpoint::" + endPoint + "Request PayLoad::" + requestPayload + "Error::" + e.getMessage());
        }
        return response;
    }

    private Response getRestWithDynamicHeaders(String endPoint, Map<String, ?> params, List<Header> dynamicHeaderList) {
        try {
            baseURI = getBaseURL(endPoint);

            Headers headers = new Headers(dynamicHeaderList);
            response = given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .headers(headers)
                    .params(params)
                    .when()
                    .get(endPoint)
                    .then()
                    .extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            Assert.fail("Endpoint::" + endPoint + "Error::" + e.getMessage() + "Stack Trace::" + errors.toString());
        }
        return response;
    }

    private Response postRestWithBodyAndAPIkey(String endPoint, String requestPayload, String apiKey) {
        try {
            baseURI = getBaseURL(endPoint);
            List<Header> headerList = new LinkedList<>();
            headerList.add(new Header("api-key", apiKey));
            headerList.add(new Header("cache-control", "no-cache"));
            Headers headers = new Headers(headerList);

            response = given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .headers(headers)
                    .body(requestPayload)
                    .when()
                    .post(endPoint).then()
                    .extract().response();

        } catch (Exception e) {
            e.printStackTrace();
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            Assert.fail("Endpoint::" + endPoint + "Request PayLoad::" + requestPayload + "Error::" + e.getMessage() + "Stack Trace::" + errors.toString());
        }
        return response;
    }

    public static String sendGet(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        return getResponse(conn);
    }

    public static String sendPost(String urlStr, String jsonInput) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        return getResponse(conn);
    }

    public static String sendPut(String urlStr, String jsonInput) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        return getResponse(conn);
    }

    private static String getResponse(HttpURLConnection conn) throws IOException {
        int status = conn.getResponseCode();
        InputStream is = (status > 299) ? conn.getErrorStream() : conn.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }

        in.close();
        return response.toString();
    }

    private String getBaseURL(String endPoint) {
        return TestProperties.get("WEATHER_MAP_URL");

    }
}
