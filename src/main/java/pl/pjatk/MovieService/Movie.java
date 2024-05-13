package pl.pjatk.MovieService;


public class Movie {

    private Integer id;

    private String name;
    private MovieCategory movieCategory;

    private Integer yearProduction;

    public Movie(Integer id, String name, MovieCategory movieCategory, Integer yearProduction) {
        this.id = id;
        this.name = name;
        this.movieCategory = movieCategory;
        this.yearProduction = yearProduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }

    public Integer getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(Integer yearProduction) {
        this.yearProduction = yearProduction;
    }
}
