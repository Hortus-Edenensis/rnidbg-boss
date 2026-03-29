package com.amap.api.maps2d.model;

import com.amap.api.col.p0002sl.ct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class UrlTileProvider implements TileProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3117a;
    private final int b;

    public UrlTileProvider(int i, int i2) {
        this.f3117a = i;
        this.b = i2;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.amap.api.maps2d.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        URL tileUrl = getTileUrl(i, i2, i3);
        if (tileUrl == null) {
            return TileProvider.NO_TILE;
        }
        tileUrl.toString();
        try {
            return new Tile(this.f3117a, this.b, a(tileUrl.openStream()));
        } catch (IOException e) {
            ct.a(e, "UrlTileProvider", "getTile");
            return TileProvider.NO_TILE;
        }
    }

    @Override // com.amap.api.maps2d.model.TileProvider
    public int getTileHeight() {
        return this.b;
    }

    public abstract URL getTileUrl(int i, int i2, int i3);

    @Override // com.amap.api.maps2d.model.TileProvider
    public int getTileWidth() {
        return this.f3117a;
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }
}
