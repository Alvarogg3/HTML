package info.jab.trivia;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
public class MainController {

    @Autowired
    private QuestionService questionService ;

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("{\"result\" : \"OK\"}", HttpStatus.OK);
    }

    @PostMapping(
            path="/login",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(User loginParam) {
        return "Ok";
    }

    @PostMapping(
            path="/login2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login2(
            @Valid @RequestBody UserValidation loginParam,
            @org.jetbrains.annotations.NotNull BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        }

        if ((loginParam.getEmail().equals("comillas@gmail.com")) &&
            (loginParam.getPassword().equals("Comillas1"))) {
            return new ResponseEntity<>("{\"result\" : \"OK\"}", HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"result\" : \"KO\"}", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(
            path="/contact",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String contact(Contact contactParam) {
        return "Ok";
    }

    @PostMapping(
        path="/contactVal",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> contactValidation(
            @Valid @RequestBody ContactValidation contactParam,
            @org.jetbrains.annotations.NotNull BindingResult bindingResult2) {
        if (bindingResult2.hasErrors()) {
            return new ResponseEntity<>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        }
        if ((contactParam.getName().isEmpty()) ||
                (contactParam.getEmail().isEmpty()) ||
                (contactParam.getTelephone().isEmpty()) ||
                (contactParam.getSubject().isEmpty()) ||
                (contactParam.getMessage().isEmpty())) {
            return new ResponseEntity<>("{\"result\" : \"KO\"}", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("{\"result\" : \"OK\"}", HttpStatus.OK);
    }

    @GetMapping("/home/questions")
    public List<String> getQuestions() { return questionService.getQuestions(); }

}
