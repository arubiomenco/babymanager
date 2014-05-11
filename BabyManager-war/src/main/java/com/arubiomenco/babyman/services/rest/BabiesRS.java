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
