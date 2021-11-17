package at.itkollegimst.wetterdaten.controller.Thymeleaf;

import at.itkollegimst.wetterdaten.entity.Messwerte;
import at.itkollegimst.wetterdaten.service.MesswerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MesswetControllerUI {

    @Autowired
    private MesswerteService messwerteService;

    @GetMapping("/ui/messwerte")
    public String fetchAllMesswerte(Model model) {
        List<Messwerte> messwerteList = this.messwerteService.fetchAllMesswerte();
        model.addAttribute("messwerteList", messwerteList);
        return "messwerte";
    }

    @GetMapping("/ui/messwerte/new")
    public String showNewForm(Model model) {
        model.addAttribute("messwert", new Messwerte());
        return "messwert_form";
    }

    @PostMapping("/ui/messwerte/save")
    public String saveEmployee(Messwerte messwert, RedirectAttributes ra) {
        messwerteService.saveMesswert(messwert);
        ra.addFlashAttribute("message", "Der Messwert wurde gespeichert.");
        return "redirect:/ui/messwerte";
    }

    @GetMapping ("/ui/messwerte/delete/{id}")
    public String deleteMesswert(@PathVariable("id") Long id, RedirectAttributes ra) {
        messwerteService.deleteMesswert(id);
        ra.addAttribute("message", "Der Messwert mit der ID " + id + " wurde gelöscht.");
        return "redirect:/ui/messwerte";
    }
}