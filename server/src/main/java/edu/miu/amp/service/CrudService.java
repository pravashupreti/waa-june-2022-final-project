package edu.miu.amp.service;

import java.util.List;

public interface CrudService<T,R,ID> {

    R save(T t);

    List<R> findAll();

    R findById(ID id);

    R update(T t, ID id);

    void deleteById(ID id);

}
