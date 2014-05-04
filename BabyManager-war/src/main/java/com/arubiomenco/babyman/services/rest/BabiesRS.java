package com.arubiomenco.babyman.services.rest;

import com.arubiomenco.babyman.services.sdo.BabySdo;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Angel
 */
@Path("/babies")
public class BabiesRS {
    @GET
    @Produces({ "application/json" })
    public List<BabySdo> list(){
        List<BabySdo> babies = new ArrayList<BabySdo>();
        
        return babies;
    }
}
