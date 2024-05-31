package pl.pjatk.MovieService;

public enum MovieCategory {
    SciFi("SciFi"),
    Comedy("Comedy"),
    Horror("Horror"),
    Action("Action");

    private final String value;

    MovieCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}