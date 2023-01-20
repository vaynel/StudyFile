package com.mr.tour;

import com.mr.tour.presentation.MainMenu;
import com.mr.tour.service.Airline;
import com.mr.tour.service.Tourist;

public class Run {
	
	public static void main(String[] args) {
		Airline[] airlines = { new Airline("미국행", 3000, 300000),
				new Airline("중국행", 2000, 200000),
				new Airline("일본행", 1500, 150000) };
		
		new MainMenu(new Tourist(1000000,1000), airlines).mainMenu();
	}

}
