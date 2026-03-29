package com.lantern.core.database;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class EventSp extends PubSharedPref {
    private static final String DBERR = "dbErr";
    private static final String MAC = "mac";
    private static final String SP_SECREKEY_FILENAME = "secrekey_sp";
    private static final String SP_USERINFO_FILENAME = "event_sp";
    public static EventSp mSecreKeySp;
    private static EventSp mUserSP;

    public EventSp(Context context, String str, int i) {
        super(context, str, i);
    }

    public static EventSp getInstance(Context context) {
        if (mUserSP == null) {
            mUserSP = new EventSp(context.getApplicationContext(), SP_USERINFO_FILENAME, 0);
        }
        if (mSecreKeySp == null) {
            mSecreKeySp = new EventSp(context.getApplicationContext(), SP_SECREKEY_FILENAME, 0);
        }
        return mUserSP;
    }

    public boolean getDBErr() {
        return readBoolean(DBERR);
    }

    public String getMac() {
        return readString("mac");
    }

    public void setDBErr(boolean z) {
        write(DBERR, z);
    }

    public void setMac(String str) {
        write("mac", str);
    }
}
