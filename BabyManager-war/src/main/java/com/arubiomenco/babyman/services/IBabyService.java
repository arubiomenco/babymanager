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
package com.arubiomenco.babyman.services;

import com.arubiomenco.babyman.dal.IBabiesDao;
import com.arubiomenco.babyman.dal.entities.Baby;
import com.arubiomenco.babyman.services.sdo.BmBaby;
import java.util.List;

/**
 *
 * @author Angel
 */
public interface IBabyService extends IService<IBabiesDao, Long, Baby, BmBaby> {

    List<BmBaby> listBabies(String accountId);

    void create(BmBaby bmBaby, String userId);

    void update(BmBaby bmBaby);

    boolean canModify(BmBaby baby, String userId);
}
