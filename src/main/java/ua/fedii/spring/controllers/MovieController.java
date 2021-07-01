package ua.fedii.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.fedii.spring.dao.MovieDAO;
import ua.fedii.spring.models.Movie;

import javax.validation.Valid;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private MovieDAO movieDAO;

    @Autowired
    public MovieController(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("movies", movieDAO.index());
        return ("movies/index");
    }

    @GetMapping("/{idMovie}")
    public String show(@PathVariable("idMovie") int idMovie, Model model) {
        model.addAttribute("movie", movieDAO.show(idMovie));
        return "movies/show";
    }

    @GetMapping("/new")
    public String newMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "movies/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("movie") @Valid Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "movies/new";
        }

        movieDAO.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/{idMovie}/edit")
    public String edit(Model model, @PathVariable("idMovie") int idMovie) {
        model.addAttribute("movie", movieDAO.show(idMovie));
        return "movies/edit";
    }

    @PatchMapping("/{idMovie}")
    public String update(@ModelAttribute("movie") @Valid Movie movie, BindingResult bindingResult, @PathVariable("idMovie") int idMovie) {
        if (bindingResult.hasErrors()) {
            return "movies/edit";
        }

        movieDAO.update(idMovie, movie);
        return "redirect:/movies";
    }

    @DeleteMapping("/{idMovie}")
    public String delete(@PathVariable("idMovie") int idMovie) {
        movieDAO.delete(idMovie);
        return "redirect:/movies";
    }
}
