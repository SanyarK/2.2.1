package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {

   Session getSession();
   void add(User user);
   List<User> listUsers();

   void addCar(Car car);

   List<Car> listCars();
   User getCarFromModelsAndSeries(String model, int series);

}
