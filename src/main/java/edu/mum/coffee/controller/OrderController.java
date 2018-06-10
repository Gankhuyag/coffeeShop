package edu.mum.coffee.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import edu.mum.coffee.domain.Address;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;


@Controller 
public class OrderController {

	@Resource
	private OrderService orderService;
	
	//@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/order";
	}


	@RequestMapping(value="/order", method=RequestMethod.GET)
	public String getListOrder(Model model) {
		
		model.addAttribute("order", orderService.findAll());
	
		//return productService.getAllProduct();
		return "orderList";
	}
	
	@RequestMapping(value="/order/add", method=RequestMethod.GET)
	public String getAllOrder(Model model) {
		Order order=new Order();
		//List<ProductType> types = Arrays.asList(ProductType.values());
		model.addAttribute("order", order);
		//model.addAttribute("prodType",types);
		return "addOrder";
	}
	
	@RequestMapping(value="/order/add", method=RequestMethod.POST)
	public String addOrder(Order order) {
		orderService.save(order);
		return "redirect:/order";
	}

	@RequestMapping(value="/order/{id}", method=RequestMethod.GET)
	public String getPerson(@PathVariable int id, Model model) {
		model.addAttribute("order", orderService.findById(id));
		//List<ProductType> types = Arrays.asList(ProductType.values());	 
		//model.addAttribute("prodType",types);
		return "orderDetail";
	}
	
	@RequestMapping(value="/order/{id}", method=RequestMethod.POST)
	//@PutMapping("/prod/{id}")
	public String updateOrder( @PathVariable("id") int id, Order order) {
	//public ResponseEntity<Person> updatePerson( @PathVariable("id") int id, Person person, Address address  ) {
			
		//Product prd=productService.findById(id);
		//prd.setProductName(product.getProductName());
		//prd.setDescription(product.getDescription());
		//prd.setPrice(product.getPrice());
		//prd.setProductType(product.getProductType());
		order.setId(id);
 		//person.setFirstName(firstName);
		orderService.save(order);
		//productService.delete(id);
		//redirectAttributes.addFlashAttribute("product",product);
		
		//model.addAttribute("product",prd);
		//productService.update(id, product); // car.id already set by binding
		//return  "prodList";
		//
		//return person.getFirstName();//"redirect:/person/";
		return "redirect:/order";
		//return new ResponseEntity<Person>(person, HttpStatus.CREATED);
	}

	/*@RequestMapping(value="/updateEmployee/{id}",method=RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        Employee emp = employeeDAO.findOne(id);
        emp.setEmpName(employee.getEmpName());
        emp.setEmpDept(employee.getEmpDept());
        Employee savedEmp = employeeDAO.save(emp);
        return savedEmp;
    }*/
	
	
	@RequestMapping(value="/order/del/{id}")
	public String deletePerson( Order order) {
		orderService.delete(order);; 
		return "redirect:/order";
	}

/*	@ExceptionHandler(value=NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}*/
}
