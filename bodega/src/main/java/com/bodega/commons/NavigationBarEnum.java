package com.bodega.commons;

public enum NavigationBarEnum {
	
	HOME(1),
	DEPARTMENTS(2),
	PROMOTIONS(3),
	CAR(4);
	
	private int navBarOption;
	
	NavigationBarEnum(int navBarOption) {
		this.navBarOption = navBarOption;
	}
	
	public int getNavigation(){
		return navBarOption;
	}
}
