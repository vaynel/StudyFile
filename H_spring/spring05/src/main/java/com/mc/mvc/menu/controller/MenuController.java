package com.mc.mvc.menu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mc.mvc.menu.dto.Menu;


@Controller
@RequestMapping("menu")
public class MenuController {
	
	@GetMapping("/menu")
	public void signup() {
		System.out.println("menu에 들어왔습니다.");
	};
	
	@PostMapping("/selectMenu")
	public String selectMenu(Menu menu,Model model) {
	
		String[] foodList = menu.getMenu().split(",");
		Map<String,Integer> costList= new HashMap<>();
		costList.put("Pizza",10000);
		costList.put("Hamburger",5000);
		costList.put("Chicken",18000);
		costList.put("Fish",70000);
		int cost=0;
		int n =1;
		String bill ="";
		
		
		String bilge="";
		for (String food : foodList) {
			bilge+=food+"/";
			if(costList.get(food) != null) {
				bill +=n+". "+food+":"+costList.get(food)+"<br>";
				cost+=costList.get(food);
				n++;
			}
		}
		bilge="주문하신 "+bilge+"의 결재 금액은"+ cost +"원 입니다.";
	
		model.addAttribute("bill", bill);
		model.addAttribute("bilge", bilge);
		
		System.out.println("receipt로 갑니다.");
		return "/menu/receipt"; 
	}
	

}
