package org.apache.cordovaNew;

import android.content.Context;
import com.huawei.hms.ads.ex;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.gdt.action.ActionUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ConfigXmlParser {
    private static String TAG = "ConfigXmlParser";
    private String launchUrl = "file:///android_asset/www/index.html";
    private CordovaPreferences prefs = new CordovaPreferences();
    private ArrayList<PluginEntry> pluginEntries = new ArrayList<>(20);
    boolean insideFeature = false;
    String service = "";
    String pluginClass = "";
    String paramType = "";
    boolean onload = false;

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

    public String getLaunchUrl() {
        return this.launchUrl;
    }

    public ArrayList<PluginEntry> getPluginEntries() {
        return this.pluginEntries;
    }

    public CordovaPreferences getPreferences() {
        return this.prefs;
    }

    public void handleEndTag(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getName().equals("feature")) {
            this.pluginEntries.add(new PluginEntry(this.service, this.pluginClass, this.onload));
            this.service = "";
            this.pluginClass = "";
            this.insideFeature = false;
            this.onload = false;
        }
    }

    public void handleStartTag(XmlPullParser xmlPullParser) {
        String attributeValue;
        String name = xmlPullParser.getName();
        if (name.equals("feature")) {
            this.insideFeature = true;
            this.service = xmlPullParser.getAttributeValue(null, "name");
            return;
        }
        if (!this.insideFeature || !name.equals(RemoteMessageConst.MessageBody.PARAM)) {
            if (name.equals("preference")) {
                this.prefs.set(xmlPullParser.getAttributeValue(null, "name").toLowerCase(Locale.ENGLISH), xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT));
                return;
            } else {
                if (!name.equals("content") || (attributeValue = xmlPullParser.getAttributeValue(null, "src")) == null) {
                    return;
                }
                setStartUrl(attributeValue);
                return;
            }
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "name");
        this.paramType = attributeValue2;
        if (attributeValue2.equals("service")) {
            this.service = xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT);
            return;
        }
        if (this.paramType.equals("package") || this.paramType.equals("android-package")) {
            this.pluginClass = xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT);
        } else if (this.paramType.equals("onload")) {
            this.onload = ex.Code.equals(xmlPullParser.getAttributeValue(null, ActionUtils.PAYMENT_AMOUNT));
        }
    }

    public void parse(Context context) {
        int identifier = context.getResources().getIdentifier("web_platform_config", "xml", context.getClass().getPackage().getName());
        if (identifier == 0 && (identifier = context.getResources().getIdentifier("web_platform_config", "xml", context.getPackageName())) == 0) {
            LOG.e(TAG, "res/xml/web_platform_config.xml is missing!");
        } else {
            parse(context.getResources().getXml(identifier));
        }
    }

    public void parse(XmlPullParser xmlPullParser) {
        int next = -1;
        while (next != 1) {
            if (next == 2) {
                handleStartTag(xmlPullParser);
            } else if (next == 3) {
                handleEndTag(xmlPullParser);
            }
            try {
                next = xmlPullParser.next();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
    }
}
