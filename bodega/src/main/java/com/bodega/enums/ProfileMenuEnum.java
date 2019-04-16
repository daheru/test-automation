package com.bodega.enums;

public enum ProfileMenuEnum {
	
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
	
	ProfileMenuEnum(String menu) {
		this.menu = menu;
	}
	
	public String getMenu(){
		return menu;
	}
}
