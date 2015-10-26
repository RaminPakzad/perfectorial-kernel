package com.perfectorial;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mohsen Ebrahimi
 */
public class JsonUtil {
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
