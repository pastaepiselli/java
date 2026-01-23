package interfacce;

public class Cane extends Terrestre{

	@Override
	public String verso() {
		// TODO Auto-generated method stub
		return "Bau, Bau";
	}
	
	@Override
	public String toString() {
		return super.toString() + ", specie: cane";
	}
	
}
