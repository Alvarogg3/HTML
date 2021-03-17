package info.jab.trivia;


import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ContactValidation {

    @NotNull
    private String name;

    @Pattern(message="Valid email address please"
            , regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @Pattern(message="Only spanish valid phone numbers accepted"
            , regexp="6[0-9]{8}")
    private String telephone;

    @NotNull
    private String subject;

    @NotNull
    private String message;
}
