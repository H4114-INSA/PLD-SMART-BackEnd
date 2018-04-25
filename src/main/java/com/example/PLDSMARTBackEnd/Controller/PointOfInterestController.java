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
import java.text.ParseException;
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

    @Autowired
    private TemporaryPointOfInterestRepository temporaryPoIRepository;

    @RequestMapping(path = "/add")
    public @ResponseBody
    String addNewPoint(@RequestParam String title,
                       @RequestParam String description,
                       @RequestParam String mailUser,
                       @RequestParam String longitude,
                       @RequestParam String latitude,
                       @RequestParam(required = false, defaultValue = "") String endDate){ // TODO : Ajouter coordo et categories

        //Find the Object user thanks to his email address
        User owner =  uR.findbyMail(mailUser);

        //Create the new point
        PointOfInterest p = new PointOfInterest();
        p.setTitle(title);
        p.setDescription(description);
        p.setOwner(owner);
        p.setCreateDate(new Date());
        p.setLatitude(Long.parseLong(latitude));
        p.setLongitude(Long.parseLong(longitude));

        if(!endDate.equals("")){
            TemporaryPointOfInterest tp = new TemporaryPointOfInterest(p);
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date = format.parse(endDate);
                tp.setEndDate(date);
                temporaryPoIRepository.save(tp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            //Save point
            pointRepository.save(p);
        }
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<PointOfInterest> getAllPoints() {
        // This returns a JSON or XML with the users
        return pointRepository.findAll();
    }
}
