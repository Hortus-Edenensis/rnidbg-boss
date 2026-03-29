package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.bc.u.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements nr.u {
    private com.bytedance.sdk.component.n.nr.nr.nr.u u;

    public u(com.bytedance.sdk.component.n.nr.nr.nr.u uVar) {
        this.u = uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public int delete(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.n.nr.nr.nr.u uVar = this.u;
        if (uVar != null) {
            return uVar.delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public String getTableName() {
        com.bytedance.sdk.component.n.nr.nr.nr.u uVar = this.u;
        if (uVar != null) {
            return uVar.u();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public String getType(Uri uri) {
        com.bytedance.sdk.component.n.nr.nr.nr.u uVar = this.u;
        if (uVar != null) {
            return uVar.getType(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public void injectContext(Context context) {
        com.bytedance.sdk.component.n.nr.nr.nr.u uVar = this.u;
        if (uVar != null) {
            uVar.u(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.n.nr.nr.nr.u uVar = this.u;
        if (uVar != null) {
            return uVar.insert(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.n.nr.nr.nr.u uVar = this.u;
        if (uVar != null) {
            return uVar.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.n.nr.nr.nr.u uVar = this.u;
        if (uVar != null) {
            return uVar.update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public void init() {
    }
}
