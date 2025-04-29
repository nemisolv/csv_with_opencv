package com.vht.csv.util;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvUtil {

    public static <T> byte[] writeCsvToByteArrayFromList(List<T> list) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             OutputStreamWriter osWriter = new OutputStreamWriter(baos, StandardCharsets.UTF_8);
             CSVWriter csvWriter = new CSVWriter(osWriter,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,   // 👈 Tắt quote
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END
                     )) {

            if (list == null || list.isEmpty()) {
                return new byte[0];
            }

            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(csvWriter)
                    .withOrderedResults(true)
                    .build();

            beanToCsv.write(list);
            csvWriter.flush();
            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Failed to write CSV data", e);
        }
    }
}
