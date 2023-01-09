package monprojet.dao;

import java.util.List;

import monprojet.dto.PopulationParPays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring

public interface CountryRepository extends JpaRepository<Country, Integer> {
    /**
     * l'ID est passé en paramètre,
     * calcule sa population (somme des populations des villes).
     * @param codePays le pays  à traiter
     * @return somme des populations des villes,
     *.        sous la forme d'une liste de DTO PopulationParPays
     */
    @Query("SELECT c.country.id as pays, SUM(c.population) AS population "
            + "FROM City c "
            + "WHERE c.country.id = :codePays "
            + "GROUP BY c ")
    public List<PopulationParPays> populationPayspour(Integer codePays);



}