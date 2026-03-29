package com.tide.host.proxy;

import android.content.Intent;
import android.os.Bundle;
import com.tide.host.HostManager;
import com.tide.protocol.context.ITideActivity;
import com.tide.protocol.context.base.ProxyBaseActivity;
import com.tide.protocol.managers.ComponentManager;
import com.tide.protocol.util.TdLogUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ProxyActivity extends ProxyBaseActivity {
    @Override // com.tide.protocol.context.base.ProxyBaseActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        try {
            Intent intent = getIntent();
            if (intent != null) {
                ITideActivity iTideActivityLoadPluginActivity = HostManager.getInstance().loadPluginActivity(this, intent.getStringExtra(ComponentManager.PLUGIN_NAME), intent.getStringExtra(ComponentManager.COMPONENT_CLASS_PATH));
                this.pluginActivity = iTideActivityLoadPluginActivity;
                if (iTideActivityLoadPluginActivity != null) {
                    iTideActivityLoadPluginActivity.attachProxy(this);
                    this.pluginActivity.onCreate(bundle);
                } else {
                    super.onCreate(bundle);
                    TdLogUtils.error("not find plugin Activity");
                    finish();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            finish();
        }
    }
}
