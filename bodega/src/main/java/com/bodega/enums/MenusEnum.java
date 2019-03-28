package com.bodega.enums;

public enum MenusEnum {

	LEGALS_TERMS("términos", new String[] { "disponibilidad", "pago", "políticas", "tiempo" }),
	LEGALS_PRIVACITY("privacidad", new String[] { "aviso" });

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
