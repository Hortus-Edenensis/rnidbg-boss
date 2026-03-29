package com.ss.android.socialbase.appdownloader.pn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.jk.iz;
import com.ss.android.socialbase.downloader.network.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {
    private static volatile fx nr = null;
    private static int u = 8;
    private u<Integer, Bitmap> fx;

    /* JADX INFO: compiled from: SearchBox */
    public static class u<K, T> extends LinkedHashMap<K, T> {
        final int u;

        public u(int i, int i2) {
            super(i2, 0.75f, true);
            this.u = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.u;
        }
    }

    private fx() {
        this.fx = null;
        int i = u;
        this.fx = new u<>(i, i / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream nr(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i < 0) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static fx u() {
        if (nr == null) {
            synchronized (fx.class) {
                if (nr == null) {
                    nr = new fx();
                }
            }
        }
        return nr;
    }

    public Bitmap u(int i) {
        return this.fx.get(Integer.valueOf(i));
    }

    public void u(final int i, final String str) {
        if (TextUtils.isEmpty(str) || u(i) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.fx.mv().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.pn.fx.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStreamNr;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStreamU;
                InputStream inputStream = null;
                try {
                    a aVarU = com.ss.android.socialbase.downloader.downloader.fx.u(true, 0, str, null);
                    if (aVarU == null) {
                        iz.u(null, null, null, null);
                        return;
                    }
                    inputStreamU = aVarU.u();
                    try {
                        byteArrayOutputStreamNr = fx.nr(inputStreamU);
                    } catch (Exception unused) {
                        byteArrayOutputStreamNr = null;
                        byteArrayInputStream = null;
                    } catch (Throwable th2) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th2;
                        byteArrayOutputStreamNr = null;
                    }
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamNr.toByteArray());
                        try {
                            byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStreamNr.toByteArray());
                            try {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                int iU = com.ss.android.socialbase.appdownloader.fx.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), 44.0f);
                                options.inSampleSize = fx.u(iU, iU, options);
                                options.inJustDecodeBounds = false;
                                fx.this.fx.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                iz.u(inputStreamU, byteArrayOutputStreamNr, byteArrayInputStream, byteArrayInputStream2);
                                return;
                            } catch (Exception unused2) {
                                inputStream = inputStreamU;
                                iz.u(inputStream, byteArrayOutputStreamNr, byteArrayInputStream, byteArrayInputStream2);
                            } catch (Throwable th3) {
                                th = th3;
                                iz.u(inputStreamU, byteArrayOutputStreamNr, byteArrayInputStream, byteArrayInputStream2);
                                throw th;
                            }
                        } catch (Exception unused3) {
                            byteArrayInputStream2 = null;
                        } catch (Throwable th4) {
                            byteArrayInputStream2 = null;
                            th = th4;
                        }
                    } catch (Exception unused4) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = byteArrayInputStream;
                        inputStream = inputStreamU;
                        iz.u(inputStream, byteArrayOutputStreamNr, byteArrayInputStream, byteArrayInputStream2);
                    } catch (Throwable th5) {
                        byteArrayInputStream2 = null;
                        th = th5;
                        byteArrayInputStream = null;
                    }
                } catch (Exception unused5) {
                    byteArrayOutputStreamNr = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                } catch (Throwable th6) {
                    byteArrayOutputStreamNr = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th6;
                    inputStreamU = null;
                }
                iz.u(inputStream, byteArrayOutputStreamNr, byteArrayInputStream, byteArrayInputStream2);
            }
        });
    }

    public static int u(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return Math.min(Math.round(i3 / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
