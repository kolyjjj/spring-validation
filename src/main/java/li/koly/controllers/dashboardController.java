package li.koly.controllers;

import li.koly.domain.User;
import li.koly.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class dashboardController {

    @Autowired
    private Validator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(new UserValidator());
    }

    @RequestMapping
    public ModelAndView onDashBoard(){
        System.out.println("This is the dashboard!");
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("firstName", "Koly");
        modelAndView.addObject("lastName", "Li");

        modelAndView.addObject("user", createUser());
        modelAndView.addObject("skills", createSkills());

        return modelAndView;
    }

    private List createSkills() {
        ArrayList<String> skills = new ArrayList<String>();
        skills.add("Programmer");
        skills.add("piper");
        skills.add("roader");
        return skills;
    }

    private User createUser() {
        User user = new User();
        ArrayList<String> sexOptions = new ArrayList<String>();
        sexOptions.add("male");
        sexOptions.add("female");
        user.setSexOptions(sexOptions);
        return user;
    }

    //the bindingResult must be the first one after the validated object
    @RequestMapping(value = "userSubmit")
    public ModelAndView onSubmit(@Validated User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("dashboard");
        if (bindingResult.hasErrors()){
            //getModel() will create a new modelMap so it should beyond the next two lines
            //when you want to bind the validation results to the model, you should manually
            //add it if you return is a modelAndView, if return is a string, do not need to
            modelAndView.addAllObjects(bindingResult.getModel());
            modelAndView.addObject("user", createUser());
            modelAndView.addObject("skills", createSkills());
            return modelAndView;
        }
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
