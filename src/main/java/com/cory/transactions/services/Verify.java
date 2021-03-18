package com.cory.transactions.services;

/**
 * Provides verification helper methods to ensure non-null and non-empty values when needed
 */
public class Verify {

    /**
     * Verifies that the given String value is not null nor empty
     * @param str String to verify
     * @param name String name of item to verify
     * @throws Exception when the given String value is either null or empty
     */
    public static void NotEmpty(String str, String name) throws Exception {

        if (str == null) {
            throw new Exception(String.format("%s should not be null.", name));
        }

        if (str.trim().isEmpty()) {
            throw new Exception(String.format("%s should not be empty.", name));
        }
    }
}
