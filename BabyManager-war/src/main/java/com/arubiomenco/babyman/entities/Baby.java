package com.arubiomenco.babyman.entities;

import com.google.appengine.api.datastore.Key;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    private Key id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    
    private String name;
    
    @OneToMany(mappedBy = "babies")
    private List<BabyPermission> babies;

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
     * @return the babies
     */
    public List<BabyPermission> getBabies() {
        return babies;
    }

    /**
     * @param babies the babies to set
     */
    public void setBabies(List<BabyPermission> babies) {
        this.babies = babies;
    }
    
    
}
