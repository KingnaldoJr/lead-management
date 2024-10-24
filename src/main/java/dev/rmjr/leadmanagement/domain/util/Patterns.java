package dev.rmjr.leadmanagement.domain.util;

public class Patterns {
    private Patterns() {}

    public static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String NAME = "[\\p{L}\\s]*";
    public static final String ZIPCODE = "\\d{8}";
}
