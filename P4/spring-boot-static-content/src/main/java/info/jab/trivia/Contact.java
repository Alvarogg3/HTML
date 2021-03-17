package info.jab.trivia;

import java.util.Objects;

public class Contact {
    private String name;
    private String email;
    private String telephone;
    private String subject;
    private String message;

    public Contact(String name, String email, String telephone, String subject, String message) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.subject = subject;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(email, contact.email) && Objects.equals(telephone, contact.telephone) && Objects.equals(subject, contact.subject) && Objects.equals(message, contact.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, telephone, subject, message);
    }
}
