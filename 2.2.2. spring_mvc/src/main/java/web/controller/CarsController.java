package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import web.Service.CarService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(@RequestParam(required = false) Integer count, Model model) {
        if (count == null || count > 5) {
            count = 5;
        }
        List<Car> collect = carService.getCars().stream().limit(count).collect(Collectors.toList());
        model.addAttribute("listCars", collect);
        return "cars";
    }
}
