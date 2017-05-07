package com.teamscreenbiz.web.controller;

import com.teamscreenbiz.mobileModel.MobileModelRepository;
import com.teamscreenbiz.product.ProductRepository;
import com.teamscreenbiz.product.Product;
import com.teamscreenbiz.product.ProductRepository;
import com.teamscreenbiz.product.ProductService;
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
public class ProductController {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private MobileModelRepository mobileModelRepository;

  @Autowired
  private ProductService productService;

  // Index of all products
  @RequestMapping("/products")
  public String listCompanies(Model model) {

    List<Product> products = productRepository.findAll();
    model.addAttribute("products",products);
    return "product/index";
  }



  // Single product page
  @RequestMapping("/products/{productId}")
  public String product(@PathVariable Long productId, Model model) {
    // TODO: Get the product given by productId
    Product product = productRepository.findById(productId);

    model.addAttribute("product", product);
    return "product/details";
  }

  // Form for adding a new product
  @RequestMapping("products/add")
  public String formNewProduct(Model model) {
    // TODO: Add model attributes needed for new form
    if(!model.containsAttribute("product")) {
      model.addAttribute("product",new Product());
    }

    model.addAttribute("mobileModels",mobileModelRepository.findAll());
    model.addAttribute("action","/products");
    model.addAttribute("heading","New Product");
    model.addAttribute("submit","Add");

    return "product/form";
  }

  // Form for editing an existing product
  @RequestMapping("products/{productId}/edit")
  public String formEditProduct(@PathVariable Long productId, Model model) {
    // TODO: Add model attributes needed for new form
    if(!model.containsAttribute("product")) {
      model.addAttribute("product",productRepository.findById(productId));
    }

    model.addAttribute("mobileModels",mobileModelRepository.findAll());
    model.addAttribute("action",String.format("/products/%s",productId));
    model.addAttribute("heading","Edit Product");
    model.addAttribute("submit","Update");

    return "product/form";
  }


  // Update an existing product
  @RequestMapping(value = "/products/{productId}", method = RequestMethod.POST)
  public String updateProduct(@Valid Product product, BindingResult result, RedirectAttributes redirectAttributes) {
    // TODO: Update product if valid data was received
    System.out.println(product.getId());
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.product",result);

      // Add  product if invalid was received
      redirectAttributes.addFlashAttribute("product",product);

      // Redirect back to the form
      return String.format("redirect:/products/%s/edit",product.getId());
    }


    productService.save(product);

    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Product successfully updated!", FlashMessage.Status.SUCCESS));

    // TODO: Redirect browser to /products
    return "redirect:/products";
  }

  // Add a product
  @RequestMapping(value = "/products", method = RequestMethod.POST)
  public String addProduct(@Valid Product product, BindingResult result, RedirectAttributes redirectAttributes) {
    // TODO: Add product if valid data was received
    if(result.hasErrors()) {
      // Include validation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.product",result);

      // Add  product if invalid was received
      redirectAttributes.addFlashAttribute("product",product);

      // Redirect back to the form
      return "redirect:/products/add";
    }
//    System.out.println(product.getId());
    productRepository.save(product);

    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Product successfully added!", FlashMessage.Status.SUCCESS));

    // TODO: Redirect browser to /products
    return "redirect:/products";
  }

  // Delete an existing product
  @RequestMapping(value = "/products/{productId}/delete", method = RequestMethod.POST)
  public String deleteProduct(@PathVariable Long productId, RedirectAttributes redirectAttributes) {
    Product mob = productRepository.findById(productId);

    // TODO: Delete product if it contains no GIFs

    productRepository.delete(mob);
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Product deleted!", FlashMessage.Status.SUCCESS));

    // TODO: Redirect browser to /products
    return "redirect:/products";
  }



}
