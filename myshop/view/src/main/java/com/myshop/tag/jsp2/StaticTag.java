package com.myshop.tag.jsp2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().println("Current date: " +
                new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
    }
}
