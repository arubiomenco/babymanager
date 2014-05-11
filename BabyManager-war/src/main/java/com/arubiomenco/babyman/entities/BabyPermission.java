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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Angel
 */
@Entity
@IdClass(BabyPermissionId.class)
public class BabyPermission implements Serializable {
    @Id
    @Column(name="baby_id")
    private Key babyId;
    
    @Id
    @Column(name="account_id")
    private String accountId;
    
    @Column(name = "can_modify")
    private boolean canModify;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "baby_id", referencedColumnName = "id")
    private Baby baby;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    /**
     * @return the babyId
     */
    public Key getBabyId() {
        return babyId;
    }

    /**
     * @param babyId the babyId to set
     */
    public void setBabyId(Key babyId) {
        this.babyId = babyId;
    }

    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the canModify
     */
    public boolean isCanModify() {
        return canModify;
    }

    /**
     * @param canModify the canModify to set
     */
    public void setCanModify(boolean canModify) {
        this.canModify = canModify;
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
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }
    
    
}
