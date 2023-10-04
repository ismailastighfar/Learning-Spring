package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {

   // @Autowired
   // @Qualifier("dao" ou "ext")
    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

   /* public void setDao(IDao dao) {
        this.dao = dao;
    }
*/
    @Override
    public double calcul() {

        double temp = dao.getData();
        double res = temp*Math.random();
        return res;
    }
}
