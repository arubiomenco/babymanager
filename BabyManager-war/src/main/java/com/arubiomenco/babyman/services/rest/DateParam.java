/*
 * Copyright 2014 - Angel Rubio Menco
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arubiomenco.babyman.services.rest;

import com.arubiomenco.babyman.services.exception.InvalidDataException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Angel
 */
public class DateParam {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private final Date date;

    public DateParam(String dateStr) throws InvalidDataException {
        if (dateStr == null || dateStr.isEmpty()) {
            this.date = null;
        } else {
            final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            try {
                this.date = dateFormat.parse(dateStr);
            } catch (ParseException e) {
                throw new InvalidDataException("Invalid date value '" + dateStr + "' expected format: " + DATE_FORMAT);
            }
        }
    }

    public Date getDate() {
        return date;
    }
}
