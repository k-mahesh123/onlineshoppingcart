package com.niit.Shopingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.shopinngcart1.model.Supplier;
import com.niit.shopinngcart1.service.SupplierService;
import com.niit.shopinngcart1.model.Supplier;

@Controller
public class SuppliersController {
	@Autowired
	SupplierService supplierservice;
	
	
	@RequestMapping("supplier")
	public String supplierpage(Model model)
	{    
		model.addAttribute("supplier",new Supplier());
		model.addAttribute("supplierList", supplierservice.getAllSuppliers());
		model.addAttribute("msg",true);
		model.addAttribute("add","stored sucessfully");
		return "supplierdetails";
	}
	@ModelAttribute
	public Supplier mm(Model model)
	{
	
		model.addAttribute("supplierList", supplierservice.getAllSuppliers());
		return new Supplier();
	}
	
	@RequestMapping(value="/supplieroperations" ,method=RequestMethod.POST)
	public String supplieroperations(@Valid @ModelAttribute("supplier") Supplier supplier,BindingResult result,@RequestParam String action,Model model)
	{
		if(result.hasErrors())
		{
			if(action.equals("Add"))
			{
				model.addAttribute("msg","true");
			}
			else
			{
				model.addAttribute("msg2","true");
			}
			return "supplierdetails";
		}
		Supplier supplierResult = new Supplier();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			supplierservice.save(supplier);;
			supplierResult = supplier;
			model.addAttribute("add","stored sucessfully");
			break;
		case "update":
			supplierservice.update(supplier);;
			supplierResult = supplier;
			break;
	
		
		}
		model.addAttribute("supplier", supplier);
		model.addAttribute("msg","true");
	
		return "redirect:/supplier";
	}
		
	
	@RequestMapping("/deletesupplier")
	public String deleteSup(@RequestParam int supid,Model model) {
		
		
		supplierservice.delete(supid);
	
		return "redirect:/supplier";
	
		}
	@RequestMapping("/editsupplier")
	public String editSup(@RequestParam int supid,Model model) {
		model.addAttribute("msg2",true);
	    model.addAttribute("supplier",new Supplier());
		model.addAttribute("supplier",supplierservice.getSingleSupplier(supid));
	    return "supplierdetails";
	}
	@RequestMapping("/viewsupplier")
	public String viewSup(@RequestParam int supid,Model model) {
		model.addAttribute("msg1",true);
	    model.addAttribute("supplier",new Supplier());
		model.addAttribute("supplier",supplierservice.getSingleSupplier(supid));
		model.addAttribute("msg2",true);
	    return "supplierdetails";
	}
		

		
	}


