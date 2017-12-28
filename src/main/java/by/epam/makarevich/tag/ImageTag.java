package by.epam.makarevich.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class ImageTag extends TagSupport {

    private String title;

    private String imagePath;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }

    @Override
    public int doStartTag() throws JspException {
        String caption = "<h1 class=\"center\">" + title + "</h1>";
        String centerPart = "<p class=\"center\">\n" +
                "            <img class=\"server-img\"\n" +
                "                 src=\"" + imagePath + "\">\n" +
                "        </p>";
        try {
            JspWriter out = pageContext.getOut();
            out.write(caption + centerPart);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
