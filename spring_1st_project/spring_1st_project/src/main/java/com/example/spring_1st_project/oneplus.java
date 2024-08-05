package com.example.spring_1st_project;

public class oneplus implements Mobiles {
	Color color;
	
	oneplus(){
	System.out.println("onepluse obj triggres completed");
	}

	@Override
	public void getModelAndColor() {
		// TODO Auto-generated method stub
		System.out.println("Mobile : 9 pro");
		color.getoneplusColor();
	}

}
