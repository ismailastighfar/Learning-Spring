package ext;

import dao.IDao;

public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("version 2");
        double temp = 5000;
        return temp;
    }
}
