package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import com.kuaishou.weapon.p0.t;
import defpackage.d23;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
final class GifInfoHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f20037a;

    static {
        d23.b();
    }

    public GifInfoHandle() {
    }

    private static native void bindSurface(long j, Surface surface, long[] jArr);

    public static native int createTempNativeFileDescriptor() throws GifIOException;

    public static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z) throws GifIOException;

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native String getComment(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getFrameDuration(long j, int i);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native long getMetadataByteCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native long getSourceLength(long j);

    private static native int getWidth(long j);

    private static native void glTexImage2D(long j, int i, int i2);

    private static native void glTexSubImage2D(long j, int i, int i2);

    private static native void initTexImageDescriptor(long j);

    private static native boolean isAnimationCompleted(long j);

    private static native boolean isOpaque(long j);

    @RequiresApi(21)
    public static int k(FileDescriptor fileDescriptor, boolean z) throws GifIOException, ErrnoException {
        try {
            int iCreateTempNativeFileDescriptor = createTempNativeFileDescriptor();
            Os.dup2(fileDescriptor, iCreateTempNativeFileDescriptor);
            return iCreateTempNativeFileDescriptor;
        } finally {
            if (z) {
                Os.close(fileDescriptor);
            }
        }
    }

    public static native long openByteArray(byte[] bArr) throws GifIOException;

    public static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    public static native long openFile(String str) throws GifIOException;

    public static native long openNativeFileDescriptor(int i, long j) throws GifIOException;

    public static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j);

    public static long q(FileDescriptor fileDescriptor, long j, boolean z) throws GifIOException {
        int iK;
        if (Build.VERSION.SDK_INT > 27) {
            try {
                iK = k(fileDescriptor, z);
            } catch (Exception e) {
                throw new GifIOException(GifError.OPEN_FAILED.errorCode, e.getMessage());
            }
        } else {
            iK = extractNativeFileDescriptor(fileDescriptor, z);
        }
        return openNativeFileDescriptor(iK, j);
    }

    public static GifInfoHandle r(ContentResolver contentResolver, Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, t.k);
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return new GifInfoHandle(assetFileDescriptorOpenAssetFileDescriptor);
        }
        throw new IOException("Could not open AssetFileDescriptor for " + uri);
    }

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToFrame(long j, int i, Bitmap bitmap);

    private static native void seekToFrameGL(long j, int i);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    private static native void setOptions(long j, char c, boolean z);

    private static native void setSpeedFactor(long j, float f);

    private static native void startDecoderThread(long j);

    private static native void stopDecoderThread(long j);

    public void A(@IntRange(from = 0, to = WebSocketProtocol.PAYLOAD_SHORT_MAX) int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.f20037a, (char) i);
        }
    }

    public void B(char c, boolean z) {
        setOptions(this.f20037a, c, z);
    }

    public void C(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f || Float.isNaN(f)) {
            throw new IllegalArgumentException("Speed factor is not positive");
        }
        if (f < 4.656613E-10f) {
            f = 4.656613E-10f;
        }
        synchronized (this) {
            setSpeedFactor(this.f20037a, f);
        }
    }

    public void a(Surface surface, long[] jArr) {
        bindSurface(this.f20037a, surface, jArr);
    }

    public synchronized long b() {
        return getAllocationByteCount(this.f20037a);
    }

    public synchronized int c() {
        return getCurrentFrameIndex(this.f20037a);
    }

    public synchronized int d() {
        return getCurrentLoop(this.f20037a);
    }

    public synchronized int e() {
        return getCurrentPosition(this.f20037a);
    }

    public synchronized int f() {
        return getDuration(this.f20037a);
    }

    public void finalize() throws Throwable {
        try {
            t();
        } finally {
            super.finalize();
        }
    }

    public synchronized int g() {
        return getHeight(this.f20037a);
    }

    public synchronized int h() {
        return getLoopCount(this.f20037a);
    }

    public synchronized long i() {
        return getMetadataByteCount(this.f20037a);
    }

    public synchronized int j() {
        return getNativeErrorCode(this.f20037a);
    }

    public synchronized int l() {
        return getNumberOfFrames(this.f20037a);
    }

    public synchronized long[] m() {
        return getSavedState(this.f20037a);
    }

    public synchronized int n() {
        return getWidth(this.f20037a);
    }

    public synchronized boolean o() {
        return isOpaque(this.f20037a);
    }

    public synchronized boolean p() {
        return this.f20037a == 0;
    }

    public synchronized void s() {
        postUnbindSurface(this.f20037a);
    }

    public synchronized void t() {
        free(this.f20037a);
        this.f20037a = 0L;
    }

    public synchronized long u(Bitmap bitmap) {
        return renderFrame(this.f20037a, bitmap);
    }

    public synchronized boolean v() {
        return reset(this.f20037a);
    }

    public synchronized long w() {
        return restoreRemainder(this.f20037a);
    }

    public synchronized int x(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f20037a, jArr, bitmap);
    }

    public synchronized void y() {
        saveRemainder(this.f20037a);
    }

    public synchronized void z(@IntRange(from = 0, to = 2147483647L) int i, Bitmap bitmap) {
        seekToTime(this.f20037a, i, bitmap);
    }

    public GifInfoHandle(FileDescriptor fileDescriptor) throws GifIOException {
        this.f20037a = q(fileDescriptor, 0L, true);
    }

    public GifInfoHandle(byte[] bArr) throws GifIOException {
        this.f20037a = openByteArray(bArr);
    }

    public GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.f20037a = openDirectByteBuffer(byteBuffer);
    }

    public GifInfoHandle(String str) throws GifIOException {
        this.f20037a = openFile(str);
    }

    public GifInfoHandle(InputStream inputStream) throws GifIOException {
        if (inputStream.markSupported()) {
            this.f20037a = openStream(inputStream);
            return;
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.f20037a = q(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }
}
