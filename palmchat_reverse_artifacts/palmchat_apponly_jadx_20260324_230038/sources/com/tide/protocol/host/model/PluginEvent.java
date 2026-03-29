package com.tide.protocol.host.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PluginEvent {
    private Map<String, Object> additionalParams = new HashMap();
    private String pluginName;
    private PluginEventType type;

    public PluginEvent(PluginEventType pluginEventType, String str) {
        this.type = pluginEventType;
        this.pluginName = str;
    }

    public String getPluginName() {
        return this.pluginName;
    }

    public PluginEventType getType() {
        return this.type;
    }

    public void setPluginName(String str) {
        this.pluginName = str;
    }
}
