package org.api_objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class PostObject {
    @JsonProperty("next")
    private JsonNode next;
    @JsonProperty("request")
    private JsonNode request;

    public JsonNode getNext()
    {
        return next;
    }

    public JsonNode getRequest()
    {
        return request;
    }
}
