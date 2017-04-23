package Dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public interface BaseDao<T> {
    T get(Class<T> entityClass, Serializable id);
    Serializable save(T entity);
    void update(T entity);
    void delete(T entity);
    void delete(Class<T> entityClass,Serializable id);
    List<T> findall(Class<T> entityClass);
    List<T> find(String hql);
    long findCount(Class<T> entityClass);
}
