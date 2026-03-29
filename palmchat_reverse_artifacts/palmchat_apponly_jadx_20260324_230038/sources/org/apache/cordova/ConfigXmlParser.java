package org.apache.cordova;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.util.Log;
import com.huawei.hms.ads.ex;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.push.core.b;
import com.qq.gdt.action.ActionUtils;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ConfigXmlParser {
    private static String TAG = "ConfigXmlParser";
    private String launchUrl = "file:///android_asset/www/index.html";
    private CordovaPreferences prefs = new CordovaPreferences();
    private Whitelist internalWhitelist = new Whitelist();
    private Whitelist externalWhitelist = new Whitelist();
    private ArrayList<PluginEntry> pluginEntries = new ArrayList<>(20);

    private void setStartUrl(String str) {
        if (Pattern.compile("^[a-z-]+://").matcher(str).find()) {
            this.launchUrl = str;
            return;
        }
        if (str.charAt(0) == '/') {
            str = str.substring(1);
        }
        this.launchUrl = "file:///android_asset/www/" + str;
    }

    public Whitelist getExternalWhitelist() {
        return this.externalWhitelist;
    }

    public Whitelist getInternalWhitelist() {
        return this.internalWhitelist;
    }

    public String getLaunchUrl() {
        return this.launchUrl;
    }

    public ArrayList<PluginEntry> getPluginEntries() {
        return this.pluginEntries;
    }

    public CordovaPreferences getPreferences() {
        return this.prefs;
    }

    public void parse(Activity activity) {
        int identifier = activity.getResources().getIdentifier(b.Y, "xml", activity.getClass().getPackage().getName());
        if (identifier == 0 && (identifier = activity.getResources().getIdentifier(b.Y, "xml", activity.getPackageName())) == 0) {
            LOG.e(TAG, "res/xml/config.xml is missing!");
        } else {
            parse(activity.getResources().getXml(identifier));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:5|(2:7|(3:9|(1:11)|12)(2:13|(1:15)(2:16|(2:32|(3:34|(1:36)(1:37)|(1:(3:40|(1:45)(1:44)|46)(2:47|(1:49)(3:50|(1:55)(1:54)|56))))(2:57|(1:59)(2:60|(1:64))))(2:20|(1:22)(2:23|(1:31)(2:28|(1:30)))))))(6:65|(0)(1:69)|78|71|81|72)|70|78|71|81|72|3) */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0175, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0176, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x017c, code lost:
    
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parse(XmlResourceParser xmlResourceParser) {
        String str;
        String str2;
        ArrayList arrayList;
        boolean z;
        boolean z2;
        String attributeValue;
        this.internalWhitelist.addWhiteListEntry("file:///*", false);
        this.internalWhitelist.addWhiteListEntry("content:///*", false);
        this.internalWhitelist.addWhiteListEntry("data:*", false);
        String attributeValue2 = "";
        String attributeValue3 = attributeValue2;
        ArrayList arrayList2 = null;
        int next = -1;
        boolean zEquals = false;
        boolean z3 = false;
        while (next != 1) {
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if (name.equals("url-filter")) {
                    Log.w(TAG, "Plugin " + attributeValue2 + " is using deprecated tag <url-filter>");
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(2);
                    }
                    arrayList2.add(xmlResourceParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT));
                } else if (name.equals("feature")) {
                    attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                    z3 = true;
                } else if (z3 && name.equals(RemoteMessageConst.MessageBody.PARAM)) {
                    String attributeValue4 = xmlResourceParser.getAttributeValue(null, "name");
                    if (attributeValue4.equals("service")) {
                        attributeValue2 = xmlResourceParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT);
                    } else if (!attributeValue4.equals("package") && !attributeValue4.equals("android-package")) {
                        if (attributeValue4.equals("onload")) {
                            zEquals = ex.Code.equals(xmlResourceParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT));
                        }
                    } else {
                        attributeValue3 = xmlResourceParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT);
                    }
                } else if (name.equals(bt.Q)) {
                    String attributeValue5 = xmlResourceParser.getAttributeValue(null, "origin");
                    String attributeValue6 = xmlResourceParser.getAttributeValue(null, "subdomains");
                    boolean z4 = xmlResourceParser.getAttributeValue(null, "launch-external") != null;
                    if (attributeValue5 != null) {
                        if (z4) {
                            this.externalWhitelist.addWhiteListEntry(attributeValue5, attributeValue6 != null && attributeValue6.compareToIgnoreCase(ex.Code) == 0);
                        } else if ("*".equals(attributeValue5)) {
                            this.internalWhitelist.addWhiteListEntry("http://*/*", false);
                            this.internalWhitelist.addWhiteListEntry("https://*/*", false);
                        } else {
                            this.internalWhitelist.addWhiteListEntry(attributeValue5, attributeValue6 != null && attributeValue6.compareToIgnoreCase(ex.Code) == 0);
                        }
                    }
                } else if (name.equals("preference")) {
                    this.prefs.set(xmlResourceParser.getAttributeValue(null, "name").toLowerCase(Locale.ENGLISH), xmlResourceParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT));
                } else if (name.equals("content") && (attributeValue = xmlResourceParser.getAttributeValue(null, "src")) != null) {
                    setStartUrl(attributeValue);
                }
            } else {
                if (next == 3 && xmlResourceParser.getName().equals("feature")) {
                    this.pluginEntries.add(new PluginEntry(attributeValue2, attributeValue3, zEquals, arrayList2));
                    str = "";
                    str2 = str;
                    arrayList = null;
                    z = false;
                    z2 = false;
                }
                next = xmlResourceParser.next();
                attributeValue2 = str;
                arrayList2 = arrayList;
                attributeValue3 = str2;
                zEquals = z;
                z3 = z2;
            }
            z2 = z3;
            z = zEquals;
            str2 = attributeValue3;
            arrayList = arrayList2;
            str = attributeValue2;
            next = xmlResourceParser.next();
            attributeValue2 = str;
            arrayList2 = arrayList;
            attributeValue3 = str2;
            zEquals = z;
            z3 = z2;
        }
    }
}
