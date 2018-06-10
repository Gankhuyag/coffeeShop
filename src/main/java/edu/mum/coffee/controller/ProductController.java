package edu.mum.coffee.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
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
		
		//return productService.getAllProduct();
		return "prodList";
	}
	
	@RequestMapping(value="/prod/add", method=RequestMethod.GET)
	public String getAll(Model model) {
		Product product=new Product();
		List<ProductType> types = Arrays.asList(ProductType.values());
		model.addAttribute("product", product);
		model.addAttribute("prodType",types);
		return "addProduct";
	}
	
	@RequestMapping(value="/prod/add", method=RequestMethod.POST)
	public String add(Product product) {
		productService.save(product);
		return "redirect:/prod";
	}

	@RequestMapping(value="/prod/{id}", method=RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("product", productService.getProduct(id));
		List<ProductType> types = Arrays.asList(ProductType.values());	 
		model.addAttribute("prodType",types);
		return "prodDetail";
	}
	
	@RequestMapping(value="/prod/{id}", method=RequestMethod.POST)
	//@PutMapping("/prod/{id}")
	public String update( @PathVariable("id") int id, Product product  ) {
		//Product prd=productService.findById(id);
		//prd.setProductName(product.getProductName());
		//prd.setDescription(product.getDescription());
		//prd.setPrice(product.getPrice());
		//prd.setProductType(product.getProductType());
		product.setId(id);
		productService.save(product);
		
		//redirectAttributes.addFlashAttribute("product",product);
		
		//model.addAttribute("product",prd);
		//productService.update(id, product); // car.id already set by binding
		//return  "prodList";
		//
		return "redirect:/prod/";
		
	}

	/*@RequestMapping(value="/updateEmployee/{id}",method=RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        Employee emp = employeeDAO.findOne(id);
        emp.setEmpName(employee.getEmpName());
        emp.setEmpDept(employee.getEmpDept());
        Employee savedEmp = employeeDAO.save(emp);
        return savedEmp;
    }*/
	
	
	@RequestMapping(value="/prod/del/{id}", method=RequestMethod.POST)
	public String delete(Integer id) {
		productService.delete(id); 
		return "redirect:/prod";
	}

/*	@ExceptionHandler(value=NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}*/
}
