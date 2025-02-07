/*
 *
 * *****************************************************************************
 *  * Copyright ©2020 Mawdoo3. All rights reserved
 *  *  —————————————————————————————————
 *  *  NOTICE: All information contained herein is a property of Mawdoo3.
 *  *****************************************************************************
 *
 *
 */

package org.utils.rest_assured;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;

public class PostApiHelper {

    public static Response post(String apiUrl, HashMap<String, String> headers, String requestBody)  {

        if (ResponseHandler.isNotNullOrEmpty(apiUrl)) {
            return RestAssured.given().that()
                    .contentType("application/json")
                    .headers(headers)
                    .body(requestBody).when().post(apiUrl).thenReturn();
        } else {
            try {
                throw new InvalidResponseException(ApiConstants.INVALID_EMPTY_URL_ERROR);
            } catch (InvalidResponseException e) {
                e.printStackTrace();
            }
        }
    return null;
    }
    
}
