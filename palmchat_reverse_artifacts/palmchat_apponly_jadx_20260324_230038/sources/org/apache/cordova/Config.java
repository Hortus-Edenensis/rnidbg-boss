package org.apache.cordova;

import android.app.Activity;
import android.util.Log;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class Config {
    private static final String TAG = "Config";
    public static ConfigXmlParser parser;

    private Config() {
    }

    public static void addWhiteListEntry(String str, boolean z) {
        ConfigXmlParser configXmlParser = parser;
        if (configXmlParser == null) {
            Log.e(TAG, "Config was not initialised. Did you forget to Config.init(this)?");
        } else {
            configXmlParser.getInternalWhitelist().addWhiteListEntry(str, z);
        }
    }

    public static String getErrorUrl() {
        return parser.getPreferences().getString("errorurl", null);
    }

    public static Whitelist getExternalWhitelist() {
        return parser.getExternalWhitelist();
    }

    public static List<PluginEntry> getPluginEntries() {
        return parser.getPluginEntries();
    }

    public static CordovaPreferences getPreferences() {
        return parser.getPreferences();
    }

    public static String getStartUrl() {
        ConfigXmlParser configXmlParser = parser;
        return configXmlParser == null ? "file:///android_asset/www/index.html" : configXmlParser.getLaunchUrl();
    }

    public static Whitelist getWhitelist() {
        return parser.getInternalWhitelist();
    }

    public static void init(Activity activity) {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        parser = configXmlParser;
        configXmlParser.parse(activity);
        parser.getPreferences().setPreferencesBundle(activity.getIntent().getExtras());
    }

    public static boolean isInitialized() {
        return parser != null;
    }

    public static boolean isUrlExternallyWhiteListed(String str) {
        ConfigXmlParser configXmlParser = parser;
        if (configXmlParser != null) {
            return configXmlParser.getExternalWhitelist().isUrlWhiteListed(str);
        }
        Log.e(TAG, "Config was not initialised. Did you forget to Config.init(this)?");
        return false;
    }

    public static boolean isUrlWhiteListed(String str) {
        ConfigXmlParser configXmlParser = parser;
        if (configXmlParser != null) {
            return configXmlParser.getInternalWhitelist().isUrlWhiteListed(str);
        }
        Log.e(TAG, "Config was not initialised. Did you forget to Config.init(this)?");
        return false;
    }

    public static void init() {
        if (parser == null) {
            parser = new ConfigXmlParser();
        }
    }
}
