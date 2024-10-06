package org.utils.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.api_objects.PostObject;

public class PostMapper {

    public static PostObject readObjectPostFares(Response response){
        String json = response.getBody().prettyPrint();
        ObjectMapper mapper = new ObjectMapper();
        PostObject postFaresCalnderObject;
        try {
            postFaresCalnderObject = mapper.readValue(json, PostObject.class);
            return postFaresCalnderObject;
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
