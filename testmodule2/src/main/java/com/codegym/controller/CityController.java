package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/citys")
    public ModelAndView listCity(){
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("city", cities);
        return modelAndView;
    }

    @GetMapping("/create-city")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCity(@ModelAttribute("city") City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Tao moi thanh cong !");
        return modelAndView;
    }

    @PostMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        City city = cityService.findById(id);
        if (city != null){
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-city")
    public ModelAndView updateCity(@ModelAttribute("city") City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Update thanh cong !");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        City city =  cityService.findById(id);
        if (city != null){
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", city);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute("city") City city){
        cityService.remove(city.getId());
        return "redirect:citys";
    }

}
