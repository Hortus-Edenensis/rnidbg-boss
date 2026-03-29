package com.oplus.tbl.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.offline.DownloadRequest;
import com.oplus.tbl.exoplayer2.util.AtomicFile;
import com.oplus.tbl.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
final class ActionFile {
    private static final String DOWNLOAD_TYPE_DASH = "dash";
    private static final String DOWNLOAD_TYPE_HLS = "hls";
    private static final String DOWNLOAD_TYPE_PROGRESSIVE = "progressive";
    private static final String DOWNLOAD_TYPE_SS = "ss";
    private static final int VERSION = 0;
    private final AtomicFile atomicFile;

    public ActionFile(File file) {
        this.atomicFile = new AtomicFile(file);
    }

    private static String generateDownloadId(Uri uri, @Nullable String str) {
        return str != null ? str : uri.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String inferMimeType(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != 3680) {
            if (iHashCode != 103407) {
                if (iHashCode != 3075986) {
                    b = (iHashCode == 1131547531 && str.equals(DOWNLOAD_TYPE_PROGRESSIVE)) ? (byte) 3 : (byte) -1;
                } else if (str.equals(DOWNLOAD_TYPE_DASH)) {
                    b = 0;
                }
            } else if (str.equals("hls")) {
                b = 1;
            }
        } else if (str.equals(DOWNLOAD_TYPE_SS)) {
            b = 2;
        }
        return b != 0 ? b != 1 ? b != 2 ? "video/x-unknown" : "application/vnd.ms-sstr+xml" : "application/x-mpegURL" : "application/dash+xml";
    }

    private static DownloadRequest readDownloadRequest(DataInputStream dataInputStream) throws IOException {
        byte[] bArr;
        String utf = dataInputStream.readUTF();
        int i = dataInputStream.readInt();
        Uri uri = Uri.parse(dataInputStream.readUTF());
        boolean z = dataInputStream.readBoolean();
        int i2 = dataInputStream.readInt();
        String utf2 = null;
        if (i2 != 0) {
            bArr = new byte[i2];
            dataInputStream.readFully(bArr);
        } else {
            bArr = null;
        }
        boolean z2 = true;
        boolean z3 = i == 0 && DOWNLOAD_TYPE_PROGRESSIVE.equals(utf);
        ArrayList arrayList = new ArrayList();
        if (!z3) {
            int i3 = dataInputStream.readInt();
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.add(readKey(utf, i, dataInputStream));
            }
        }
        if (i >= 2 || (!DOWNLOAD_TYPE_DASH.equals(utf) && !"hls".equals(utf) && !DOWNLOAD_TYPE_SS.equals(utf))) {
            z2 = false;
        }
        if (!z2 && dataInputStream.readBoolean()) {
            utf2 = dataInputStream.readUTF();
        }
        String strGenerateDownloadId = i < 3 ? generateDownloadId(uri, utf2) : dataInputStream.readUTF();
        if (z) {
            throw new DownloadRequest.UnsupportedRequestException();
        }
        return new DownloadRequest.Builder(strGenerateDownloadId, uri).setMimeType(inferMimeType(utf)).setStreamKeys(arrayList).setCustomCacheKey(utf2).setData(bArr).build();
    }

    private static StreamKey readKey(String str, int i, DataInputStream dataInputStream) throws IOException {
        int i2;
        int i3;
        int i4;
        if (("hls".equals(str) || DOWNLOAD_TYPE_SS.equals(str)) && i == 0) {
            i2 = dataInputStream.readInt();
            i3 = dataInputStream.readInt();
            i4 = 0;
        } else {
            int i5 = dataInputStream.readInt();
            int i6 = dataInputStream.readInt();
            int i7 = dataInputStream.readInt();
            i4 = i5;
            i2 = i6;
            i3 = i7;
        }
        return new StreamKey(i4, i2, i3);
    }

    public void delete() {
        this.atomicFile.delete();
    }

    public boolean exists() {
        return this.atomicFile.exists();
    }

    public DownloadRequest[] load() throws IOException {
        if (!exists()) {
            return new DownloadRequest[0];
        }
        try {
            InputStream inputStreamOpenRead = this.atomicFile.openRead();
            DataInputStream dataInputStream = new DataInputStream(inputStreamOpenRead);
            int i = dataInputStream.readInt();
            if (i > 0) {
                throw new IOException("Unsupported action file version: " + i);
            }
            int i2 = dataInputStream.readInt();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    arrayList.add(readDownloadRequest(dataInputStream));
                } catch (DownloadRequest.UnsupportedRequestException unused) {
                }
            }
            DownloadRequest[] downloadRequestArr = (DownloadRequest[]) arrayList.toArray(new DownloadRequest[0]);
            Util.closeQuietly(inputStreamOpenRead);
            return downloadRequestArr;
        } catch (Throwable th) {
            Util.closeQuietly((Closeable) null);
            throw th;
        }
    }
}
