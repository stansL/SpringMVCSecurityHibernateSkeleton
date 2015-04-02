package ke.co.greid.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

import ke.co.greid.entities.Religion;
import ke.co.greid.services.ReligionService;
import ke.co.greid.utils.JsfUtil;

@ManagedBean
public class ReligionController {
	
	@ManagedProperty("#{religionService}")
	private ReligionService religionService;
	private List<Religion> religions;

	public ReligionService getReligionService() {
		return religionService;
	}

	public void setReligionService(ReligionService religionService) {
		this.religionService = religionService;
	}

	public List<Religion> getReligions() {
		return religions;
	}

	public void setReligions(List<Religion> religions) {
		this.religions = religions;
	}

	@PostConstruct
	public void init() {
		religions = religionService.getReligions();
	}
	public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(religions, true);
    }
	
	@FacesConverter(forClass = Religion.class)
    public static class ReligionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ReligionController controller = (ReligionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "religionController");
            return controller.getReligion(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Religion) {
                Religion o = (Religion) object;
                return getStringKey(o.getReligionId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Religion.class.getName());
            }
        }

    }

	public Object getReligion(Integer key) {
		return religionService.getReligion(key);
	}

}
