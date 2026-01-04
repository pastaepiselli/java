package oggetti;

public class TestPersona {

	public static void main(String[] args) {
		
		Persona marco = new Persona("Marco", 25, 80);
		System.out.println(marco);
	
		
		
		// con attributi privati ritorna 
		
//		Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
//			The field Persona.nome is not visible
//			The field Persona.eta is not visible
//			The field Persona.peso is not visible
//
//			at oggetti.TestPersona.main(TestPersona.java:10)
		
//		System.out.println(marco.nome);
//		System.out.println(marco.eta);
//		System.out.println(marco.peso);
		
		System.out.println(marco.getNome());
		System.out.println(marco.getEta());
		System.out.println(marco.getPeso());
		System.out.println(marco.toString());
		
		marco.cresce();
		
		System.out.println(marco);
		
		marco.cresce(10);
		
		System.out.println(marco);
		}

}
