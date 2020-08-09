package com.eason.lottert.controller;

//import cn.jiguang.common.resp.APIConnectionException;
//import cn.jiguang.common.resp.APIRequestException;

import com.eason.lottert.bean.User;
import com.eason.lottert.service.UserService;
import com.eason.lottert.utils.BallUtils;
//import com.eason.lottert.utils.JGSMSUtils;
import com.eason.lottert.utils.UUIDUtils;
import com.eason.lottert.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ 文件名:   TestController
 * @ 创建者:   Eason
 * @ 时间:    2018/9/25 15:11
 * @ 描述:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    @GetMapping("/register")
    public String register() {
        return "register.html";
    }

    @PostMapping("/registerUser")
    public String registerUser(User user, String code, HttpSession session, Model model) {
        //验证码校验
//        String smsCode = (String) session.getAttribute("smsCode");
//        if (!code.equals(smsCode)) {
//            model.addAttribute("smsFeedback", "验证码错误");
//            return "/register";
//        }
        String msgId = (String) session.getAttribute("msgId");
//        boolean status = JGSMSUtils.sendValidSms(msgId, code);
//        if (!status) {
//            model.addAttribute("smsFeedback", "验证码错误");
//            return "/register";
//        }

        user.setUid(UUIDUtils.getId());
        user.setState(0);
        user.setMoney(0);
        user.setHeadimg("default.png");

        userService.register(user);
        return "redirect:/user/login";
    }

    @GetMapping("/sendSMS")
    @ResponseBody
    public String sendSMS(String mobile, HttpSession session) {
//        try {
//            String msgId = JGSMSUtils.sendSms(mobile);
//            session.setAttribute("msgId", msgId);
//        } catch (APIConnectionException e) {
//            System.out.println(e);
//            return "发送失败";
//        } catch (APIRequestException e) {
//            System.out.println(e);
//            return "发送失败";
//        }
        return "发送成功";
    }


    //登录
    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @PostMapping("/loginUser")
    public String loginUser(String mobile, String password, Model model, HttpSession session, HttpServletResponse response) {
        User user = userService.login(mobile, password);
        if (user != null) {
            session.setAttribute("uid", user.getUid());

            Cookie cookie = new Cookie("autologin", mobile + "#" + password);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            cookie.setPath("/");
            response.addCookie(cookie);

            return "redirect:/";
        } else {
            model.addAttribute("feedback", true);
        }
        return "/login";
    }

    //个人中心
    @GetMapping("/person")
    public String person(HttpSession session, Model model) {
        //交由Filter过滤没有保存session的请求
        //uid异常，user查询结果为空，页面反馈
        String uid = (String) session.getAttribute("uid");
        User user = userService.findByUid(uid);
        model.addAttribute("user", user);

        //生成随机球
        String redBalls = BallUtils.redBalls();
        String blueBall = BallUtils.blueBall();
        model.addAttribute("redBalls", redBalls);
        model.addAttribute("blueBall", blueBall);
        return "person.html";
    }

    @PostMapping("/updataProfile")
    public String updataProfile(MultipartFile profile, HttpSession session) {
        try {
            String uid = (String) session.getAttribute("uid");
            User user = userService.findByUid(uid);

            String originalFilename = profile.getOriginalFilename();
            String filename = UploadUtils.getUUIDName(originalFilename);
            String randomDir = UploadUtils.getDir();
            //服务器端头像存储位置
            String dir = "G:/资源/uploadfiles" + randomDir;

            //空路径判断
            File fileDir = new File(dir);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }

            profile.transferTo(new File(dir, filename));

            user.setHeadimg(randomDir + "/" + filename);
            userService.updata(user);

            System.out.println("profile upload success");
        } catch (IOException e) {
            System.out.println("profile upload fail");
            e.printStackTrace();
        }

        return "redirect:/user/person";
    }

    @Autowired
    ResourceLoader resourceLoader;

    //    /getImg/'+${person.headImg}
    @GetMapping("/getProfile/{dir1}/{dir2}/{headimg:.+}")
    public ResponseEntity<Resource> getProfile(@PathVariable String dir1, @PathVariable String dir2, @PathVariable String headimg) {
        Path path = Paths.get("G:/资源/uploadfiles/" + dir1 + "/" + dir2, headimg);

        Resource resource = resourceLoader.getResource("file:" + path);

        return ResponseEntity.ok(resource);
    }
}
