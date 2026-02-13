package lambda;

public class CriterioColoreVerde implements Criterio {

	@Override
	public boolean test(Mela mela) {
		if (mela.getColore().equals("Verde")) 
			return true;
		return false;
	}

}
