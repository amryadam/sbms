//package com.amryadam.sbms.controller;
//
//
//import com.amryadam.sbms.model.locations.Country;
//import com.amryadam.sbms.services.locations.CountryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class CountryController {
//    @Autowired
//    private CountryService countryService;
//
//    @GetMapping("country")
//    public String getcountry(@ModelAttribute("country") Country country) {
//        return "country";
//    }
//
//    @GetMapping("countrys")
//    public @ResponseBody
//    List<Country>
//    getcountrys() {
//        List<Country> countrys = countryService.findAll();
//        return countrys;
//    }
//
//    @GetMapping("country-reports")
//    public @ResponseBody
//    List<Country>
//    getcountryReports() {
//        List<Country> countryReports = countryService.findAllReports();
//        return countryReports;
//    }
//
//    @PostMapping("country")
//    public String addcountry(@Valid @ModelAttribute ("country")
//                                  country country,
//                                  BindingResult result) {
//
//        if(result.hasErrors()) {
//            System.out.println("There were errors");
//            return "country";
//        } else {
//            countryService.addcountry(country);
//        }
//
//        System.out.println("country: " + country.getName());
//
//        return "redirect:country";
//    }
//
//    @PostMapping("country/update")
//    public @ResponseBody country updatecountry (@Valid @ModelAttribute("country")
//                                                          country country,
//                                                          BindingResult result) {
//        return countryService.addcountry(country);
//    }
//}
