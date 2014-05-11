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

/**
 *
 * @author Angel
 */
public class BabyPermissionId implements Serializable{
    private Key babyId;
    private String accountId;

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof BabyPermissionId){
            BabyPermissionId permId = (BabyPermissionId) obj;
            equals = ((permId.accountId == null && accountId == null) || (permId.accountId.equals(accountId))) && permId.babyId == babyId;
        }
        return equals;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        if (accountId != null){
            hashCode += accountId.hashCode();
        }
        if (babyId != null){
            hashCode += babyId.hashCode();
        }
        return hashCode;
    }
    
    

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
}
