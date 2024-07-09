package com.example.http_snooper;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Enumeration;

@Controller
public class IntrospectionController {

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        IntrospectedRequest r = new IntrospectedRequest();

        r.setSecure(request.isSecure());

        r.setLocalPort(request.getLocalPort());
        r.setLocalAddr(request.getLocalAddr());
        r.setLocalName(request.getLocalName());

        r.setServerPort(request.getServerPort());

        r.setRemotePort(request.getRemotePort());
        r.setRemoteAddr(request.getRemoteAddr());

        r.setContextPath(request.getContextPath());
        r.setServletPath(request.getServletPath());
        r.setQueryString(request.getQueryString());

        Enumeration<String> hnames = request.getHeaderNames();
        while (hnames.hasMoreElements()) {
            String hname = hnames.nextElement();
            String value = request.getHeader(hname);
            r.addRequestHeader(hname, value);
        }

        Enumeration<String> sessionAttributes = request.getSession().getAttributeNames();
        while (sessionAttributes.hasMoreElements()) {
            String sessionAttribute = sessionAttributes.nextElement();
            String value = request.getSession(true).getAttribute(sessionAttribute).toString();
            r.addSessionAttribute(sessionAttribute, value);
        }

        model.addAttribute("snooped", r);

        return "main";
    }
}
