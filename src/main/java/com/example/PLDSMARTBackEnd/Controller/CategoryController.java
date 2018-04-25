package com.example.PLDSMARTBackEnd.Controller;

import com.example.PLDSMARTBackEnd.Model.Category;
import com.example.PLDSMARTBackEnd.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping(path = "/category")
@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewCategory (@RequestParam String categoryName) {
        if (categoryName == "") {
            return "Parametre incorrect.";
        }

        Category category = new Category();
        category.setCategoryName(categoryName);
        categoryRepository.save(category);
        return "Saved"; // TODO : Faire le message d'erreur en cas d'échec de l'ajout (boolean ?)
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Category> getAllCategories() {
        // This returns a JSON or XML with the categories
        return categoryRepository.findAll();
    }
}
