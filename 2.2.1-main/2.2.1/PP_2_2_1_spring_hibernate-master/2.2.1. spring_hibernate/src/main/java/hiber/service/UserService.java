package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    void addCar(Car car);

    List<Car> listCars();

    User getCarFromModelsAndSeries(String model, int series);
}
