package api.utilities;

public enum Routes {
    BASE_URL("http://jsonplaceholder.typicode.com"),
    USERS_URL("/users"),
    TODOS_URL("/todos");

    private final String url;

    Routes(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
