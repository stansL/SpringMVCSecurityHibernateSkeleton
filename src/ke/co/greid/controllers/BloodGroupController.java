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

import ke.co.greid.entities.BloodGroup;
import ke.co.greid.services.BloodGroupService;
import ke.co.greid.utils.JsfUtil;

@ManagedBean
public class BloodGroupController {
	@ManagedProperty("#{bloodGroupService}")
	private BloodGroupService bloodGroupService;
	private List<BloodGroup> bloodGroups;

	public BloodGroupService getBloodGroupService() {
		return bloodGroupService;
	}

	public void setBloodGroupService(BloodGroupService bloodGroupService) {
		this.bloodGroupService = bloodGroupService;
	}

	public List<BloodGroup> getBloodGroups() {
		return bloodGroups;
	}

	public void setBloodGroups(List<BloodGroup> bloodGroups) {
		this.bloodGroups = bloodGroups;
	}

	@PostConstruct
	public void init() {
		bloodGroups = bloodGroupService.getBloodGroups();
	}

	public SelectItem[] getItemsAvailableSelectOne() {
		return JsfUtil.getSelectItems(bloodGroups, true);
	}

	@FacesConverter(forClass = BloodGroup.class)
	public static class BloodGroupControllerConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext facesContext,
				UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			BloodGroupController controller = (BloodGroupController) facesContext
					.getApplication()
					.getELResolver()
					.getValue(facesContext.getELContext(), null,
							"bloodGroupController");
			return controller.getBloodGroup(getKey(value));
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
			if (object instanceof BloodGroup) {
				BloodGroup o = (BloodGroup) object;
				return getStringKey(o.getBloodGroupId());
			} else {
				throw new IllegalArgumentException("object " + object
						+ " is of type " + object.getClass().getName()
						+ "; expected type: " + BloodGroup.class.getName());
			}
		}

	}

	public BloodGroup getBloodGroup(Integer key) {
		return bloodGroupService.getBloodGroup(key);
	}

}
