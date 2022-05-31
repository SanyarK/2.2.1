package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "Car_table")
public class Car {

    @OneToOne(mappedBy = "car")
    private User carOwner;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_car")
    String model;

    @Column(name = "series_car")
    int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

     }

    public User getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(User carOwner) {
        this.carOwner = carOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carOwner=" + carOwner.toString() +
                ", id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
