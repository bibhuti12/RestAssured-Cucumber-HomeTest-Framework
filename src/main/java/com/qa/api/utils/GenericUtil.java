package com.qa.api.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class GenericUtil {


    public synchronized static boolean isNull(String s) {
        return (s == null || s.trim().equals(""));
    }

    public synchronized static boolean isNotNull(String s) {
        return !isNull(s);
    }

    public synchronized static JsonObject convertStringToJsonObject(String jsonObject) {
        JsonObject convertedObject = new Gson().fromJson(jsonObject, JsonObject.class);
        return convertedObject;
    }


    /**
     * This function converts the Basic auth cred to base64 string
     *
     * @param sid
     * @param AuthToken
     * @return String
     */
    public synchronized static String getBase64EncodedCredential(String sid, String AuthToken) {
        String encoding = Base64.getEncoder().encodeToString((sid + ":" + AuthToken).getBytes());
        return "Basic " + encoding;


    }

    /**
     * This function converts the pojo object to Map
     *
     * @param fromValue
     * @return Map<String, Object>
     */
    public synchronized static Map<String, Object> convertPayloadToMap(Object fromValue) {

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map =
                (HashMap<String, Object>) mapper.convertValue(fromValue, new TypeReference<Map<String, Object>>() {
                });

        return map;
    }

    public static Map<String, String> getCommonHeader() {
        Map<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        return map;
    }

}
