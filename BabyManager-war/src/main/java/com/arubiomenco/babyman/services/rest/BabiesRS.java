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

import com.arubiomenco.babyman.services.IBabyService;
import com.arubiomenco.babyman.services.exception.InvalidDataException;
import com.arubiomenco.babyman.services.exception.NotAuthorizedException;
import com.arubiomenco.babyman.services.impl.BmServiceFactory;
import com.arubiomenco.babyman.services.sdo.BmBaby;
import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Angel
 */
@Path("/babies")
public class BabiesRS {
    private static final Logger logger = Logger.getLogger(BabiesRS.class.getName());
    @Context
    private SecurityContext secContext;
            
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<BmBaby> list( ){
        List<BmBaby> sdoBabies = null;
        Principal principal = secContext.getUserPrincipal();
        if (principal != null){
            logger.info( "User: " + principal.getName() );
            
            IBabyService babyService = BmServiceFactory.getFactory().getBabyService();
            sdoBabies = babyService.listBabies( principal.getName() );
        }else{
            throw new NotAuthorizedException("Not logged In!");
        }
        
        return sdoBabies;
    }
    
    @POST
    @Produces ( { MediaType.APPLICATION_JSON })
    @Consumes ( {MediaType.APPLICATION_FORM_URLENCODED} )
    public BmBaby create ( @FormParam("name") String babyName, @FormParam("birth") DateParam birthDate ){
        Principal principal = secContext.getUserPrincipal();
        BmBaby bmBaby = null;
        if (principal != null){
            bmBaby = new BmBaby();
            bmBaby.setName(babyName);
            if (birthDate != null){
                bmBaby.setBirthDate( birthDate.getDate() );
            }
            
            IBabyService babyService = BmServiceFactory.getFactory().getBabyService();
            babyService.create(bmBaby, principal.getName());
        }else{
            throw new NotAuthorizedException("Not logged in!");
        }
        return bmBaby;
    }
    
    @PUT
    @Produces ( { MediaType.APPLICATION_JSON })
    @Consumes ( { MediaType.APPLICATION_FORM_URLENCODED } )
    @Path("/{baby_id}")
    public BmBaby update ( @PathParam("baby_id") String babyId, @FormParam("name") String babyName, @FormParam("birth") DateParam birthDate ){
        Principal principal = secContext.getUserPrincipal();
        BmBaby bmBaby = null;
        if (principal != null){
            if (babyId == null){
                throw new InvalidDataException("baby_id parameter is required");
            }
            bmBaby = new BmBaby();
            bmBaby.setId(babyId);
            bmBaby.setName(babyName);
            if (birthDate != null){
                bmBaby.setBirthDate( birthDate.getDate() );
            }
           
            IBabyService babyService = BmServiceFactory.getFactory().getBabyService();
            if (babyService.canModify(bmBaby, principal.getName() )){
                babyService.update(bmBaby);
            }else{
                throw new NotAuthorizedException("Insuficient permissions!");
            }
            
        }else{
            throw new NotAuthorizedException("Not logged in!");
        }
        return bmBaby;
    }
}
