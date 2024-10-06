
package org.utils.rest_assured;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;

public class ResponseHandler {

    public static boolean isNotNullOrEmpty(Object param) {
        return !(param == null || param.toString().isEmpty());
    }
}