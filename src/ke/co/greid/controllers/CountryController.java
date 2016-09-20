package ke.co.greid.controllers;

import ke.co.greid.entities.Country;
import ke.co.greid.services.CountryService;
import ke.co.greid.utils.JsfUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean
public class CountryController {
	
	
	@ManagedProperty("#{countryService}")
	private CountryService countryService;
	private List<Country> countries;

	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	@PostConstruct
	public void init() {
		countries = countryService.getCountries();
	}
	
	public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(countries, true);
    }
	
	@FacesConverter(forClass = Country.class)
    public static class CountryControllerConverter implements Converter {
		private Logger logy=Logger.getLogger(CountryControllerConverter.class.toString());

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CountryController controller = (CountryController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "countryController");
            
            logy.info(controller.getCountry(getKey(value))+"");
            return controller.getCountry(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Country) {
                Country o = (Country) object;
                return getStringKey(o.getCountryCode());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Country.class.getName());
            }
        }

    }

	public Object getCountry(String key) {
		return countryService.getCountry(key);
	}

}
