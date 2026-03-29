package com.bytedance.pangle;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.pangle.plugin.Plugin;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Keep
public class ZeusApplication extends PluginContext {
    Application mHostApplication;

    public Function attach(Function function) {
        return null;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void attach(Plugin plugin, Application application) {
        this.mPlugin = plugin;
        this.mHostApplication = application;
        this.mPlugin.setPluginBridge(attach(plugin.getApiBridge()));
        attachBaseContext(application);
        onCreate();
    }

    public void onCreate() {
    }
}
