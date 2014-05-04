package com.arubiomenco.babyman.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Angel
 */
@Entity
public class Account implements Serializable {
    @Id
    private String id;
    
    @OneToMany(mappedBy = "account")
    private List<BabyPermission> babies;

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
