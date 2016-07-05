package com.co.hsg.innventa.backing;

/**
 *
 * @author Hector Sanchez Garcia
 */
public enum Modules {
    ORDERS("pedidos", "warning"),PURCHASE_ORDERS("remisiones", "primary"),
    ACCOUNTS("cuentas","info"), PRODUCTS("productos","success"),
    THIRDS("terceros","danger"),USERS("usuarios","info"),MASTERS("maestros","info"),
    STATES_OC("estadosOC","info"),STATES_RM("estadosRM","info"),
    CATEGORIES_PROD("categoriasProd","info"),CONFIGURATION("configuracion","info"),
    INIT("inicio","primary"), 
    CREATE_ORDER("pedidosCreate","primary"),
    CREATE_PURCHASE_ORDERS("remisionesProducto","primary")
    ;
   
    private String moduleName;
    private String moduleType;
    
    Modules(String moduleName, String moduleType){
        this.moduleName = moduleName;
        this.moduleType = moduleType;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getModuleType() {
        return moduleType;
    }
    
    
    public static Modules getModule(String module){
       for (Modules m : Modules.values()){
           if(m.moduleName.toUpperCase().equals(module.toUpperCase())){
               return m;
           }
       }
       return INIT;
    }
}
