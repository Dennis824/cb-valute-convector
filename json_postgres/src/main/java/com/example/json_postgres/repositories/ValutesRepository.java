package com.example.json_postgres.repositories;

import com.example.json_postgres.entities.Valute;
import org.springframework.data.repository.CrudRepository;

public interface ValutesRepository extends CrudRepository<Valute, Long> {
}
