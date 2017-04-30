package com.teamscreenbiz.companyEmployee;

import com.teamscreenbiz.core.BaseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Entity;

@Entity
public class CompanyEmployee extends BaseEntity {
  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
  public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
      Pattern.compile(
          "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
          Pattern.CASE_INSENSITIVE);

  private String name;
  private Long phoneNumber;
  private String email;
  private String address;
  private Date date;
  private String username;
  private String password;
  private String pass_Hint;
  private char sex;
  //TODO max: add pic class file
  //TODO max: add pdf class file
  //TODO max: add ID_PROOF pdf file
  private String[] roles;

  public CompanyEmployee(String name, Long phoneNumber, String email, String address,
                         Date date, String username, String password, String pass_Hint, char sex,
                         String[] roles) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
    this.date = date;
    this.username = username;
    setPassword(password);
    this.pass_Hint = pass_Hint;
    this.sex = sex;
    this.roles = roles;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    //TODO max: set message for successfull email update
    if (validate(email))
      this.email = email;
  }


  public static boolean validate(String emailStr) {
    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
    return matcher.find();
  }
  // TODO max: Code repetition

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = PASSWORD_ENCODER.encode(password);
  }

  public String getPass_Hint() {
    return pass_Hint;
  }

  public void setPass_Hint(String pass_Hint) {
    this.pass_Hint = pass_Hint;
  }

  public char getSex() {
    return sex;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }
}
