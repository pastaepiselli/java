package cartoleria;

public class Main {

	public static void main(String[] args) {
		Penna pn1 = new Penna("Platinum 3776" ,"Stilografica", 180.00, "Nero");
		Penna pn2 = new Penna("Lamy 2000", "Roller", 22.50, "Blu");
		Gomma gm1 = new Gomma("Milan", "430", 0.60, "2,8 x 2,8 x 1,3 centimetri", "Rettangolare");
		Gomma gm2 = new Gomma("Faber-Castle", "Dust Free", 1.10, "6,2 x 2,8 x 1,2 centimetri", "Rettangolare");
		
		Magazzino magazzino = new Magazzino();
		
		magazzino.CaricaArticolo(pn1);
		magazzino.CaricaArticolo(pn2);
		magazzino.CaricaArticolo(gm1);
		magazzino.CaricaArticolo(gm2);
		
		magazzino.StampaArticoli();
		
		magazzino.StampaCostiTotali();
		
		magazzino.StampaRicaviTotali();
		
		
		magazzino.rimuoviArticolo(gm2);
		
		magazzino.StampaArticoli();
		
		magazzino.cercaPerMarca("milan");
		magazzino.cercaPerMarca("pier");
		
		magazzino.cercaPerModello("Roller");
		magazzino.cercaPerModello("popa");
	
		
		
	}

}
