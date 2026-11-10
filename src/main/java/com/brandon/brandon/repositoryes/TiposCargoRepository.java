package com.brandon.brandon.repositoryes;

import com.brandon.brandon.models.TiposCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposCargoRepository extends JpaRepository<TiposCargo, Byte> {
}