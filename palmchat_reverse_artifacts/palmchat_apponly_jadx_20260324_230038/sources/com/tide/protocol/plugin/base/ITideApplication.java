package com.tide.protocol.plugin.base;

import android.content.Context;
import com.tide.protocol.context.base.IResource;
import com.tide.protocol.plugin.ITideComponentFactory;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITideApplication {
    void addComponent(Map<String, String> map, Map<String, String> map2);

    ITideComponentFactory getComponentFactory();

    String getProxyActivityClassName(String str);

    String getProxyServiceClassName(String str);

    void onCreate(Context context, IResource iResource);

    void setPluginName(String str);
}
