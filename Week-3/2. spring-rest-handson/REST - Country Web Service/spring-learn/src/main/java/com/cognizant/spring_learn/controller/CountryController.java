package com.cognizant.spring_learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.Country;

@RestController
public class CountryController {

	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@RequestMapping("/country")
	public Country getCountryIndia() {
		logger.info("Start - getCountryIndia() method");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("countryIN", Country.class);

		logger.info("End - getCountryIndia() method");
		return country;
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		logger.info("Start - getAllCountries() method");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = new ArrayList<>();
		countries.add((Country) context.getBean("countryIN", Country.class));
		countries.add((Country) context.getBean("countryUS", Country.class));
		countries.add((Country) context.getBean("countryJP", Country.class));
		countries.add((Country) context.getBean("countryDE", Country.class));

		logger.info("End - getAllCountries() method");
		return countries;
	}

}