package com.example.PLDSMARTBackEnd.Controller;

import com.example.PLDSMARTBackEnd.Model.TemporaryPointOfInterest;
import com.example.PLDSMARTBackEnd.Repository.TemporaryPointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping(path = "/temporarypoi")
@Controller
public class TemporaryPointOfInterestController {

    @Autowired
    private TemporaryPointOfInterestRepository temporaryPointRepository;

    @RequestMapping(path = "/add")
    public @ResponseBody
    String addNewTemporaryPoint(@RequestParam String title){
        TemporaryPointOfInterest p = new TemporaryPointOfInterest();
        p.setTitle(title);
        temporaryPointRepository.save(p);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<TemporaryPointOfInterest> getAllPoints() {
        // This returns a JSON or XML with the users
        return temporaryPointRepository.findAll();
    }

}
