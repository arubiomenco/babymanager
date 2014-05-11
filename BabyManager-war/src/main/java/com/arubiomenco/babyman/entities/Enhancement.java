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
    @Column(name="id")
    private Key id;
    
    @ManyToOne(optional = false)
    @Column(name="type_id", nullable = false)
    private EnhancementType type;
    
    @Column(name = "amount", precision = 2, nullable = false)
    private double amount;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="enh_time")
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
