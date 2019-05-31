/*
 * Copyright (c) 2011-2019 Nexmo Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.nexmo.client.application;

import com.nexmo.client.AbstractClient;
import com.nexmo.client.HttpWrapper;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;

import java.io.IOException;

/**
 * A client for talking to the Nexmo Application API. The standard way to obtain an instance of this class is to use
 * {@link NexmoClient#getApplicationClient()}
 */
public class ApplicationClient extends AbstractClient {
    private ApplicationEndpoint applicationEndpoint;

    public ApplicationClient(HttpWrapper httpWrapper) {
        super(httpWrapper);
        this.applicationEndpoint = new ApplicationEndpoint(httpWrapper);
    }

    /**
     * Create a new application.
     *
     * @param application The application properties for the application to be created with.
     *
     * @return The application which has been created.
     *
     * @throws IOException          if a network error occurred contacting the Nexmo Application API.
     * @throws NexmoClientException if there was a problem with the Nexmo request.
     */
    public Application createApplication(Application application) throws IOException, NexmoClientException {
        return this.applicationEndpoint.create(application);
    }

    /**
     * Update an existing application.
     *
     * @param application The application properties for the application to be updated with.
     *
     * @return The application which has been updated.
     *
     * @throws IOException          if a network error occurred contacting the Nexmo Application API.
     * @throws NexmoClientException if there was a problem with the Nexmo request.
     */
    public Application updateApplication(Application application) throws IOException, NexmoClientException {
        return this.applicationEndpoint.update(application);
    }

    /**
     * Retrieve an application.
     *
     * @param id The id of the application to retrieve.
     *
     * @return The corresponding application.
     *
     * @throws IOException          if a network error occurred contacting the Nexmo Application API.
     * @throws NexmoClientException if there was a problem with the Nexmo request.
     */
    public Application getApplication(String id) throws IOException, NexmoClientException {
        return this.applicationEndpoint.get(id);
    }

    /**
     * Delete an application.
     *
     * @param id The id of the application to delete.
     *
     * @throws IOException          if a network error occurred contacting the Nexmo Application API.
     * @throws NexmoClientException if there was a problem with the Nexmo request.
     */
    public void deleteApplication(String id) throws IOException, NexmoClientException {
        this.applicationEndpoint.delete(id);
    }

    /**
     * List the first page of available applications.
     *
     * @return The list of available applications.
     *
     * @throws IOException          if a network error occurred contacting the Nexmo Application API.
     * @throws NexmoClientException if there was a problem with the Nexmo request.
     */
    public ApplicationList listApplications() throws IOException, NexmoClientException {
        return listApplications(null);
    }

    /**
     * List the available applications.
     *
     * @param listApplicationRequest The page and number of applications per page to list.
     *
     * @return The list of available applications.
     *
     * @throws IOException          if a network error occurred contacting the Nexmo Application API.
     * @throws NexmoClientException if there was a problem with the Nexmo request.
     */
    public ApplicationList listApplications(ListApplicationRequest listApplicationRequest) throws IOException, NexmoClientException {
        return this.applicationEndpoint.list(listApplicationRequest);
    }
}
