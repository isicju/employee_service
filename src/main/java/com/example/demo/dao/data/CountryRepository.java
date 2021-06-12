package com.example.demo.dao.data;

import com.example.demo.dao.orm.Countries;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository  extends CrudRepository<Countries, String> {
}
