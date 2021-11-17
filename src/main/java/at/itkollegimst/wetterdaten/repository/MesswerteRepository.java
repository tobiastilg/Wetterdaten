package at.itkollegimst.wetterdaten.repository;

import at.itkollegimst.wetterdaten.entity.Messwerte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MesswerteRepository extends JpaRepository<Messwerte, Long> {

    List<Messwerte> findAllByNameIgnoreCase(String name);
}
