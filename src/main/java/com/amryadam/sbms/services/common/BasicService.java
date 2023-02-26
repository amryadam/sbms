package com.amryadam.sbms.services.common;

import java.util.List;

public interface BasicService<T> {

    void add(List<T> t);
    T add(T t);
    void delete(T t);
    void delete(Long id);

}
