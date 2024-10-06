package org.apis;

import io.restassured.response.Response;
import org.constatns.ApiConstant;
import org.utils.apihelpers.ApiUtilities;
import org.utils.rest_assured.GetApiHelper;

import java.util.Objects;

public class StatusGet {

    public static Response apiResponse;
    public Response callStatus(){
        String newstatus = ApiConstant.base_URL + "/status";
        apiResponse = Objects.requireNonNull(GetApiHelper.getResponseByHeaders(newstatus, ApiUtilities.headers()));
        return apiResponse;
    }
}
