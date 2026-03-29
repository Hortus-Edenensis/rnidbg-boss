package com.bytedance.sdk.component.n.nr.nr.nr;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.n.nr.fx.fx;
import com.bytedance.sdk.component.n.nr.u.u.b;
import com.bytedance.sdk.component.n.u.a;
import com.bytedance.sdk.component.n.u.pn;
import com.bytedance.sdk.component.n.u.x;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private a b;
    private pn fx;
    private Context nr;
    private String u;

    public u(String str) {
        this.u = str;
        x xVarFx = com.bytedance.sdk.component.n.nr.u.fx(str);
        this.fx = xVarFx.fx();
        this.b = xVarFx.b();
    }

    private a fx() {
        if (this.b == null) {
            this.b = com.bytedance.sdk.component.n.nr.u.fx(this.u).b();
        }
        return this.b;
    }

    private pn nr() {
        if (this.fx == null) {
            this.fx = com.bytedance.sdk.component.n.nr.u.fx(this.u).fx();
        }
        return this.fx;
    }

    public static void u(pn pnVar) {
        if (pnVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverNr = nr(pnVar);
            if (contentResolverNr != null) {
                contentResolverNr.getType(Uri.parse(fx(pnVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getType(Uri uri) {
        int i;
        JSONObject jSONObject;
        nr();
        a aVarFx = fx();
        if (aVarFx == null) {
            fx.nr("getType center is null", nr());
            return null;
        }
        String str = uri.getPath().split("/")[2];
        str.hashCode();
        switch (str) {
            case "trackAdFailed":
                com.bytedance.sdk.component.n.nr.iz.u.u(nr()).u(uri.getQueryParameter("did"));
                return null;
            case "adLogStart":
                nr();
                aVarFx.u();
                return null;
            case "adLogStop":
                nr();
                return null;
            case "adLogDispatch":
                nr();
                com.bytedance.sdk.component.n.u.nr nrVarB = com.bytedance.sdk.component.n.nr.b.u.u.b(com.bytedance.sdk.component.n.nr.u.u.fx.nr(uri.getQueryParameter("event")));
                if (nrVarB != null) {
                    aVarFx.u(nrVarB);
                }
                return null;
            case "trackAdUrl":
                try {
                    String queryParameter = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String queryParameter2 = uri.getQueryParameter(FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK);
                    try {
                        jSONObject = new JSONObject(com.bytedance.sdk.component.n.nr.u.u.fx.nr(uri.getQueryParameter("extraMate")));
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    String[] strArrSplit = com.bytedance.sdk.component.n.nr.u.u.fx.nr(queryParameter2).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strNr = com.bytedance.sdk.component.n.nr.u.u.fx.nr(str2);
                            if (!TextUtils.isEmpty(strNr)) {
                                arrayList.add(strNr);
                            }
                        }
                        com.bytedance.sdk.component.n.nr.iz.u.u(nr()).u(queryParameter, arrayList, zBooleanValue, null, jSONObject);
                    }
                    break;
                } catch (Throwable unused2) {
                }
                return null;
            default:
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private static String fx(pn pnVar) {
        String strU = b.u(pnVar);
        StringBuilder sb = new StringBuilder();
        sb.append(strU);
        sb.append("/");
        sb.append("csj_mediation".equals(pnVar.pn()) ? "gromore_ad_log_event" : "ad_log_event");
        sb.append("/");
        return sb.toString();
    }

    private static ContentResolver nr(pn pnVar) {
        try {
            if (pnVar.getContext() != null) {
                return pnVar.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void u(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        if (nrVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverNr = nr(pnVar);
            if (contentResolverNr != null) {
                contentResolverNr.getType(Uri.parse(fx(pnVar) + "adLogDispatch?event=" + com.bytedance.sdk.component.n.nr.u.u.fx.u(nrVar.iz())));
            }
        } catch (Throwable th) {
            fx.u("dispatch event Throwable:" + th.toString(), pnVar);
        }
    }

    public static void u(String str, List<String> list, boolean z, pn pnVar, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.component.n.nr.u.u.fx.u(it.next()));
                sb.append(",");
            }
            String strU = com.bytedance.sdk.component.n.nr.u.u.fx.u(sb.toString());
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(strU) + "&replace=" + String.valueOf(z) + "&extraMate=" + com.bytedance.sdk.component.n.nr.u.u.fx.u(jSONObject.toString());
            ContentResolver contentResolverNr = nr(pnVar);
            if (contentResolverNr != null) {
                contentResolverNr.getType(Uri.parse(fx(pnVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void u(String str, pn pnVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverNr = nr(pnVar);
            if (contentResolverNr != null) {
                contentResolverNr.getType(Uri.parse(fx(pnVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    public void u(Context context) {
        this.nr = context;
    }

    public String u() {
        return "csj_mediation".equals(this.u) ? "gromore_ad_log_event" : "ad_log_event";
    }
}
