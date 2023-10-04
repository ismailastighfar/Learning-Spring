package presentation;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.IMetier;
import metier.MetierImpl;

public class Presentation {

    public static void main(String[] args) {

         /*
        Injection des dépendances par
        instanciation statique => new (couplge fort)
        */

        DaoImpl2 dao = new DaoImpl2();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println(metier.calcul());
    }
}
