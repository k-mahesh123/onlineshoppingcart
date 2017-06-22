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

import com.niit.shopinngcart1.model.Category;
import com.niit.shopinngcart1.model.Supplier;
import com.niit.shopinngcart1.service.CategoryService;
import com.niit.shopinngcart1.service.SupplierService;

@Controller
public class CategorysController {
	@Autowired
	private CategoryService categoryservice;
	@Autowired
	private SupplierService supplierservice;
	@RequestMapping("/category")
	public String category1(Model model)
	{
		model.addAttribute("supplier",supplierservice.getAllSuppliers());
		model.addAttribute("categoryList", categoryservice.getAllCategorys());
		model.addAttribute("category",new Category());
		model.addAttribute("msg1",true);
		return "categorydetails";
	}
	@ModelAttribute
	public Category mmm(Model model)
	{
		model.addAttribute("supplier",supplierservice.getAllSuppliers());
		model.addAttribute("categoryList", categoryservice.getAllCategorys());
		model.addAttribute("category",new Category());
		return new Category();
	}
 
	@RequestMapping(value="/categorydetailsk" ,method=RequestMethod.POST)
	public String supplieroperations(@Valid @ModelAttribute("category") Category category,BindingResult result,@RequestParam String action,Model model)
	{
		if(result.hasErrors())
		{ 
			String s="Add";
		System.out.println(action);
			System.out.println(action=="s");//false
			System.out.println(action.equals(s));//true
			System.out.println(action=="Add");//false
			System.out.println(action.equals("Add"));//true
			if(action.equals("Add"))
			{
				model.addAttribute("msg1","true");
			}
			else
			{
				model.addAttribute("msg2","true");
			}
		
			return "categorydetails";
		}
           Category category1 = new Category();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			categoryservice.add(category);
		category1 = category;
			break;
		case "update":
		  categoryservice.edit(category);
		category1=category;
			break;
	
		
		}
		model.addAttribute("category", category);
		model.addAttribute("supplier",supplierservice.getAllSuppliers());

		model.addAttribute("categoryList", categoryservice.getAllCategorys());
		return "redirect:/category";
	}
	
	
	@RequestMapping("/deletecategory")
	public String deleteSup(@RequestParam int categoryid,Model model) {
		
		 
		categoryservice.delete(categoryid);
		
		return "redirect:/category";
	
		}
	
	
	@RequestMapping("/editcategory")
	public String editSup(@RequestParam int categoryid,Model model) {
	
	    model.addAttribute("category",new Category());
		model.addAttribute("category",categoryservice.getsinglecategory(categoryid));
		model.addAttribute("msg2",true);
	    return "categorydetails";
	}
	
	
	@RequestMapping("/viewcategory")
	public String viewSup(@RequestParam int categoryid,Model model) {
		model.addAttribute("msg",true);
		model.addAttribute("msg2",true);
		model.addAttribute("category",new Category());
		model.addAttribute("category",categoryservice.getsinglecategory(categoryid));
	    return "categorydetails";
	}
}
