package ripasso;

public  class Sottoclasse extends SuperClasse implements FacciaIntera  {

	public Sottoclasse(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}
	
	public int caca() {
		return 1;
	}
	
	public void metodoEsclusivo() {
		System.out.println("yay");
	}

	@Override
	public int pipi() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
	
}
