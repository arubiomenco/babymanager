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
package com.arubiomenco.babyman.dal.impl;

import com.arubiomenco.babyman.dal.IAccountsDao;
import com.arubiomenco.babyman.dal.entities.Account;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angel
 */
@Repository
public class AccountsDao extends JpaDao<String, Account> implements IAccountsDao{
    
}
