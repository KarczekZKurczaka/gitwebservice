//package com.pawel.webservice;
//
//import com.pawel.webservice.repo.Repository;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@org.springframework.stereotype.Controller
//public class Controller {
//
//    @RequestMapping("/securedPage")
//    public String securedPage(Model model,
//                              @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
//                              @AuthenticationPrincipal OAuth2User oauth2User) {
//        model.addAttribute("userName", oauth2User.getName());
//        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
//        model.addAttribute("userAttributes", oauth2User.getAttributes());
//
//        return "securedPage";
//    }
//
//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping("/login-error.html")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login.html";
//    }
//
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello";
//    }
//
//    @GetMapping("/withname")
//    @ResponseBody
//    public String helloWithName(@RequestParam(name = "name", required = false) String name) {
//        return "Hello dear " + name;
//    }
//
//    @GetMapping("/afterSlash/{name}")
//    @ResponseBody
//    public String helloWithSlash(@PathVariable("name") String name) {
//        return "Hello dear " + name;
//    }
//
//    @GetMapping("/repositories/{owner}/{reponame}")
//    @ResponseBody
//    public String repositories(@PathVariable(value = "owner", required = true) String owner, @PathVariable(value = "reponame", required = false) String repoName) {
//        Repository repository = new Repository();
//
//        return String.format("here go repositories for %s in repository %s...", owner, repoName);
//    }
//}
