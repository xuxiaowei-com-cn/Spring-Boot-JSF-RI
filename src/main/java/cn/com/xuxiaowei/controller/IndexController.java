package cn.com.xuxiaowei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 普通主页 Controller
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Controller
public class IndexController {

    /**
     * 普通主页
     */
    @RequestMapping("")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {

        request.getSession();

        return "index";
    }

}
