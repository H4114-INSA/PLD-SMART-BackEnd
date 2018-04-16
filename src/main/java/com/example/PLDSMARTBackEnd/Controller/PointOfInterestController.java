package com.example.PLDSMARTBackEnd.Controller;


import com.example.PLDSMARTBackEnd.Model.PointOfInterest;
import com.example.PLDSMARTBackEnd.Repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping(path = "/poi")
@Controller
public class PointOfInterestController {
    @Autowired

    private PointOfInterestRepository pointRepository;

    @RequestMapping(path = "/add")
    public @ResponseBody
    String addNewPoint(@RequestParam String title){
        PointOfInterest p = new PointOfInterest();
        p.setTitle(title);
        pointRepository.save(p);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<PointOfInterest> getAllPoints() {
        // This returns a JSON or XML with the users
        return pointRepository.findAll();
    }
}
