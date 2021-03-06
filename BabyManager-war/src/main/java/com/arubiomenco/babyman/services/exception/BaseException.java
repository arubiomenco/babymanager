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
package com.arubiomenco.babyman.services.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Angel
 */
public class BaseException extends WebApplicationException{
    private final String message;
    private final Response.Status status;

    public BaseException ( Response.Status status, String message ) {
        super ( status );
        this.status = status;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
    
    public Response.Status getStatus(){
        return status;
    }
    
}
