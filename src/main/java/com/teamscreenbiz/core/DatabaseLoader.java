package com.teamscreenbiz.core;


import com.teamscreenbiz.company.Company;
import com.teamscreenbiz.company.CompanyRepository;
import com.teamscreenbiz.companyEmployee.CompanyEmployee;
import com.teamscreenbiz.companyEmployee.CompanyEmployeeRepository;
import com.teamscreenbiz.mobileModel.MobileModel;
import com.teamscreenbiz.mobileModel.MobileModelRepository;
import com.teamscreenbiz.product.Product;
import com.teamscreenbiz.product.ProductRepository;
import com.teamscreenbiz.productPrice.ProductPriceCCTRepository;
import com.teamscreenbiz.productPrice.ProductPriceCommercialRepository;
import com.teamscreenbiz.transaction.TransactionRepository;
import com.teamscreenbiz.user.User;
import com.teamscreenbiz.user.UserRepository;
import com.teamscreenbiz.vendor.VendorRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner{
    private final UserRepository users;
    private final MobileModelRepository mobileModelRepository;
    private final CompanyRepository companies;
    private final CompanyEmployeeRepository employees;
    private final ProductRepository products;
    private final ProductPriceCCTRepository cctPrices;
    private final ProductPriceCommercialRepository commercialPrices;
    private final TransactionRepository transactions;
    private final VendorRepository vendors;

  public DatabaseLoader(UserRepository users,MobileModelRepository mobileModelRepository, CompanyRepository companies,
                        CompanyEmployeeRepository employees,
                        ProductRepository products,
                        ProductPriceCCTRepository cctPrices,
                        ProductPriceCommercialRepository commercialPrices,
                        TransactionRepository transactions,
                        VendorRepository vendors) {
    this.users = users;
    this.mobileModelRepository = mobileModelRepository;
    this.companies = companies;
    this.employees = employees;
    this.products = products;
    this.cctPrices = cctPrices;
    this.commercialPrices = commercialPrices;
    this.transactions = transactions;
    this.vendors = vendors;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<User> students;
    students = Arrays.asList(
//        String firstName, String lastName, String userName, String address,
//        String password, String[] roles, boolean emailConfirmed, String email,
//    boolean firstPhoneNumberConfirmed, Long firstPhoneNumber,
//    boolean secondPhoneNumberConfirmed, Long secondPhoneNumber

       new User("Baljit", "Singh", "baloo", "bhai", "#504 sec-38A Chandigarh",
           "baloo.bhai@example.com",8146928380L),
       new User("Shubham", "Wadhwa", "shubham", "bhai", "#504 sec-38A Chandigarh",
           "baloo.bhai@example.com",8146928380L)
    );
    users.save(students);
    User mishra = new User("Anuraag", "Mishra", "max", "death", "#504 sec-38A Chandigarh","mishra.anuraag@yahoo.com",8146928380L);
    mishra.setRoles(new String[]{"Admin"});
    users.save(mishra);




//  String companyName, String desc
    List<Company> brands = Arrays.asList(
        new Company("Apple", "Overpriced,Top-Notch"),
        new Company("Samsung", "Lost Market with last phone, hope for the best in future"),
        new Company("Mi", "Well best valued phones at low price range"),
        new Company("Motorola", "Troll"),
        new Company("Vivo", "Lol")
    );
    companies.save(brands);
    Company c = new Company("Screenbiz", "startup");
    companies.save(c);
    MobileModel m = new MobileModel("S6");
    mobileModelRepository.save(m);
    m.setCompany(c);
    mobileModelRepository.save(m);

    m = new MobileModel("S6");
    mobileModelRepository.save(m);
    m.setCompany(brands.get(2));
    mobileModelRepository.save(m);

    List<CompanyEmployee> colleages = Arrays.asList(
        new CompanyEmployee("Baloo", 7696435591L, "baljitsingh@gmail.com",
            "Sec-15B", new Date(), "baloo", "bhai", "font",
            'M', new String[]{"Design_Team"}),
        new CompanyEmployee("Baloo", 7696435591L, "baljitsingh@gmail.com",
            "Sec-15B", new Date(), "mishra", "backend", "font",
            'M', new String[]{"Design_Team"})
    );

    employees.save(colleages);

//  String name, Company company, String mobileModel,double rating

    List<Product> allParts = Arrays.asList(
        new Product("xoxoxy", 4.8),
        new Product("product2", 3.8),
        new Product("product3", 2.9),
        new Product("product4", 4.9)
    );
    products.save(allParts);

//  int minVal, int maxVal, int lastQuote,Product product
//  int minVal, int maxVal, int availableAmount, int profit,Product product
//  String name, String address, Long phoneNumber, int[] rating, int finalRating,String desc
//  User user, Product product, Vendor vendor, int price, String desc

  }
}
