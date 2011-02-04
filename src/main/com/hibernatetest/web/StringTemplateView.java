package com.hibernatetest.web;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class StringTemplateView implements View {

    private String templateDirectory;
    private String viewName;


    public StringTemplateView(String templateDirectory, String viewName) {
        this.templateDirectory = templateDirectory;
        this.viewName = viewName;
    }

    public String getContentType() {
        return "text/html";
    }

    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringTemplateGroup group = new StringTemplateGroup("mytemplates", templateDirectory);
        StringTemplate template = group.getInstanceOf(viewName, model);

        response.getWriter().print(template);
    }
}
