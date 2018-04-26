package com.example.PLDSMARTBackEnd.Controller;

import com.example.PLDSMARTBackEnd.Model.PointOfInterest;
import com.example.PLDSMARTBackEnd.Model.Report;
import com.example.PLDSMARTBackEnd.Model.User;
import com.example.PLDSMARTBackEnd.Repository.PointOfInterestRepository;
import com.example.PLDSMARTBackEnd.Repository.ReportRepository;
import com.example.PLDSMARTBackEnd.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping(path = "/report")
@Controller
public class ReportController {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PointOfInterestRepository pointOfInterestRepository;

    @GetMapping(path = "/add")
    public @ResponseBody
    String addReport(@RequestParam String email,
                     @RequestParam int idPoint,
                     @RequestParam String cause){
        User user = userRepository.findByMail(email);
        PointOfInterest poi = pointOfInterestRepository.findById(idPoint);
        // TODO : faire la cause

        Report report = new Report();
        report.setPoint(poi);
        report.setUser(user);
        
        reportRepository.save(report);
        return "";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Report> getAllReports() {
        // This returns a JSON or XML with the users
        return reportRepository.findAll();
    }
}
