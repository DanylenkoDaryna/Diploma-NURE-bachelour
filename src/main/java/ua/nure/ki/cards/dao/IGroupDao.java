package ua.nure.ki.cards.dao;

import java.io.Serializable;
import java.util.List;

public interface IGroupDao <T, Id extends Serializable> {

    //  public void persist(T entity);

    public T findById(Id id);

    public List<T> findAll();

}