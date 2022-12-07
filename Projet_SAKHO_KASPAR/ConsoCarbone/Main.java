public class Main{
    public static void main (String[] args){
        Logement log = new  Logement();
        Logement log1 = new Logement(20, CE.B);
        System.out.println("votre emprunte carbone logement de log est:" + log.impact+" TCO2 équivalente"); 
        System.out.println("votre emprunte carbone logement de log1 est:" + log1.impact+" TCO2 équivalente");
        System.out.println(log1.toString());
        Logement.impactL_Moy();
        Alimentation ali= new Alimentation ();
        Alimentation ali1= new Alimentation(0.5, 0.3);
        System.out.println("votre empreinte carbone pour ali est:" + ali.impact+" TCO2 équivalente");
        System.out.println("votre empreinte carbone pour ali1 est:" + ali1.impact+" TCO2 équivalente");
        System.out.println(ali1.toString());
        Alimentation.impactA_Moy();

        BienConso bc = new BienConso(7000);
        System.out.println("votre emprunte carbone bien consommation de bc est:" + bc.impact+" TCO2 équivalente"); 
        System.out.println(bc.toString());
        BienConso.impactBienC_Moy();

        Transport transp = new Transport(true, Taille.P , 3600, 20);
        System.out.println("votre emprunte carbone Transport de transp est:" + transp.impact+" TCO2 équivalente"); 
        System.out.println(transp.toString());
        Transport.impactT_Moy();

        Transport transp2 = new Transport(false, Taille.P, 0, 0);
        System.out.println("votre emprunte carbone Transport de trans2 est:" + transp2.impact+" TCO2 équivalente"); 
        System.out.println(transp2.toString());
        Transport.impactT_Moy();

        //test du polymorphisme
        Object bien_cons = new BienConso(7800); 
        //bien_cons est de type Object mais aussi de type BienConso. De plus,
        //comme BienConso hérite de la classe mère ConsoCarbone, bien_cons est aussi de type ConsoCarbone d'où le polymorphisme
        System.out.println("bien_cons instanceof Object: " + (bien_cons instanceof Object));
        System.out.println("bien_cons instanceof BienConso:" +(bien_cons instanceof BienConso));
        System.out.println("bien_cons instanceof ConsoCarbone : "+ (bien_cons instanceof ConsoCarbone));
        System.out.println(" bien_cons instanceof Logement: "+ (bien_cons instanceof Logement));
        
    }
}