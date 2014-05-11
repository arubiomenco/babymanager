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
package com.arubiomenco.babyman.services.impl;

import com.arubiomenco.babyman.dal.IAccountsDao;
import com.arubiomenco.babyman.dal.entities.Account;
import com.arubiomenco.babyman.services.IServiceFactory;
import com.arubiomenco.babyman.services.IUserService;
import com.arubiomenco.babyman.services.sdo.BmUser;

/**
 *
 * @author Angel
 */
public class BmUserService extends BmBaseService<IAccountsDao, String, Account, BmUser> implements IUserService{
    public BmUserService(IAccountsDao dao, IServiceFactory factory){
        super ( dao, factory );
    }
    
    public BmUser getUser(String userId) {
        Account account = getDao().findById(userId);
        BmUser bmUser = null;
        if (account != null){
            bmUser = convert ( account );
        }
        return bmUser;
    }

    public BmUser convert(Account original) {
        BmUser bmUser = null;
        if (original != null){
            bmUser = new BmUser();
            bmUser.setUserId( original.getId() );
        }
        return bmUser;
    }

    public Account toOriginal(BmUser target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
