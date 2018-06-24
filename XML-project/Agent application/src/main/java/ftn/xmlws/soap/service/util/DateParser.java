package ftn.xmlws.soap.service.util;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DateParser {

    public Date parseDate(String dateAsString) {
        return  Date.valueOf(dateAsString);
    }
}
