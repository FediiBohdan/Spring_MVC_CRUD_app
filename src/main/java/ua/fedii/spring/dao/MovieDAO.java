package ua.fedii.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.fedii.spring.models.Movie;

import java.util.List;

@Component
public class MovieDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movie> index() {
        return jdbcTemplate.query("SELECT * FROM movie", new BeanPropertyRowMapper<Movie>(Movie.class));
    }

    public Movie show(int idMovie) {
        return jdbcTemplate.query("SELECT * FROM movie WHERE id_movie = ?", new Object[]{idMovie}, new BeanPropertyRowMapper<>(Movie.class))
                .stream().findAny().orElse(null);
    }

    public void save(Movie movie) {
        jdbcTemplate.update("INSERT INTO movie (name, genre, director, release_year) VALUES (?, ?, ?, ?)", movie.getName(), movie.getGenre(),
                movie.getDirector(), movie.getReleaseYear());
    }

    public void update(int idMovie, Movie updatedMovie) {
        jdbcTemplate.update("UPDATE movie SET name = ?, genre = ?, director = ?, release_year = ? WHERE id_movie = ?", updatedMovie.getName(),
                updatedMovie.getGenre(), updatedMovie.getDirector(), updatedMovie.getReleaseYear(), updatedMovie.getIdMovie());
    }

    public void delete(int idMovie) {
        jdbcTemplate.update("DELETE FROM movie WHERE id_movie = ?", idMovie);
    }
}
