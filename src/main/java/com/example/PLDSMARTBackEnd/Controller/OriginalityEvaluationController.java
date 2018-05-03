package com.example.PLDSMARTBackEnd.Controller;

import com.example.PLDSMARTBackEnd.Model.OriginalityEvaluation;
import com.example.PLDSMARTBackEnd.Model.PointOfInterest;
import com.example.PLDSMARTBackEnd.Model.User;
import com.example.PLDSMARTBackEnd.Repository.OriginalityEvaluationRepository;
import com.example.PLDSMARTBackEnd.Repository.PointOfInterestRepository;
import com.example.PLDSMARTBackEnd.Repository.UserRepository;
import com.unboundid.util.json.JSONString;
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

    @RequestMapping(path = "/add")
    public @ResponseBody String addNewOriginalityEvaluation(@RequestParam int note,
                                                            @RequestParam String mailUser,
                                                            @RequestParam int idPoi){
        //Vérif si l'user a déjà évalué ce point
        if(checkExisting(mailUser,idPoi) == true){
            OriginalityEvaluation oe = oeRepository.check(uR.findByMail(mailUser),poiRepository.findById(idPoi));
            oe.setNote(note);
            oeRepository.save(oe);
            return new JSONString("saved").toString();
        }
        //Find the Object user thanks to his email address
        User owner =  uR.findByMail(mailUser);
        PointOfInterest poi = (poiRepository.findById(idPoi));

        OriginalityEvaluation originalityEvaluation = new OriginalityEvaluation();
        originalityEvaluation.setEvaluationDate(new Date());
        originalityEvaluation.setNote(note);
        originalityEvaluation.setPoint(poi);
        originalityEvaluation.setUser(owner);

        oeRepository.save(originalityEvaluation);
        return new JSONString("saved").toString();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<OriginalityEvaluation> getAllOriginalityEvaluation() {
        // This returns a JSON or XML with the users
        return oeRepository.findAll();
    }

    @GetMapping(path="/check")
    public @ResponseBody boolean checkExisting(@RequestParam String mailUser,
                                               @RequestParam int idPoi) {
        User owner =  uR.findByMail(mailUser);
        OriginalityEvaluation oE = oeRepository.check(owner, poiRepository.findById(idPoi));
        if(oE == null){
            return false;
        }
        return true;
    }

}

