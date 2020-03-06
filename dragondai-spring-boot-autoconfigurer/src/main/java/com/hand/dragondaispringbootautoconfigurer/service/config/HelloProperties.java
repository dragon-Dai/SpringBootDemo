package com.hand.dragondaispringbootautoconfigurer.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dragondai.hello")
public class HelloProperties {
    private String prefix = "dragondai-prefix";

    private String suffix = "dragondai-suffix";

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
