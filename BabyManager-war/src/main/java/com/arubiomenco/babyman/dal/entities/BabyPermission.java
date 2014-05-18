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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

/**
 *
 * @author Angel
 */
@Entity
public class BabyPermission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key permissionId;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "baby_id", referencedColumnName = "id")
    private Baby baby;

    @Column(name = "can_modify")
    private boolean canModify;
    
    @Column (name = "account_id")
    private String accountId;
    
    @Transient    
    private Account account;
    
    


    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
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
        if (account != null){
            this.accountId = account.getId();
        }else{
            this.accountId = null;
        }
        this.account = account;
    }

    /**
     * @return the permissionId
     */
    public Key getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId the permissionId to set
     */
    public void setPermissionId(Key permissionId) {
        this.permissionId = permissionId;
    }
    
    
}
