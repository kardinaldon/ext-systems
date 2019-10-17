package dao;

import entity.CurrencyData;
import entity.MainData;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class MainDataDao {
    public MainData findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(MainData.class, id);
    }

    public void save(MainData mainData) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(mainData);
        tx1.commit();
        session.close();
    }

    public void update(MainData mainData) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(mainData);
        tx1.commit();
        session.close();
    }

    public void delete(MainData mainData) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(mainData);
        tx1.commit();
        session.close();
    }

    public CurrencyData findCurrencyDataById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(CurrencyData.class, id);
    }

    public List<MainData> findAll() {
        List<MainData> mainData = (List<MainData>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From entity.MainData").list();
        return mainData;
    }
}
