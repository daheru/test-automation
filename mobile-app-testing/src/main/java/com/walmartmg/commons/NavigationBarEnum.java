package com.walmartmg.commons;

public enum NavigationBarEnum {
	
	HOME(1),
	DEPARTMENTS(2),
	PROFILE(3);
	
	private int navBarOption;
	
	NavigationBarEnum(int navBarOption) {
		this.navBarOption = navBarOption;
	}
	
	public int getNavigation(){
		return navBarOption;
	}
}
