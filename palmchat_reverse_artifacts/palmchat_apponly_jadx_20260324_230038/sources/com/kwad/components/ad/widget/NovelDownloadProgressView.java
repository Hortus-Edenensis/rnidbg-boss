package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class NovelDownloadProgressView extends DownloadProgressView {
    public NovelDownloadProgressView(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    public final void nY() {
        m.inflate(getContext(), R.layout.ksad_download_progress_novel_layout, this);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    public final void nZ() {
        this.MX = getResources().getDrawable(R.drawable.ksad_feed_download_progress_novel);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    public final void oa() {
        this.MY = getResources().getDrawable(R.drawable.ksad_feed_actionbar_before_bg);
    }

    public NovelDownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NovelDownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
