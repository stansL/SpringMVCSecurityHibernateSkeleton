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

import ke.co.greid.entities.MaritalStatus;
import ke.co.greid.services.MaritalStatusService;
import ke.co.greid.utils.JsfUtil;

@ManagedBean
public class MaritalStatusController {
	@ManagedProperty("#{maritalStatusService}")
	private MaritalStatusService maritalStatusService;
	private List<MaritalStatus> maritalStatusList;

	public MaritalStatusService getMaritalStatusService() {
		return maritalStatusService;
	}

	public void setMaritalStatusService(
			MaritalStatusService maritalStatusService) {
		this.maritalStatusService = maritalStatusService;
	}

	public List<MaritalStatus> getMaritalStatus() {
		return maritalStatusList;
	}

	public void setMaritalStatus(List<MaritalStatus> maritalStatusList) {
		this.maritalStatusList = maritalStatusList;
	}

	@PostConstruct
	public void init() {
		maritalStatusList = maritalStatusService.getMaritalStatuses();
	}

	public SelectItem[] getItemsAvailableSelectOne() {
		return JsfUtil.getSelectItems(maritalStatusList, true);
	}

	@FacesConverter(forClass = MaritalStatus.class)
	public static class MaritalStatusControllerConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext facesContext,
				UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			MaritalStatusController controller = (MaritalStatusController) facesContext
					.getApplication()
					.getELResolver()
					.getValue(facesContext.getELContext(), null,
							"maritalStatusController");
			return controller.getMaritalStatus(getKey(value));
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
			if (object instanceof MaritalStatus) {
				MaritalStatus o = (MaritalStatus) object;
				return getStringKey(o.getMaritalStatusId());
			} else {
				throw new IllegalArgumentException("object " + object
						+ " is of type " + object.getClass().getName()
						+ "; expected type: " + MaritalStatus.class.getName());
			}
		}

	}

	public Object getMaritalStatus(Integer key) {
		
		return maritalStatusService.getMaritalStatus(key);
	}

}
