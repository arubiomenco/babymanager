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

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author Angel
 */
public class NotAuthorizedMapper implements ExceptionMapper<NotAuthorizedException> {

    public Response toResponse(NotAuthorizedException e) {
        HttpError error = new HttpError(e.getMessage(), e.getStatus().getStatusCode());
        return Response.status(e.getStatus()).entity(error).type(MediaType.APPLICATION_JSON).build();
    }
}
