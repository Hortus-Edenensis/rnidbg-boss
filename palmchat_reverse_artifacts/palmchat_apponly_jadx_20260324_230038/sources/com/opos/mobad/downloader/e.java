package com.opos.mobad.downloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.opos.cmn.i.d;
import com.opos.mobad.d.a;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e implements com.opos.mobad.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f8781a;
    private LruCache<String, Buffer> b;
    private LruCache<String, WeakReference<Buffer>> c;
    private Context d;

    public e(Context context) {
        this(context, new j(context));
    }

    private static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = 1;
        if (options != null) {
            try {
                int i4 = options.outHeight;
                int i5 = options.outWidth;
                com.opos.cmn.an.f.a.b("fCache", "options.outHeight=" + i4 + ",options.outWidth=" + i5);
                if (i4 > i2 || i5 > i) {
                    int i6 = i4 / 2;
                    int i7 = i5 / 2;
                    while (i6 / i3 > i2 && i7 / i3 > i) {
                        i3 *= 2;
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("fCache", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("fCache", "calculateInSampleSize reqWidth=" + i + ",reqHeight=" + i2 + ",inSampleSize=" + i3);
        return i3;
    }

    public e(Context context, h hVar) {
        this.d = context.getApplicationContext();
        this.f8781a = hVar;
        this.c = new LruCache<>(50);
        this.b = new com.opos.cmn.i.d(20, new d.a<String, Buffer>() { // from class: com.opos.mobad.downloader.e.1
            @Override // com.opos.cmn.i.d.a
            public void a(String str, Buffer buffer) {
                e.this.c.put(str, new WeakReference(buffer));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File b(File file) {
        return new File(file.getParent(), file.getName() + ".tmp");
    }

    public int a(String str, BufferedSource bufferedSource, String str2, String str3) {
        return a(str, bufferedSource, new Buffer(), str2, str3);
    }

    public int a(String str, BufferedSource bufferedSource, Buffer buffer, String str2, String str3) {
        long j;
        File fileA = a(str, str3);
        if (fileA == null) {
            return 2;
        }
        if (fileA.exists()) {
            fileA.delete();
        }
        BufferedSink bufferedSink = null;
        try {
            try {
                File fileB = b(fileA);
                if (fileB.exists()) {
                    fileB.delete();
                }
                BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(fileB));
                do {
                    j = bufferedSource.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                    if (j >= 0) {
                        bufferedSinkBuffer.write(buffer, j);
                    }
                } while (j >= 0);
                if (TextUtils.isEmpty(str2) || str2.equals(com.opos.cmn.an.b.c.a(fileB))) {
                    fileB.renameTo(fileA);
                    a(bufferedSource);
                    a(buffer);
                    if (bufferedSinkBuffer == null) {
                        return 0;
                    }
                    try {
                        bufferedSinkBuffer.flush();
                        bufferedSinkBuffer.close();
                        return 0;
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("fCache", "close", e);
                        return 0;
                    }
                }
                com.opos.cmn.an.f.a.b("fCache", "write but md5 fail");
                fileB.delete();
                a(bufferedSource);
                a(buffer);
                if (bufferedSinkBuffer == null) {
                    return 1;
                }
                try {
                    bufferedSinkBuffer.flush();
                    bufferedSinkBuffer.close();
                    return 1;
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("fCache", "close", e2);
                    return 1;
                }
            } catch (Throwable th) {
                a(bufferedSource);
                a(buffer);
                if (0 != 0) {
                    try {
                        bufferedSink.flush();
                        bufferedSink.close();
                    } catch (Exception e3) {
                        com.opos.cmn.an.f.a.b("fCache", "close", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            com.opos.cmn.an.f.a.b("fCache", "is", e4);
            a(bufferedSource);
            a(buffer);
            if (0 != 0) {
                try {
                    bufferedSink.flush();
                    bufferedSink.close();
                } catch (Exception e5) {
                    com.opos.cmn.an.f.a.b("fCache", "close", e5);
                }
            }
            return 2;
        }
    }

    public void b(String str, String str2, int i, int i2, a.InterfaceC0732a interfaceC0732a) {
        File fileA = this.f8781a.a(str);
        if (fileA != null) {
            a(fileA, str2, i, i2, interfaceC0732a);
        } else if (interfaceC0732a != null) {
            interfaceC0732a.a(2, null);
        }
    }

    public static Bitmap a(InputStream inputStream) {
        Bitmap bitmapDecodeStream = null;
        if (inputStream != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("fCache", "", e);
            }
        }
        com.opos.cmn.an.f.a.b("fCache", "decodeSampledBitmapFromStream res=" + inputStream + ",dst:" + bitmapDecodeStream);
        return bitmapDecodeStream;
    }

    public void b(String str, String str2, a.InterfaceC0732a interfaceC0732a) {
        b(str, str2, -1, -1, interfaceC0732a);
    }

    public static Bitmap a(Buffer buffer, int i, int i2) {
        Bitmap bitmapA = null;
        if (buffer != null) {
            try {
                Buffer bufferClone = buffer.clone();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(buffer.inputStream(), null, options);
                options.inSampleSize = a(options, i, i2);
                options.inJustDecodeBounds = false;
                bitmapA = com.opos.cmn.an.e.c.a.a(BitmapFactory.decodeStream(bufferClone.inputStream(), null, options), i, i2, options.inSampleSize);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("BitmapTool", "", e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("decodeSampledBitmapFromStream res=");
        Object obj = com.igexin.push.core.b.m;
        Object obj2 = buffer;
        if (buffer == null) {
            obj2 = com.igexin.push.core.b.m;
        }
        sb.append(obj2);
        sb.append(",reqWidth=");
        sb.append(i);
        sb.append(",reqHeight=");
        sb.append(i2);
        sb.append(",dst=");
        if (bitmapA != null) {
            obj = bitmapA;
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("BitmapTool", sb.toString());
        return bitmapA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(File file, String str, int i, int i2, a.InterfaceC0732a interfaceC0732a) {
        Bitmap bitmapA;
        com.opos.cmn.an.f.a.b("fCache", "decodeWidthFile:" + file.getAbsolutePath());
        for (int i3 = 0; i3 < 3 && !file.exists(); i3++) {
            try {
                Thread.sleep(10L);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("fCache", "sleep fail", e);
            }
        }
        if (!file.exists()) {
            com.opos.cmn.an.f.a.b("fCache", "cache file no exits");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("fCache", "decode is");
            try {
                if (i <= 0 || i2 <= 0) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                        try {
                            Bitmap bitmapA2 = a((InputStream) bufferedInputStream);
                            bufferedInputStream.close();
                            fileInputStream.close();
                            bitmapA = bitmapA2;
                        } finally {
                        }
                    } finally {
                    }
                } else {
                    bitmapA = com.opos.cmn.an.e.c.a.a(file.getAbsolutePath(), i, i2);
                }
                if (bitmapA != null) {
                    if (interfaceC0732a == null) {
                        return true;
                    }
                    interfaceC0732a.a(0, bitmapA);
                    return true;
                }
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.b("fCache", "decode file fail:", th);
            }
            return false;
        }
        com.opos.cmn.an.f.a.b("fCache", "decode bf");
        Buffer buffer = new Buffer();
        BufferedSource bufferedSourceBuffer = null;
        try {
            try {
                bufferedSourceBuffer = Okio.buffer(Okio.source(file));
                bufferedSourceBuffer.readAll(buffer);
                boolean zA = a(buffer, str, i, i2, interfaceC0732a);
                try {
                    bufferedSourceBuffer.close();
                } catch (Exception e2) {
                    Log.d("fCache", "", e2);
                }
                return zA;
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.b("fCache", "read file fail", e3);
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Exception e4) {
                        Log.d("fCache", "", e4);
                    }
                }
                return false;
            }
        } catch (Throwable th2) {
            if (bufferedSourceBuffer != null) {
                try {
                    bufferedSourceBuffer.close();
                } catch (Exception e5) {
                    Log.d("fCache", "", e5);
                }
            }
            throw th2;
        }
    }

    private final File a(String str, String str2) {
        return TextUtils.isEmpty(str2) ? this.f8781a.a(str) : this.f8781a.a(str, str2);
    }

    public Buffer a(File file) throws Exception {
        Buffer buffer = new Buffer();
        Okio.buffer(Okio.source(file)).readAll(buffer);
        return buffer;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("fCache", "close", e);
            }
        }
    }

    private void a(final File file, final String str, final int i, final int i2, final a.InterfaceC0732a interfaceC0732a) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.downloader.e.3
            @Override // java.lang.Runnable
            public void run() {
                WeakReference weakReference;
                try {
                    Buffer buffer = (Buffer) e.this.b.remove(file.getAbsolutePath());
                    if (buffer == null && (weakReference = (WeakReference) e.this.c.get(file.getAbsolutePath())) != null) {
                        buffer = (Buffer) weakReference.get();
                    }
                    Buffer buffer2 = buffer;
                    if (buffer2 != null) {
                        com.opos.cmn.an.f.a.b("fCache", "decode cache");
                        if (e.this.a(buffer2, str, i, i2, interfaceC0732a)) {
                            return;
                        } else {
                            com.opos.cmn.an.f.a.c("fCache", "decode cache fail");
                        }
                    }
                    com.opos.cmn.an.f.a.b("fCache", "decode file");
                    if (e.this.b(file, str, i, i2, interfaceC0732a)) {
                        return;
                    }
                } catch (Throwable th) {
                    Log.d("fCache", "decode fail", th);
                }
                a.InterfaceC0732a interfaceC0732a2 = interfaceC0732a;
                if (interfaceC0732a2 != null) {
                    interfaceC0732a2.a(2, null);
                }
            }
        });
    }

    @Override // com.opos.mobad.d.a
    public void a(String str, String str2, int i, int i2, a.InterfaceC0732a interfaceC0732a) {
        a(new File(str), str2, i, i2, interfaceC0732a);
    }

    @Override // com.opos.mobad.d.a
    public void a(String str, String str2, a.InterfaceC0732a interfaceC0732a) {
        a(str, str2, -1, -1, interfaceC0732a);
    }

    public void a(String str, Buffer buffer, String str2) throws Exception {
        File fileA = a(str, str2);
        if (fileA == null) {
            return;
        }
        this.b.put(fileA.getAbsolutePath(), buffer.clone());
        a(buffer, fileA);
    }

    private void a(final Buffer buffer, final File file) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.downloader.e.2
            @Override // java.lang.Runnable
            public void run() {
                BufferedSink bufferedSinkBuffer = null;
                try {
                    try {
                        try {
                            if (file.exists()) {
                                file.delete();
                            }
                            File fileB = e.this.b(file);
                            if (fileB.exists()) {
                                fileB.delete();
                            }
                            bufferedSinkBuffer = Okio.buffer(Okio.sink(fileB));
                            bufferedSinkBuffer.writeAll(buffer);
                            fileB.renameTo(file);
                            bufferedSinkBuffer.flush();
                            bufferedSinkBuffer.close();
                            buffer.close();
                        } catch (Throwable th) {
                            if (bufferedSinkBuffer != null) {
                                try {
                                    bufferedSinkBuffer.flush();
                                    bufferedSinkBuffer.close();
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.b("fCache", "", e);
                                    throw th;
                                }
                            }
                            buffer.close();
                            throw th;
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("fCache", "write fail", e2);
                        if (bufferedSinkBuffer != null) {
                            bufferedSinkBuffer.flush();
                            bufferedSinkBuffer.close();
                        }
                        buffer.close();
                    }
                } catch (Exception e3) {
                    com.opos.cmn.an.f.a.b("fCache", "", e3);
                }
            }
        });
    }

    private boolean a(File file, String str) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Buffer bufferA = null;
        try {
            try {
                bufferA = a(file);
                boolean zA = a(bufferA, str);
                if (zA) {
                    this.b.put(file.getAbsolutePath(), bufferA);
                }
                if (bufferA != null) {
                    bufferA.close();
                }
                return zA;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("fCache", "check fail", e);
                if (bufferA != null) {
                    bufferA.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (bufferA != null) {
                bufferA.close();
            }
            throw th;
        }
    }

    public boolean a(String str) {
        File fileA = this.f8781a.a(str);
        return fileA != null && fileA.exists();
    }

    public boolean a(String str, String str2, String str3) {
        return a(a(str, str3), str2);
    }

    private boolean a(Buffer buffer, String str) {
        return buffer.md5().hex().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Buffer buffer, String str, int i, int i2, a.InterfaceC0732a interfaceC0732a) {
        boolean zEquals;
        Buffer bufferClone = null;
        try {
            if (TextUtils.isEmpty(str)) {
                zEquals = true;
            } else {
                bufferClone = buffer.clone();
                zEquals = bufferClone.md5().hex().equals(str);
            }
            Bitmap bitmapA = (i <= 0 || i2 <= 0) ? a(buffer.inputStream()) : a(buffer, i, i2);
            if (bitmapA != null) {
                if (interfaceC0732a != null) {
                    interfaceC0732a.a(zEquals ? 0 : 1, bitmapA);
                }
                return true;
            }
            if (bufferClone != null) {
                bufferClone.close();
            }
            buffer.close();
            return false;
        } catch (Throwable th) {
            try {
                com.opos.cmn.an.f.a.b("fCache", "decode cache fail", th);
                if (bufferClone != null) {
                    bufferClone.close();
                }
                buffer.close();
                return false;
            } finally {
                if (bufferClone != null) {
                    bufferClone.close();
                }
                buffer.close();
            }
        }
    }
}
