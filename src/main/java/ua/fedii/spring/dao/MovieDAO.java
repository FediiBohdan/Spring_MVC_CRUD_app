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

}
