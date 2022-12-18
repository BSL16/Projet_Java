package consoCarbone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class BienConsoTest {
	private BienConso myBienConso;
	
	@BeforeEach
	public void initAlimentation() {
		myBienConso = new BienConso(0);
	}
	
	@AfterEach
	public void undefAlimentation() {
		myBienConso = null;
 	}
	
	//On ne fait pas les tests pour les constructeurs et les getters car ceux-ci ne devraient pas poser de problèmes

	@ParameterizedTest
	@CsvSource({"5000,5000","300,300","-2,0","0,0"})
	public void test_setmontant_BienConso_montant(double arg1,double arg2) {
		myBienConso.set_montant(arg1);
		assertEquals(myBienConso.get_montant(),arg2);
	}
	
	@ParameterizedTest
	@CsvSource({"20003.9,11.43","3000.8,1.71","0,0.0","3,0.0017"})
	public void test_EmpreinteC_BienConso_impact(double arg1,double arg2) {
		myBienConso.set_montant(arg1);
		assertEquals(myBienConso.get_impact(), arg2,0.1);
	}
	
	@ParameterizedTest
	@CsvSource({"20,3","30,8","0","10000"})
	public void test_toString_BienConso_stringrepresentative(double arg1) {
		myBienConso.set_montant(arg1);
		String s ="Bien Consommation [ ID: "+myBienConso.get_id()+",  Montant dépenses/an: "+myBienConso.get_montant()+",  Impact en TCO2:"+myBienConso.get_impact()+" ]";
		assertEquals(s,myBienConso.toString());
	}
	

}
