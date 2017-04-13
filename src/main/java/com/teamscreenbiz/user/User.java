package com.teamscreenbiz.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamscreenbiz.core.BaseEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends BaseEntity{
  public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
      Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
          Pattern.CASE_INSENSITIVE);

  @NotNull
  @Size(min = 5, max = 20)
  private String firstName;
  @Size(min = 5, max = 20)
  private String lastName;
  @NotNull
  @Size(min = 3, max = 20)
  private String userName;
  private String address;
  @NotNull
//  @JsonIgnore
//  @Size(min = 5, max = 16) /*Size property not working check*/
  private String password;
//  @JsonIgnore
  private String[] roles;
  boolean emailConfirmed;
//TODO max: not working validation moved on to other tables for now
  @Size(min = 3, max = 321)
  private String email;
  @JsonProperty(required = true)
  boolean firstPhoneNumberConfirmed;
  private Long firstPhoneNumber;
  boolean secondPhoneNumberConfirmed;
  //TODO max: check for hypenated mobile number
  private Long secondPhoneNumber;

  protected User() {super();}

  public User(String firstName, String lastName, String userName,
              String password,String address, String[] roles, boolean emailConfirmed, String email,
              boolean firstPhoneNumberConfirmed, Long firstPhoneNumber,
              boolean secondPhoneNumberConfirmed, Long secondPhoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.address = address;
    this.password = password;
    this.roles = roles;
    this.emailConfirmed = emailConfirmed;
    this.email = email;
    this.firstPhoneNumberConfirmed = firstPhoneNumberConfirmed;
    this.firstPhoneNumber = firstPhoneNumber;
    this.secondPhoneNumberConfirmed = secondPhoneNumberConfirmed;
    this.secondPhoneNumber = secondPhoneNumber;
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

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public boolean isEmailConfirmed() {
    return emailConfirmed;
  }

  public void setEmailConfirmed(boolean emailConfirmed) {
    this.emailConfirmed = emailConfirmed;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if(validate(email)){
      this.email = email;
      //TODO max: set message for successfull email update
    }


  }


  public static boolean validate(String emailStr) {
    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
    return matcher.find();
  }

  public Long getFirstPhoneNumber() {
    return firstPhoneNumber;
  }

  public void setFirstPhoneNumber(Long firstPhoneNumber) {
    this.firstPhoneNumber = firstPhoneNumber;
  }

  public boolean isFirstPhoneNumberConfirmed() {
    return firstPhoneNumberConfirmed;
  }

  public void setFirstPhoneNumberConfirmed(boolean firstPhoneNumberConfirmed) {
    this.firstPhoneNumberConfirmed = firstPhoneNumberConfirmed;
  }

  public boolean isSecondPhoneNumberConfirmed() {
    return secondPhoneNumberConfirmed;
  }

  public void setSecondPhoneNumberConfirmed(boolean secondPhoneNumberConfirmed) {
    this.secondPhoneNumberConfirmed = secondPhoneNumberConfirmed;
  }

  public Long getSecondPhoneNumber() {
    return secondPhoneNumber;
  }

  public void setSecondPhoneNumber(Long secondPhoneNumber) {
    this.secondPhoneNumber = secondPhoneNumber;
  }



}
