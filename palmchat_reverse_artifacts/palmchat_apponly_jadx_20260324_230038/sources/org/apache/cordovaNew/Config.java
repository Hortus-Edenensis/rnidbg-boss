package org.apache.cordovaNew;

import android.app.Activity;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class Config {
    private static final String TAG = "Config";
    static ConfigXmlParser parser;

    private Config() {
    }

    public static String getErrorUrl() {
        return parser.getPreferences().getString("errorurl", null);
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

    public static void init(Activity activity) {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        parser = configXmlParser;
        configXmlParser.parse(activity);
        parser.getPreferences().setPreferencesBundle(activity.getIntent().getExtras());
    }

    public static boolean isInitialized() {
        return parser != null;
    }

    public static void init() {
        if (parser == null) {
            parser = new ConfigXmlParser();
        }
    }
}
