package consoCarbone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class AlimentationTest {
	private Alimentation myAlimentation;
	
	@BeforeEach
	public void initAlimentation() {
		myAlimentation = new Alimentation(0,0);
	}
	
	@AfterEach
	public void undefAlimentation() {
		myAlimentation = null;
 	}
	
	//On ne fait pas les tests pour les constructeurs et les getters car ceux-ci ne devraient pas poser de problèmes
	
	@ParameterizedTest
	@CsvSource({"0.4,0.4","-1,0","2,0"})
	public void test_settxBoeuf_Alimentation_txBoeuf(double arg1,double arg2) {
		myAlimentation.set_txBoeuf(arg1);
		assertEquals(myAlimentation.get_txBoeuf(),arg2);
	}
	@ParameterizedTest
	@CsvSource({"0.4,0.4","-1,0","2,0"})
	public void test_settxVege_Alimentation_txVege(double arg1,double arg2) {
		myAlimentation = new Alimentation(arg1,arg2);
		myAlimentation.set_txVege(arg1);
		assertEquals(myAlimentation.get_txVege(),arg2);
	}
	@ParameterizedTest
	@CsvSource({"0.2,0.7,2.39","0.5,0.1,4.73","0.7,0.3,5.869999","0,0,1.6"})
	public void test_EmpreinteC_Alimentation_impact(double arg1,double arg2,double arg3) {
		myAlimentation = new Alimentation(arg1,arg2); //EmpreinteC est appelé par le constructeur
		assertEquals(myAlimentation.get_impact(), arg3,0.01);
	}
	
	@ParameterizedTest
	@CsvSource({"0.2,0.7","0,0"})
	public void test_toString_Alimentation_stringrepresentative(double arg1,double arg2) {
		myAlimentation.set_txBoeuf(arg1);
		myAlimentation.set_txVege(arg2);
		String s ="Alimentation [ ID: "+myAlimentation.get_id()+",  Taux Boeufs: "+myAlimentation.get_txBoeuf()+",  taux végetariens:"+myAlimentation.get_txVege()+",  Impact en TCO2:"+myAlimentation.get_impact()+" ]";
		assertEquals(s,myAlimentation.toString());
	}
	
}
