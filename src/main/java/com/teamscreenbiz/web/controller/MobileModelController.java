package com.teamscreenbiz.web.controller;

import com.teamscreenbiz.company.CompanyRepository;
import com.teamscreenbiz.mobileModel.MobileModel;
import com.teamscreenbiz.mobileModel.MobileModelRepository;
import com.teamscreenbiz.mobileModel.MobileModelService;
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
public class MobileModelController {
  @Autowired
  private MobileModelRepository mobileModelRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private MobileModelService mobileModelService;

  // Index of all mobileModels
  @RequestMapping("/mobileModels")
  public String listCompanies(Model model) {

    List<MobileModel> mobileModels = mobileModelRepository.findAll();
    model.addAttribute("mobileModels",mobileModels);
    return "mobileModel/index";
  }



  // Single mobileModel page
  @RequestMapping("/mobileModels/{mobileModelId}")
  public String mobileModel(@PathVariable Long mobileModelId, Model model) {
    // TODO: Get the mobileModel given by mobileModelId
    MobileModel mobileModel = mobileModelRepository.findById(mobileModelId);

    model.addAttribute("mobileModel", mobileModel);
    return "mobileModel/details";
  }

  // Form for adding a new mobileModel
  @RequestMapping("mobileModels/add")
  public String formNewMobileModel(Model model) {
    // TODO: Add model attributes needed for new form
    if(!model.containsAttribute("mobileModel")) {
      model.addAttribute("mobileModel",new MobileModel());
    }

    model.addAttribute("companies",companyRepository.findAll());
    model.addAttribute("action","/mobileModels");
    model.addAttribute("heading","New MobileModel");
    model.addAttribute("submit","Add");

    return "mobileModel/form";
  }

  // Form for editing an existing mobileModel
  @RequestMapping("mobileModels/{mobileModelId}/edit")
  public String formEditMobileModel(@PathVariable Long mobileModelId, Model model) {
    // TODO: Add model attributes needed for new form
    if(!model.containsAttribute("mobileModel")) {
      model.addAttribute("mobileModel",mobileModelRepository.findById(mobileModelId));
    }

    model.addAttribute("companies",companyRepository.findAll());
    model.addAttribute("action",String.format("/mobileModels/%s",mobileModelId));
    model.addAttribute("heading","Edit MobileModel");
    model.addAttribute("submit","Update");

    return "mobileModel/form";
  }


  // Update an existing mobileModel
  @RequestMapping(value = "/mobileModels/{mobileModelId}", method = RequestMethod.POST)
  public String updateMobileModel(@Valid MobileModel mobileModel, BindingResult result, RedirectAttributes redirectAttributes) {
    // TODO: Update mobileModel if valid data was received
    System.out.println(mobileModel.getId());
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.mobileModel",result);

      // Add  mobileModel if invalid was received
      redirectAttributes.addFlashAttribute("mobileModel",mobileModel);

      // Redirect back to the form
      return String.format("redirect:/mobileModels/%s/edit",mobileModel.getId());
    }


    mobileModelService.save(mobileModel);

    redirectAttributes.addFlashAttribute("flash",new FlashMessage("MobileModel successfully updated!", FlashMessage.Status.SUCCESS));

    // TODO: Redirect browser to /mobileModels
    return "redirect:/mobileModels";
  }

  // Add a mobileModel
  @RequestMapping(value = "/mobileModels", method = RequestMethod.POST)
  public String addMobileModel(@Valid MobileModel mobileModel, BindingResult result, RedirectAttributes redirectAttributes) {
    // TODO: Add mobileModel if valid data was received
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.mobileModel",result);

      // Add  mobileModel if invalid was received
      redirectAttributes.addFlashAttribute("mobileModel",mobileModel);

      // Redirect back to the form
      return "redirect:/mobileModels/add";
    }
//    System.out.println(mobileModel.getId());
    mobileModelRepository.save(mobileModel);

    redirectAttributes.addFlashAttribute("flash",new FlashMessage("MobileModel successfully added!", FlashMessage.Status.SUCCESS));

    // TODO: Redirect browser to /mobileModels
    return "redirect:/mobileModels";
  }

  // Delete an existing mobileModel
  @RequestMapping(value = "/mobileModels/{mobileModelId}/delete", method = RequestMethod.POST)
  public String deleteMobileModel(@PathVariable Long mobileModelId, RedirectAttributes redirectAttributes) {
    MobileModel mob = mobileModelRepository.findById(mobileModelId);

    // TODO: Delete mobileModel if it contains no GIFs
    if(mob.getProducts().size() > 0) {
      redirectAttributes.addFlashAttribute("flash",new FlashMessage("Only empty mobileModels can be deleted.", FlashMessage.Status.FAILURE));
      return String.format("redirect:/mobileModels/%s/edit",mobileModelId);
    }
    mobileModelRepository.delete(mob);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("MobileModel deleted!", FlashMessage.Status.SUCCESS));

    // TODO: Redirect browser to /mobileModels
    return "redirect:/mobileModels";
  }



}
