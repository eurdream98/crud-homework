package com.ohgiraffers.crud.hospital.controller;

import com.ohgiraffers.crud.hospital.model.dto.DepartmentDTO;
import com.ohgiraffers.crud.hospital.model.dto.PatientDTO;
import com.ohgiraffers.crud.hospital.model.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final MessageSource messageSource;
    private final PatientService patientService;
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    public PatientController(PatientService patientService, MessageSource messageSource) {
        this.messageSource = messageSource;
        this.patientService = patientService;
    }

    @GetMapping("/selectAll")
    public String selectAllPatient(Model model){
        List<PatientDTO> patientList = patientService.selectAllPatient();
        model.addAttribute("list",patientList);
        return "result/list";
    }
    @GetMapping("/insert")
    public String insertPatient0(){
        return "/crud/insert";
    }

    @GetMapping("/department")
    public @ResponseBody List<DepartmentDTO> bringDepartment(){
        return patientService.bringDepartment();
    }

    @PostMapping("/insert")
    public String insertPatient(@ModelAttribute PatientDTO patientDTO, RedirectAttributes rttr, Locale locale){
        System.out.println(patientDTO);
        patientService.insertPatient(patientDTO);

        logger.info("patientDTO : {}",patientDTO);
        logger.debug("patientDTO : {}",patientDTO);
        logger.trace("patientDTO : {}",patientDTO);
        logger.warn("patientDTO : {}",patientDTO);
        logger.error("patientDTO : {}",patientDTO);
        rttr.addFlashAttribute("message",messageSource.getMessage("success",null,locale));
        return "redirect:/patient/selectAll";
    }
    @GetMapping("/loginResult")
    public void loginResult(){
    }
    @PostMapping("/login")
    public String login(RedirectAttributes rttr,@RequestParam("name") String name){
        System.out.println(name);
        rttr.addFlashAttribute("name",name);
        return "redirect:/patient/loginResult";
    }
    @GetMapping("/name")
    public @ResponseBody List<PatientDTO> bringPatient(){
        return patientService.selectAllPatient();
    }

    @PostMapping("/selectOne")
    public ModelAndView selectOne(ModelAndView mv,int patientCode){
        PatientDTO patient = patientService.selectOne(patientCode);
        mv.addObject("patient",patient);
        mv.setViewName("/result/one");
        return mv;
    }

    @PostMapping("/updateOne")
    public String updateOne(PatientDTO patientDTO,RedirectAttributes rttr,Locale locale){
        patientService.updateOne(patientDTO);
        String message = messageSource.getMessage("update",null,locale);
        rttr.addFlashAttribute("message",message);
        System.out.println(patientDTO);
        return"redirect:/patient/selectAll";
    }

    @PostMapping("/deleteOne")
    public String deleteOne(int patientCode,RedirectAttributes rttr,Locale locale){
        patientService.deleteOne(patientCode);
        rttr.addFlashAttribute("message",messageSource.getMessage("delete",null,locale));
        return "redirect:/patient/selectAll";
    }
}
