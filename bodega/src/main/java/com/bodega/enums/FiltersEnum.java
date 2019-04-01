package com.bodega.enums;

import com.bodega.constants.NamesMobileElements;

public enum FiltersEnum {
	
	A_Z( NamesMobileElements.FILTER_A_TO_Z ),
	Z_A( NamesMobileElements.FILTER_Z_TO_A ),
	HIGHER_PRICE( NamesMobileElements.FILTER_HIGHER_PRICE ),
	MINNOR_PRICE( NamesMobileElements.FILTER_MINNOR_PRICE ),
	POPULAR( NamesMobileElements.FILTER_POPULAR_BUTTON );
	
	private String filter;
	
	FiltersEnum(String filter) {
		this.filter = filter;
	}
	
	public String getFilter(){
		return filter;
	}
}
