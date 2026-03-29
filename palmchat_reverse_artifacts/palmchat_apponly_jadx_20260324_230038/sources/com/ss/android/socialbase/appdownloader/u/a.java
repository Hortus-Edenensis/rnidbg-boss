package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends u {
    private String b;
    private String pn;

    public a(Context context, com.ss.android.socialbase.downloader.n.u uVar, String str, String str2, String str3) {
        super(context, uVar, str);
        this.b = str2;
        this.pn = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3  */
    @Override // com.ss.android.socialbase.appdownloader.u.pn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent nr() {
        String str;
        String strFx = this.nr.fx("s");
        String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("ak"), strFx);
        String strU2 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("am"), strFx);
        String strU3 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("an"), strFx);
        String strSubstring = null;
        if (!TextUtils.isEmpty(strU3) && strU3.split(",").length == 2) {
            String[] strArrSplit = strU3.split(",");
            String strU4 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx("al"), strFx);
            String strU5 = com.ss.android.socialbase.appdownloader.iz.fx.u(this.nr.fx(LiveConfigKey.AUDIO), strFx);
            if (!TextUtils.isEmpty(strU5) && strU5.split(",").length == 2) {
                String[] strArrSplit2 = strU5.split(",");
                JSONObject jSONObjectB = this.nr.b("download_dir");
                if (jSONObjectB != null) {
                    String strOptString = jSONObjectB.optString("dir_name");
                    if (TextUtils.isEmpty(strOptString) || !strOptString.contains("%s")) {
                        str = this.pn;
                        strSubstring = str;
                        if (strSubstring.length() > 255) {
                            strSubstring = strU4.substring(strSubstring.length() - 255);
                        }
                    } else {
                        try {
                            str = String.format(strOptString, this.pn);
                        } catch (Throwable unused) {
                            str = this.pn;
                        }
                        strSubstring = str;
                        if (strSubstring.length() > 255) {
                        }
                    }
                }
                Intent intent = new Intent(strU);
                intent.putExtra(strArrSplit2[0], strArrSplit2[1]);
                intent.putExtra(strU2, this.b);
                intent.putExtra(strU4, strSubstring);
                intent.putExtra(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
