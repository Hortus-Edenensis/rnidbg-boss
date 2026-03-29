package com.tide.protocol.plugin;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IComponentLinker {
    void addComponent(Map<String, String> map, Map<String, String> map2);

    boolean checkComponentExist(String str, boolean z);

    String getProxyActivityName(String str);

    String getProxyServiceName(String str);
}
