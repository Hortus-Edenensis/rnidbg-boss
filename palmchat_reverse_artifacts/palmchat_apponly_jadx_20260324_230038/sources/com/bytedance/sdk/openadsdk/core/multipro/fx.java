package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.bc.u.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements nr.u {
    private com.bytedance.sdk.component.x.fx.u.b u = new com.bytedance.sdk.component.x.fx.u.b();

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public int delete(Uri uri, String str, String[] strArr) {
        return this.u.delete(uri, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public String getTableName() {
        return this.u.u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public String getType(Uri uri) {
        return this.u.getType(uri);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.u.insert(uri, contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.u.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.u.update(uri, contentValues, str, strArr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public void injectContext(Context context) {
    }
}
