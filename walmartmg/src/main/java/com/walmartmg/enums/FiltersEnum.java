package com.walmartmg.enums;

import com.walmartmg.constants.NamesMobileElements;

public enum FiltersEnum {
	
	A_Z( NamesMobileElements.FILTERS_SORT_BY_AZ ),
	Z_A( NamesMobileElements.FILTERS_SORT_BY_ZA ),
	HIGHER_PRICE( NamesMobileElements.FILTERS_SORT_BY_GREATERTHAN ),
	MINNOR_PRICE( NamesMobileElements.FILTERS_SORT_BY_LESSTHAN ),
	POPULAR( NamesMobileElements.FILTERS_SORT_BY_POPULARITY );
	
	private String filter;
	
	FiltersEnum(String filter) {
		this.filter = filter;
	}
	
	public String getFilter(){
		return filter;
	}
}
