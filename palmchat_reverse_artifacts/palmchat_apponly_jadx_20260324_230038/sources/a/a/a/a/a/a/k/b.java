package a.a.a.a.a.a.k;

import a.a.c.a.d.d;
import a.a.c.a.d.e;
import a.a.c.a.d.g;
import a.a.c.a.d.h;
import a.a.c.a.d.i;
import a.a.c.a.d.j;
import a.a.c.a.d.k;
import a.a.c.a.d.l;
import a.a.c.a.d.m;
import a.a.c.a.d.n;
import a.a.c.a.d.p;
import android.content.Context;
import android.net.Network;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(String str);
    }

    public static void a(Network network, String str, String str2, a aVar) {
        InputStream inputStream;
        OutputStream outputStream;
        if (str == null) {
            aVar.a();
            return;
        }
        HttpsURLConnection httpsURLConnection = null;
        InputStream inputStream2 = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) (network != null ? network.openConnection(new URL(str)) : new URL(str).openConnection());
            try {
                if (httpsURLConnection2 == null) {
                    aVar.a();
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                        return;
                    }
                    return;
                }
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setConnectTimeout(10000);
                httpsURLConnection2.setReadTimeout(10000);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setDefaultUseCaches(false);
                if (str2 != null) {
                    httpsURLConnection2.setDoOutput(true);
                    outputStream = httpsURLConnection2.getOutputStream();
                    try {
                        outputStream.write(str2.getBytes());
                        outputStream.flush();
                    } catch (Throwable unused) {
                        httpsURLConnection = httpsURLConnection2;
                        inputStream = null;
                        try {
                            aVar.a();
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e2) {
                                    throw new RuntimeException(e2);
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    }
                } else {
                    outputStream = null;
                }
                httpsURLConnection2.connect();
                if (httpsURLConnection2.getResponseCode() == 200) {
                    inputStream2 = httpsURLConnection2.getInputStream();
                    byte[] bArr = new byte[2048];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i = inputStream2.read(bArr);
                        if (i <= 0) {
                            break;
                        } else {
                            sb.append(new String(bArr, 0, i, StandardCharsets.UTF_8));
                        }
                    }
                    aVar.a(sb.toString());
                } else {
                    aVar.a();
                }
                httpsURLConnection2.disconnect();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                        throw new RuntimeException(e3);
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            } catch (Throwable unused2) {
                outputStream = null;
                httpsURLConnection = httpsURLConnection2;
                inputStream = null;
            }
        } catch (Throwable unused3) {
            inputStream = null;
            outputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a.a.c.a.b.c a(Context context) {
        String str = Build.BRAND;
        if (str.equals("Pico")) {
            return new m();
        }
        int i = a.a.c.a.e.b.f1121a;
        String str2 = Build.MANUFACTURER;
        if ("oppo".equalsIgnoreCase(str2) || "oppo".equalsIgnoreCase(str) || "realme".equalsIgnoreCase(str)) {
            return new l(new p());
        }
        if (str2.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("REDMI")) {
            if (!((p.b == null || p.f1120a == null || p.c == null) ? false : true)) {
            }
        } else {
            if (!("BlackShark".equalsIgnoreCase(str2) || "BlackShark".equalsIgnoreCase(str))) {
                if (k.f1115a.b(new Object[0]).booleanValue()) {
                    return new k();
                }
                if (a.a.c.a.e.b.b() && a.a.c.a.e.b.a()) {
                    return new e();
                }
                if (a.a.c.a.e.b.b() && !a.a.c.a.e.b.a()) {
                    return new g();
                }
                if ("HUAWEI".equalsIgnoreCase(str2)) {
                    return new e();
                }
                if ("OnePlus".equalsIgnoreCase(str2) || "OnePlus".equalsIgnoreCase(str)) {
                    return new l(null);
                }
                if (str.toLowerCase(Locale.ENGLISH).contains(AssistUtils.BRAND_MZ)) {
                    return new i();
                }
                if (Build.VERSION.SDK_INT <= 28) {
                    zContains = Class.forName("miui.os.Build").getName().length() > 0;
                    if (zContains || !e.c(context)) {
                        return null;
                    }
                    return new e();
                }
                if ("samsung".equalsIgnoreCase(str) || "samsung".equalsIgnoreCase(str2)) {
                    return new n();
                }
                if (str2.trim().toUpperCase().contains("NUBIA")) {
                    return new j();
                }
                String str3 = Build.FINGERPRINT;
                if (TextUtils.isEmpty(str3)) {
                    Map<String, Object> map = a.a.c.a.e.e.b;
                    Object objA = map.get("ro.build.version.incremental");
                    if (objA == null && (objA = a.a.c.a.e.e.f1124a.a("ro.build.version.incremental")) != null) {
                        map.put("ro.build.version.incremental", objA);
                    }
                    String str4 = (String) objA;
                    if (TextUtils.isEmpty(str4) || !str4.contains("VIBEUI_V2")) {
                        zContains = false;
                    }
                } else {
                    zContains = str3.contains("VIBEUI_V2");
                }
                if (zContains) {
                    return new h();
                }
                if (str2.trim().toUpperCase().contains("ASUS")) {
                    return new a.a.c.a.d.a();
                }
                d dVar = new d(context);
                return dVar.b(context) ? dVar : new a.a.c.a.d.c();
            }
        }
        return new p();
    }

    public static a.a.b.a.c.a.b<ByteBuffer, Long> a(FileChannel fileChannel) throws a.a.b.a.c.a.c, IOException {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
        long j = size - 22;
        long jMin = Math.min(j, WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i = 0;
        while (true) {
            long j2 = i;
            if (j2 > jMin) {
                throw new IOException("ZIP End of Central Directory (EOCD) record not found");
            }
            long j3 = j - j2;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            fileChannel.position(j3);
            fileChannel.read(byteBufferAllocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            if (byteBufferAllocate.getInt(0) == 101010256) {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j3 + 20);
                fileChannel.read(byteBufferAllocate2);
                byteBufferAllocate2.order(byteOrder);
                short s = byteBufferAllocate2.getShort(0);
                if (s == i) {
                    ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(4);
                    byteBufferAllocate3.order(byteOrder);
                    fileChannel.position((fileChannel.size() - ((long) s)) - 6);
                    fileChannel.read(byteBufferAllocate3);
                    long j4 = byteBufferAllocate3.getInt(0);
                    if (j4 < 0) {
                        fileChannel.read(byteBufferAllocate3);
                        byte[] bArr = new byte[8];
                        for (int i2 = 4; i2 < 8; i2++) {
                            bArr[i2] = byteBufferAllocate3.get((8 - i2) - 1);
                        }
                        j4 = ByteBuffer.wrap(bArr).getLong();
                    }
                    if (j4 < 32) {
                        throw new a.a.b.a.c.a.c("APK too small for APK Signing Block. ZIP Central Directory offset: " + j4);
                    }
                    fileChannel.position(j4 - 24);
                    ByteBuffer byteBufferAllocate4 = ByteBuffer.allocate(24);
                    fileChannel.read(byteBufferAllocate4);
                    ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
                    byteBufferAllocate4.order(byteOrder2);
                    if (byteBufferAllocate4.getLong(8) != 2334950737559900225L || byteBufferAllocate4.getLong(16) != 3617552046287187010L) {
                        throw new a.a.b.a.c.a.c("No APK Signing Block before ZIP Central Directory");
                    }
                    long j5 = byteBufferAllocate4.getLong(0);
                    if (j5 < byteBufferAllocate4.capacity() || j5 > 2147483639) {
                        throw new a.a.b.a.c.a.c("APK Signing Block size out of range: " + j5);
                    }
                    int i3 = (int) (8 + j5);
                    long j6 = j4 - ((long) i3);
                    if (j6 < 0) {
                        throw new a.a.b.a.c.a.c("APK Signing Block offset out of range: " + j6);
                    }
                    fileChannel.position(j6);
                    ByteBuffer byteBufferAllocate5 = ByteBuffer.allocate(i3);
                    fileChannel.read(byteBufferAllocate5);
                    byteBufferAllocate5.order(byteOrder2);
                    long j7 = byteBufferAllocate5.getLong(0);
                    if (j7 == j5) {
                        return new a.a.b.a.c.a.b<>(byteBufferAllocate5, Long.valueOf(j6));
                    }
                    throw new a.a.b.a.c.a.c("APK Signing Block sizes in header and footer do not match: " + j7 + " vs " + j5);
                }
            }
            i++;
        }
    }

    public static Map<Integer, ByteBuffer> a(ByteBuffer byteBuffer) throws a.a.b.a.c.a.c {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            int iCapacity = byteBuffer.capacity() - 24;
            if (iCapacity < 8) {
                throw new IllegalArgumentException("end < start: " + iCapacity + " < 8");
            }
            int iCapacity2 = byteBuffer.capacity();
            if (iCapacity > byteBuffer.capacity()) {
                throw new IllegalArgumentException("end > capacity: " + iCapacity + " > " + iCapacity2);
            }
            int iLimit = byteBuffer.limit();
            int iPosition = byteBuffer.position();
            int i = 0;
            try {
                byteBuffer.position(0);
                byteBuffer.limit(iCapacity);
                byteBuffer.position(8);
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                byteBufferSlice.order(byteBuffer.order());
                byteBuffer.position(0);
                byteBuffer.limit(iLimit);
                byteBuffer.position(iPosition);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (byteBufferSlice.hasRemaining()) {
                    i++;
                    if (byteBufferSlice.remaining() < 8) {
                        throw new a.a.b.a.c.a.c("Insufficient data to read size of APK Signing Block entry #" + i);
                    }
                    long j = byteBufferSlice.getLong();
                    if (j < 4 || j > 2147483647L) {
                        throw new a.a.b.a.c.a.c("APK Signing Block entry #" + i + " size out of range: " + j);
                    }
                    int i2 = (int) j;
                    int iPosition2 = byteBufferSlice.position() + i2;
                    if (i2 > byteBufferSlice.remaining()) {
                        throw new a.a.b.a.c.a.c("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + byteBufferSlice.remaining());
                    }
                    Integer numValueOf = Integer.valueOf(byteBufferSlice.getInt());
                    int i3 = i2 - 4;
                    if (i3 < 0) {
                        throw new IllegalArgumentException("size: " + i3);
                    }
                    int iLimit2 = byteBufferSlice.limit();
                    int iPosition3 = byteBufferSlice.position();
                    int i4 = i3 + iPosition3;
                    if (i4 < iPosition3 || i4 > iLimit2) {
                        throw new BufferUnderflowException();
                    }
                    byteBufferSlice.limit(i4);
                    try {
                        ByteBuffer byteBufferSlice2 = byteBufferSlice.slice();
                        byteBufferSlice2.order(byteBufferSlice.order());
                        byteBufferSlice.position(i4);
                        byteBufferSlice.limit(iLimit2);
                        linkedHashMap.put(numValueOf, byteBufferSlice2);
                        byteBufferSlice.position(iPosition2);
                    } catch (Throwable th) {
                        byteBufferSlice.limit(iLimit2);
                        throw th;
                    }
                }
                return linkedHashMap;
            } catch (Throwable th2) {
                byteBuffer.position(0);
                byteBuffer.limit(iLimit);
                byteBuffer.position(iPosition);
                throw th2;
            }
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
}
