package com.reza.psikotestapp.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class UtilHelperImplDtNow implements UtilHelper {
    @Override
    public String dtNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }

    @Override
    public String birthDateStr(LocalDate time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDatetime = time.format(formatter);
        return formatDatetime;
    }
}
