package com.teamscreenbiz.web.controller;

import com.teamscreenbiz.company.Company;
import com.teamscreenbiz.company.CompanyRepository;
import com.teamscreenbiz.company.CompanyService;
import com.teamscreenbiz.company.CompanyServiceImpl;
import com.teamscreenbiz.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import javax.validation.Valid;

@Controller
public class CompanyController {
  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private CompanyService companyService;

  // Index of all companies
  @RequestMapping("/companies")
  public String listCompanies(Model model) {

    List<Company> companies = companyRepository.findAll();
    model.addAttribute("companies",companies);
    return "company/index";
  }


  // Single company page
  @RequestMapping("/companies/{companyId}")
  public String company(@PathVariable Long companyId, Model model) {
    // TODO: Get the company given by companyId
    Company company = companyRepository.findById(companyId);

    model.addAttribute("company", company);
    System.out.println(company.getMobileModels());
    return "company/details";
  }

  // Form for adding a new company
  @RequestMapping("companies/add")
  public String formNewCompany(Model model) {
    // TODO: Add model attributes needed for new form
    if(!model.containsAttribute("company")) {
      model.addAttribute("company",new Company());
    }
//    model.addAttribute("colors", Color.values());
    model.addAttribute("action","/companies");
    model.addAttribute("heading","New Company");
    model.addAttribute("submit","Add");

    return "company/form";
  }

  // Form for editing an existing company
  @RequestMapping("companies/{companyId}/edit")
  public String formEditCompany(@PathVariable Long companyId, Model model) {
    // TODO: Add model attributes needed for new form
    if(!model.containsAttribute("company")) {
      model.addAttribute("company",companyRepository.findById(companyId));
    }
//    model.addAttribute("colors", Color.values());
    model.addAttribute("action",String.format("/companies/%s",companyId));
    model.addAttribute("heading","Edit Company");
    model.addAttribute("submit","Update");

    return "company/form";
  }


  // Update an existing company
  @RequestMapping(value = "/companies/{companyId}", method = RequestMethod.POST)
  public String updateCompany(@Valid Company company, BindingResult result, RedirectAttributes redirectAttributes) {
    // TODO: Update company if valid data was received
    System.out.println(company.getId());
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.company",result);

      // Add  company if invalid was received
      redirectAttributes.addFlashAttribute("company",company);

      // Redirect back to the form
      return String.format("redirect:/companies/%s/edit",company.getId());
    }

//    companyRepository.setUserInfoById(company.getCompanyName(),company.getDesc(),company.getId());

    companyService.save(company);

    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Company successfully updated!", FlashMessage.Status.SUCCESS));

    // TODO: Redirect browser to /companies
    return "redirect:/companies";
  }

  // Add a company
  @RequestMapping(value = "/companies", method = RequestMethod.POST)
  public String addCompany(@Valid Company company, BindingResult result, RedirectAttributes redirectAttributes) {
    // TODO: Add company if valid data was received
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.company",result);

      // Add  company if invalid was received
      redirectAttributes.addFlashAttribute("company",company);

      // Redirect back to the form
      return "redirect:/companies/add";
    }
    System.out.println(company.getId());
    companyRepository.save(company);

    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Company successfully added!", FlashMessage.Status.SUCCESS));

    // TODO: Redirect browser to /companies
    return "redirect:/companies";
  }

  // Delete an existing company
  @RequestMapping(value = "/companies/{companyId}/delete", method = RequestMethod.POST)
  public String deleteCompany(@PathVariable Long companyId, RedirectAttributes redirectAttributes) {
    Company cat = companyRepository.findById(companyId);

    // TODO: Delete company if it contains no GIFs
    if(cat.getMobileModels().size() > 0) {
      redirectAttributes.addFlashAttribute("flash",new FlashMessage("Only empty companies can be deleted.", FlashMessage.Status.FAILURE));
      return String.format("redirect:/companies/%s/edit",companyId);
    }
    companyRepository.delete(cat);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Company deleted!", FlashMessage.Status.SUCCESS));

    // TODO: Redirect browser to /companies
    return "redirect:/companies";
  }



}
