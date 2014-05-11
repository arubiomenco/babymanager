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

import com.arubiomenco.babyman.dal.IBabiesDao;
import com.arubiomenco.babyman.dal.entities.Baby;
import com.arubiomenco.babyman.services.IBabyService;
import com.arubiomenco.babyman.services.exception.NotAuthorizedException;
import com.arubiomenco.babyman.services.impl.BmServiceFactory;
import com.arubiomenco.babyman.services.sdo.BmBaby;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Angel
 */
@Path("/babies")
public class BabiesRS {
    private static final Logger logger = Logger.getLogger(BabiesRS.class.getName());
            
    @GET
    @Produces({ "application/json" })
    public List<BmBaby> list( @Context SecurityContext sec ){
        List<BmBaby> sdoBabies = null;
        Principal principal = sec.getUserPrincipal();
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
    @Produces ( {"application/json"})
    public BmBaby add( @Context SecurityContext sec, @QueryParam("name") String babyName, @QueryParam("birth") Date birthDate ){
        Principal principal = sec.getUserPrincipal();
        BmBaby bmBaby = null;
        if (principal != null){
            bmBaby = new BmBaby();
            bmBaby.setName(babyName);
            
            Baby baby = new Baby();
            baby.setName( babyName );
            baby.setBirthDate( birthDate );
            
            IBabyService babyService = BmServiceFactory.getFactory().getBabyService();
            babyService.create(bmBaby, principal.getName());
        }else{
            throw new NotAuthorizedException("Not logged in!");
        }
        return bmBaby;
    }
}
