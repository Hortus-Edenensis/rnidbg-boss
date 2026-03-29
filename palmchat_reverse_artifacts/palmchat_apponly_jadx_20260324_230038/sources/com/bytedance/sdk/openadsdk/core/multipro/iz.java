package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.bc.u.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements nr.u {
    private static List<nr.u> fx;
    private static WeakReference<Context> nr;
    private static volatile iz u;

    static {
        List<nr.u> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        fx = listSynchronizedList;
        listSynchronizedList.add(new fx());
        fx.add(new com.bytedance.sdk.openadsdk.core.multipro.u.nr());
        fx.add(new com.bytedance.sdk.openadsdk.core.multipro.fx.u());
        fx.add(new u(new com.bytedance.sdk.component.n.nr.nr.nr.u("csj")));
        Iterator<nr.u> it = fx.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
    }

    private iz() {
    }

    private Context getContext() {
        WeakReference<Context> weakReference = nr;
        return (weakReference == null || weakReference.get() == null) ? dw.getContext() : nr.get();
    }

    private boolean nr(Uri uri) {
        return true;
    }

    public static iz u(Context context) {
        if (context != null) {
            nr = new WeakReference<>(context.getApplicationContext());
        }
        if (u == null) {
            synchronized (iz.class) {
                if (u == null) {
                    u = new iz();
                }
            }
        }
        return u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            nr.u uVarU = u(uri);
            if (uVarU != null) {
                return uVarU.delete(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public String getType(Uri uri) {
        try {
            nr.u uVarU = u(uri);
            if (uVarU != null) {
                return uVarU.getType(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public void injectContext(Context context) {
        Iterator<nr.u> it = fx.iterator();
        while (it.hasNext()) {
            it.next().injectContext(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            nr.u uVarU = u(uri);
            if (uVarU != null) {
                return uVarU.insert(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            nr.u uVarU = u(uri);
            if (uVarU != null) {
                return uVarU.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            nr.u uVarU = u(uri);
            if (uVarU != null) {
                return uVarU.update(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private nr.u u(Uri uri) {
        if (uri == null || !nr(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (nr.u uVar : fx) {
            if (str.equals(uVar.getTableName())) {
                return uVar;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
    public void init() {
    }
}
