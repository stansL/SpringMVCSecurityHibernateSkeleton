package ke.co.greid.utils;

import java.util.List;

import javax.faces.model.SelectItem;

public class JsfUtil {
	
	
	 public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
	        int size = selectOne ? entities.size() + 1 : entities.size();
	        SelectItem[] items = new SelectItem[size];
	        int i = 0;
	        if (selectOne) {
	            items[0] = new SelectItem("", "---");
	            i++;
	        }
	        for (Object x : entities) {
	            items[i++] = new SelectItem(x, x.toString());
	        }
	        return items;
	    }

}
