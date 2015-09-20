/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.usergrid.persistence.cache;


import com.google.inject.Inject;
import org.apache.usergrid.persistence.cache.guice.CacheModule;
import org.apache.usergrid.persistence.core.test.ITRunner;
import org.apache.usergrid.persistence.core.test.UseModules;
import org.apache.usergrid.persistence.model.entity.SimpleId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static junit.framework.TestCase.assertNotNull;


@RunWith( ITRunner.class )
@UseModules( { CacheModule.class } )
public class ScopedCacheTest {

    @Inject
    protected CacheFactory<String, Map<String, Object>> cf;

    protected CacheScope scope;


    @Before
    public void mockApp(){
        this.scope = new CacheScope( new SimpleId( "application" ) );
    }


    @Test
    public void testBasicOperation() {

        ScopedCache cache = cf.getScopedCache(scope);
        assertNotNull( cache );
    }

}