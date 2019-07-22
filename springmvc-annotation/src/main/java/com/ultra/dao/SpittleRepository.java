package com.ultra.dao;

import java.util.List;

import com.ultra.dao.entity.Spittle;

public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);
}
