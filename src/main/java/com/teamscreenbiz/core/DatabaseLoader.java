package com.teamscreenbiz.core;


import com.teamscreenbiz.company.Company;
import com.teamscreenbiz.company.CompanyRepository;
import com.teamscreenbiz.user.User;
import com.teamscreenbiz.user.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner{
    private final UserRepository users;
    private final CompanyRepository companies;

  public DatabaseLoader(UserRepository users, CompanyRepository companies) {
    this.users = users;
    this.companies = companies;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<User> students = Arrays.asList(
//        String firstName, String lastName, String userName, String address,
//        String password, String[] roles, boolean emailConfirmed, String email,
//    boolean firstPhoneNumberConfirmed, Long firstPhoneNumber,
//    boolean secondPhoneNumberConfirmed, Long secondPhoneNumber

        new User("Anuraag", "Mishra",  "max", "death","#504 sec-38A Chandigarh", new String[] {"ROLE_USER","ROLE_ADMIN"},false,
            "mishra.anuraag@yahoo.com",true,8146928380L,false,null),
        new User("Shubham Raj", "Wadhwa","Raj","alive","Room no. 101, Block-1, Boys Hostel-7, Panjab university, Sector-14, Chandigarh",
            new String[]{"ROLE_USER","ROLE_ADMIN"},false,"shubhamchandigarh68@gmail.com",true,9988720494L,
            false,null)
//        new User("Anuraag", "Mishra",  "max", "death","#504 sec-38A Chandigarh", new String[] {"ROLE_USER"},false,
//            "mishra.anuraag@yahoo.com",true,8146928380L,false,null),
//        new User("Anuraag", "Mishra",  "max", "death","#504 sec-38A Chandigarh", new String[] {"ROLE_USER"},false,
//            "mishra.anuraag@yahoo.com",true,8146928380L,false,null)

        );
    users.save(students);

    List<Company> brands = Arrays.asList(
      new Company("Apple","Overpriced,Top-Notch"),
      new Company("Samsung","Lost Market with last phone, hope for the best in future"),
      new Company("Mi","Well best valued phones at low price range"),
      new Company("MOTO","Hopefully Lenovo does well with this company")
    );

    companies.save(brands);

  }
}
