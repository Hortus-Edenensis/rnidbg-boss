package defpackage;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class v17 implements k47 {
    public static /* synthetic */ String g() {
        return "get provider client failed.";
    }

    public static /* synthetic */ String h(Exception exc) {
        return "insert exception:" + exc;
    }

    public static boolean i(Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("", "");
        boolean zJ = j(context, "content://com.oplus.statistics.provider/support", contentValues);
        if (!zJ) {
            n87.c("ContentProviderRecorder", new la7() { // from class: iz6
                @Override // defpackage.la7
                public final Object get() {
                    return v17.l();
                }
            });
        }
        return zJ;
    }

    public static boolean j(Context context, String str, ContentValues contentValues) {
        la7 la7Var;
        Uri uri = Uri.parse(str);
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            la7Var = new la7() { // from class: zy6
                @Override // defpackage.la7
                public final Object get() {
                    return v17.k();
                }
            };
        } else {
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
            try {
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    try {
                        contentProviderClientAcquireUnstableContentProviderClient.insert(uri, contentValues);
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        return true;
                    } catch (RemoteException | IllegalArgumentException | IllegalStateException e) {
                        n87.a("ContentProviderRecorder", new la7() { // from class: gz6
                            @Override // defpackage.la7
                            public final Object get() {
                                return v17.h(e);
                            }
                        });
                        return false;
                    }
                }
                la7Var = new la7() { // from class: dz6
                    @Override // defpackage.la7
                    public final Object get() {
                        return v17.g();
                    }
                };
            } finally {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            }
        }
        n87.e("ContentProviderRecorder", la7Var);
        return false;
    }

    public static /* synthetic */ String k() {
        return "get resolver failed.";
    }

    public static /* synthetic */ String l() {
        return "not support content provider";
    }

    @Override // defpackage.k47
    public void a(@NonNull Context context, @NonNull u17 u17Var) {
        j(context, "content://com.oplus.statistics.provider/track_event", f(u17Var));
    }

    public final ContentValues f(u17 u17Var) {
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, Object> entry : u17Var.h().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                contentValues.put(key, (String) value);
            } else if (value instanceof Integer) {
                contentValues.put(key, (Integer) value);
            } else if (value instanceof Long) {
                contentValues.put(key, (Long) value);
            } else if (value instanceof Boolean) {
                contentValues.put(key, (Boolean) value);
            }
        }
        return contentValues;
    }
}
