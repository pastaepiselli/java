package laBanca;

import java.util.HashMap;


public class Banca {
	
	// chiave = coordinate / valore = saldo
	HashMap<Integer, Integer> conti = new HashMap<Integer, Integer>();
	
	public Banca() {
		// creo 10 conti
		for (int i = 1; i <= 10; i++) {
			conti.put(i, 5000);
		}
	}
	synchronized void bonifico(int ccOrdinante, int ccBeneficiario, int importo) throws ImportoNonValidoException {
		// se si sta provando a fare bonifico a se stesso
		if (ccBeneficiario == ccOrdinante) { 
			return;
		}
		// entrambi i conti esistono nella banca
		if(conti.containsKey(ccOrdinante) && conti.containsKey(ccBeneficiario)){
			
			
			
			// trasferisco i soldi
			while (conti.get(ccOrdinante) < importo) { // se non ha soldi disponibili
//				throw new ImportoNonValidoException("Non hai quei soldi!! "
//						+ "\n Tuo conto: " + soldiOrdinante
//						+ "\n Il soldi che volevi inviare: "+ importo);
				try {
					// non ci sono fondi sufficienti: il thread si sospende
	                // e rilascia il lock, permettendo ad altri di depositare
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			} 
			
			// ottengo i soldi dei 2
						int soldiOrdinante = conti.get(ccOrdinante);
						int soldiBeneficiariio = conti.get(ccBeneficiario);
				
			// se ci sono i soldi :P
			conti.put(ccOrdinante, soldiOrdinante - importo);
			conti.put(ccBeneficiario, soldiBeneficiariio + importo);
			// sveglio tutti i thread in attesa: qualcuno potrebbe ora avere fondi
			notifyAll();
			
			
		} 
	}
	synchronized int getPatrimonio() {
		int sum = 0;
		// ciclo per i valori (patrimonio di ogni conto)
		for (int s : conti.values()) {
			sum += s;
		}
		return sum;
	}
}
