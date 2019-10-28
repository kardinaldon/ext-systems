package services;

import dao.MainDataDao;
import entity.CurrencyData;
import entity.MainData;

import java.util.List;

public class DataService {
    private MainDataDao mainDataDao = new MainDataDao();

    public DataService() {
    }

    public MainData findUser(int id) {
        return mainDataDao.findById(id);
    }

    public void saveUser(MainData mainData) {
        mainDataDao.save(mainData);
    }

    public void deleteUser(MainData mainData) {
        mainDataDao.delete(mainData);
    }

    public void updateUser(MainData mainData) {
        mainDataDao.update(mainData);
    }

    public List<MainData> findAllMainData() {
        return mainDataDao.findAll();
    }

    public CurrencyData findAutoById(int id) {
        return mainDataDao.findCurrencyDataById(id);
    }
}
