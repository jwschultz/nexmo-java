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

import com.nexmo.client.HttpConfig;
import com.nexmo.client.HttpWrapper;
import org.apache.http.client.methods.RequestBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetApplicationMethodTest {
    private GetApplicationMethod method;

    @Before
    public void setUp() {
        method = new GetApplicationMethod(new HttpWrapper());
    }

    @Test
    public void testMakeRequest() throws Exception {
        RequestBuilder builder = method.makeRequest("78d335fa323d01149c3dd6f0d48968cf");

        assertEquals("GET", builder.getMethod());
        assertEquals("application/json", builder.getFirstHeader("Content-Type").getValue());
    }

    @Test
    public void testDefaultUri() throws Exception {
        RequestBuilder builder = method.makeRequest("78d335fa323d01149c3dd6f0d48968cf");

        assertEquals("GET", builder.getMethod());
        assertEquals("https://api.nexmo.com/v2/applications/78d335fa323d01149c3dd6f0d48968cf", builder.build().getURI().toString());
    }

    @Test
    public void testCustomUri() throws Exception {
        HttpWrapper wrapper = new HttpWrapper(HttpConfig.builder().baseUri("https://example.com").build());
        GetApplicationMethod method = new GetApplicationMethod(wrapper);

        RequestBuilder builder = method.makeRequest("78d335fa323d01149c3dd6f0d48968cf");

        assertEquals("GET", builder.getMethod());
        assertEquals("https://example.com/v2/applications/78d335fa323d01149c3dd6f0d48968cf", builder.build().getURI().toString());
    }
}
