package com.teamscreenbiz.user;


import com.teamscreenbiz.companyEmployee.CompanyEmployee;
import com.teamscreenbiz.companyEmployee.CompanyEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetailsService implements UserDetailsService {
  @Autowired
  UserRepository users;
  CompanyEmployeeRepository employees;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = users.findByUsername(username);

    if(user == null){
      CompanyEmployee employee = employees.findByUsername(username);
      if(employee == null){

        throw new UsernameNotFoundException(username + " was not found");
      }
      else{
        return new org.springframework.security.core.userdetails.User(
            employee.getUsername(),
            employee.getPassword(),
            AuthorityUtils.createAuthorityList(user.getRoles())
        );
      }
    }

    return new org.springframework.security.core.userdetails.User(
        user.getUsername(),
        user.getPassword(),
        AuthorityUtils.createAuthorityList(user.getRoles())
    );
  }
}
