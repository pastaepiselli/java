package strategy;

import java.time.LocalDate;
import java.time.Month;

// class factory :P
public class PeriodoSconto {
	// static cosi che non devo istanziare per chiamare questo metodo
	public static Sconto getSconto(LocalDate dataAcquisto) {
		// blackfriday 25 novembre penso
		if (dataAcquisto.getMonth() == Month.NOVEMBER && dataAcquisto.getDayOfMonth() == 25) {
			return new ScontoBlackFriday();
		}
		
		// saldi invernali dicembre - gennaio??
		if (dataAcquisto.getMonth() == Month.JANUARY || dataAcquisto.getMonth() == Month.DECEMBER) {
			return new ScontoSaldiInvernali();
		}
		
		// saldi estivi luglio - agosto
		if (dataAcquisto.getMonth() == Month.JULY || dataAcquisto.getMonth() == Month.AUGUST) {
			return new ScontoSaldiEstivi();
		}
		// se il periodo non concide
		return null;
	}
}
