package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.webplatform.b;
import defpackage.ei0;
import defpackage.nl0;
import defpackage.vw5;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZXWebView extends CordovaWebView {
    public static final int CENTER = 2;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private static final ExecutorService workingThreadPool = vw5.a(CordovaWebView.TAG);
    private int mSide;

    public ZXWebView(Context context) {
        super(context);
        this.mSide = 2;
        init(null);
    }

    public static ExecutorService getThreadPool() {
        return workingThreadPool;
    }

    private void removeSystemJavaScriptInterface() {
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        removeJavascriptInterface("searchBoxJavaBridge_");
        getSettings().setSavePassword(false);
    }

    public void init(CordovaInterface cordovaInterface, ConfigXmlParser configXmlParser) {
        super.init(cordovaInterface, makeWebViewClient(cordovaInterface), makeWebChromeClient(cordovaInterface), configXmlParser.getPluginEntries(), configXmlParser.getInternalWhitelist(), configXmlParser.getExternalWhitelist(), configXmlParser.getPreferences());
    }

    @Override // org.apache.cordova.CordovaWebView
    public boolean shouldRequestFocusOnInit() {
        return false;
    }

    public ZXWebView(Context context, int i) {
        super(context);
        this.mSide = 2;
        if (i >= 0 && i <= 2) {
            this.mSide = i;
        }
        init(null);
    }

    public ZXWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSide = 2;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        NinePatchDrawable ninePatchDrawable;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ChatItemSide);
            this.mSide = typedArrayObtainStyledAttributes.getInt(3, 2);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.mSide != 2) {
            setBackgroundColor(0);
            if (this.mSide == 1) {
                ninePatchDrawable = (NinePatchDrawable) getResources().getDrawable(R.drawable.selector_message_image_right_item_normal);
            } else {
                ninePatchDrawable = (NinePatchDrawable) getResources().getDrawable(R.drawable.selector_message_image_left_item_normal);
            }
            setBackground(ninePatchDrawable);
        }
        if (!nl0.g()) {
            String userAgentString = getSettings().getUserAgentString();
            getSettings().setUserAgentString(userAgentString + " ZenmenIM");
        } else {
            getSettings().setUserAgentString(ei0.a(this, "lx-palmchat"));
        }
        removeSystemJavaScriptInterface();
        CordovaWebViewClient.setJSSDKPath(b.n().o(getContext()));
    }
}
