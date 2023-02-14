package com.mc.app.menu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mc.app.menu.dto.Menu;

@Controller
@RequestMapping("menu")
public class MenuController {

	
	@GetMapping("/menu-form")
	public void menu() {
		System.out.println("menu-form에 있습니다.");
	}
	
	@GetMapping("/order")
	public String selectMenu(Menu menu,Model model) {
		String[] foodList = menu.getMenu().split(",");
		Map<String,Integer> costList= new HashMap<String, Integer>();
		costList.put("피자",10000);
		costList.put("햄버거",5000);
		costList.put("치킨",18000);
		costList.put("회",70000);
		int cost=0;
		int n =1;
		String bill ="";
		String bilge="";
		
		for (String food : foodList) {
			if(costList.get(food) != null) {
				bill +=n+". "+food+":"+costList.get(food)+"<br>";
				cost+=costList.get(food);
				n++;
			}
			if(n-1==foodList.length) {bilge+=food; break;}
			bilge+=food+"/"; 
		}
		bilge="주문하신 "+bilge+"의 결재 금액은 "+ cost +"원 입니다.";
	
		model.addAttribute("bill", bill);
		model.addAttribute("bilge", bilge);
		
		return "/menu/receipt";
		
	}
	
	
}
