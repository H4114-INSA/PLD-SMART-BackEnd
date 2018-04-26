package com.example.PLDSMARTBackEnd.Controller;

import com.example.PLDSMARTBackEnd.Model.OriginalityEvaluation;
import com.example.PLDSMARTBackEnd.Model.PointOfInterest;
import com.example.PLDSMARTBackEnd.Model.User;
import com.example.PLDSMARTBackEnd.Repository.OriginalityEvaluationRepository;
import com.example.PLDSMARTBackEnd.Repository.PointOfInterestRepository;
import com.example.PLDSMARTBackEnd.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin
@RequestMapping(path = "/originality")
@Controller
public class OriginalityEvaluationController{

    @Autowired
    private OriginalityEvaluationRepository oeRepository;

    @Autowired
    private UserRepository uR;

    @Autowired
    private PointOfInterestRepository poiRepository;

    //  private int note;
    @RequestMapping(path = "/add")
    public @ResponseBody String addNewOriginalityEvaluation(@RequestParam int note, @RequestParam String mailUser, @RequestParam long idPoi){
        //Find the Object user thanks to his email address
        User owner =  uR.findbyMail(mailUser);
        PointOfInterest poi = (poiRepository.findbyId(idPoi));

        OriginalityEvaluation originalityEvaluation = new OriginalityEvaluation();
        originalityEvaluation.setEvaluationDate(new Date());
        originalityEvaluation.setNote(note);
        originalityEvaluation.setPoint(poi);
        originalityEvaluation.setUser(owner);

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<OriginalityEvaluation> getAllOriginalityEvaluation() {
        // This returns a JSON or XML with the users
        return oeRepository.findAll();
    }


}

