package at.itkollegimst.wetterdaten.controller;

import at.itkollegimst.wetterdaten.entity.Messwerte;
import at.itkollegimst.wetterdaten.exception.MesswertNotFoundException;
import at.itkollegimst.wetterdaten.exception.MesswertValidate;
import at.itkollegimst.wetterdaten.service.MesswerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/messwerte")
public class MesswerteController {

    @Autowired
    private MesswerteService messwerteService;

    @PostMapping
    public ResponseEntity<Messwerte> saveMesswert(@Valid @RequestBody Messwerte messwerte,
                                                  BindingResult bindingResult) throws MesswertValidate {
        if(bindingResult.hasErrors()) {
            throw new MesswertValidate("Es können nur Werte zwischen -273 und 1000 Grad Celsius gemessen werden.");
        }
        return ResponseEntity.ok(this.messwerteService.saveMesswert(messwerte));
    }

    @GetMapping
    public ResponseEntity<List<Messwerte>> fetchAllMesswerte(){
        return ResponseEntity.ok(this.messwerteService.fetchAllMesswerte());
    }

    @GetMapping("/station/{name}")
    public ResponseEntity<List<Messwerte>> fetchAllMesswerteByName(@PathVariable String name){
        return ResponseEntity.ok(this.messwerteService.fetchAllMesswerteByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Messwerte> fetchMesswertById(@PathVariable Long id) throws MesswertNotFoundException {
        return ResponseEntity.ok(this.messwerteService.fetchMesswert(id));
    }

    @DeleteMapping("/{id}")
    public String deleteMesswertById(@PathVariable Long id) {
        return this.messwerteService.deleteMesswert(id);
    }
}