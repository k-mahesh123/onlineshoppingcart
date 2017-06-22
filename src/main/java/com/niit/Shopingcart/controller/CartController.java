package com.niit.Shopingcart.controller;


import java.util.List;


import javax.servlet.http.HttpSession;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.google.gson.Gson;
import com.niit.shopinngcart1.dao.CartDao;

import com.niit.shopinngcart1.model.CartItem;
import com.niit.shopinngcart1.model.Product;
import com.niit.shopinngcart1.service.ProductService;


@Controller
public class CartController 
{
	
	@Autowired
	private ProductService productservice;
	@Autowired
	private CartDao cartdao;
	@Autowired
	private HttpSession session;
	private static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@ModelAttribute
	public CartItem CartItem()
	{
		return new CartItem();
	}
	   
	
     
	@SuppressWarnings({ "unused", "unchecked" })
	@RequestMapping(value="viewcart",method=RequestMethod.GET)
	public  String cart(Model model)
	{
		log.debug("Starting method cart");
		
			String username=(String)session.getAttribute("loggedInUser");
			List<CartItem> list=cartdao.getAllItems(username);
			log.info(username);
			model.addAttribute("cart",new CartItem());
			log.debug("Ending method of cart ");
			
		
		return "viewcart";
	}
	
	
	
	 @RequestMapping(value="viewCart",method=RequestMethod.GET)
		public String AddCart(@RequestParam int productid)
		{  
		 log.debug("Starting method addcart");
		 String username=(String)session.getAttribute("loggedInUser");
		
			

		 
	    Product product=productservice.getsingleproduct(productid);
	    CartItem cartItem=new CartItem();
	    
	   
	   
	   	@SuppressWarnings("unchecked")
		List<CartItem> list=cartdao.getAllItems(username);
	   	for(CartItem l: list)
	   	{
	   		
	   		log.info(l.getName());
	   		
	   		
	   	}
	   
	   
	   	for(CartItem l: list)
	   	{
	   	 
	   	  if(productid==l.getId())
	   	  {
	   
	    cartItem.setId(l.getId());
	    cartItem.setName(l.getName());
	    cartItem.setPrice(l.getPrice());
	    cartItem.setUsername(username);
	    System.out.println("1 "+cartItem.getQuantity());
	    System.out.println("2-l "+l.getQuantity());
	    
	   cartItem.setQuantity(1+l.getQuantity());
	   cartItem.setCartItemId(l.getCartItemId());
	    
	System.out.println("1 "+cartItem.getQuantity());
	System.out.println("2-l   "+l.getQuantity());
	    cartItem.setPrice(product.getProductprice()*cartItem.getQuantity());
	    System.out.println("cartid"+cartItem.getCartItemId());
	    System.out.println(cartItem.getQuantity());
	    
	    cartdao.update(cartItem);;
      
    
	    
	    return "redirect:/viewcart";
	   	}
	   	}
	   	
	   	cartItem.setId(product.getProductid());
	    cartItem.setName(product.getProductname());
	    cartItem.setPrice(product.getProductprice());
	    cartItem.setUsername(username);
	    cartItem.setQuantity(cartItem.getQuantity()+1);
	   
	    cartItem.setPrice(product.getProductprice()*cartItem.getQuantity());
	   
	    cartdao.add(cartItem);    
		  
	    return "redirect:/viewcart";
	    }
		  
	 @RequestMapping(value="/listone",method=RequestMethod.GET,produces="application/json")
	    public @ResponseBody String showListOne(){
		 String username=(String)session.getAttribute("loggedInUser");
			
	    	@SuppressWarnings("rawtypes")
			List blist=cartdao.getAllItems(username);
	    	System.out.println(username+"in listone page");
	    	Gson x=new Gson();
	    	String json=x.toJson(blist);
	    	return json;
	    }

	 @RequestMapping("/deleteItemCart")
	    public String deleteProduct(@RequestParam int id,Model model)
	    {
		CartItem cartItem= cartdao.getsinglecartitem(id);
		 System.out.println(id+"jajaja");
		 System.out.println(cartItem.getCartItemId());
		 System.out.println(cartItem.getQuantity());
		 System.out.println(cartItem.getUsername());
		 System.out.println(cartItem.getId());
		Product product= productservice.getsingleproduct(cartItem.getId());
		 
		 if(cartItem.getQuantity()>1)
		 {
			 cartItem.setQuantity(cartItem.getQuantity()-1);
			 cartItem.setPrice(product.getProductprice()*cartItem.getQuantity());
			 cartdao.update(cartItem);
		 }
		 else
		 {
         cartdao.delete(id);
		 }
         
	    return "redirect:/viewcart";
	    }
	 @RequestMapping("/deleteItemCartAll")
	    public String deleteProduct11(@RequestParam int id,Model model)
	    {
		 cartdao.delete(id);
		 return "redirect:/viewcart";
	    }
	 
	 @RequestMapping("/removeAll")
	 public String removeAllItem()
	 {
		 String username=(String)session.getAttribute("loggedInUser");
		 cartdao.removeAll(username);
		 return "redirect:/viewcart";
	 }
	
	 @RequestMapping("/Enduser")
	 public String dispe()
	 {
		 
		 return "redirect:/product";
	 }
	
	 
	 @RequestMapping("/addItemCart")
	    public String addProduct(@RequestParam int id,Model model)
	    {
		CartItem cartItem= cartdao.getsinglecartitem(id);
		 
		Product product= productservice.getsingleproduct(cartItem.getId());
		 
		
			 cartItem.setQuantity(cartItem.getQuantity()+1);
			 cartItem.setPrice(product.getProductprice()*cartItem.getQuantity());
			 cartdao.update(cartItem);
			 return "redirect:/viewcart";
		 }
	 

	
	 
	 
}
