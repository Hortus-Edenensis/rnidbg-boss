package com.bytedance.sdk.openadsdk.core.multipro.u;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.bc.u.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.jk.b;
import com.bytedance.sdk.openadsdk.core.jk.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements nr.u {
    private Context u;

    private Context getContext() {
        Context context = this.u;
        return context == null ? dw.getContext() : context;
    }

    private boolean u(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public int delete(Uri uri, String str, String[] strArr) throws Exception {
        String[] strArrSplit;
        if (!u(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            b bVarU = u(str2);
            if (bVarU != null) {
                bVarU.delete(str3, str, strArr);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public String getTableName() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public String getType(Uri uri) {
        String[] strArrSplit;
        if (!u(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 5) {
            String str = strArrSplit[2];
            String str2 = strArrSplit[4];
            b bVarU = u(str);
            if (bVarU != null) {
                if ("execSQL".equals(str2)) {
                    String queryParameter = uri.getQueryParameter("sql");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bVarU.u(Uri.decode(queryParameter));
                    }
                } else if ("transactionBegin".equals(str2)) {
                    bVarU.fx();
                } else if ("transactionSetSuccess".equals(str2)) {
                    bVarU.b();
                } else if ("transactionEnd".equals(str2)) {
                    bVarU.pn();
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public void injectContext(Context context) {
        this.u = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public Uri insert(Uri uri, ContentValues contentValues) throws Exception {
        String[] strArrSplit;
        if (!u(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str = strArrSplit[2];
            String str2 = strArrSplit[3];
            b bVarU = u(str);
            if (bVarU != null) {
                bVarU.insert(str2, null, contentValues);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (u(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit == null || strArrSplit.length < 4) {
            return null;
        }
        String str3 = strArrSplit[2];
        String str4 = strArrSplit[3];
        b bVarU = u(str3);
        if (bVarU != null) {
            return bVarU.query(str4, strArr, str, strArr2, null, null, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws Exception {
        String[] strArrSplit;
        if (!u(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            b bVarU = u(str2);
            if (bVarU != null) {
                bVarU.update(str3, contentValues, str, strArr);
            }
        }
        return 0;
    }

    private b u(String str) {
        if ("ttopensdk.db".equals(str)) {
            return fx.u(getContext()).u();
        }
        if ("ttopensdk2.db".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.jk.u.u(getContext()).u();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public void init() {
    }
}
