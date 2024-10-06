package org.constatns;

public class ApiConstant {

    public static final String base_URL;
    public static final String ACCEPT_LANGUAGE;
    public static final int SUCCESS;

    public static final int ERROR_422;
    public static final int ERROR_401;
    public static final int ERROR_404;
   public static final int CREATED;






    static {

        base_URL = "https://simple-books-api.glitch.me";
        ACCEPT_LANGUAGE = "en-gb";
        SUCCESS = 200;
        ERROR_422 = 422;
        ERROR_401 = 401;
        ERROR_404 = 404;
        CREATED = 201;

    }
}
