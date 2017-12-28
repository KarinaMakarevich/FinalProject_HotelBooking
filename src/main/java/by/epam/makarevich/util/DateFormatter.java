package by.epam.makarevich.util;

import by.epam.makarevich.exception.ReceiverException;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatter {

    public Date getDate(String value) throws ReceiverException {
        Date date;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long sec = formatter.parse(value).getTime();
            date = new Date(sec);
        } catch (ParseException e) {
            throw new ReceiverException(e.getMessage());
        }
        return date;
    }
}
