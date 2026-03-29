package com.bytedance.sdk.component.n.nr.nr.nr;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.n.nr.fx;
import com.bytedance.sdk.component.n.nr.u.u.b;
import com.bytedance.sdk.component.n.u.a;
import com.bytedance.sdk.component.n.u.pn;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static fx u;
    private a b;
    private pn fx;
    private String nr;

    private static String fx(pn pnVar) {
        return b.u(pnVar) + "/ad_log_event/";
    }

    private a nr() {
        if (this.b == null) {
            this.b = com.bytedance.sdk.component.n.nr.u.fx(this.nr).b();
        }
        return this.b;
    }

    private pn u() {
        if (this.fx == null) {
            this.fx = com.bytedance.sdk.component.n.nr.u.fx(this.nr).fx();
        }
        return this.fx;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getType(Uri uri) {
        int i;
        com.bytedance.sdk.component.n.u.nr nrVarB;
        u();
        a aVarNr = nr();
        if (aVarNr == null) {
            return null;
        }
        String str = uri.getPath().split("/")[2];
        str.hashCode();
        switch (str) {
            case "trackAdFailed":
                com.bytedance.sdk.component.n.nr.iz.u.u(u()).u(uri.getQueryParameter("did"));
                return null;
            case "adLogStart":
                u();
                aVarNr.u();
                return null;
            case "adLogStop":
                u();
                return null;
            case "adLogDispatch":
                u();
                String queryParameter = uri.getQueryParameter("event");
                if (!TextUtils.isEmpty(queryParameter) && (nrVarB = com.bytedance.sdk.component.n.nr.b.u.u.b(com.bytedance.sdk.component.n.nr.u.u.fx.nr(queryParameter))) != null) {
                    nr().u(nrVarB);
                }
                return null;
            case "trackAdUrl":
                u();
                try {
                    String queryParameter2 = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String[] strArrSplit = com.bytedance.sdk.component.n.nr.u.u.fx.nr(uri.getQueryParameter(FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK)).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strNr = com.bytedance.sdk.component.n.nr.u.u.fx.nr(str2);
                            if (!TextUtils.isEmpty(strNr)) {
                                arrayList.add(strNr);
                            }
                        }
                        com.bytedance.sdk.component.n.nr.iz.u.u(u()).u(queryParameter2, arrayList, zBooleanValue, null, new JSONObject());
                    }
                    break;
                } catch (Throwable unused) {
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

    public static void nr(pn pnVar) {
        if (pnVar == null) {
            return;
        }
        try {
            fx fxVarU = u(pnVar);
            if (fxVarU != null) {
                fxVarU.getType(Uri.parse(fx(pnVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static fx u(pn pnVar) {
        try {
            if (u == null) {
                u = pnVar.b().mv();
            }
        } catch (Exception unused) {
        }
        return u;
    }

    public static void u(com.bytedance.sdk.component.n.u.nr nrVar, pn pnVar) {
        if (nrVar == null || pnVar == null) {
            return;
        }
        try {
            fx fxVarU = u(pnVar);
            if (fxVarU != null) {
                fxVarU.getType(Uri.parse(fx(pnVar) + "adLogDispatch?event=" + com.bytedance.sdk.component.n.nr.u.u.fx.u(nrVar.iz())));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.n.nr.fx.fx.u("dispatch event Throwable:" + th.toString(), pnVar);
        }
    }

    public static void u(String str, List<String> list, boolean z, pn pnVar) {
        if (list == null || list.isEmpty() || pnVar == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.component.n.nr.u.u.fx.u(it.next()));
                sb.append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.n.nr.u.u.fx.u(sb.toString())) + "&replace=" + String.valueOf(z);
            fx fxVarU = u(pnVar);
            if (fxVarU != null) {
                fxVarU.getType(Uri.parse(fx(pnVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void u(String str, pn pnVar) {
        if (TextUtils.isEmpty(str) || pnVar == null) {
            return;
        }
        try {
            fx fxVarU = u(pnVar);
            if (fxVarU != null) {
                fxVarU.getType(Uri.parse(fx(pnVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
