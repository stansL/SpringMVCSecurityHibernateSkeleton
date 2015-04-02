package ke.co.greid.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;

import ke.co.greid.entities.Authorities;
import ke.co.greid.services.AuthoritiesService;
import ke.co.greid.utils.JsfUtil;

@ManagedBean
public class AuthoritiesController implements Serializable {

	private static final long serialVersionUID = 3819509111113244097L;
	@ManagedProperty("#{authoritiesService}")
	private static AuthoritiesService authoritiesService;
	private List<Authorities> authorities;

	public AuthoritiesService getAuthoritiesService() {
		return authoritiesService;
	}

	public void setAuthoritiesService(AuthoritiesService authoritiesService) {
		AuthoritiesController.authoritiesService = authoritiesService;
	}

	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}

	@PostConstruct
	public void init() {
		authorities = authoritiesService.getAuthorities();
	}

	public SelectItem[] getItemsAvailableSelectOne() {
		return JsfUtil.getSelectItems(authorities, true);
	}

	public SelectItem[] getItemsAvailableSelectMany() {
		return JsfUtil.getSelectItems(authorities, false);
	}

	@FacesConverter(forClass = Authorities.class)
	public static class AuthoritiesControllerConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext facesContext,
				UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			AuthoritiesController controller = (AuthoritiesController) facesContext
					.getApplication()
					.getELResolver()
					.getValue(facesContext.getELContext(), null,
							"authoritiesController");
			return controller.getAuthorities(getKey(value));
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
		public String getAsString(FacesContext facesContext,
				UIComponent component, Object object) {
			if (object == null) {
				return null;
			}
			if (object instanceof Authorities) {
				Authorities o = (Authorities) object;
				return getStringKey(o.getId());
			} else {
				throw new IllegalArgumentException("object " + object
						+ " is of type " + object.getClass().getName()
						+ "; expected type: " + Authorities.class.getName());
			}
		}

	}

	public Object getAuthorities(Integer key) {
		return authoritiesService.getAuthority(key);
	}

}
