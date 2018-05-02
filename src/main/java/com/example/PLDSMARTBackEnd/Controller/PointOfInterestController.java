package com.example.PLDSMARTBackEnd.Controller;


import com.example.PLDSMARTBackEnd.Model.PointOfInterest;
import com.example.PLDSMARTBackEnd.Model.User;
import com.example.PLDSMARTBackEnd.Repository.CategoryRepository;
import com.example.PLDSMARTBackEnd.Repository.PointOfInterestRepository;
import com.example.PLDSMARTBackEnd.Repository.TemporaryPointOfInterestRepository;
import com.example.PLDSMARTBackEnd.Repository.UserRepository;
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

    //Save the uploaded file to this folder
    //private static String UPLOADED_FOLDER = "UploadedFile";

  /* @PostMapping(path = "/add")
    public @ResponseBody
    String addNewPoint(@RequestParam String title,
                       @RequestParam String description,
                       @RequestParam String mailUser,
                       @RequestParam long longitude,
                       @RequestParam long latitude,
                       @RequestParam String[] categories,
                       @RequestParam(required = false) MultipartFile file,
                       @RequestParam(required = false, defaultValue = "") String endDate) {

        //Find the Object user thanks to his email address
        User owner = userRepository.findByMail(mailUser);

        //Create the new point
        PointOfInterest p = new PointOfInterest();
        p.setTitle(title);
        p.setDescription(description);
        p.setOwner(owner);
        p.setCreateDate(new Date());
        p.setLatitude(latitude);
        p.setLongitude(longitude);
        p.setStatus(Status.Validated);

        //Put all categories in a list
        List<Category> categoryList = new ArrayList();
        for(int i = 0 ; i<categories.length ; i++){
            Category tmp = categoryRepository.findById(Integer.parseInt(categories[i]));
            System.out.println(tmp.getCategoryName());
            categoryList.add(tmp);
        }
        p.setCategories(categoryList);

        try {
            // TODO : faire le stockage des path dans l'objet poi
            if (!endDate.equals("")) {
                TemporaryPointOfInterest tp = new TemporaryPointOfInterest(p);
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(endDate);
                tp.setEndDate(date);
                temporaryPoIRepository.save(tp);
            } else {
                //Save point
                pointRepository.save(p);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Saved";
    }*/

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody String addNewPoint(@RequestBody PointOfInterest point){
        User user= userRepository.findByMail(point.getOwner().getEmail());
        point.setOwner(user);
        point.setCreateDate(new Date());

        pointRepository.save(point);
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

   /* @GetMapping(path = "/filterPoint")
    public @ResponseBody Iterable<PointOfInterest> getPointsWithfilters(@RequestParam String name,
                                                                        @RequestParam String[] categories){
        return;
    }*/

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
    PointOfInterest getPointToValidate(@RequestParam int id){
       User user = userRepository.findById(id);
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
