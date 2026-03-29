package com.oplus.tblplayer.misc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.zm2;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class TBLMediaFormat implements IMediaFormat {

    @NonNull
    private Map<String, Object> mMap = new HashMap();

    @NonNull
    public static IMediaFormat createAudioFormat(@NonNull String str, int i, int i2) {
        TBLMediaFormat tBLMediaFormat = new TBLMediaFormat();
        tBLMediaFormat.setString(IMediaFormat.KEY_MIME, str);
        tBLMediaFormat.setInteger("sample-rate", i);
        tBLMediaFormat.setInteger("channel-count", i2);
        return tBLMediaFormat;
    }

    @NonNull
    public static IMediaFormat createSubtitleFormat(@NonNull String str, String str2) {
        TBLMediaFormat tBLMediaFormat = new TBLMediaFormat();
        tBLMediaFormat.setString(IMediaFormat.KEY_MIME, str);
        tBLMediaFormat.setString("language", str2);
        return tBLMediaFormat;
    }

    @NonNull
    public static IMediaFormat createVideoFormat(@NonNull String str, int i, int i2) {
        TBLMediaFormat tBLMediaFormat = new TBLMediaFormat();
        tBLMediaFormat.setString(IMediaFormat.KEY_MIME, str);
        tBLMediaFormat.setInteger("width", i);
        tBLMediaFormat.setInteger("height", i2);
        return tBLMediaFormat;
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final boolean containsKey(@NonNull String str) {
        return this.mMap.containsKey(str);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final ByteBuffer getByteBuffer(@NonNull String str) {
        return (ByteBuffer) this.mMap.get(str);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final float getFloat(@NonNull String str) {
        return ((Float) this.mMap.get(str)).floatValue();
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final int getInteger(@NonNull String str) {
        return ((Integer) this.mMap.get(str)).intValue();
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final long getLong(@NonNull String str) {
        return ((Long) this.mMap.get(str)).longValue();
    }

    public Map<String, Object> getMap() {
        return this.mMap;
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final String getString(@NonNull String str) {
        return (String) this.mMap.get(str);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final int getValueTypeForKey(@NonNull String str) {
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        if (obj instanceof Long) {
            return 2;
        }
        if (obj instanceof Float) {
            return 3;
        }
        if (obj instanceof String) {
            return 4;
        }
        if (obj instanceof ByteBuffer) {
            return 5;
        }
        throw new RuntimeException("invalid value for key");
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final void setByteBuffer(@NonNull String str, @Nullable ByteBuffer byteBuffer) {
        this.mMap.put(str, byteBuffer);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final void setFloat(@NonNull String str, float f) {
        this.mMap.put(str, new Float(f));
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final void setInteger(@NonNull String str, int i) {
        this.mMap.put(str, Integer.valueOf(i));
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final void setLong(@NonNull String str, long j) {
        this.mMap.put(str, Long.valueOf(j));
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public final void setString(@NonNull String str, @Nullable String str2) {
        this.mMap.put(str, str2);
    }

    @NonNull
    public String toString() {
        return this.mMap.toString();
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ ByteBuffer getByteBuffer(String str, ByteBuffer byteBuffer) {
        return zm2.c(this, str, byteBuffer);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ float getFloat(String str, float f) {
        return zm2.e(this, str, f);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ int getInteger(String str, int i) {
        return zm2.g(this, str, i);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ long getLong(String str, long j) {
        return zm2.i(this, str, j);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ String getString(String str, String str2) {
        return zm2.k(this, str, str2);
    }
}
