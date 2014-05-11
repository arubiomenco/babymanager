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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Column(name="id")
    private Key id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="baby_id")
    private Baby baby;
    
    @ManyToOne(optional = false)
    @Column(name="type_id")
    private FeedType feedType;
    
    @Column(name = "amount", precision = 2, nullable = false)
    private double amount;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "feed_time", nullable = false)
    private Date feedTime;
    
    @OneToMany(mappedBy = "feed", fetch = FetchType.EAGER)
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
