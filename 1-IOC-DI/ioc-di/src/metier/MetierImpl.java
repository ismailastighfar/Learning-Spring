package metier;

import dao.IDao;

public class MetierImpl implements IMetier {

    private IDao dao;

    // injecter une variable dao un objet d'une classe qui implement l'interface IDao
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {

        double temp = dao.getData();
        double res = temp*Math.random();
        return res;
    }
}
