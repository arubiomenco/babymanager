package com.arubiomenco.babyman.entities;

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
