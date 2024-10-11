package api.utilities;

public enum Keys {
    USER_ID("userId"),
    LATITUDE("lat"),
    LONGITUDE("lng");

    private final String key;

    Keys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
