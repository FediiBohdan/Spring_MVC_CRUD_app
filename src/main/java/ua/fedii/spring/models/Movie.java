package ua.fedii.spring.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Movie {
    private int idMovie;

    @NotEmpty(message = "Name is required!")
    @Size(max = 30, message = "Name should be less than 30 characters!")
    private String name;

    @NotEmpty(message = "Genre is required!")
    @Size(min = 3, max = 30, message = "Genre should be between 3 and 30 characters!")
    private String genre;

    @NotEmpty(message = "Director is required!")
    @Size(max = 40, message = "Director should be less than 40 characters!")
    private String director;

    @Min(value = 1880, message = "Release year should be greater than 1880!")
    private int releaseYear;

    public Movie() {}

    public Movie(int idMovie, String name, String genre, String director, int releaseYear) {
        this.idMovie = idMovie;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
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
