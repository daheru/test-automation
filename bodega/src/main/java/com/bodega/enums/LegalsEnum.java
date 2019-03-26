package com.bodega.enums;

public enum LegalsEnum {
	
	TERMS("términos", new String[]{"disponibilidad", "pago", "políticas", "tiempo"}),
	PRIVACITY("privacidad", new String[]{"aviso"})
	;
	
	private String term;
	private String[] subTerms;
	
	LegalsEnum(String term, String[] subTerms) {
		this.term = term;
		this.subTerms = subTerms;
	}
	
	public String getTerm() {
		return term;
	}
	
	public String[] getSubTerm() {
		return subTerms;
	}
}
