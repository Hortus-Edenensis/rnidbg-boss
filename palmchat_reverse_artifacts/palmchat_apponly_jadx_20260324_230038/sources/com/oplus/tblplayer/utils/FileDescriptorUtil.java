package com.oplus.tblplayer.utils;

import android.annotation.SuppressLint;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@SuppressLint({"RestrictedApi"})
public final class FileDescriptorUtil {
    private static final int SEEK_SET = 0;

    @Nullable
    @GuardedBy("sPosixLockV14")
    private static Method sCloseMethodV14;

    @Nullable
    @GuardedBy("sPosixLockV14")
    private static Method sDupMethodV14;

    @Nullable
    @GuardedBy("sPosixLockV14")
    private static Method sLseekMethodV14;
    private static final Object sPosixLockV14 = new Object();

    @Nullable
    @GuardedBy("sPosixLockV14")
    private static Object sPosixObjectV14;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void close(FileDescriptor fileDescriptor) throws ErrnoException {
            Os.close(fileDescriptor);
        }

        @DoNotInline
        public static FileDescriptor dup(FileDescriptor fileDescriptor) throws ErrnoException {
            return Os.dup(fileDescriptor);
        }

        @DoNotInline
        public static long getStatSize(FileDescriptor fileDescriptor) throws ErrnoException {
            StructStat structStatFstat = Os.fstat(fileDescriptor);
            if (OsConstants.S_ISREG(structStatFstat.st_mode) || OsConstants.S_ISLNK(structStatFstat.st_mode)) {
                return structStatFstat.st_size;
            }
            return -1L;
        }

        @DoNotInline
        public static long lseek(FileDescriptor fileDescriptor, long j, int i) throws ErrnoException {
            return Os.lseek(fileDescriptor, j, i);
        }
    }

    private FileDescriptorUtil() {
    }

    public static void close(FileDescriptor fileDescriptor) throws IOException {
        closeV21(fileDescriptor);
    }

    @SuppressLint({"PrivateApi"})
    private static FileDescriptor closeV14(FileDescriptor fileDescriptor) throws IOException {
        Object obj;
        Method method;
        try {
            synchronized (sPosixLockV14) {
                ensurePosixObjectsInitialized();
                obj = sPosixObjectV14;
                method = sCloseMethodV14;
            }
            return (FileDescriptor) method.invoke(obj, fileDescriptor);
        } catch (Exception e) {
            throw new IOException("Failed to close the file descriptor", e);
        }
    }

    @RequiresApi(21)
    private static void closeV21(FileDescriptor fileDescriptor) throws IOException {
        try {
            Api21Impl.close(fileDescriptor);
        } catch (Exception e) {
            throw new IOException("Failed to close the file descriptor", e);
        }
    }

    public static FileDescriptor dup(FileDescriptor fileDescriptor) throws IOException {
        return dupV21(fileDescriptor);
    }

    @SuppressLint({"PrivateApi"})
    private static FileDescriptor dupV14(FileDescriptor fileDescriptor) throws IOException {
        Object obj;
        Method method;
        try {
            synchronized (sPosixLockV14) {
                ensurePosixObjectsInitialized();
                obj = sPosixObjectV14;
                method = sDupMethodV14;
            }
            return (FileDescriptor) method.invoke(obj, fileDescriptor);
        } catch (Exception e) {
            throw new IOException("Failed to dup the file descriptor", e);
        }
    }

    @RequiresApi(21)
    private static FileDescriptor dupV21(FileDescriptor fileDescriptor) throws IOException {
        try {
            return Api21Impl.dup(fileDescriptor);
        } catch (Exception e) {
            throw new IOException("Failed to dup the file descriptor", e);
        }
    }

    private static void ensurePosixObjectsInitialized() throws Exception {
        synchronized (sPosixLockV14) {
            if (sPosixObjectV14 != null) {
                return;
            }
            Class<?> cls = Class.forName("libcore.io.Posix");
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            sLseekMethodV14 = cls.getMethod("lseek", FileDescriptor.class, Long.TYPE, Integer.TYPE);
            sDupMethodV14 = cls.getMethod("dup", FileDescriptor.class);
            sCloseMethodV14 = cls.getMethod("close", FileDescriptor.class);
            sPosixObjectV14 = declaredConstructor.newInstance(new Object[0]);
        }
    }

    public static long getStatSize(FileDescriptor fileDescriptor) throws IOException {
        return getStatSizeV21(fileDescriptor);
    }

    @RequiresApi(21)
    @SuppressLint({"PrivateApi"})
    private static long getStatSizeV14(FileDescriptor fileDescriptor) throws IOException {
        return -1L;
    }

    @RequiresApi(21)
    private static long getStatSizeV21(FileDescriptor fileDescriptor) throws IOException {
        try {
            return Api21Impl.getStatSize(fileDescriptor);
        } catch (Exception e) {
            throw new IOException("Failed to get size from the file descriptor", e);
        }
    }

    public static void seek(FileDescriptor fileDescriptor, long j) throws IOException {
        seekV21(fileDescriptor, j);
    }

    @SuppressLint({"PrivateApi"})
    private static void seekV14(FileDescriptor fileDescriptor, long j) throws IOException {
        Object obj;
        Method method;
        try {
            synchronized (sPosixLockV14) {
                ensurePosixObjectsInitialized();
                obj = sPosixObjectV14;
                method = sLseekMethodV14;
            }
            method.invoke(obj, fileDescriptor, Long.valueOf(j), 0);
        } catch (Exception e) {
            throw new IOException("Failed to seek the file descriptor", e);
        }
    }

    @RequiresApi(21)
    private static void seekV21(FileDescriptor fileDescriptor, long j) throws IOException {
        try {
            Api21Impl.lseek(fileDescriptor, j, OsConstants.SEEK_SET);
        } catch (Exception e) {
            throw new IOException("Failed to seek the file descriptor", e);
        }
    }
}
