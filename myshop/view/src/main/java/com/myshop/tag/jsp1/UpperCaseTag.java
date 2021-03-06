package com.myshop.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class UpperCaseTag extends BodyTagSupport {
    private static final long serialVersionUID = -7164875760503662621L;
    @Override
    public int doEndTag() throws JspException {
        BodyContent body = getBodyContent();
        try {
            pageContext.getOut().print(body.getString().toUpperCase());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }
}
