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

package com.arubiomenco.babyman.dal.entities;

import com.google.appengine.api.datastore.Key;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Angel
 */
@Entity
public class Account implements Serializable {
    @Id
    @Column(name="id", length = 100)
    private String id;
    
    @Column(name = "creation_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creationDate;
       
    @Transient
    private Set<BabyPermission> babies;
    
    @Basic
    private Set<Key> permissionKeys;

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
    
    /**
     * @return the babies
     */
    public Set<BabyPermission> getBabies() {
        if (babies == null){
            babies = new HashSet<BabyPermission>();
        }
        return babies;
    }
    
    public void addBaby ( Baby baby, boolean modify ){
        BabyPermission permission = new BabyPermission();
        permission.setAccount(this);
        permission.setBaby( baby );
        permission.setCanModify(modify);
        
        getBabies().add(permission);
    }

    /**
     * @return the permissionKeys
     */
    public Set<Key> getPermissionKeys() {
        if (permissionKeys == null){
            permissionKeys = new HashSet<Key>();
        }
        return permissionKeys;
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + ", creationDate: " + getCreationDate() + "]";
    }
}
