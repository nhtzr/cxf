/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.osgi.itests.jaxrs;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PreMatching
public class BookFilterImpl implements BookFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookFilterImpl.class);
    private UriInfo ui;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        LOGGER.info("ui = " + ui);
        LOGGER.info("ui.getAbsolutePath() = " + ui.getAbsolutePath());
        LOGGER.info("ui.getAbsolutePath().getPath() = " + ui.getAbsolutePath().getPath());
    }

    @Override
    public UriInfo getUi() {
        return ui;
    }

    @Override
    @Context
    public void setUi(UriInfo ui) {
        this.ui = ui;
    }

}