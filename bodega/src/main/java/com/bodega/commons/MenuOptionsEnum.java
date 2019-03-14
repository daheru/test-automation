package com.bodega.commons;

public enum MenuOptionsEnum {
	
	LOGIN("iniciar"),
	CREATE_PROFILE("crear"),
	SUPPORT("soporte"),
	TERMS("condiciones"),
	PROFILE("perfil"),
	ADDRESS("direcciones"),
	ORDERS("pedidos"),
	GET_BILL("factura"),
	LEGALS("legales"),
	LOGOUT("cerrar"),
	NOTIFICATIONS("notificaciones");
	
	private String menu;
	
	MenuOptionsEnum(String menu) {
		this.menu = menu;
	}
	
	public String getMenu(){
		return menu;
	}
}
