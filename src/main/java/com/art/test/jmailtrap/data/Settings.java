package com.art.test.jmailtrap.data;

public class Settings {

    private static final String SENDING_ENDPOINT= "https://send.api.mailtrap.io";

    private static final String SENDING_SUFFIX = "/api/send";

    public static final String SENDING_URL = SENDING_ENDPOINT + SENDING_SUFFIX;

    private final static String TOKEN = "Token";


    public static String getTOKEN() {
        return TOKEN;
    }
}
