package vishal.benotest.models;

import com.google.gson.annotations.SerializedName;

public class Property {

	@SerializedName("city")
	private String city;

	@SerializedName("reviewCount")
	private int reviewCount;

	@SerializedName("price")
	private float price;

	@SerializedName("name")
	private String name;

	@SerializedName("landmark")
	private String landmark;

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setReviewCount(int reviewCount){
		this.reviewCount = reviewCount;
	}

	public int getReviewCount(){
		return reviewCount;
	}

	public void setPrice(float price){
		this.price = price;
	}

	public float getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLandmark(String landmark){
		this.landmark = landmark;
	}

	public String getLandmark(){
		return landmark;
	}

	@Override
 	public String toString(){
		return 
			"PropertyListingItem{" + 
			"city = '" + city + '\'' + 
			",reviewCount = '" + reviewCount + '\'' + 
			",price = '" + price + '\'' + 
			",name = '" + name + '\'' + 
			",landmark = '" + landmark + '\'' + 
			"}";
		}
}