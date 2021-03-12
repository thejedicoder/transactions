package com.cory.transactions.Services;

public class Verify {

    static void NotEmpty(String str, String name) throws Exception {
        if (str == null) {
            throw new Exception(String.format("%s should not be null.", name));
        }

        if (str.trim().isEmpty()) {
            throw new Exception(String.format("%s should not be empty.", name));
        }
    }
}
