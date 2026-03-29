package org.apache.cordova;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LinearLayoutSoftKeyboardDetect extends LinearLayout {
    private static final String TAG = "SoftKeyboardDetect";
    private App appPlugin;
    private int oldHeight;
    private int oldWidth;
    private PluginManager pluginManager;
    private int screenHeight;
    private int screenWidth;

    public LinearLayoutSoftKeyboardDetect(Context context, PluginManager pluginManager, int i, int i2) {
        super(context);
        this.oldHeight = 0;
        this.oldWidth = 0;
        this.appPlugin = null;
        this.screenWidth = i;
        this.screenHeight = i2;
        this.pluginManager = pluginManager;
    }

    private void sendEvent(String str) {
        if (this.appPlugin == null) {
            this.appPlugin = (App) this.pluginManager.getPlugin(App.PLUGIN_NAME);
        }
        App app = this.appPlugin;
        if (app == null) {
            LOG.w(TAG, "Unable to fire event without existing plugin");
        } else {
            app.fireJavascriptEvent(str);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        LOG.v(TAG, "We are in our onMeasure method");
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        LOG.v(TAG, "Old Height = %d", Integer.valueOf(this.oldHeight));
        LOG.v(TAG, "Height = %d", Integer.valueOf(size));
        LOG.v(TAG, "Old Width = %d", Integer.valueOf(this.oldWidth));
        LOG.v(TAG, "Width = %d", Integer.valueOf(size2));
        int i3 = this.oldHeight;
        if (i3 == 0 || i3 == size) {
            LOG.d(TAG, "Ignore this event");
        } else {
            int i4 = this.screenHeight;
            if (i4 == size2) {
                this.screenHeight = this.screenWidth;
                this.screenWidth = i4;
                LOG.v(TAG, "Orientation Change");
            } else if (size > i3) {
                sendEvent("hidekeyboard");
            } else if (size < i3) {
                sendEvent("showkeyboard");
            }
        }
        this.oldHeight = size;
        this.oldWidth = size2;
    }
}
