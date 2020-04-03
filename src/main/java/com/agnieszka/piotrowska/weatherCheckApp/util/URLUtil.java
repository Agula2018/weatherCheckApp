package com.agnieszka.piotrowska.weatherCheckApp.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringJoiner;

public class URLUtil {

    private URLUtil() {
    }

    public static <T> String getURLParams(T requestObject, boolean isQueryParam) {
        if (requestObject != null) {
            try {

                StringJoiner paramsJoiner = new StringJoiner(isQueryParam ? "&" : "/");
                for (Field singleField : requestObject.getClass().getDeclaredFields()) {
                    String fieldName = singleField.getName();
                    paramsJoiner.add(
                            isQueryParam ?
                                    getKeyValuePair(fieldName, getFieldValue(requestObject, fieldName)) : getFieldValue(requestObject, fieldName)
                    );
                }
                return isQueryParam ? "?" : "" + paramsJoiner.toString();
            } catch (IllegalAccessException | InvocationTargetException e) {
                //EXCEPTION
                return "";
            }

        } else return "";
    }

    private static String getKeyValuePair(String key, String value) {
        return key + "=" + value;
    }

    private static <T> String getFieldValue(T object, String fieldName) throws IllegalAccessException, InvocationTargetException {
        for (Method method : object.getClass().getMethods()) {
            if (method.getName().equals("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1))) {
                return method.invoke(object, null).toString();
            }
        }
        return "";
    }
}
