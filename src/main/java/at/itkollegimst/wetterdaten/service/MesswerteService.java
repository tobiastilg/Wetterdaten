package at.itkollegimst.wetterdaten.service;

import at.itkollegimst.wetterdaten.entity.Messwerte;
import at.itkollegimst.wetterdaten.exception.MesswertNotFoundException;

import java.util.List;

public interface MesswerteService {
    Messwerte saveMesswert(Messwerte messwerte);
    List<Messwerte> fetchAllMesswerte();
    List<Messwerte> fetchAllMesswerteByName(String name);
    Messwerte fetchMesswert(Long id) throws MesswertNotFoundException;
    String deleteMesswert(Long id);
}
