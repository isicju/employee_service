package com.example.demo.dao.orm;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class JpaDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Countries> findAll() {
        try {
            List<Countries> countries = entityManager.createQuery("SELECT c FROM Countries c").getResultList();
//            List<Departments> departments = entityManager.createQuery("SELECT d FROM Departments d").getResultList();
//            List<Employees> employees = entityManager.createQuery("SELECT e FROM Employees e").getResultList();
//            List<Locations> locations = entityManager.createQuery("SELECT l FROM Locations l").getResultList();
            return countries;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Countries getCountryByName(Countries countries) {
        Query selectCountryQuery = entityManager.createQuery("SELECT c FROM Countries c WHERE c.countryName = :countryName");
        selectCountryQuery.setParameter("countryName", countries.getCountryName());
        return (Countries) selectCountryQuery.getSingleResult();
    }

    @Transactional
    public Countries addNewCountry(Countries countries) {
        try {
            entityManager.persist(countries);
            return countries;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


}
