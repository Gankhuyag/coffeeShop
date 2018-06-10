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
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;


@Controller 
public class PersonController {

	@Resource
	private PersonService personService;
	
	//@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/person";
	}


	@RequestMapping(value="/person", method=RequestMethod.GET)
	public String getListPerson(Model model) {
		
		model.addAttribute("person", personService.getAllPerson());
	
		//return productService.getAllProduct();
		return "personList";
	}
	
	@RequestMapping(value="/person/add", method=RequestMethod.GET)
	public String getAllPerson(Model model) {
		Person person=new Person();
		//List<ProductType> types = Arrays.asList(ProductType.values());
		model.addAttribute("person", person);
		//model.addAttribute("prodType",types);
		return "addPerson";
	}
	
	@RequestMapping(value="/person/add", method=RequestMethod.POST)
	public String addPerson(Person person) {
		personService.savePerson(person);
		return "redirect:/person";
	}

	@RequestMapping(value="/person/{id}", method=RequestMethod.GET)
	public String getPerson(@PathVariable int id, Model model) {
		model.addAttribute("person", personService.getPerson(id));
		//List<ProductType> types = Arrays.asList(ProductType.values());	 
		//model.addAttribute("prodType",types);
		return "personDetail";
	}
	
	@RequestMapping(value="/person/{id}", method=RequestMethod.POST)
	//@PutMapping("/prod/{id}")
	public String updatePerson( @PathVariable("id") int id, Person person, Address address  ) {
	//public ResponseEntity<Person> updatePerson( @PathVariable("id") int id, Person person, Address address  ) {
			
		//Product prd=productService.findById(id);
		//prd.setProductName(product.getProductName());
		//prd.setDescription(product.getDescription());
		//prd.setPrice(product.getPrice());
		//prd.setProductType(product.getProductType());
		person.setId(id);
		person.setAddress(address);
		person.getAddress().setId(id);
		//person.setFirstName(firstName);
		personService.savePerson(person);
		//productService.delete(id);
		//redirectAttributes.addFlashAttribute("product",product);
		
		//model.addAttribute("product",prd);
		//productService.update(id, product); // car.id already set by binding
		//return  "prodList";
		//
		//return person.getFirstName();//"redirect:/person/";
		return "redirect:/person";
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
	
	
	@RequestMapping(value="/person/del/{id}")
	public String deletePerson( Person person) {
		personService.removePerson(person); 
		return "redirect:/person";
	}

/*	@ExceptionHandler(value=NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}*/
}
