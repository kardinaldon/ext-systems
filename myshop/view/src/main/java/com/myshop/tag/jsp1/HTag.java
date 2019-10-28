package com.myshop.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Arrays;

public class HTag extends TagSupport {
    private String type;
    public HTag() { setDefaults(); }
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().println("<" + type + ">");
            return EVAL_BODY_INCLUDE;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }
    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().println("</" + type + ">");
            setDefaults();
            return EVAL_PAGE;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }
    private void setDefaults(){ type = "h6"; }
    public void setType(String type) {
        if (type != null) {
            if (Arrays.asList(new String[] { "h1", "h2", "h3", "h4", "h5", "h6" })
                    .contains(type.toLowerCase())) {
                this.type = type;
            }
        }
    }
}
