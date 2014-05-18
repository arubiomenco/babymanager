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

import com.arubiomenco.babyman.services.exception.HttpError;
import com.arubiomenco.babyman.services.sdo.BmBaby;
import com.arubiomenco.babyman.services.sdo.BmEnhancement;
import com.arubiomenco.babyman.services.sdo.BmFeed;
import com.arubiomenco.babyman.services.sdo.BmUser;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author Angel
 */
@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {
    private final JAXBContext context;
    private final Set<Class> types;
    private Class[] ctypes = { BmBaby.class, BmEnhancement.class, BmFeed.class, BmUser.class, HttpError.class };
    public JAXBContextResolver() throws Exception {
        this.types = new HashSet<Class>(Arrays.asList(ctypes));
        this.context = new JSONJAXBContext(JSONConfiguration.natural().build(), ctypes); //json configuration
    }

    @Override
    public JAXBContext getContext(Class<?> objectType) {
        return (types.contains(objectType)) ? context : null;
    }
}