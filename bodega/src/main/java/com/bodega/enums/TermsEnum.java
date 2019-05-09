package com.bodega.enums;

public enum TermsEnum {
	
	BANKS("bancos"),
	//BUEN_FIN("buen"),
	//COMENZO_EL_FIN("comenzo"),
	CUPONS("cupones"),
	SHIPMENTS("envios"),
	OTHERS_PROMOTIONS("promociones"),
	//PRE_SALES("preventas"),
	//PICK_UP("tienda"),
	SPECIAL_SALES("especiales");
	
	private String term;
	
	TermsEnum(String term) {
		this.term = term;
	}
	
	public String getTerm(){
		return term;
	}
}
