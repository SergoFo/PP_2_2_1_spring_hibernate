package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    private Long id;  // Обратите внимание, что не используется @GeneratedValue // Будет совпадать с ID пользователя

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @MapsId // Указывает, что ID автомобиля должен быть скопирован из ID пользователя
    @OneToOne(mappedBy = "car", fetch = FetchType.LAZY)
    private User user;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    // Конструкторы, геттеры и сеттеры
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car[model=" + model + ", series=" + series + "]";
    }
}