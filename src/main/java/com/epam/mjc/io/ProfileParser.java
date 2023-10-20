package com.epam.mjc.io;

public class ProfileParser {

    private static final String KEY_VALUE_DELIMITER = ":";
    private Profile profile;

    public void init() {
        profile = new Profile();
    }

    public Profile getProfile() {
        return profile;
    }

    public void addData(String s) {
        String[] data = s.trim().split(KEY_VALUE_DELIMITER);
        if (data.length == 1) {
            // found only key, skip this case
        } else if (data.length == 2) {
            // found key-value pair
            parse(data[0].trim(), data[1].trim());
        } else {
            System.err.println("Invalid profile format: " + s);
        }
    }

    private void parse(String key, String value) {
        ProfileKey prop = ProfileKey.getValue(key);
        switch (prop) {
            case NAME:
                profile.setName(value);
                break;
            case AGE:
                setAge(value);
                break;
            case EMAIL:
                profile.setEmail(value);
                break;
            case PHONE:
                setPhone(value);
                break;
            default:
                System.err.println("Cannot find profile key: " + key);
                break;
        }
    }

    private void setPhone(String value) {
        try {
            long phone = Long.parseLong(value);
            profile.setPhone(phone);
        } catch (NumberFormatException e) {
            System.err.println("Invalid Phone format: " + value);
            System.err.println(e);
        }
    }

    private void setAge(String value) {
        try {
            int age = Integer.parseInt(value);
            profile.setAge(age);
        } catch (NumberFormatException e) {
            System.err.println("Invalid Age format: " + value);
            System.err.println(e);
        }
    }
}
