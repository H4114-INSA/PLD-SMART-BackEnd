package com.example.PLDSMARTBackEnd.Controller;


import com.example.PLDSMARTBackEnd.Model.PointOfInterest;
import com.example.PLDSMARTBackEnd.Model.TemporaryPointOfInterest;
import com.example.PLDSMARTBackEnd.Model.User;
import com.example.PLDSMARTBackEnd.Repository.PointOfInterestRepository;
import com.example.PLDSMARTBackEnd.Repository.TemporaryPointOfInterestRepository;
import com.example.PLDSMARTBackEnd.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin
@RequestMapping(path = "/poi")
@Controller
public class PointOfInterestController {
    @Autowired
    private PointOfInterestRepository pointRepository;

    @Autowired
    private UserRepository uR;

    @RequestMapping(path = "/add")
    public @ResponseBody
    String addNewPoint(@RequestParam String title,
                       @RequestParam String description,
                       @RequestParam String idUser){ // TODO : Ajouter coordo et categories

        //Find the Object user thanks to his id
        User owner =  uR.findById(Long.parseLong(idUser)).get();

        //Conversion date
        DateFormat fromat = new SimpleDateFormat("dd-MM-yyyy");
        Date creationdate;
        PointOfInterest p = new PointOfInterest();
        p.setTitle(title);
        p.setDescription(description);
        p.setOwner(owner);
        //p.setCreateDate();
        pointRepository.save(p);
        return "Saved";
    }



    @GetMapping(path="/all")
    public @ResponseBody Iterable<PointOfInterest> getAllPoints() {
        // This returns a JSON or XML with the users
        return pointRepository.findAll();
    }
}
