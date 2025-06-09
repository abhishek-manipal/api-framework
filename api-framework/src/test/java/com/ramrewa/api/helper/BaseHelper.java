package com.ramrewa.api.helper;
import java.util.logging.Logger;
import java.util.LinkedList;
import java.util.List;
import com.ramrewa.api.util.TestProperties;
import io.restassured.http.Header;

public class BaseHelper {
    private final static Logger logger = Logger.getLogger("BaseHelper.class");
    protected static List<Header> headerListCommon;

    public BaseHelper() {
        this.headerListCommon = new LinkedList<>();
        headerListCommon.add(new Header("x-api-key", TestProperties.get("x-api-key")));
        headerListCommon.add(new Header("Authorization", "Bearer " + sharedData.accessToken));
    }
}
