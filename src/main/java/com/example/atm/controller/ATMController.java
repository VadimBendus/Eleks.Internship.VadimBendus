package com.example.atm.controller;

import com.example.atm.domain.ATM;
import com.example.atm.repository.ATMRepository;
import com.example.atm.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.ModelMap;
import sun.util.calendar.BaseCalendar;

import java.util.Date;

import java.util.List;

@RestController
public class ATMController {

    @Autowired
    ATMService service;


    @RequestMapping("/")
    public ModelAndView doHome(){
        ModelAndView mv = new ModelAndView("/jsp/index.jsp");
        mv.addObject("lists",service.getAllKupuru());
        return mv;
    }

    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam(value = "id",required = false) int id,@RequestParam("kname") int kname,@RequestParam(value = "dated",required = false) String dated,@RequestParam("description") String description,@RequestParam("status") String status){
        ModelAndView mv = new ModelAndView("redirect:/");
        ATM atm = new ATM();
        atm.setId(id);
        atm.setKname(kname);
        atm.setDescription(description);
        atm.setDated(dated);
        atm.setStatus(status);
service.insertKupuru(atm);
        return mv;
    }

    @RequestMapping(value ="/search/", method = RequestMethod.GET)
    public ModelAndView doSearch(@RequestParam(value = "kupura") int kname ){
        ModelAndView mv = new ModelAndView("/jsp/search.jsp");
        mv.addObject("account",service.getAccount());
        mv.addObject("count",service.getCount(kname));
        mv.addObject("lists",service.getKupuruByKname(kname));
        return mv;
    }

    @RequestMapping(value ="/search", method = RequestMethod.GET)
    public ModelAndView doView(){
        ModelAndView mv = new ModelAndView("/jsp/search.jsp");
mv.addObject("account",service.getAccount());
        return mv;
    }

    @RequestMapping(value ="/deposit", method = RequestMethod.GET)
    public ModelAndView doDepositView(){
        ModelAndView mv = new ModelAndView("/jsp/deposit.jsp");
        mv.addObject("lists",service.getKupuruWithCount());
        return mv;
    }


    @RequestMapping(value ="/deposit/", method = RequestMethod.GET)
    public ModelAndView doDeposit(@RequestParam("kname") String kname){
        ModelAndView mv = new ModelAndView("/jsp/deposit.jsp");
        mv.addObject("kname",service.deleteKupuruByKname(kname));
        mv.addObject("lists",service.getKupuruWithCount());
        return mv;
    }
}
