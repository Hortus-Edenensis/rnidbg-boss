package com.bytedance.sdk.openadsdk.core.bc.u;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: compiled from: SearchBox */
    public static class fx implements ITTProvider, u {
        private u u;

        public fx(u uVar) {
            this.u = uVar;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public int delete(Uri uri, String str, String[] strArr) {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public String getTableName() {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public String getType(Uri uri) {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public void init() {
            u uVar = this.u;
            if (uVar != null) {
                uVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public void injectContext(Context context) {
            u uVar = this.u;
            if (uVar != null) {
                uVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public Uri insert(Uri uri, ContentValues contentValues) {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.bc.u.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0237nr extends com.bytedance.sdk.openadsdk.core.bc.b implements u {
        private u u;

        public C0237nr(u uVar) {
            this.u = uVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.bytedance.sdk.openadsdk.core.bc.b
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            T t = (T) 0;
            switch (i) {
                case -7999907:
                    return this.u != null ? (T) Integer.valueOf(update((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t;
                case -7999906:
                    return this.u != null ? (T) Integer.valueOf(delete((Uri) pluginValueSet.objectValue(-7999921, Uri.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t;
                case -7999905:
                    if (this.u != null) {
                        return (T) insert((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class));
                    }
                    return null;
                case -7999904:
                    if (this.u != null) {
                        return (T) query((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (String[]) pluginValueSet.objectValue(-7999922, String[].class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class), pluginValueSet.stringValue(-7999925, null));
                    }
                    return null;
                case -7999903:
                    if (this.u != null) {
                        return (T) getType((Uri) pluginValueSet.objectValue(-7999921, Uri.class));
                    }
                    return null;
                case -7999902:
                    init();
                    return null;
                case -7999901:
                    return (T) getTableName();
                case -7999900:
                    if (this.u != null) {
                        injectContext((Context) pluginValueSet.objectValue(-7999920, Context.class));
                    }
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public int delete(Uri uri, String str, String[] strArr) {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public String getTableName() {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public String getType(Uri uri) {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public void init() {
            u uVar = this.u;
            if (uVar != null) {
                uVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public void injectContext(Context context) {
            u uVar = this.u;
            if (uVar != null) {
                uVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public Uri insert(Uri uri, ContentValues contentValues) {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.bc.u.nr.u
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            u uVar = this.u;
            if (uVar != null) {
                return uVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        int delete(Uri uri, String str, String[] strArr);

        String getTableName();

        String getType(Uri uri);

        void init();

        void injectContext(Context context);

        Uri insert(Uri uri, ContentValues contentValues);

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

        int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
    }

    public static Object u(u uVar, Class cls, Bundle bundle) {
        if (u(bundle)) {
            return new C0237nr(uVar);
        }
        if (u(cls)) {
            return new fx(uVar);
        }
        return null;
    }

    public static boolean u(Class cls, Bundle bundle) {
        if (cls == null) {
            return false;
        }
        return u(cls) || u(bundle);
    }

    private static boolean u(Class cls) {
        return cls != null && "com.bytedance.sdk.openadsdk.ITTProvider".equals(cls.getName());
    }

    private static boolean u(Bundle bundle) {
        return bundle != null && bundle.getBoolean("proto2_ittprovider");
    }
}
