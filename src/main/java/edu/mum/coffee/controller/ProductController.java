package edu.mum.coffee.controller;

import javax.annotation.Resource;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;


@Controller 
public class ProductController {

	@Resource
	private ProductService productService;
	
	//@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/prod";
	}
	

	@RequestMapping(value="/prod", method=RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("product", productService.getAllProduct());
		return "prodList";
	}
	
	@RequestMapping(value="/prod/add", method=RequestMethod.GET)
	public String getAll(Model model) {
		Product product=new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}
	
	@RequestMapping(value="/prod/add", method=RequestMethod.POST)
	public String add(Product product) {
		productService.save(product);
		return "redirect:/prod/add";
	}

	@RequestMapping(value="/prod/{id}", method=RequestMethod.GET)
	public String get(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.getProduct(id));
		return "prodDetail";
	}
	
	@RequestMapping(value="/prod/{id}", method=RequestMethod.POST)
	public String update(Product product, @PathVariable int id) {
		product=productService.findById(id);
		productService.update(id, product); // car.id already set by binding
		return "redirect:/prod";
	}
	
	@RequestMapping(value="/prod/del/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id, Model model) {
		productService.delete(id);
		model.addAttribute("product", productService.getAllProduct());
		System.out.println("Deleted! ");
		
		 return "prodList";
	}


/*	@ExceptionHandler(value=NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}*/
}
