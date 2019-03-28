package com.walmartmg.enums;

public enum MenusEnum {
	
	TERMS_RETURNS("devoluciones", new String[]{"devolución", "garantias", "cancelacion"}),
	TERMS_DELIVERY("envíos", new String[]{"costos", "tiempos", "horarios"}),
	TERMS_BILLING("facturación", new String[]{"facturación"}),
	TERMS_MARKETPLACE("marketplace", new String[]{"marketplace"}),
	TERMS_PAYMENTS("pagos", new String[]{"formas","seguro", "walmart", "secure", "paypal", "wallet", "pay", "regalo"}),
	TERMS_PROMOTIONS("promociones", new String[]{"precios", "artículos", "compras", "inventario", "informacion"}),
	TERMS_FAQ("preguntas", new String[]{"preguntas"}),
	TERMS_SECURITY("seguridad", new String[]{"políticas", "términos"}),
	TERMS_ACCOUNT("cuenta", new String[]{"cuenta", "beneficios", "olvidaste", "configuración", "newsletter"}),
	TERMS_ORDERS("pedidos", new String[]{"comprar", "invitado", "revisa", "estatus", "tipos", "rastrea", "historial"})
	;
	
	private String menu;
	private String[] subMenu;

	MenusEnum(String menu, String[] subMenu) {
		this.menu = menu;
		this.subMenu = subMenu;
	}

	public String getMenu() {
		return menu;
	}

	public String[] getSubMenu() {
		return subMenu;
	}
}
