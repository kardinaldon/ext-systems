package com.myshop.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.println("Current date: "+
                    new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            return SKIP_BODY;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }
}
