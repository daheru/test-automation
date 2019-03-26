package com.walmartmg.enums;

public enum TermsEnum {
	
	RETURNS("devoluciones", new String[]{"devolución", "garantias", "cancelacion"}),
	DELIVERY("envíos", new String[]{"costos", "tiempos", "horarios"}),
	BILLING("facturación", new String[]{"facturación"}),
	MARKETPLACE("marketplace", new String[]{"marketplace"}),
	PAYMENTS("pagos", new String[]{"formas","seguro", "walmart", "secure", "paypal", "wallet", "pay", "regalo"}),
	PROMOTIONS("promociones", new String[]{"precios", "artículos", "compras", "inventario", "informacion"}),
	FAQ("preguntas", new String[]{"preguntas"}),
	SECURITY("seguridad", new String[]{"políticas", "términos"}),
	ACCOUNT("cuenta", new String[]{"cuenta", "beneficios", "olvidaste", "configuración", "newsletter"}),
	ORDERS("pedidos", new String[]{"comprar", "invitado", "revisa", "estatus", "tipos", "rastrea", "historial"})
	;
	
	private String term;
	private String[] subTerms;
	
	TermsEnum(String term, String[] subTerms) {
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
