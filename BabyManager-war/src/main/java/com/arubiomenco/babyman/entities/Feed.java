package com.arubiomenco.babyman.entities;

import com.google.appengine.api.datastore.Key;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Angel
 */
@Entity
public class Feed implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="baby_id")
    private Baby baby;
    
    @ManyToOne(optional = false)
    private FeedType feedType;
    
    @Column(precision = 2)
    private double amount;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date feedTime;
    
    @OneToMany(mappedBy = "feed")
    private List<Enhancement> enhancements;

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
     * @return the feedType
     */
    public FeedType getFeedType() {
        return feedType;
    }

    /**
     * @param feedType the feedType to set
     */
    public void setFeedType(FeedType feedType) {
        this.feedType = feedType;
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
     * @return the feedTime
     */
    public Date getFeedTime() {
        return feedTime;
    }

    /**
     * @param feedTime the feedTime to set
     */
    public void setFeedTime(Date feedTime) {
        this.feedTime = feedTime;
    }

    /**
     * @return the enhancements
     */
    public List<Enhancement> getEnhancements() {
        return enhancements;
    }

    /**
     * @param enhancements the enhancements to set
     */
    public void setEnhancements(List<Enhancement> enhancements) {
        this.enhancements = enhancements;
    }
}
