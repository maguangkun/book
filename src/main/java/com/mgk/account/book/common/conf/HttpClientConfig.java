package com.mgk.account.book.common.conf;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: lijiangang
 * @date: 2022-4-2 14:50
 */
@Configuration
public class HttpClientConfig {

    @Bean
    public CloseableHttpClient httpClient() {
        // 长连接保持30秒
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
        //设置整个连接池最大连接数 根据自己的场景决定
        connectionManager.setMaxTotal(500);
        //同路由的并发数,路由是对maxTotal的细分
        connectionManager.setDefaultMaxPerRoute(500);
        RequestConfig requestConfig = RequestConfig.custom()
                //服务器返回数据(response)的时间，超过该时间抛出read timeout
                .setSocketTimeout(10000)
                //连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
                .setConnectTimeout(5000)
                //从连接池中获取连接的超时时间，超过该时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
                .setConnectionRequestTimeout(500)
                .build();
        //headers
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36"));
        headers.add(new BasicHeader("Accept-Encoding", "gzip,deflate"));
        headers.add(new BasicHeader("Accept-Language", "zh-CN"));
        headers.add(new BasicHeader("Connection", "Keep-Alive"));
        headers.add(new BasicHeader("Content-type", "application/json;charset=UTF-8"));

        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .setDefaultHeaders(headers)
                // 保持长连接配置，需要在头添加Keep-Alive
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                //重试次数，默认是3次，没有开启
                // .setRetryHandler(new DefaultHttpRequestRetryHandler(2, true))
                .build();
    }
}
