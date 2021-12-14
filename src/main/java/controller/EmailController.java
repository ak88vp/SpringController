package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }


    @GetMapping("/")
    String getIndex() {
        return "index";
    }

    @PostMapping("/validate")
    String validateEmail(@RequestParam String email, Model model) {
        boolean isValid = this.validate(email);
        if (!isValid) {
            model.addAttribute("message", "Email is invalid");
            return "index";
        }

        model.addAttribute("email", email);
        return "success";
    }

    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }


    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }

    @GetMapping("/submit")
    public String showResult(Model model, @RequestParam String condiment){

        model.addAttribute("condiment",condiment);

        return "condiment";
    }
    @GetMapping ("calculator")
    public String getCalculator(Model model, @RequestParam String numberA, String numberB, String result) {
        int a = Integer.parseInt(numberA);
        int b = Integer.parseInt(numberB);

        switch (result){
            case "Cong":
                model.addAttribute("result", a + b);
                model.addAttribute("numberA", a);
                model.addAttribute("numberB", b);
                break;
            case "tru":
                model.addAttribute("result", a - b);
                model.addAttribute("numberA", a);
                model.addAttribute("numberB", b);
                break;
            case "nhan":
                model.addAttribute("result", a * b);
                model.addAttribute("numberA", a);
                model.addAttribute("numberB", b);
                break;
            case "chia":
                model.addAttribute("result", a / b);
                model.addAttribute("numberA", a);
                model.addAttribute("numberB", b);
                break;

        }

        return "redirect:index";
    }


}
