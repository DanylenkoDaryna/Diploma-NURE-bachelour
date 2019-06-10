package ua.nure.ki.cards.dao;

import java.io.Serializable;
import java.util.List;

public interface IUserDao <T, Id extends Integer> {

//  public void persist(T entity);

public T findById(Id id);

public List<T> findAll();

        }