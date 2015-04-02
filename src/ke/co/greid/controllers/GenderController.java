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

import ke.co.greid.entities.Gender;
import ke.co.greid.services.GenderService;
import ke.co.greid.utils.JsfUtil;

@ManagedBean
public class GenderController {
	@ManagedProperty("#{genderService}")
	private GenderService genderService;
	private List<Gender> genders;

	public GenderService getGenderService() {
		return genderService;
	}

	public void setGenderService(GenderService genderService) {
		this.genderService = genderService;
	}

	public List<Gender> getGenders() {
		return genders;
	}

	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}
	
	@PostConstruct
	public void init(){
		genders=genderService.getGenders();
	}
	public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(genders, true);
    }
	
	@FacesConverter(forClass = Gender.class)
    public static class GenderControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GenderController controller = (GenderController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "genderController");
            return controller.getGender(getKey(value));
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
            if (object instanceof Gender) {
                Gender o = (Gender) object;
                return getStringKey(o.getGenderId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Gender.class.getName());
            }
        }

    }

	public Object getGender(Integer key) {
		return genderService.getGender(key);
	}


}
