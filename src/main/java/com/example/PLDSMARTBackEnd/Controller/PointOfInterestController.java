package com.example.PLDSMARTBackEnd.Controller;


import com.example.PLDSMARTBackEnd.Model.*;
import com.example.PLDSMARTBackEnd.Repository.CategoryRepository;
import com.example.PLDSMARTBackEnd.Repository.PointOfInterestRepository;
import com.example.PLDSMARTBackEnd.Repository.TemporaryPointOfInterestRepository;
import com.example.PLDSMARTBackEnd.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    @Autowired
    private CategoryRepository categoryRepository;

    //Save the uploaded file to this folder
    //private static String UPLOADED_FOLDER = "UploadedFile";

 //   @RequestMapping(value=("/uploadpsd"),headers=("content-type=multipart/*"),method=RequestMethod.POST)
    @RequestMapping(path = "/add")//,headers=("content-type=multipart/*"))
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
        User owner = uR.findByMail(mailUser);

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

        //Load the picture
        /*if (file.isEmpty()) {
            return "Image manquante";
        }*/

        try {
            // Get the file and save it somewhere
           // p.setPicture(file.getBytes());

           /* Path path = Paths.get(UPLOADED_FOLDER + p.getIdPoint()+".png");
            Files.write(path, bytes);*/
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
        /*} catch (IOException e) {
            e.printStackTrace();*/
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Saved";
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
}
