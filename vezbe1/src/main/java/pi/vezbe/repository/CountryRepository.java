package pi.vezbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pi.vezbe.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
	
}
