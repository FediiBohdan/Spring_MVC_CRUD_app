package ua.fedii.spring.models;

public class Movie {
    private int id;
    private String name;
    private String genre;
    private String director;
    private int releaseYear;

    public Movie() {}

    public Movie(int id, String name, String genre, String director, int releaseYear) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
