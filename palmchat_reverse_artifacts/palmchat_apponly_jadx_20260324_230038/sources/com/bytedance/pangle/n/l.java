package com.bytedance.pangle.n;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.pangle.util.FieldUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class l implements t {
    private static final long u = Os.sysconf(OsConstants._SC_PAGESIZE);
    private final long b;
    private final long fx;
    private final FileDescriptor nr;

    public l(FileDescriptor fileDescriptor, long j, long j2) {
        this.nr = fileDescriptor;
        this.fx = j;
        this.b = j2;
    }

    @Override // com.bytedance.pangle.n.t
    public long u() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.pangle.n.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(jk jkVar, long j, int i) throws Throwable {
        long j2;
        long jMmap;
        int iIntValue;
        ByteBuffer byteBuffer;
        long j3 = this.fx + j;
        long j4 = u;
        long j5 = (j3 / j4) * j4;
        int i2 = (int) (j3 - j5);
        long j6 = i + i2;
        try {
            try {
                ByteBuffer byteBuffer2 = null;
                if (com.bytedance.pangle.util.a.t()) {
                    try {
                        iIntValue = ((Integer) FieldUtils.readField(OsConstants.class.getField("MAP_POPULATE"), (Object) null)).intValue();
                    } catch (IllegalAccessException e) {
                        com.bytedance.sdk.openadsdk.api.iz.u(e);
                        iIntValue = 0;
                    } catch (Exception e2) {
                        com.bytedance.sdk.openadsdk.api.iz.u(e2);
                        iIntValue = 0;
                    }
                    jMmap = Os.mmap(0L, j6, OsConstants.PROT_READ, OsConstants.MAP_SHARED | iIntValue, this.nr, j5);
                    try {
                        try {
                            if (com.bytedance.pangle.util.a.mv()) {
                                try {
                                    Constructor<?> declaredConstructor = Class.forName("java.nio.DirectByteBuffer").getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                                    if (declaredConstructor != null) {
                                        declaredConstructor.setAccessible(true);
                                        byteBuffer = (ByteBuffer) declaredConstructor.newInstance(Long.valueOf(((long) i2) + jMmap), Integer.valueOf(i));
                                        byteBuffer2 = byteBuffer;
                                    }
                                } catch (ClassNotFoundException e3) {
                                    com.bytedance.sdk.openadsdk.api.iz.u(e3);
                                } catch (IllegalAccessException e4) {
                                    com.bytedance.sdk.openadsdk.api.iz.u(e4);
                                } catch (InstantiationException e5) {
                                    com.bytedance.sdk.openadsdk.api.iz.u(e5);
                                } catch (InvocationTargetException e6) {
                                    com.bytedance.sdk.openadsdk.api.iz.u(e6);
                                } catch (Exception e7) {
                                    com.bytedance.sdk.openadsdk.api.iz.u(e7);
                                }
                            } else {
                                try {
                                    Class<?> cls = Class.forName("java.nio.DirectByteBuffer");
                                    Class<?>[] clsArr = {Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE};
                                    Constructor<?> constructor = cls.getConstructor(clsArr);
                                    if (constructor == null) {
                                        constructor = cls.getDeclaredConstructor(clsArr);
                                    }
                                    if (constructor != null) {
                                        constructor.setAccessible(true);
                                        byteBuffer = (ByteBuffer) constructor.newInstance(Integer.valueOf(i), Long.valueOf(((long) i2) + jMmap), this.nr, null, Boolean.TRUE);
                                        byteBuffer2 = byteBuffer;
                                    }
                                } catch (ClassNotFoundException e8) {
                                    com.bytedance.sdk.openadsdk.api.iz.u(e8);
                                } catch (IllegalAccessException e9) {
                                    com.bytedance.sdk.openadsdk.api.iz.u(e9);
                                } catch (InstantiationException e10) {
                                    com.bytedance.sdk.openadsdk.api.iz.u(e10);
                                } catch (InvocationTargetException e11) {
                                    com.bytedance.sdk.openadsdk.api.iz.u(e11);
                                } catch (Exception e12) {
                                    com.bytedance.sdk.openadsdk.api.iz.u(e12);
                                }
                            }
                            jkVar.u(byteBuffer2);
                            if (jMmap == 0) {
                                try {
                                    Os.munmap(jMmap, j6);
                                    return;
                                } catch (ErrnoException unused) {
                                    return;
                                }
                            }
                            return;
                        } catch (ErrnoException e13) {
                            e = e13;
                            throw new IOException("Failed to mmap " + j6 + " bytes", e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        j2 = 0;
                        if (jMmap != j2) {
                        }
                        throw th;
                    }
                }
                iIntValue = 0;
                jMmap = Os.mmap(0L, j6, OsConstants.PROT_READ, OsConstants.MAP_SHARED | iIntValue, this.nr, j5);
                if (com.bytedance.pangle.util.a.mv()) {
                }
                jkVar.u(byteBuffer2);
                if (jMmap == 0) {
                }
            } catch (ErrnoException e14) {
                e = e14;
                jMmap = 0;
            }
            throw new IOException("Failed to mmap " + j6 + " bytes", e);
        } catch (Throwable th2) {
            th = th2;
            j2 = 0;
            jMmap = 0;
            if (jMmap != j2) {
                try {
                    Os.munmap(jMmap, j6);
                } catch (ErrnoException unused2) {
                }
            }
            throw th;
        }
    }
}
