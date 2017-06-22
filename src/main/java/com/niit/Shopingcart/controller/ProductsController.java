package com.niit.Shopingcart.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shopinngcart1.model.Category;
import com.niit.shopinngcart1.model.Product;
import com.niit.shopinngcart1.service.CategoryService;
import com.niit.shopinngcart1.service.ProductService;
import com.niit.shopinngcart1.service.SupplierService;

@Controller
public class ProductsController {
	
	@Autowired
	ProductService productservice;
	@Autowired
	SupplierService supplierservice;
	@Autowired
	CategoryService categoryservice;
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("product")
	public String product1(Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		model.addAttribute("product",new Product());
		model.addAttribute("supplier",supplierservice.getAllSuppliers());
		model.addAttribute("category",categoryservice.getAllCategorys());
		model.addAttribute("productList",productservice.getAllProducts());
	
		model.addAttribute("msg2",true);
		model.addAttribute("msg",true);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get username
		session = request.getSession(true);
		session.setAttribute("loggedInUser", username);
		
		String str=(String)session.getAttribute("loggedInUser");
		if(str.equals("null")||str.equals("anonymousUser"))
		{
			model.addAttribute("msg11",true);
		}
		
		return"productdetails";
	}
	@ModelAttribute
	public Product produt2(Model model)
	{ 
		model.addAttribute("supplier",supplierservice.getAllSuppliers());
		model.addAttribute("category",categoryservice.getAllCategorys());
		model.addAttribute("productList",productservice.getAllProducts());
		return new Product();
	}
	
	private static final String UPLOAD_DIRECTORY ="resources/imgs";  
	@RequestMapping(value="/productdetailsk" ,method=RequestMethod.POST)
	public String productoperations(HttpSession session,HttpServletRequest request,@Valid @ModelAttribute("product") Product product,BindingResult result,Model model,@RequestParam String action)throws Exception
	{
		
		if(result.hasErrors())
		{
			model.addAttribute("msg",true);
			if(action.equals("Add"))
			{
			model.addAttribute("msg2",true);
			}
			else
			{
				model.addAttribute("msg3",true);
			}
			return "productdetails";
		}
		System.out.println("hello");
		System.out.println( product);
		String filename = product.getImg().getOriginalFilename();
		product.setImage(filename);
                byte[] bytes = new byte[product.getImg().getInputStream().available()];
				product.getImg().getInputStream().read(bytes);
				BufferedInputStream buffer = new BufferedInputStream(product.getImg().getInputStream());
				MultipartFile file = product.getImg();
				ServletContext context = session.getServletContext();
				String path = context.getRealPath(UPLOAD_DIRECTORY);
				File rootPath = new File(path);
				product.setPath(path);
				if (!rootPath.exists())
					rootPath.mkdirs();
				File store = new File(rootPath.getAbsolutePath() + "/" + filename);
				System.out.println("Image path :" + path);
				OutputStream os;
				try{
				os = new FileOutputStream(store);
				os.write(bytes);
			} catch (Exception e) {
				// TODO: handle exception
			}
		
           Product product1=new Product();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			productservice.add(product);
          product1 = product;
			break;
		case "update":
		  productservice.edit(product);;
		product1=product;
			break;
	
		
		}
		
		return "redirect:/product";
	}
	@RequestMapping("/deleteproduct")
	public String deleteSup(@RequestParam int productid,Model model) {
		
		 
		productservice.delete(productid);
		
		return "redirect:/product";
	
		}
	
	
	@RequestMapping("/editproduct")
	public String editproduct(@RequestParam int productid,Model model) {
	
	    model.addAttribute("product",new Category());
		model.addAttribute("product",productservice.getsingleproduct(productid));
		model.addAttribute("msg1",true);
		model.addAttribute("msg3",true);
		model.addAttribute("msg10",true);
		
	    return "productdetails";
	}
	
	
	@RequestMapping("/viewproduct")
	public String viewproduct(@RequestParam int productid,Model model) {
		model.addAttribute("msg1",true);
		model.addAttribute("msg3",true);
		 model.addAttribute("product",new Product());
			model.addAttribute("product",productservice.getsingleproduct(productid));
			String str=(String)session.getAttribute("loggedInUser");
			System.out.println(str);
			if(str.equals("null")||str.equals("anonymousUser"))
			{
				model.addAttribute("msg10",true);
			}
		    return "productdetails";
	}
	

}
