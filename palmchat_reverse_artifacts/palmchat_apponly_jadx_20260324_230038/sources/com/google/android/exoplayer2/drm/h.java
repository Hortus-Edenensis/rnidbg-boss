package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.drm.h;
import defpackage.bk4;
import defpackage.f10;
import defpackage.f42;
import defpackage.g86;
import defpackage.gc4;
import defpackage.i32;
import defpackage.vh;
import defpackage.xc0;
import defpackage.xo4;
import defpackage.y53;
import defpackage.zv;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(18)
@Deprecated
public final class h implements g {
    public static final g.c d = new g.c() { // from class: u32
        @Override // com.google.android.exoplayer2.drm.g.c
        public final g acquireExoMediaDrm(UUID uuid) {
            return h.p(uuid);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f5866a;
    public final MediaDrm b;
    public int c;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(31)
    public static class a {
        @DoNotInline
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        @DoNotInline
        public static void b(MediaDrm mediaDrm, byte[] bArr, bk4 bk4Var) {
            LogSessionId logSessionIdA = bk4Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            f42.a(vh.e(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(logSessionIdA);
        }
    }

    public h(UUID uuid) throws UnsupportedSchemeException {
        vh.e(uuid);
        vh.b(!zv.b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f5866a = uuid;
        MediaDrm mediaDrm = new MediaDrm(j(uuid));
        this.b = mediaDrm;
        this.c = 1;
        if (zv.d.equals(uuid) && q()) {
            l(mediaDrm);
        }
    }

    public static byte[] e(byte[] bArr) {
        gc4 gc4Var = new gc4(bArr);
        int iU = gc4Var.u();
        short sW = gc4Var.w();
        short sW2 = gc4Var.w();
        if (sW != 1 || sW2 != 1) {
            y53.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short sW3 = gc4Var.w();
        Charset charset = f10.e;
        String strF = gc4Var.F(sW3, charset);
        if (strF.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strF.indexOf("</DATA>");
        if (iIndexOf == -1) {
            y53.i("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strF.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strF.substring(iIndexOf);
        int i = iU + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.putShort(sW);
        byteBufferAllocate.putShort(sW2);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    public static String f(String str) {
        return "<LA_URL>https://x</LA_URL>".equals(str) ? "" : (g86.f17680a == 33 && "https://default.url".equals(str)) ? "" : str;
    }

    public static byte[] g(UUID uuid, byte[] bArr) {
        return zv.c.equals(uuid) ? xc0.a(bArr) : bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] h(UUID uuid, byte[] bArr) {
        UUID uuid2 = zv.e;
        if (uuid2.equals(uuid)) {
            byte[] bArrE = xo4.e(bArr, uuid);
            if (bArrE != null) {
                bArr = bArrE;
            }
            bArr = xo4.a(uuid2, e(bArr));
        }
        if (g86.f17680a >= 23 || !zv.d.equals(uuid)) {
            if (uuid2.equals(uuid) && "Amazon".equals(g86.c)) {
                String str = g86.d;
                if ("AFTB".equals(str) || "AFTS".equals(str) || "AFTM".equals(str) || "AFTT".equals(str)) {
                    byte[] bArrE2 = xo4.e(bArr, uuid);
                    if (bArrE2 != null) {
                        return bArrE2;
                    }
                }
            }
        }
        return bArr;
    }

    public static String i(UUID uuid, String str) {
        return (g86.f17680a < 26 && zv.c.equals(uuid) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) ? "cenc" : str;
    }

    public static UUID j(UUID uuid) {
        return (g86.f17680a >= 27 || !zv.c.equals(uuid)) ? uuid : zv.b;
    }

    public static void l(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    public static DrmInitData.SchemeData n(UUID uuid, List<DrmInitData.SchemeData> list) {
        boolean z;
        if (!zv.d.equals(uuid)) {
            return list.get(0);
        }
        if (g86.f17680a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                DrmInitData.SchemeData schemeData2 = list.get(i);
                byte[] bArr = (byte[]) vh.e(schemeData2.data);
                if (!g86.c(schemeData2.mimeType, schemeData.mimeType) || !g86.c(schemeData2.licenseServerUrl, schemeData.licenseServerUrl) || !xo4.c(bArr)) {
                    z = false;
                    break;
                }
                length += bArr.length;
            }
            z = true;
            if (z) {
                byte[] bArr2 = new byte[length];
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    byte[] bArr3 = (byte[]) vh.e(list.get(i3).data);
                    int length2 = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i2, length2);
                    i2 += length2;
                }
                return schemeData.copyWithData(bArr2);
            }
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            DrmInitData.SchemeData schemeData3 = list.get(i4);
            int iG = xo4.g((byte[]) vh.e(schemeData3.data));
            int i5 = g86.f17680a;
            if (i5 < 23 && iG == 0) {
                return schemeData3;
            }
            if (i5 >= 23 && iG == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(g.b bVar, MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        bVar.a(this, bArr, i, i2, bArr2);
    }

    public static /* synthetic */ g p(UUID uuid) {
        try {
            return r(uuid);
        } catch (UnsupportedDrmException unused) {
            y53.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new e();
        }
    }

    public static boolean q() {
        return "ASUS_Z00AD".equals(g86.d);
    }

    public static h r(UUID uuid) throws UnsupportedDrmException {
        try {
            return new h(uuid);
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void a(@Nullable final g.b bVar) {
        this.b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: a42
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                this.f1148a.o(bVar, mediaDrm, bArr, i, i2, bArr2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void b(byte[] bArr, bk4 bk4Var) {
        if (g86.f17680a >= 31) {
            try {
                a.b(this.b, bArr, bk4Var);
            } catch (UnsupportedOperationException unused) {
                y53.i("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void closeSession(byte[] bArr) {
        this.b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public int getCryptoType() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.drm.g
    @SuppressLint({"WrongConstant"})
    public g.a getKeyRequest(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i, @Nullable HashMap<String, String> map) throws NotProvisionedException {
        DrmInitData.SchemeData schemeDataN;
        byte[] bArrH;
        String strI;
        if (list != null) {
            schemeDataN = n(this.f5866a, list);
            bArrH = h(this.f5866a, (byte[]) vh.e(schemeDataN.data));
            strI = i(this.f5866a, schemeDataN.mimeType);
        } else {
            schemeDataN = null;
            bArrH = null;
            strI = null;
        }
        MediaDrm.KeyRequest keyRequest = this.b.getKeyRequest(bArr, bArrH, strI, i, map);
        byte[] bArrG = g(this.f5866a, keyRequest.getData());
        String strF = f(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(strF) && schemeDataN != null && !TextUtils.isEmpty(schemeDataN.licenseServerUrl)) {
            strF = schemeDataN.licenseServerUrl;
        }
        return new g.a(bArrG, strF, g86.f17680a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public g.d getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.b.getProvisionRequest();
        return new g.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.g
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public i32 createCryptoConfig(byte[] bArr) throws MediaCryptoException {
        return new i32(j(this.f5866a), bArr, g86.f17680a < 21 && zv.d.equals(this.f5866a) && "L3".equals(m("securityLevel")));
    }

    public String m(String str) {
        return this.b.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public byte[] openSession() throws MediaDrmException {
        return this.b.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.g
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (zv.c.equals(this.f5866a)) {
            bArr2 = xc0.b(bArr2);
        }
        return this.b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.b.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public synchronized void release() {
        int i = this.c - 1;
        this.c = i;
        if (i == 0) {
            this.b.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.g
    public boolean requiresSecureDecoder(byte[] bArr, String str) {
        if (g86.f17680a >= 31) {
            return a.a(this.b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f5866a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.b.restoreKeys(bArr, bArr2);
    }
}
