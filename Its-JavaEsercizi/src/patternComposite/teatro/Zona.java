package patternComposite.teatro;

import java.util.ArrayList;
import java.util.List;

// leaf
public class Zona extends SettoreComponent {
	private List<Posto> posti;
	
	public Zona(String id) {
		super(id);
		this.posti = new ArrayList<Posto>();
	
	}

	public Zona(String id, List<Posto> posti) {
		super(id);
		this.posti = posti;
	}

	public List<Posto> getPosti() {
		return posti;
	}

	public void setPosti(List<Posto> posti) {
		this.posti = posti;
	}

	@Override
	public void add(SettoreComponent sc) throws ZonaException {
		if (this instanceof Zona) {
			throw new ZonaException("La zona non puo aggiungere settori o zone");
		}
		
	}

	@Override
	public void remove(SettoreComponent sc) throws ZonaException {
		if (this instanceof Zona) {
			throw new ZonaException("La zona non puo rimuovere settori o zone");
		}
	}
	
	public void addPosto(Posto p) {
		posti.add(p);
	}
	
	public void removePosto(Posto p) {
		posti.remove(p);
	}

	@Override
	public String toString() {
		return "Zona [posti=" + posti + "]";
	}
	
	
	
	
	


	
	
	
}
