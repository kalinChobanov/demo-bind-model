package bg.test.bindModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Kalin
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    private final PersonService personService;

    @Autowired
    public HomeController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "")
    String getHomePage(@ModelAttribute("person") PersonBindModel person) {

        return "home";
    }

    @GetMapping(value = "/sucsses")
    String getSucssesPage() {

        return "sucsses";
    }

    @PostMapping(value = "/create", consumes = MediaType.ALL_VALUE)
    public String getRequest(@ModelAttribute PersonBindModel person) {

        this.personService.create(person);
        return "redirect:sucsses";
    }

}
