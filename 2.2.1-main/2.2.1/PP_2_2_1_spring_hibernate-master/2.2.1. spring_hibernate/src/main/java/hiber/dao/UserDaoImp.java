package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   private SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }


   @Override
   public Session getSession() {
      return sessionFactory.openSession();
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void addCar(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<Car> listCars() {
      TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getCarFromModelsAndSeries(String model, int series) {
      try (Session session = sessionFactory.getCurrentSession()) {
         String HQL = "FROM User user WHERE user.car.model=:model_car and  user.car.series=:series_car"; //FROM Car car WHERE car.model=:model_car and  car.series=:series_car
         TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(HQL);
         query.setParameter("model_car", model).setParameter("series_car", series);
         return query.setMaxResults(1).getSingleResult();
      }
   }
}
