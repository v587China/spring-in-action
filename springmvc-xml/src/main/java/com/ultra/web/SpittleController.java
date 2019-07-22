package com.ultra.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ultra.dao.SpittleRepository;
import com.ultra.dao.entity.Spittle;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    // private static final String MAX_LONG_AS_STRING =
    // Long.toString(Long.MAX_VALUE);
    // @Autowired
    private SpittleRepository spittleRepository;

    /**
     * 
     * 测试:获取查询参数(query parameter)
     *
     * @param max
     * @param count
     * @return
     */
    @GetMapping("/param")
    public List<Spittle> param(@RequestParam(defaultValue = "0x7fffffffffffffffL") long max,
            @RequestParam(defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    /**
     * 
     * 测试:获取表单参数(form parameter)
     *
     * @param max
     * @param count
     * @return
     */
    @GetMapping("/form")
    public String form() {
        return null;
    }

    /**
     * 
     * 测试:获取路径变量(path variable)
     *
     * @param max
     * @param count
     * @return
     */
    @GetMapping("/path/{spittleId}")
    public String path(@PathVariable long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @GetMapping
    public String spittles(Model model) {
        model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    /**
     * model有默认key
     */
    // @GetMapping
    // public String spittles(Model model) {
    // model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
    // return "spittles";
    // }
    /**
     * 当返回值不是String/View/ModelAndView时,默认的视图是servletPath去掉/
     * 
     * @param model
     * @return
     */
    // @GetMapping
    // public List<Spittle> spittles() {
    // return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
    // }
}
