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

import com.arubiomenco.babyman.dal.IEnhancementsDao;
import com.arubiomenco.babyman.dal.entities.Baby;
import com.arubiomenco.babyman.dal.entities.Enhancement;
import com.arubiomenco.babyman.dal.entities.EnhancementType;
import com.google.appengine.api.datastore.Key;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Angel
 */
@Repository
public class EnhancementsDao extends JpaDao<Key, Enhancement> implements IEnhancementsDao{

    public List<EnhancementType> listEnhancementsType() {
        Query query = em.createQuery("SELECT et FROM EnhancementType et");
        return (List<EnhancementType>) query.getResultList();
    }

    public List<Enhancement> listEnhancementsByBaby(Baby baby) {
        Query query = em.createQuery("SELECT e FROM Enhancement e WHERE e.baby = :baby");
        query.setParameter("baby", baby);
        return (List<Enhancement>) query.getResultList();
    }
    
}
