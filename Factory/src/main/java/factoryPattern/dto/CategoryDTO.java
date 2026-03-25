package factoryPattern.dto;

public class CategoryDTO {
	private  int idCategory;
	private String description;
	
	public CategoryDTO() {
	}

	public CategoryDTO(int idCategory, String description) {
		super();
		this.idCategory = idCategory;
		this.description = description;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
