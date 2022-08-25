package com.singup_form.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

public class UserDto implements Validator {
    private Long id;
    @NotBlank
    @Pattern(regexp = "^([A-Z][a-z]+\\s?){1,2}$", message = "Name must contain at least 5 characters and maximum 45 characters")
    private String firstName;
    @NotBlank
    @Pattern(regexp = "^([A-Z][a-z]+\\s?){1,2}$", message = "Name must contain at least 5 characters and maximum 45 characters")
    private String lastName;
    @NotBlank
    @Pattern(regexp = "^(09|\\+84){1}[0-9]{9}$", message = "phone number wrong format")
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate age;
    @Email
    @NotBlank
    private String email;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, String phoneNumber, LocalDate age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDto(String firstName, String lastName, String phoneNumber, LocalDate age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        LocalDate now = LocalDate.now();
        if (userDto.age != null) {
            if (Period.between(userDto.age, now).getYears() < 18 || Period.between(userDto.age, now).getYears() > 100) {
                errors.rejectValue("age", "create.age", "age must be more than 18 and less than 100");
            }
        } else {
            errors.rejectValue("age", "create.age", "not null please");
        }
    }
}
