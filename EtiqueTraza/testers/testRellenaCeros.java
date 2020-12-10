package testers;
import auxiliares.RellenarCeros;

public class testRellenaCeros {
	static RellenarCeros llena=new RellenarCeros();
	
	public static void main(String[] args) {
		System.out.println(llena.llenar("GUILLE",10,"I"));
		System.out.println(llena.llenar("GUILLE",10,"D"));

	}

}
