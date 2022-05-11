import aeroport.Aeroport;
import aeroport.Compagnie;
import aeroport.Vol;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Start {

    public static void main(String[] args){
        /*Vol volFinal = new Vol();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String dd = "21/10/2020 13:00";
        String da = "23/10/2020 02:15";

        try {
            volFinal.setDateDepart(format.parse(dd));
            volFinal.setDateArrivee(format.parse(da));
        } catch (Exception e){
            throw new RuntimeException("Unable to format to date");
        }

        System.out.println(volFinal.getDateArrivee());
        System.out.println(volFinal.obtenirDuree().toString().substring(2));






        //Bidirectional
        Vol vol = new Vol();
        vol.setNumero("abc1");

        Vol vol2 = new Vol();
        vol2.setNumero("abc2");

        Compagnie compagnie = new Compagnie();
        compagnie.setName("Air France");
        compagnie.addVol(vol);
        compagnie.addVol(vol2);

        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }

        System.out.println(vol.getCompagnie().getName());
        System.out.println(vol2.getCompagnie().getName());

        vol2.setCompagnie(null);
        System.out.println(vol2.getCompagnie());

        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }*/

        Date dd = new Date(2022, 4, 22, 6, 45);
        Date da = new Date(2022, 4, 22, 7, 45);
        Date d3 = da;

        Aeroport a1 = new Aeroport("Orly");
        Aeroport a2 = new Aeroport("Carthage");

        Compagnie c1 = new Compagnie("Air France");

        Vol v1 = new Vol("AF144", a1, a2, dd, da);
        /*v1.setDateArrivee(da);
        v1.setDateDepart(dd);*/

        System.out.println(v1.getDateDepart().toString());


    }
}
