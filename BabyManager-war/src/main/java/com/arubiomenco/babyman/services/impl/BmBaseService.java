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

import com.arubiomenco.babyman.dal.IDao;
import com.arubiomenco.babyman.services.IService;
import com.arubiomenco.babyman.services.IServiceFactory;

/**
 *
 * @author Angel
  */
public abstract class BmBaseService<D extends IDao, K, O, T> implements IService<D, K, O, T>{
    private D dao;
    private IServiceFactory factory;
    
    public BmBaseService(D dao, IServiceFactory factory){
        this.dao = dao;
        this.factory = factory;
    }
    
    public void persist(T entity) {
        dao.persist(entity);
    }

    public void remove(T entity) {
        dao.remove(entity);
    }

    public T findById(K id) {
        return (T) dao.findById(id);
    }
    
    public D getDao(){
        return this.dao;
    }
    
    public IServiceFactory getServiceFactory(){
        return this.factory;
    }
}
