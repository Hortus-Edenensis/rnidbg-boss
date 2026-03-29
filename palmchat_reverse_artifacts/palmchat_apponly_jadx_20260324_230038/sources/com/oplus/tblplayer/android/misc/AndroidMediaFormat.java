package com.oplus.tblplayer.android.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.igexin.push.core.b;
import com.oplus.tblplayer.misc.IMediaFormat;
import defpackage.zm2;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AndroidMediaFormat implements IMediaFormat {
    private final MediaFormat mMediaFormat;

    public AndroidMediaFormat(MediaFormat mediaFormat) {
        this.mMediaFormat = mediaFormat;
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ boolean containsKey(String str) {
        return zm2.a(this, str);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ ByteBuffer getByteBuffer(String str) {
        return zm2.b(this, str);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ float getFloat(String str) {
        return zm2.d(this, str);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    @TargetApi(16)
    public int getInteger(String str) {
        MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        return mediaFormat.getInteger(str);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ long getLong(String str) {
        return zm2.h(this, str);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    @TargetApi(16)
    public String getString(String str) {
        MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return null;
        }
        return mediaFormat.getString(str);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ int getValueTypeForKey(String str) {
        return zm2.l(this, str);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ void setByteBuffer(String str, ByteBuffer byteBuffer) {
        zm2.m(this, str, byteBuffer);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ void setFloat(String str, float f) {
        zm2.n(this, str, f);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ void setInteger(String str, int i) {
        zm2.o(this, str, i);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ void setLong(String str, long j) {
        zm2.p(this, str, j);
    }

    @Override // com.oplus.tblplayer.misc.IMediaFormat
    public /* synthetic */ void setString(String str, String str2) {
        zm2.q(this, str, str2);
    }

    @TargetApi(16)
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getName());
        sb.append('{');
        MediaFormat mediaFormat = this.mMediaFormat;
        sb.append(mediaFormat != null ? mediaFormat.toString() : b.m);
        sb.append('}');
        return sb.toString();
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
