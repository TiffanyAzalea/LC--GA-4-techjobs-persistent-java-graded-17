package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;



    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "skills/add";
        }

        skillRepository.save(newSkill);

        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {

        Optional<Skill> optEmployer = skillRepository.findById(skillId);
        if (optEmployer.isPresent()) {
            Skill skill = (Skill) optEmployer.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }

    }

    //TH

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Skill> skills = skillRepository.findAll();
        model.addAttribute("skills", skills);
        return "skills/index";
    }

}
