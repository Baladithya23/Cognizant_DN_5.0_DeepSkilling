package com.cognizant.spring_learn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;

@Service
public class CountryService {

	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

	public Country getCountry(String code) {
		logger.info("Start - getCountry() method. code={}", code);

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country result = context.getBeansOfType(Country.class)
				.values()
				.stream()
				.filter(country -> country.getCode().equalsIgnoreCase(code))
				.findFirst()
				.orElse(null);

		logger.info("End - getCountry() method. Found={}", result != null);
		return result;
	}

}