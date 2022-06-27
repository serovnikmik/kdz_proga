package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.TopUpQuantity;
import web.services.TopUpService;

@Controller
@RequestMapping("/topUp")
public class TopUpController {

    @Autowired
    private TopUpService topUpService;

    @GetMapping("/{id}/balance")
    public String balance(@PathVariable("id") int id, Model model){
        model.addAttribute("user", topUpService.getUser(id));
        return "topUp/balance";
    }

    @GetMapping("/{id}/topUpInfo")
    public String info(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        return "topUp/info";
    }

    @GetMapping("/{id}/topUpQuantity")
    public String quantity(@PathVariable("id") int id, Model model){
        model.addAttribute("quantity", new TopUpQuantity());
        model.addAttribute("id", id);
        return "/topUp/quantity";
    }

    @PostMapping("/{id}/topUp")
    public String topUp(@ModelAttribute("quantity") TopUpQuantity topUpQuantity,
                        @PathVariable("id") int id, Model model){
        if (Math.random() > 0.5){
            System.out.println("Balance of user with id: " + id +
                    " was topped up by " + topUpQuantity.getValue());
            topUpService.topUp(id, topUpQuantity.getValue());
            model.addAttribute("id", id);
            return "topUp/successful";
        } else {
            System.out.println("Unsuccessful try to top up balance");
            model.addAttribute("id", id);
            return "topUp/unsuccessful";
        }
    }

    @GetMapping("/{id}/unsuccessful")
    public String unsuccessful(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        return null;
    }

    @GetMapping("/{id}/successful")
    public String successful(@PathVariable("id") int id, Model model){
        model.addAttribute("id", id);
        return null;
    }

}

// /{id}/balance -> /{id}/topUpQuantity(page of top up) or /{id}/topUpInfo (how to top up)
// /{id}/topUpInfo -> /{id}/balance
// /{id}/topUpQuantity (enter sum) -> random check -> /{id}/unsuccessful or /{id}/successful
// /{id}/unsuccessful -> /{id}/balance
// /{id}/successful -> /{id}/balance