package com.parking.parkinglot.ejb;

import java.util.ArrayList;
import java.util.List;

import com.parking.parkinglot.entities.User;
import common.UserDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.logging.Logger;

@Stateless
public class UserBean {

  private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

  @PersistenceContext
  EntityManager entityManager;

  public List<UserDto> findAllUsers() {
    LOG.info("findAllUsers");

    try {
      TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
      List<User> users = typedQuery.getResultList();
      return copyUsersToDto(users);
    } catch (Exception ex) {
      throw new EJBException(ex);
    }
  }

  private List<UserDto> copyUsersToDto(List<User> users) {
    List<UserDto> dto = new ArrayList<>();
    for (User user : users) {
      UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getEmail());
      dto.add(userDto);
    }

    return dto;
  }
}
