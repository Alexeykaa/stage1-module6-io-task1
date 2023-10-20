package com.epam.mjc.io;

public enum ProfileKey {
    NAME("Name"), AGE("Age"), EMAIL("Email"), PHONE("Phone");

    private final String key;

    ProfileKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static ProfileKey getValue(String key) {
        ProfileKey result = null;
        for (ProfileKey value : ProfileKey.values()) {
            if (value.getKey().equalsIgnoreCase(key)) {
                result = value;
                break;
            }
        }
        return result;
    }
}
