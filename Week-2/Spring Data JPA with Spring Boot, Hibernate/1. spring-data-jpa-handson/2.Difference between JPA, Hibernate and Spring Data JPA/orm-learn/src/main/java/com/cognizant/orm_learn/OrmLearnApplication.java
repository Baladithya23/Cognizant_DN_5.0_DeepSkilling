package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        testGetCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testGetCountriesByPartialName();
        testDeleteCountry();
    }

    private static void testGetAllCountries() {
        LOGGER.info("testGetAllCountries Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries={}", countries.size());
        LOGGER.info("testGetAllCountries End");
    }

    private static void testGetCountryByCode() {
        LOGGER.info("testGetCountryByCode Start");
        Country country = countryService.getCountryByCode("IN");
        LOGGER.debug("country={}", country);
        LOGGER.info("testGetCountryByCode End");
    }

    private static void testAddCountry() {
        LOGGER.info("testAddCountry Start");
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Test Country");
        Country saved = countryService.addCountry(country);
        LOGGER.debug("saved={}", saved);
        LOGGER.info("testAddCountry End");
    }

    private static void testUpdateCountry() {
        LOGGER.info("testUpdateCountry Start");
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Test Country Updated");
        Country updated = countryService.updateCountry(country);
        LOGGER.debug("updated={}", updated);
        LOGGER.info("testUpdateCountry End");
    }

    private static void testGetCountriesByPartialName() {
        LOGGER.info("testGetCountriesByPartialName Start");
        List<Country> countries = countryService.getCountriesByPartialName("Stat");
        LOGGER.debug("matched countries={}", countries);
        LOGGER.info("testGetCountriesByPartialName End");
    }

    private static void testDeleteCountry() {
        LOGGER.info("testDeleteCountry Start");
        countryService.deleteCountry("ZZ");
        LOGGER.info("testDeleteCountry End");
    }
}