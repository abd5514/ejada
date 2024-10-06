package org.ApisTest;

import org.apis.StatusGet;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.error_handlers.StatusCodeValidator;

public class getResult {

    @Test(description = "validate status")
    public void Getstatus(){
        StatusGet statusGet = new StatusGet();
        statusGet.callStatus();
        StatusCodeValidator.validateStatusCode(statusGet.apiResponse,200);
    }
}
