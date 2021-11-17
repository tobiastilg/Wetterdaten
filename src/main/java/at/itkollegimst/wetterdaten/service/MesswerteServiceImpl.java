package at.itkollegimst.wetterdaten.service;

import at.itkollegimst.wetterdaten.entity.Messwerte;
import at.itkollegimst.wetterdaten.exception.MesswertNotFoundException;
import at.itkollegimst.wetterdaten.repository.MesswerteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesswerteServiceImpl implements MesswerteService{

    @Autowired
    private MesswerteRepository messwerteRepository;

    @Override
    public Messwerte saveMesswert(Messwerte messwerte){
        return this.messwerteRepository.save(messwerte);
    }

    @Override
    public List<Messwerte> fetchAllMesswerte() {
        return this.messwerteRepository.findAll();
    }

    @Override
    public List<Messwerte> fetchAllMesswerteByName(String name) {
        return this.messwerteRepository.findAllByNameIgnoreCase(name);
    }

    @Override
    public Messwerte fetchMesswert(Long id) throws MesswertNotFoundException{
        Optional<Messwerte> optionalMesswerte = this.messwerteRepository.findById(id);

        if (!optionalMesswerte.isPresent()) {
            throw new MesswertNotFoundException(
                    "Der Messwert mit der ID " + id + " wurde nicht gefunden.");
        }
        return this.messwerteRepository.findById(id).get();
    }

    @Override
    public String deleteMesswert(Long id) {
        this.messwerteRepository.deleteById(id);
        return "Der Messwert mit der ID " + id + " wurde gelöscht";
    }
}
