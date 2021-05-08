package com.today10sec.diary.customize.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.ErrorManager;


public final class DiaryTimeUtil {

    private static ErrorManager log;

    private static final Logger logger = LoggerFactory.getLogger(DiaryTimeUtil.class);
    public static String URL_PATTEN_ONLY_NUM = "yyyyMMdd";

    public static LocalDate getToday(){
        return LocalDate.now();
    }

    public static LocalDateTime getNow(){
        return LocalDateTime.now();
    }

    /**
     *  getTodayOnlyNumberText(yyyyMMdd)
     *
     * @return today
     */
    public static String getTodayOnlyNumberText() {
        return getDateOnlyNumberText(getToday());
    }
    public static String getDateOnlyNumberText(LocalDate localDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(URL_PATTEN_ONLY_NUM);
        return localDate.format(dateTimeFormatter);
    }

    public static Optional<LocalDate> getLocalDate(String date) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(URL_PATTEN_ONLY_NUM);
            return Optional.of(LocalDate.parse(date, dateTimeFormatter)) ;
        } catch (RuntimeException e){
            return Optional.empty();
        } catch (Exception e2) {
            logger.error("date: ",date);
            e2.printStackTrace();
            return  Optional.empty();
        }
    }

    public static LocalDate getFirstDayOFWeek(Locale locale, LocalDate localDate) {
        TemporalField temporalField = WeekFields.of(locale).dayOfWeek();
        return localDate.with(temporalField,1);
    }
}

