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
import com.arubiomenco.babyman.dal.IBabiesDao;
import com.arubiomenco.babyman.dal.entities.Account;
import com.arubiomenco.babyman.dal.entities.Baby;
import com.arubiomenco.babyman.dal.entities.BabyPermission;
import com.arubiomenco.babyman.services.IBabyService;
import com.arubiomenco.babyman.services.IServiceFactory;
import com.arubiomenco.babyman.services.sdo.BmBaby;
import com.arubiomenco.babyman.services.sdo.BmUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel
 */
public class BmBabyService extends BmBaseService<IBabiesDao, Long, Baby, BmBaby> implements IBabyService {

    public BmBabyService(IBabiesDao dao, IServiceFactory factory) {
        super(dao, factory);
    }

    public BmBaby convert(Baby original) {
        return BmBaby.fromBaby(original);
    }

    public Baby toOriginal(BmBaby target) {
        return null;
    }

    public List<BmBaby> listBabies(String accountId) {
        List<BmBaby> bmBabies = new ArrayList<BmBaby>();
        Account account = new Account();
        account.setId(accountId);

        List<Baby> babies = getDao().listBabiesByAccount(account);
        for (Baby baby : babies) {
            bmBabies.add( convert(baby) );
        }

        return bmBabies;
    }
    
    public void create ( BmBaby bmBaby, String userId ){
        IAccountsDao accountsDao = getServiceFactory().getUserService().getDao();
        Account account = accountsDao.findById(userId);
        
        Baby baby = toOriginal(bmBaby);
        baby.addPermission(account, true);
                
        getDao().persist(baby);
    }

}
