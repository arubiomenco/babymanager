package com.arubiomenco.babyman.entities;

import com.google.appengine.api.datastore.Key;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Angel
 */
@Entity
public class Enhancement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Key id;
    
    @ManyToOne(optional = false)
    private EnhancementType type;
    
    @Column(precision = 2)
    private double amount;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date enhancementTime;
    
    @ManyToOne(optional = true)
    @JoinColumn(name="baby_id")
    private Baby baby;
    
    @ManyToOne(optional = true)
    @JoinColumn(name="feed_id")
    private Feed feed;

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
     * @return the type
     */
    public EnhancementType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(EnhancementType type) {
        this.type = type;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the enhancementTime
     */
    public Date getEnhancementTime() {
        return enhancementTime;
    }

    /**
     * @param enhancementTime the enhancementTime to set
     */
    public void setEnhancementTime(Date enhancementTime) {
        this.enhancementTime = enhancementTime;
    }

    /**
     * @return the baby
     */
    public Baby getBaby() {
        return baby;
    }

    /**
     * @param baby the baby to set
     */
    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    /**
     * @return the feed
     */
    public Feed getFeed() {
        return feed;
    }

    /**
     * @param feed the feed to set
     */
    public void setFeed(Feed feed) {
        this.feed = feed;
    }
    
    
    
}
