package se.iths.lw.springbootfood.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.iths.lw.springbootfood.model.Food;
import se.iths.lw.springbootfood.service.FoodService;


@Controller
@RequestMapping("/foods")
public class FoodController {
    private final FoodService foodService;
    private static final Logger log = LoggerFactory.getLogger(FoodController.class);

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // ===================== READ ================================
    @GetMapping
    public String listAllFoods(Model model) {
        log.info("GET /foods -listning all foods.");
        model.addAttribute("foods", foodService.findAll());
        return"list-food";
    }

    @GetMapping("/{id}")
    public String showFood(@PathVariable Long id, Model model) {
        log.info("GET /foods/{} - showing food details.", id);
        try {
            model.addAttribute("food", foodService.findById(id));
            return "show-food";
        } catch(RuntimeException ex){
            log.warn("Food with id {} not found", id);
            model.addAttribute("errorMessage", ex.getMessage());
            return "show-food";
        }
    }
    // ======================= CREATE ============================
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        log.info("GET /foods/create - showing create form.");
        model.addAttribute("food", new Food());
        return "create-food";
    }

    @PostMapping("/create")
    public String createFood( @ModelAttribute("food") Food food, Model model) {
        log.info("Post /foods/create - creating new food: {}", food.getName());
        try {
            foodService.create(food);
        } catch (RuntimeException ex){
            log.warn(" POST /foods/create failed: {}", ex.getMessage());
            model.addAttribute("errorMessage", ex.getMessage());
            return "create-food";
        }

        return "redirect:/foods";
    }
    // =========================UPDATE ===================================
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        log.info("GET /foods/edit/{} -showing edit form.", id);
        try {
            model.addAttribute("food", foodService.findById(id));
            return "edit-food";
        } catch (RuntimeException ex) {
            log.warn("GET /foods/edit/{} failed: {}", id, ex.getMessage());
            model.addAttribute("errorMessage", ex.getMessage());
            return "show-food";
        }
    }

    @PostMapping("edit/{id}")
    public String updateFood(@PathVariable Long id, @ModelAttribute Food updated, Model model){
        log.info("POST /foods/edit/{} - updating food.",id);
        try {
            foodService.update(id, updated);
            } catch (RuntimeException ex) {
            log.warn("POST /foods/edit/{} failed: {}", id, ex.getMessage());
            model.addAttribute("errorMessage", ex.getMessage());
            return "edit-food";
            }

        return "redirect:/foods/";
    }

    // =============================DELETE ====================================
    @PostMapping("/delete/{id}")
    public String deleteFood(@PathVariable Long id) {
        log.info("POST /foods/delete/{} -deleting food.", id);
        foodService.delete(id);
        return "redirect:/foods";
    }


    // ================= Check about lactose and seafood ==========================
    @GetMapping("/lactose")
    public String getFoodsWithLactose(Model model) {
        try{
            log.info("GET /foods/lactose -fetching list of foods containing lactose.");
        model.addAttribute("foods", foodService.findByHasLactoseTrue());
        return "lactose-list-food";
        } catch (RuntimeException ex) {
            log.error("Error fetching list of foods containing lactose: {}", ex.getMessage());
            model.addAttribute("errorMessage", ex.getMessage());
            return "lactose-list-food";
        }

    }

    @GetMapping("/seafood")
    public String getFoodsWithSeafood(Model model){
        try {
            model.addAttribute("foods", foodService.findByHasSeafoodTrue());
            return "seafood-list-food";
        } catch (RuntimeException ex) {
            log.error("Error fetching list of foods containing seafood: {}", ex.getMessage());
            model.addAttribute("errorMessage", ex.getMessage());
            return "seafood-list-food";
        }

    }


   @GetMapping("/check")
    public String checkAllergy(@RequestParam(required = false) String barcode, Model model){

        if(barcode == null || barcode.isBlank()){
            return "check-food";
        }
        log.info("GET /foods/check Starting allergy check for barcode {}", barcode);
        try {
            boolean hasLactose = foodService.findIfHasLactoseByBarcode(barcode);
            boolean hasSeafood = foodService.findIfHasSeafoodByBarcode(barcode);

            String result;
            if (hasLactose && hasSeafood) {
                result = "⚠️This food contains lactose AND seafood.";
            } else if (hasLactose) {
                result = "⚠️This food contains lactose.";
            } else if (hasSeafood) {
                result = "⚠️This food contains seafood.";
            } else {
                result = "This food contains neither lactose nor seafood.";
            }

            model.addAttribute("result", result);
            return "check-food";
        } catch (RuntimeException ex) {
            log.warn("Error during allergy check for barcode {} : {}", barcode, ex.getMessage());
            model.addAttribute("errorMessage",ex.getMessage());
            return "check-food";
        }
   }



}
