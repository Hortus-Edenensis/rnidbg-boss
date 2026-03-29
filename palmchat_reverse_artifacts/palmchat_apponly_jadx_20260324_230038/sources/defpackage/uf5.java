package defpackage;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class uf5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f21203a = new Object();
    public static final Object b = new Object();

    @GuardedBy("valueLock")
    public static boolean c = false;

    @GuardedBy("valueLock")
    public static long d = 0;

    @GuardedBy("valueLock")
    public static String e = "time.android.com";

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onInitializationFailed(IOException iOException);

        void onInitialized();
    }

    public static void g(byte b2, byte b3, int i, long j) throws IOException {
        if (b2 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b3 != 4 && b3 != 5) {
            throw new IOException("SNTP: Untrusted mode: " + ((int) b3));
        }
        if (i != 0 && i <= 15) {
            if (j == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            throw new IOException("SNTP: Untrusted stratum: " + i);
        }
    }

    public static long h() {
        long j;
        synchronized (b) {
            j = c ? d : -9223372036854775807L;
        }
        return j;
    }

    public static String i() {
        String str;
        synchronized (b) {
            str = e;
        }
        return str;
    }

    public static void j(@Nullable Loader loader, @Nullable b bVar) {
        if (k()) {
            if (bVar != null) {
                bVar.onInitialized();
            }
        } else {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.m(new d(), new c(bVar), 1);
        }
    }

    public static boolean k() {
        boolean z;
        synchronized (b) {
            z = c;
        }
        return z;
    }

    public static long l() throws IOException {
        InetAddress byName = InetAddress.getByName(i());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = 27;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            o(bArr, 40, jCurrentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            long j = jCurrentTimeMillis + (jElapsedRealtime2 - jElapsedRealtime);
            byte b2 = bArr[0];
            int i = bArr[1] & UByte.MAX_VALUE;
            long jN = n(bArr, 24);
            long jN2 = n(bArr, 32);
            long jN3 = n(bArr, 40);
            g((byte) ((b2 >> 6) & 3), (byte) (b2 & 7), i, jN3);
            long j2 = (j + (((jN2 - jN) + (jN3 - j)) / 2)) - jElapsedRealtime2;
            datagramSocket.close();
            return j2;
        } catch (Throwable th) {
            try {
                datagramSocket.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long m(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (((long) i2) << 24) + (((long) i3) << 16) + (((long) i4) << 8) + ((long) i5);
    }

    public static long n(byte[] bArr, int i) {
        long jM = m(bArr, i);
        long jM2 = m(bArr, i + 4);
        if (jM == 0 && jM2 == 0) {
            return 0L;
        }
        return ((jM - 2208988800L) * 1000) + ((jM2 * 1000) / 4294967296L);
    }

    public static void o(byte[] bArr, int i, long j) {
        if (j == 0) {
            Arrays.fill(bArr, i, i + 8, (byte) 0);
            return;
        }
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + 2208988800L;
        int i2 = i + 1;
        bArr[i] = (byte) (j4 >> 24);
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j4 >> 16);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j4 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j4 >> 0);
        long j5 = (j3 * 4294967296L) / 1000;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j5 >> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j5 >> 16);
        bArr[i7] = (byte) (j5 >> 8);
        bArr[i7 + 1] = (byte) (Math.random() * 255.0d);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d implements Loader.e {
        public d() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void load() throws IOException {
            synchronized (uf5.f21203a) {
                synchronized (uf5.b) {
                    if (uf5.c) {
                        return;
                    }
                    long jL = uf5.l();
                    synchronized (uf5.b) {
                        long unused = uf5.d = jL;
                        boolean unused2 = uf5.c = true;
                    }
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void cancelLoad() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements Loader.b<Loader.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final b f21204a;

        public c(@Nullable b bVar) {
            this.f21204a = bVar;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public void f(Loader.e eVar, long j, long j2) {
            if (this.f21204a != null) {
                if (uf5.k()) {
                    this.f21204a.onInitialized();
                } else {
                    this.f21204a.onInitializationFailed(new IOException(new ConcurrentModificationException()));
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public Loader.c j(Loader.e eVar, long j, long j2, IOException iOException, int i) {
            b bVar = this.f21204a;
            if (bVar != null) {
                bVar.onInitializationFailed(iOException);
            }
            return Loader.f;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public void e(Loader.e eVar, long j, long j2, boolean z) {
        }
    }
}
