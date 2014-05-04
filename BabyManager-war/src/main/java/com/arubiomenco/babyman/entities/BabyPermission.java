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
    private Key babyId;
    
    @Id
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
