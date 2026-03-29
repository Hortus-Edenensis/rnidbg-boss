package androidx.media3.transformer;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
interface OnMediaItemChangedListener {
    void onMediaItemChanged(EditedMediaItem editedMediaItem, long j, @Nullable Format format, boolean z);
}
