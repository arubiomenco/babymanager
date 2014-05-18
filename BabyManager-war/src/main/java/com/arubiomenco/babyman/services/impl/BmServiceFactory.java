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
import com.arubiomenco.babyman.services.IBabyService;
import com.arubiomenco.babyman.services.IEnhancementService;
import com.arubiomenco.babyman.services.IFeedService;
import com.arubiomenco.babyman.services.IServiceFactory;
import com.arubiomenco.babyman.services.IUserService;

/**
 *
 * @author Angel
 */
public class BmServiceFactory implements IServiceFactory{
    public static IServiceFactory getFactory(){
        return new BmServiceFactory();
    }
    
    public IBabyService getBabyService() {
        IBabiesDao babiesDao = BmApplicationContext.getApplicationContext().getBean( IBabiesDao.class );
        
        return new BmBabyService(babiesDao, this);
    }

    public IUserService getUserService() {
        IAccountsDao accountsDao = BmApplicationContext.getApplicationContext().getBean( IAccountsDao.class );
        
        return new BmUserService(accountsDao, this);
    }

    public IEnhancementService getEnhancementService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public IFeedService getFeedService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
