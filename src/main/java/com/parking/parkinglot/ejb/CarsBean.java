package com.parking.parkinglot.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.entities.User;
import common.CarDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.logging.Logger;

@Stateless
public class CarsBean {

    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars() {
        {
            LOG.info("findAllCars");

            try {
                TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
                List<Car> cars = typedQuery.getResultList();
                return copyCarsToDto(cars);
            } catch (Exception ex) {
                throw new EJBException(ex);
            }
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> dto = new ArrayList<>();
        for (Car car : cars) {
            CarDto carDto = new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getUsername());
            dto.add(carDto);
        }

        return dto;
    }


    public CarDto findById(Long carId) {
        LOG.info("findById");

        try {
            Car car = entityManager.find(Car.class, carId);

            if (car == null) {
                return null;
            }
            return new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getUsername());
        } catch (Exception ex) {
            throw new EJBException("Error finding car by ID", ex);
        }
    }


    public void createCar(String licensePlate, String parkingSpot, Long userId) {

        LOG.info("createCar");
        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User user = entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);

        entityManager.persist(car);
    }

    public void updateCar(Long carId, String licensePlate, String parkingSpot, Long userId) {
        LOG.info("updateCar");
        Car car = entityManager.find(Car.class, carId);
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User oldUser = car.getOwner();
        oldUser.getCars().remove(car);

        User user = entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);
    }

    public void deleteCarsByIds(Collection<Long> carIds) {
        LOG.info("deleteCarsByIds");

        for (Long carId : carIds) {
            Car car = entityManager.find(Car.class, carId);
            entityManager.remove(car);
        }
    }
}
