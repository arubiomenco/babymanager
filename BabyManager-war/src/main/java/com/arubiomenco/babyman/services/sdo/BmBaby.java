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
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angel
 */
@XmlRootElement
public class BmBaby {

    private String id;
    private String name;
    private Date birthDate;
    private Date creationDate;

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
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public static BmBaby fromBaby(Baby baby) {
        BmBaby babySdo = new BmBaby();
        if (baby.getId() != null) {
            String key = KeyFactory.keyToString(baby.getId());
            babySdo.setId(key);
        }
        babySdo.setName(baby.getName());
        babySdo.setCreationDate(baby.getCreationDate());
        babySdo.setBirthDate(baby.getBirthDate());

        return babySdo;
    }

    public static Baby toBaby(BmBaby sdoBaby ) {
        Baby baby = new Baby();
        if (sdoBaby.getId() != null) {
            Key key = KeyFactory.stringToKey(sdoBaby.getId());
            baby.setId(key);
        }
        baby.setName(sdoBaby.getName());
        baby.setBirthDate(sdoBaby.getBirthDate());
        baby.setCreationDate(sdoBaby.getCreationDate());

        return baby;
    }

}
