package com.init.lugares.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.init.lugares.entitys.Lugares;

public interface LugaresDAO extends JpaRepository<Lugares , Long> {

}
