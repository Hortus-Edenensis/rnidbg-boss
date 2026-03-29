package defpackage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zh extends r15 {
    public static zh d;

    /* JADX INFO: compiled from: SearchBox */
    public interface a<T> {
        void a(T t);
    }

    public zh(ContentResolver contentResolver) {
        super(contentResolver);
    }

    public static zh k(ContentResolver contentResolver) {
        if (d == null) {
            synchronized (zh.class) {
                if (d == null) {
                    d = new zh(contentResolver);
                }
            }
        }
        return d;
    }

    @Override // defpackage.r15
    public void c(int i, Object obj, int i2) {
        super.c(i, obj, i2);
        WeakReference weakReference = new WeakReference((jk2) obj);
        if (weakReference.get() != null) {
            ((jk2) weakReference.get()).a(i, i2);
        }
    }

    @Override // defpackage.r15
    public void d(int i, Object obj, Uri uri) {
        super.d(i, obj, uri);
        WeakReference weakReference = new WeakReference((jk2) obj);
        if (weakReference.get() != null) {
            ((jk2) weakReference.get()).b(i, uri);
        }
    }

    @Override // defpackage.r15
    public void e(int i, Object obj, Cursor cursor) {
        super.e(i, obj, cursor);
        WeakReference weakReference = new WeakReference((jk2) obj);
        if (weakReference.get() != null) {
            ((jk2) weakReference.get()).c(i, cursor);
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // defpackage.r15
    public void f(int i, Object obj, int i2) {
        super.f(i, obj, i2);
        WeakReference weakReference = new WeakReference((jk2) obj);
        if (weakReference.get() != null) {
            ((jk2) weakReference.get()).d(i, i2);
        }
    }
}
