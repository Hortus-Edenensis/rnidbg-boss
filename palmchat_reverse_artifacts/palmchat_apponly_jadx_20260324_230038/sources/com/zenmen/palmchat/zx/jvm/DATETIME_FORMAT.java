package com.zenmen.palmchat.zx.jvm;

import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/zenmen/palmchat/zx/jvm/DATETIME_FORMAT;", "", "fmt", "Ljava/text/SimpleDateFormat;", "(Ljava/lang/String;ILjava/text/SimpleDateFormat;)V", "format", "", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "Ljava/util/Date;", "SIMPLE", "LOG", "zx-jvm"}, k = 1, mv = {1, 1, 16})
public enum DATETIME_FORMAT {
    SIMPLE(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS")),
    LOG(new SimpleDateFormat("HH:mm:ss,SSS"));

    private final SimpleDateFormat fmt;

    DATETIME_FORMAT(SimpleDateFormat simpleDateFormat) {
        this.fmt = simpleDateFormat;
    }

    public final String format(Date date) {
        String str = this.fmt.format(date);
        Intrinsics.checkExpressionValueIsNotNull(str, "fmt.format(date)");
        return str;
    }
}
