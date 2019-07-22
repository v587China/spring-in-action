package com.ultra.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ultra.dao.SpitterRepository;
import com.ultra.dao.entity.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    // @Autowired
    private SpitterRepository spitterRepository;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "registerForm";
    }

    @GetMapping("/{username}")
    public String showSpittleProfile(@PathVariable String username, Model model) {
        Spitter spittler = spitterRepository.findByUsername(username);
        model.addAttribute(spittler);
        return "profile";
    }

    /**
     * 
     * 获取表单参数(form parameter)
     *
     * @param max
     * @param count
     * @return
     */
    @PostMapping("/register")
    public String form(@Valid Spitter spittler, Model model, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spittler);
        // 重定向传参
        model.addAttribute("username", spittler.getUsername());
        model.addAttribute("password", spittler.getPassword());
        // 如果username属性的值是habuma并且password属性的值是42，
        // 那么结果得到的重定向URL路径将会是/spitter/habuma?spitterId=42
        return "redirect:/spitter/{username}";
    }

    @PostMapping("/register2")
    public String form2(@Valid Spitter spittler, RedirectAttributes model, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spittler);
        // 重定向传参
        model.addAttribute("username", spittler.getUsername());
        model.addAttribute("password", spittler.getPassword());
        // flash属性:重定向存活的数据放到会话;会一直携带这些数据直到下一次请求，然后才会消失
        model.addFlashAttribute("spittler", spittler);
        return "redirect:/spitter/{username}";
    }

}
