package api.utilities;

public enum Headers {
    CONTENT_TYPE_JSON("application/json"),
    CONTENT_TYPE_JSON_KEY("Content-Type");

    private final String headerKey;

    Headers(String headerKey) {
        this.headerKey = headerKey;
    }

    public String getHeaderKey() {
        return headerKey;
    }
}
