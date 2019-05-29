package com.szxs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
@ConfigurationProperties(prefix = "elasticsearch")
public class EsConnetion implements Serializable {
    private String ip;//请求地址
    private int port;//请求端口
    private String clusterName;//请求的elasticsearch集群名称
    private String index;//索引(数据库)
    private String type;//类别(表)

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
