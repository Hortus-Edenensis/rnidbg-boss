package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz {
    private final ConcurrentHashMap<String, String> nr;
    private final ConcurrentHashMap<String, String> u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static iz u = new iz();
    }

    private String fx(String str) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.equals(BaseConstants.SCHEME_HTTPS, scheme) && lastPathSegment.endsWith(com.huawei.hms.ads.dynamicloader.b.b)) {
                this.u.put(str, lastPathSegment);
                return lastPathSegment;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static iz u() {
        return u.u;
    }

    public void nr(String str) {
        Iterator<Map.Entry<String, String>> it = this.nr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.u.remove(next.getKey());
            }
        }
    }

    private iz() {
        this.u = new ConcurrentHashMap<>();
        this.nr = new ConcurrentHashMap<>();
    }

    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.nr.containsKey(str2)) {
            return;
        }
        this.nr.put(str2, str);
    }

    public String u(String str) {
        if (TextUtils.isEmpty(str) || this.nr.isEmpty() || !this.nr.containsKey(str)) {
            return null;
        }
        String strFx = fx(str);
        if (this.u.containsValue(strFx)) {
            for (Map.Entry<String, String> entry : this.u.entrySet()) {
                if (TextUtils.equals(entry.getValue(), strFx)) {
                    String str2 = this.nr.get(entry.getKey());
                    this.nr.put(str, str2);
                    if (!this.u.containsKey(str)) {
                        this.u.put(str, strFx);
                    }
                    return str2;
                }
            }
        }
        return this.nr.get(str);
    }

    public String u(DownloadModel downloadModel) {
        String strFx = fx(downloadModel.getDownloadUrl());
        if (strFx == null || TextUtils.isEmpty(strFx)) {
            return null;
        }
        String strPn = com.ss.android.socialbase.downloader.jk.iz.pn(strFx + downloadModel.getPackageName());
        this.nr.put(downloadModel.getDownloadUrl(), strPn);
        return strPn;
    }
}
