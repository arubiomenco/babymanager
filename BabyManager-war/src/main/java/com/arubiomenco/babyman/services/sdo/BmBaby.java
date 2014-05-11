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

package com.arubiomenco.babyman.services.sdo;

import com.arubiomenco.babyman.dal.entities.Baby;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angel
 */
@XmlRootElement
public class BmBaby {
    private Long id;
    private String name;
    private Date birthDate;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    public static BmBaby fromBaby( Baby baby ){
        BmBaby babySdo = new BmBaby();
        
        babySdo.setId( baby.getId().getId() );
        babySdo.setName( baby.getName() );
        
        return babySdo;
    }
    
    public static Baby toBaby( BmBaby sdoBaby, String appId ){
        Baby babySdo = new Baby();
        //Key key = new Key(appId, sdoBaby.getId().longValue() );
        //babySdo.setId( new Key( appId, sdoBaby.getId().longValue() ) );
        babySdo.setName( sdoBaby.getName() );
        
        return babySdo;
    }
}