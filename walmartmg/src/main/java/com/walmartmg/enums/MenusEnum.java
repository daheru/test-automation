package com.walmartmg.enums;

import com.walmartmg.constants.NamesMobileElements;

public enum MenusEnum {
	
	TERMS_RETURNS("devoluciones", new String[]{ NamesMobileElements.TERMS_ITEM, NamesMobileElements.TERMS_ITEM_CHILD } ,new String[]{"devolución", "garantias", "cancelacion"}),
	TERMS_DELIVERY("envíos", new String[]{ NamesMobileElements.TERMS_ITEM, NamesMobileElements.TERMS_ITEM_CHILD }, new String[]{"costos", "tiempos", "horarios"}),
	TERMS_BILLING("facturación", new String[]{ NamesMobileElements.TERMS_ITEM, NamesMobileElements.TERMS_ITEM_CHILD }, new String[]{"facturación"}),
	TERMS_MARKETPLACE("marketplace", new String[]{ NamesMobileElements.TERMS_ITEM, NamesMobileElements.TERMS_ITEM_CHILD }, new String[]{"marketplace"}),
	TERMS_PAYMENTS("pagos", new String[]{ NamesMobileElements.TERMS_ITEM, NamesMobileElements.TERMS_ITEM_CHILD }, new String[]{"formas","seguro", "walmart", "secure", "paypal", "wallet", "pay", "regalo"}),
	TERMS_PROMOTIONS("promociones", new String[]{ NamesMobileElements.TERMS_ITEM, NamesMobileElements.TERMS_ITEM_CHILD }, new String[]{"precios", "artículos", "compras", "inventario", "informacion"}),
	TERMS_FAQ("preguntas", new String[]{ NamesMobileElements.TERMS_ITEM, NamesMobileElements.TERMS_ITEM_CHILD }, new String[]{"preguntas"}),
	TERMS_SECURITY("seguridad", new String[]{ NamesMobileElements.TERMS_ITEM, NamesMobileElements.TERMS_ITEM_CHILD }, new String[]{"políticas", "términos"}),
	TERMS_ACCOUNT("cuenta", new String[]{ NamesMobileElements.TERMS_ITEM, NamesMobileElements.TERMS_ITEM_CHILD }, new String[]{"cuenta", "beneficios", "olvidaste", "configuración", "newsletter"}),
	TERMS_ORDERS("pedidos", new String[]{ NamesMobileElements.TERMS_ITEM, NamesMobileElements.TERMS_ITEM_CHILD }, new String[]{"comprar", "invitado", "revisa", "estatus", "tipos", "rastrea", "historial"}),
	
	LEGALS_TERMS("términos", new String[]{ NamesMobileElements.LEGALS_ITEM, NamesMobileElements.LEGALS_ITEM_CHILD }, new String[] { "disponibilidad", "pago", "políticas", "tiempo" }),
	LEGALS_PRIVACITY("privacidad", new String[]{ NamesMobileElements.LEGALS_ITEM, NamesMobileElements.LEGALS_ITEM_CHILD }, new String[] { "aviso" }),
	
	DEP_COMPUTERS("computadoras", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "laptops", "accesorios", "pc", "tablets", "escritorio", "software", "impresoras", "componentes", "destacados", "proyectores" }),
	DEP_TV_VIDEO("tv", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "pantallas", "accesorios", "audio", "muebles", "dvd", "destacados" }),
	DEP_AUDIO("audio", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "sonido", "mp3", "audio", "audífonos", "dj", "bocinas", "minicomponentes", "destacados" }),
	DEP_INSTRUMENTS("instrumentos", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "viento", "cuerdas", "amplificadores", "dj", "teclados", "percusión", "destacados" }),
	DEP_VIDEOGAMES("videojuegos", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "playstation 3", "xboxone", "nintendo", "switch", "playstation 4", "xbox 360", "pc", "retro", "destacados", "lanzamientos" }),
	DEP_MOBILES("celulares", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "celulares", "smartphone", "cargadores", "destacados", "fundas", "smartwatch", "fija" }),
	DEP_PHOTOGRAPHY("fotografía", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "accesorios", "drones", "memorias", "cámaras", "video", "destacados" }),
	DEP_FORNITURE("muebles", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "muebles", "recamaras", "salas", "inflables", "comedores", "decoración", "persianas", "destacados", "escritorios" }),
	DEP_HOME_KITCHEN("cocina", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "lavado", "cocina", "casa", "mesa", "organización", "destacados", "tapetes", "persianas", "iluminación" }),
	DEP_MATTRESSES("colchones", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "blancos", "colchones", "destacados" }),
	DEP_CARS("autos", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "limpieza", "accesorios", "aceites", "refacciones", "audio", "iluminación", "motos", "destacados", "llantas" }),
	DEP_HARDWARE_STORE("ferretería", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "plomería", "electricidad", "lonas", "almacenaje", "seguridad", "hogar", "manuales", "eléctricas", "destacados", "iluminación" }),
	DEP_FASHION("moda", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "destacados", "maletas", "hombre", "mujer", "joyería", "pijamas", "lentes", "relojes" }),
	DEP_HEALTH("salud", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "spa", "ortopédico", "médico", "fajas", "higiene", "destacados", "lentes" }),
	DEP_BEAUTY("belleza", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "spa", "facial", "afeitado", "higiene", "maquillaje", "cabello", "corporal", "destacados", "perfumes" }),
	DEP_SPORTS("deportes", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "acuáticos", "accesorios", "ciclismo", "contacto", "equipo", "bicicletas", "fitness", "camping", "motos", "nutrición", "destacados", "fan", "juegos" }),
	DEP_GARDEN("jardín", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "asadores", "herramientas", "muebles", "calentadores", "toldos", "decoración", "destacados" }),
	DEP_BABIES("bebés", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "carriolas", "cuarto", "higiene", "juguetes", "alimentación", "mamá", "autoasientos", "bebé", "destacados", "pañales", "monitores", "ropa" }),
	DEP_TOYS("juguetes", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "drones", "peluches", "casitas", "carritos", "bicicletas", "montables", "destacados", "figuras", "juegos", "manualidades", "mesa", "preescolar", "mascotas", "lanzadores" }),
	DEP_OFFICE("oficina", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "fiesta", "oficina", "arte", "papelería", "destacados" }),
	DEP_PETS("mascotas", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "roedores", "peces", "aves", "gatos", "perros", "reptiles", "destacados" }),
	DEP_MOVIES("películas", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "dvd", "blu-ray", "series", "coleccionistas" }),
	DEP_BOOKS("libros", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "infantil", "accesorios", "recreación", "literatura", "escolares", "destacados" }),
	DEP_WHITE_LINE("línea", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "aire", "estufas", "refrigeradores", "lavadoras", "destacados" }),
	DEP_HOME_ELECTRONICS("electrodomésticos", new String[]{ NamesMobileElements.DEP_ITEM, NamesMobileElements.DEP_ITEM_CHILD }, new String[] { "aspiradoras", "licuadoras", "cafeteras", "maquinas", "destacados", "purificadores", "especializados", "vaporeras", "hornos" })
	;
	
	private String menu;
	private String[] elements;
	private String[] subMenu;

	MenusEnum(String menu, String[] elements, String[] subMenu) {
		this.menu = menu;
		this.elements = elements;
		this.subMenu = subMenu;
	}

	public String getMenu() {
		return menu;
	}

	public String[] getSubMenu() {
		return subMenu;
	}

	public String[] getElements() {
		return elements;
	}
	
}
