package com.teamscreenbiz.web.controller;

import com.teamscreenbiz.company.Company;
import com.teamscreenbiz.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Controller
public class CompanyController {
  @Autowired
  private CompanyRepository companyRepository;

//  // Index of all categories
//  @SuppressWarnings("unchecked")
//  @RequestMapping("/categories")
//  public String listCategories(Model model) {
//    // TODO: Get all categories
//    List<Category> categories = categoryService.findAll();
//
//    model.addAttribute("categories",categories);
//    return "category/index";
//  }

  // Index of all companies
  @RequestMapping("/companies")
  public String listCompanies(Model model) {

    List<Company> companies = companyRepository.findAll();
    model.addAttribute("companies",companies);
    return "company/index";
  }

}
