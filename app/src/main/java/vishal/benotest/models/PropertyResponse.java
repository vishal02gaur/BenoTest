package vishal.benotest.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PropertyResponse {

	@SerializedName("propertyListing")
	private List<Property> propertyListing;

	public void setPropertyListing(List<Property> propertyListing){
		this.propertyListing = propertyListing;
	}

	public List<Property> getPropertyListing(){
		return propertyListing;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"propertyListing = '" + propertyListing + '\'' + 
			"}";
		}
}