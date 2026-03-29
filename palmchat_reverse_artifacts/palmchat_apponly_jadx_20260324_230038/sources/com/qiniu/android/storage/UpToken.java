package com.qiniu.android.storage;

import com.qiniu.android.utils.UrlSafeBase64;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class UpToken {
    public final String accessKey;
    public final String bucket;
    private long deadline = -1;
    private String returnUrl;
    public final String token;

    private UpToken(String str, String str2, String str3, String str4) {
        this.returnUrl = str;
        this.token = str2;
        this.accessKey = str3;
        this.bucket = str4;
    }

    public static UpToken getInvalidToken() {
        UpToken upToken = new UpToken("", "", "", "");
        upToken.deadline = -1L;
        return upToken;
    }

    public static boolean isInvalid(UpToken upToken) {
        return upToken == null || !upToken.isValid();
    }

    private boolean isValidBeforeTimestamp(long j) {
        long j2 = this.deadline;
        return j2 >= 0 && j < j2;
    }

    public static UpToken parse(String str) {
        if (str == null) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length != 3) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(new String(UrlSafeBase64.decode(strArrSplit[2])));
            String strOptString = jSONObject.optString("scope");
            if (strOptString.equals("")) {
                return null;
            }
            String[] strArrSplit2 = new String[2];
            try {
                strArrSplit2 = strOptString.split(":");
            } catch (Exception unused) {
            }
            String str2 = strArrSplit2.length > 0 ? strArrSplit2[0] : "";
            long jOptInt = jSONObject.optInt("deadline");
            if (jOptInt == 0) {
                return null;
            }
            UpToken upToken = new UpToken(jSONObject.optString("returnUrl"), str, strArrSplit[0], str2);
            upToken.deadline = jOptInt;
            return upToken;
        } catch (Exception unused2) {
            return null;
        }
    }

    public long getDeadline() {
        return this.deadline;
    }

    public boolean hasReturnUrl() {
        return !this.returnUrl.equals("");
    }

    public String index() {
        String str = "";
        if (this.accessKey != null) {
            str = "" + this.accessKey;
        }
        if (this.bucket == null) {
            return str;
        }
        return str + this.bucket;
    }

    public boolean isValid() {
        String str;
        String str2 = this.accessKey;
        return (str2 == null || str2.isEmpty() || (str = this.bucket) == null || str.isEmpty()) ? false : true;
    }

    public boolean isValidBeforeDate(Date date) {
        if (date == null) {
            return false;
        }
        return isValidBeforeTimestamp(date.getTime() / 1000);
    }

    public boolean isValidForDuration(long j) {
        return isValidBeforeTimestamp((new Date().getTime() / 1000) + j);
    }

    public String toString() {
        return this.token;
    }
}
