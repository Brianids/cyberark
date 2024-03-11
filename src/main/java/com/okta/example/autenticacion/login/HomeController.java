package com.okta.example.autenticacion.login;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model, HttpServletResponse httpServletResponse) {
    	log.info("Logueando....");
    	model.addAttribute("name", principal.getAttribute("Name"));
    	model.addAttribute("email", principal.getAttribute("Email"));
    	httpServletResponse.setHeader("Location", "https://eotqa.gnp.com.mx/");
        httpServletResponse.setStatus(302);
        return "home";
    }
}