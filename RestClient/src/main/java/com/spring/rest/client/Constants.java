package com.spring.rest.client;

public class Constants {
    public static class Errors {
        public static String ADDING_ERROR_PATTERN = "Adding error: %s";
        public static String GETTING_ERROR_PATTERN = "Error while getting %s with id %d";
        public static String UPDATING_ERROR_PATTERN = "Error while updating %s: %s";
        public static String REMOVING_ERROR_PATTERN = "Error while removing %s with id %d";
    }

    public static class SuccessfulOperations {
        public static String SUCCESS_ADDING_PATTERN = "Added: %s";
        public static String SUCCESS_UPDATING_PATTERN = "Updated %s: %s";
        public static String SUCCESS_REMOVING_PATTERN = "Removed %s with id %d";
    }
}
