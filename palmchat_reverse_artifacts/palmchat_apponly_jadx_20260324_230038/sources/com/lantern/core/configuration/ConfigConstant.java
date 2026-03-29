package com.lantern.core.configuration;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ConfigConstant {
    public static final String COLUMN_AVAILABLETIME = "availbletime";
    public static final String COLUMN_EVENTID = "eventid";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_LIMIT = "eventlimit";
    public static final String COLUMN_OP = "op";
    public static final String _ID = "_id";

    private ConfigConstant() {
    }

    public static String getAuthority(Context context) {
        return context.getApplicationContext().getPackageName() + ".config.provider";
    }

    public static Uri getContentURI(Context context) {
        return Uri.parse("content://" + getAuthority(context) + "/config");
    }
}
