package compositeTeatro;

public class Main {

	public static void main(String[] args) {
		SottoSettoreComposite sc = new SottoSettoreComposite("S1");
		SottoSettoreComposite sc2 = new SottoSettoreComposite("S2");
		sc2.add(new Zona("Z5"));
		Zona z = new Zona("Z6");
		z.addPosto(new Posto('A', 1));
		sc2.add(z);
		sc2.add(new Zona("Z7"));
		
		sc.add(new Zona("Z1"));
		sc.add(new Zona("Z2"));
		sc.add(new Zona("Z3"));
		sc.add(new Zona("Z4"));
		sc.add(sc2);
		
		System.out.println(sc);
	}

}
