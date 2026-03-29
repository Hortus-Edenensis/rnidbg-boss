package org.apache.cordova;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
class CordovaUriHelper {
    private static final String TAG = "CordovaUriHelper";
    private CordovaWebView appView;
    private List<String> buildInList = new ArrayList<String>() { // from class: org.apache.cordova.CordovaUriHelper.1
        {
            add("openapp.jdmobile");
        }
    };
    private CordovaInterface cordova;

    public CordovaUriHelper(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        this.appView = cordovaWebView;
        this.cordova = cordovaInterface;
    }

    public static boolean startActivityForUrl(Context context, String str) {
        Intent uri;
        try {
            uri = Intent.parseUri(str, 1);
        } catch (URISyntaxException | Exception unused) {
        }
        if (context.getPackageManager().resolveActivity(uri, 0) == null) {
            return false;
        }
        if (context instanceof Activity) {
            return ((Activity) context).startActivityIfNeeded(uri, -1);
        }
        context.startActivity(uri);
        return true;
    }

    public boolean isInConfigWhiteList(String str) {
        for (String str2 : this.buildInList) {
            if (str != null && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(15)
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && !str.startsWith("Http")) {
            CordovaPlugin plugin = this.appView.pluginManager.getPlugin("General");
            if ((plugin instanceof LxPluginManager) && ((LxPluginManager) plugin).getGeneralPlugin().routerToTargetPage(str)) {
                return true;
            }
            CordovaWebView cordovaWebView = this.appView;
            if (cordovaWebView.pluginManager.isInWhiteList(cordovaWebView.loadedUrl)) {
                LogUtil.d(TAG, "isInWhiteList ");
                if (startActivityForUrl(this.cordova.getActivity(), str)) {
                    LogUtil.d(TAG, "open scheme success " + str);
                    return true;
                }
                LogUtil.d(TAG, "open scheme failed " + str);
            } else {
                LogUtil.d(TAG, "not isInWhiteList forbidden");
            }
        }
        if (this.appView.pluginManager.onOverrideUrlLoading(str)) {
            return true;
        }
        if (str.startsWith("file://") || str.startsWith("data:")) {
            return str.contains("app_webview");
        }
        if (this.appView.getWhitelist().isUrlWhiteListed(str)) {
            return false;
        }
        if (this.appView.getExternalWhitelist().isUrlWhiteListed(str) || isInConfigWhiteList(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.setSelector(null);
                this.cordova.getActivity().startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                LOG.e(TAG, "Error loading url " + str, e);
            }
        }
        return true;
    }
}
