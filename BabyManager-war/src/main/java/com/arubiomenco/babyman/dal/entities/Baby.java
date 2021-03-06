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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Angel
 */
@Entity
public class Baby implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Key id;
    
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    
    @Column(name = "birth_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    
    @Column ( name = "creation_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creationDate;
    
    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<BabyPermission> permissions;

    /**
     * @return the id
     */
    public Key getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Key id) {
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
     * @return the permissions
     */
    public Set<BabyPermission> getPermissions() {
        if (permissions == null){
            permissions = new HashSet<BabyPermission>();
        }
        return permissions;
    }
    

    public void addPermission ( Account account, boolean modify ){
        BabyPermission permission = new BabyPermission();
        permission.setAccount(account);
        permission.setBaby( this );
        permission.setCanModify(modify);
        
        getPermissions().add(permission);
    }
    
    @Override
    public String toString() {
        return "[ID: " + getId() + ", name: " + getName() + ", birthDate: " + getBirthDate() + ", creationDate: " + getCreationDate() + "]";
    }
}
