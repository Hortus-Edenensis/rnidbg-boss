package io.togoto.imagezoomcrop.photoview.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@TargetApi(14)
public class IcsScroller extends GingerScroller {
    public IcsScroller(Context context) {
        super(context);
    }

    @Override // io.togoto.imagezoomcrop.photoview.scrollerproxy.GingerScroller, io.togoto.imagezoomcrop.photoview.scrollerproxy.ScrollerProxy
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }
}
