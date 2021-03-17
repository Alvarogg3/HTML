package info.jab.trivia;

import java.util.List;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/ex1")
    public List<String> getException() throws MyException {
        throw new MyException("Error 1");
    }

    @ExceptionHandler(MyException.class)
    public String handleError(MyException e) {
        return "Sorry";
    }

    @GetMapping("/ex2")
    public List<String> getException2() {
        throw new RuntimeException("Error 2");
    }

    @GetMapping("/ex3")
    public List<String> getException3() throws MyException2 {
        throw new MyException2("Error 3");
    }

}
