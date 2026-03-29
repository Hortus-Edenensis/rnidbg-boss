package com.zenmen.palmchat.utils.ImageUtils;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.zenmen.palmchat.utils.ImageUtils.c;
import defpackage.a63;
import defpackage.g13;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: com.zenmen.palmchat.utils.ImageUtils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class RunnableC1119a extends c.a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f15706a;
        public final ProgressDialog b;
        public final Runnable c;
        public final Handler d;
        public final Runnable e = new RunnableC1120a();

        /* JADX INFO: renamed from: com.zenmen.palmchat.utils.ImageUtils.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1120a implements Runnable {
            public RunnableC1120a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC1119a.this.f15706a.B1(RunnableC1119a.this);
                if (RunnableC1119a.this.b.getWindow() != null) {
                    RunnableC1119a.this.b.dismiss();
                }
            }
        }

        public RunnableC1119a(c cVar, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
            this.f15706a = cVar;
            this.b = progressDialog;
            this.c = runnable;
            cVar.A1(this);
            this.d = handler;
        }

        @Override // com.zenmen.palmchat.utils.ImageUtils.c.b
        public void a(c cVar) {
            this.b.hide();
        }

        @Override // com.zenmen.palmchat.utils.ImageUtils.c.b
        public void c(c cVar) {
            this.e.run();
            this.d.removeCallbacks(this.e);
        }

        @Override // com.zenmen.palmchat.utils.ImageUtils.c.b
        public void d(c cVar) {
            this.b.show();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.c.run();
            } finally {
                this.d.post(this.e);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(File file, File file2) {
        if (file != null && file2 != null) {
            try {
                ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
                ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
                exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION));
                exifInterface2.saveAttributes();
                return true;
            } catch (Exception e) {
                a63.a("Error copying Exif data", e);
            }
        }
        return false;
    }

    public static int c(File file) {
        if (file == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt == 3) {
                return EffectConstants.ROTATION_DEGREES_180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            a63.a("Error getting Exif data", e);
            return 0;
        }
    }

    public static File d(ContentResolver contentResolver, Uri uri) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        if (uri == null) {
            return null;
        }
        if ("file".equals(uri.getScheme())) {
            return new File(uri.getPath());
        }
        if ("content".equals(uri.getScheme())) {
            try {
                cursorQuery = contentResolver.query(uri, new String[]{"_data", "_display_name"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int columnIndex = uri.toString().startsWith("content://com.google.android.gallery3d") ? cursorQuery.getColumnIndex("_display_name") : cursorQuery.getColumnIndex("_data");
                            if (columnIndex != -1) {
                                String string = cursorQuery.getString(columnIndex);
                                if (!TextUtils.isEmpty(string)) {
                                    File file = new File(string);
                                    cursorQuery.close();
                                    return file;
                                }
                            }
                        }
                    } catch (SecurityException unused) {
                        if (cursorQuery != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SecurityException unused2) {
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return null;
    }

    public static void e(c cVar, String str, String str2, Runnable runnable, Handler handler) {
        new g13(new RunnableC1119a(cVar, runnable, ProgressDialog.show(cVar, str, str2, true, false), handler)).start();
    }

    public static void f(c cVar, String str, String str2, Runnable runnable, Handler handler, ProgressDialog progressDialog) {
        new g13(new RunnableC1119a(cVar, runnable, progressDialog, handler)).start();
    }
}
