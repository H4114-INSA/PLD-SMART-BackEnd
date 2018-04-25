package com.example.PLDSMARTBackEnd.Controller;


import com.example.PLDSMARTBackEnd.Model.PointOfInterest;
import com.example.PLDSMARTBackEnd.Model.TemporaryPointOfInterest;
import com.example.PLDSMARTBackEnd.Model.User;
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
import java.util.Date;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "UploadedFile";

    @RequestMapping(path = "/add")
    public @ResponseBody
    String addNewPoint(@RequestParam String title,
                       @RequestParam String description,
                       @RequestParam String mailUser,
                       @RequestParam long longitude,
                       @RequestParam long latitude,
                       @RequestParam MultipartFile file,
                       @RequestParam(required = false, defaultValue = "") String endDate) { // TODO : Ajouter categories

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

        //Load the picture
        if (file.isEmpty()) {
            return "Image manquante";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();

            Path path = Paths.get(UPLOADED_FOLDER + p.getIdPoint()+".png");
            Files.write(path, bytes);
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
        } catch (IOException e) {
            e.printStackTrace();
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
}
