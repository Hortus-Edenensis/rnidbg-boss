package org.apache.cordova;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class PluginEntry {
    public boolean onload;
    public CordovaPlugin plugin;
    public String pluginClass;
    public String service;
    private List<String> urlFilters;

    public PluginEntry(String str, CordovaPlugin cordovaPlugin) {
        this(str, cordovaPlugin.getClass().getName(), true, cordovaPlugin, null);
    }

    public List<String> getUrlFilters() {
        return this.urlFilters;
    }

    public PluginEntry(String str, String str2, boolean z) {
        this(str, str2, z, null, null);
    }

    @Deprecated
    public PluginEntry(String str, String str2, boolean z, List<String> list) {
        this.service = str;
        this.pluginClass = str2;
        this.onload = z;
        this.urlFilters = list;
        this.plugin = null;
    }

    private PluginEntry(String str, String str2, boolean z, CordovaPlugin cordovaPlugin, List<String> list) {
        this.service = str;
        this.pluginClass = str2;
        this.onload = z;
        this.urlFilters = list;
        this.plugin = cordovaPlugin;
    }
}
