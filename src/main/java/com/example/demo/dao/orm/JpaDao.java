package com.example.demo.dao.orm;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Log4j2
@Repository
public class JpaDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Countries> findAll() {
        try {
            return entityManager.createQuery("SELECT c FROM Countries c").getResultList();
//            List<Departments> departments = entityManager.createQuery("SELECT d FROM Departments d").getResultList();
//            List<Employees> employees = entityManager.createQuery("SELECT e FROM Employees e").getResultList();
//            List<Locations> locations = entityManager.createQuery("SELECT l FROM Locations l").getResultList();
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    public Countries getCountryByName(String countryName) {
        Query selectCountryQuery = entityManager.createQuery("SELECT c FROM Countries c WHERE c.countryName = :countryName");
        selectCountryQuery.setParameter("countryName", countryName);
        return (Countries) selectCountryQuery.getSingleResult();
    }

    @Transactional
    public Countries addNewCountry(Countries countries) {
        try {
            entityManager.persist(countries);
            return countries;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    @Transactional
    public Countries removeCountry(Countries countries) {
        try {
            entityManager.remove(entityManager.find(Countries.class, countries.getCountryId()));
            return countries;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    public Countries getCountryById(String id) {
        try {
            return entityManager.find(Countries.class, id);
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }


}
