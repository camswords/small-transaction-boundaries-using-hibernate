package com.hibernatetest.web;

import org.springframework.core.io.Resource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;

import java.util.Locale;

public class StringTemplateViewResolver extends AbstractCachingViewResolver {

    private String templateDirectory = "no.directory.specified";

    public void setTemplateDirectory(String templateDirectory) {
        this.templateDirectory = templateDirectory;
    }

    @Override
    protected View loadView(String viewName, Locale locale) throws Exception {
        String filename = templateDirectory + viewName + ".st";
        Resource resource = getApplicationContext().getResource(filename);

        if (!resource.exists()) {
            throw new IllegalStateException("unable to find stringtemplate resource with filename " + filename);
        }

        return new StringTemplateView(resource.getFile().getParent(), viewName);
    }
}
