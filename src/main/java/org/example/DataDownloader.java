package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class DataDownloader {

    public static Properties getProperties()  {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("links.properties")).getPath();
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(rootPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return appProps;
    }
    public static String getData(String path) {
        HttpGet request = new HttpGet(path);
        String result = null;
        int status;
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
             status = response.getStatusLine().getStatusCode();

            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
