package edu.matc.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


import static java.time.temporal.ChronoUnit.DAYS;

public class DateChecker extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        LocalDate today = LocalDate.now();
        String hDate = "Oct 31 2017";

        LocalDate Halloween = LocalDate.parse(hDate, DateTimeFormatter.ofPattern("MMM dd yyyy"));
        long daysBetween = DAYS.between(today, Halloween);

        if (daysBetween > 0) {
            out.println(daysBetween+" Day's till Halloween");
        } else {
            out.println("Happy Halloween!!!");
        }
    }
}
