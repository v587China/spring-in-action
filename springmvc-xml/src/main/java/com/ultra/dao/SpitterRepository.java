package com.ultra.dao;

import com.ultra.dao.entity.Spitter;

public interface SpitterRepository {

    void save(Spitter spitter);

    Spitter findByUsername(String username);
}
