package ftn.xmlws.soap.service.util;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DateParser {

    public Date parseDate(String dateAsString) {
        SimpleDateFormat sdfStat1 = new SimpleDateFormat(dateAsString);
        java.util.Date sdfParsed1 = null;

        try {
            sdfParsed1 = sdfStat1.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date date = new Date(sdfParsed1.getTime());
        return  date;
    }
}
