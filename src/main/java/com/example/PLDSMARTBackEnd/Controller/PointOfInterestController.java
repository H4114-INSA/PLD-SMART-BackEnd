package com.example.PLDSMARTBackEnd.Controller;


import com.example.PLDSMARTBackEnd.Model.*;
import com.example.PLDSMARTBackEnd.Repository.*;
import com.unboundid.util.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RequestMapping(path = "/poi")
@Controller
public class PointOfInterestController {
    @Autowired
    private PointOfInterestRepository pointRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TemporaryPointOfInterestRepository temporaryPoIRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ValidationRepository validationRepository;

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody String addNewPoint(@RequestBody PointOfInterest point){
        User user= userRepository.findByMail(point.getOwner().getEmail());
        point.setOwner(user);
        point.setCreateDate(new Date());
        List<Category> categoriesList = new ArrayList<>();
        for(Category c : point.getCategories()){
            categoriesList.add(categoryRepository.findByName(c.getCategoryName()));
        }
        point.setCategories(categoriesList);
        point.setStatus(Status.Validated); //TODO : changer à proposed
        pointRepository.save(point);
        return new JSONString("saved").toString();
    }

    @PostMapping(path = "/addTemporary", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody String addNewTemporaryPoint(@RequestBody TemporaryPointOfInterest point){
        User user= userRepository.findByMail(point.getOwner().getEmail());
        point.setOwner(user);
        point.setCreateDate(new Date());
        List<Category> categoriesList = new ArrayList<>();
        for(Category c : point.getCategories()){
            categoriesList.add(categoryRepository.findByName(c.getCategoryName()));
        }
        point.setCategories(categoriesList);
        point.setStatus(Status.Proposed);
        temporaryPoIRepository.save(point);
        return new JSONString("saved").toString();
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<PointOfInterest> getAllPoints() {
        // This returns a JSON or XML with the users
        return pointRepository.findAll();
    }

    @GetMapping(path = "/allValid")
    public @ResponseBody Iterable<PointOfInterest> getValidatedPoints(){
        return pointRepository.findAllValidatedPoint();
    }

   @GetMapping(path = "/getUserPoi")
    public @ResponseBody Iterable<PointOfInterest> getUserPoints(@RequestParam String mailUser){
       User user = userRepository.findByMail(mailUser);
       return pointRepository.findByUser(user);
   }

   @GetMapping(path = "/getUserValidatedPoi")
    public @ResponseBody Iterable<PointOfInterest> getUserValidatedPoints(@RequestParam String mailUser){
       User user = userRepository.findByMail(mailUser);
       return pointRepository.findValidatedPointByUser(user);
   }

    @GetMapping(path = "/getNumberUserPoi")
    public @ResponseBody int getNumberUserPoints(@RequestParam String mailUser){
        User user = userRepository.findByMail(mailUser);
        return (int) pointRepository.findByUser(user).spliterator().getExactSizeIfKnown();
    }

    @GetMapping(path = "/getNumberValidatedUserPoi")
    public @ResponseBody int getNumberValidatedUserPoint(@RequestParam String mailUser){
        User user = userRepository.findByMail(mailUser);
        return (int) pointRepository.findValidatedPointByUser(user).spliterator().getExactSizeIfKnown();
    }

    @GetMapping(path = "/getFilterPoints")
    public @ResponseBody List<PointOfInterest> getPointFiltered(@RequestParam String[] nameCategories){
        List<String> categories = new ArrayList<String>();
        for(int i =0 ; i<nameCategories.length ; i++){
            categories.add(nameCategories[i]);
        }
        List<PointOfInterest> finalPoints = new ArrayList<PointOfInterest>();
        for(PointOfInterest poi : pointRepository.findPointWithFilters(categories)){
            finalPoints.add(pointRepository.findById(poi.getIdPoint()));
        }
       return finalPoints; //TODO : Categories tronquees
    }

    @GetMapping(path = "/getPointToValidate")
    public @ResponseBody
    PointOfInterest getPointToValidate(@RequestParam String email){
       User user = userRepository.findByMail(email);
       if(user != null){
           Iterable<PointOfInterest> listPoints = pointRepository.findListPointToValidate(user);
           if(listPoints.spliterator().getExactSizeIfKnown() != 0){
               return listPoints.iterator().next();
           }else {
               throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
           }
       }
        throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/voteForPoi")
    public @ResponseBody
    void validatePoi(@RequestBody Validation validation){
       User user = userRepository.findByMail(validation.getUser().getEmail());
       validation.getUser().setIdUser(user.getIdUser());

       if(validation.isValidationNote()){
           validation.getPoint().setStatus(Status.Validated);
       }else {
           validation.getPoint().setStatus(Status.Deprecated);
       }

       pointRepository.save(validation.getPoint());
       validationRepository.save(validation);
    }

    @GetMapping(path = "/getSearchedPoints")
    public @ResponseBody List<PointOfInterest> getPointSearched(@RequestParam String name){
        List<PointOfInterest> finalPoints = new ArrayList<PointOfInterest>();
        name = "%" + name + "%";
        for(PointOfInterest poi : pointRepository.findSearchedPoints(name)){
            finalPoints.add(poi);
        }
        return finalPoints;
    }
}
