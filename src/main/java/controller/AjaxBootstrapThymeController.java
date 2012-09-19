package controller;

import model.ErrorMessage;
import model.User;
import model.ValidationResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AjaxBootstrapThymeController {

    @RequestMapping(value="/userAjaxBootstrapThyme",method=RequestMethod.GET)
    public String showFormBootstrap(Model model){
        model.addAttribute("user", new User());
        return "pages/03-userForm";
    }

    @RequestMapping(value="/userAjaxBootstrapThyme",method=RequestMethod.POST)
    public String processFormBootstrap(@ModelAttribute(value="user") @Valid User user, BindingResult result ){
        if(result.hasErrors()) {
            return "pages/03-userForm";
        }
        else {
            return "success";
        }
    }

    @RequestMapping(value="/userAjaxBootstrapThyme.json",method=RequestMethod.POST)
    public @ResponseBody ValidationResponse processFormAjaxJson(Model model, @ModelAttribute(value="user") @Valid User user, BindingResult result ){
        ValidationResponse res = new ValidationResponse();
        if(!result.hasErrors()){
            res.setStatus("SUCCESS");
        }else{
            res.setStatus("FAIL");
            List<FieldError> allErrors = result.getFieldErrors();
            List<ErrorMessage> errorMesages = new ArrayList<ErrorMessage>();
            for (FieldError objectError : allErrors) {
                errorMesages.add(new ErrorMessage(objectError.getField(), objectError.getField() + "  " + objectError.getDefaultMessage()));
            }
            res.setErrorMessageList(errorMesages);
        }

        return res;
    }
}
