package compositeTeatro;

// component
public abstract class SettoreComponent {
	
	private String id;
	
	public SettoreComponent(String id) {
		this.id = id;
	}

	public void add(SettoreComponent sc) throws ZonaException {};
	public void remove(SettoreComponent sc) throws ZonaException {};
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SettoreComponent [id=" + id + "]";
	}
	
	

	
	
	
	
	
}
