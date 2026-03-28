package patternComposite.teatro;

import java.util.ArrayList;
import java.util.List;

// composite
public class SottoSettoreComposite extends SettoreComponent {
	private List<SettoreComponent> contiene;
	
	public SottoSettoreComposite(String id) {
		super(id);
		contiene = new ArrayList<SettoreComponent>();
	}
	
	
	public SottoSettoreComposite(String id, List<SettoreComponent> contiene) {
		super(id);
		this.contiene = contiene;
		
	}
	
	@Override
	public void add(SettoreComponent sc) {
		this.contiene.add(sc);
	}
	
	@Override
	public void remove(SettoreComponent sc) {
		contiene.remove(sc);
	}
	
	public List<SettoreComponent> getContiene() {
		return contiene;
	}


	public void setContiene(List<SettoreComponent> contiene) {
		this.contiene = contiene;
	}


	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    
	    for (SettoreComponent sc : contiene) {
	        sb.append("    ").append(sc).append("\n");
	    }
	    
	    return "SettoreId: " + this.getId() + "\n" + sb.toString();
	}
	
	
	
	

}
