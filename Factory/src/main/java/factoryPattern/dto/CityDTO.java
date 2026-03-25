package factoryPattern.dto;

public class CityDTO {
	private String cityName;
	private String region;
	
	public CityDTO() {
	}
	
	public CityDTO(String cityName, String region) {
		super();
		this.cityName = cityName;
		this.region = region;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
}
