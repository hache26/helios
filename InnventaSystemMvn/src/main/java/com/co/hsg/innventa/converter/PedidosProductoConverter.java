package com.co.hsg.innventa.converter;

import com.co.hsg.innventa.beans.PedidosProducto;
import com.co.hsg.innventa.session.PedidosProductoFacade;
import com.co.hsg.innventa.backing.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;


@Named(value = "pedidosProductoConverter")
@RequestScoped
public class PedidosProductoConverter implements Converter {

    @Inject
    private PedidosProductoFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    java.lang.String getKey(String value) {
        java.lang.String key;
        key = value;
        return key;
    }

    String getStringKey(java.lang.String value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof PedidosProducto) {
            PedidosProducto o = (PedidosProducto) object;
            return o.getId();
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PedidosProducto.class.getName()});
            return null;
        }
    }

}
