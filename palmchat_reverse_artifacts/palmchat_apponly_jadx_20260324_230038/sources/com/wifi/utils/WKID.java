package com.wifi.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class WKID {
    private static final String DHID_KEY = "dhid";
    private static final String DHID_SP_FILE = "__wk_agent_dhid";
    private static final WKID ourInstance = new WKID();
    private static String dhid = null;

    private WKID() {
    }

    private String create(Context context) {
        String androidID = PrivInfoManager.INSTANCE.getAndroidID();
        String str = "";
        if (androidID != null && androidID.length() > 0) {
            if (TextUtils.isEmpty("")) {
                str = "-";
            }
            str = str + androidID;
        }
        return str.length() > 0 ? md5(str) : md5(UUID.randomUUID().toString());
    }

    public static WKID getInstance() {
        return ourInstance;
    }

    private String getRealDHID(String str) {
        return str.substring(0, 32);
    }

    private boolean isValid(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 64) {
            return md5(getRealDHID(str)).equals(str.substring(32));
        }
        return false;
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            return HexUtil.toHexString(messageDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public String get(Context context) {
        Pair<String, Boolean> wkid = getWKID(context);
        if (wkid == null) {
            return null;
        }
        return (String) wkid.first;
    }

    public Pair<String, Boolean> getWKID(Context context) {
        String str = dhid;
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            return Pair.create(dhid, Boolean.FALSE);
        }
        if (context == null) {
            return null;
        }
        String string = context.getSharedPreferences(DHID_SP_FILE, 0).getString("dhid", "");
        if (isValid(string)) {
            String realDHID = getRealDHID(string);
            dhid = realDHID;
            return Pair.create(realDHID, Boolean.FALSE);
        }
        synchronized (this) {
            if (!TextUtils.isEmpty(dhid)) {
                return Pair.create(dhid, Boolean.FALSE);
            }
            String strCreate = create(context);
            dhid = strCreate;
            if (TextUtils.isEmpty(strCreate)) {
                return null;
            }
            return Pair.create(dhid, Boolean.TRUE);
        }
    }
}
