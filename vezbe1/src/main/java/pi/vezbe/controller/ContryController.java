package pi.vezbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.model.Country;
import pi.vezbe.service.CountryService;

@RestController
@RequestMapping(value = "/api/countries")
public class ContryController {

		@Autowired
		private CountryService countryService;

		@RequestMapping(value="getCountries", method = RequestMethod.GET)
		public ResponseEntity<List<Country>> getCountries() {

			List<Country> countries = countryService.findAll();

			return new ResponseEntity<>(countries, HttpStatus.OK);
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Country> getCountry(@PathVariable Long id) {
			Country country = countryService.findOne(id);
			if (country == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(country, HttpStatus.OK);
		}
	
}
