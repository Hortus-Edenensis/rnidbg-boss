package com.zenmen.square.fragment;

import defpackage.iw3;
import defpackage.yt1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTopicTimelineFragment extends NestTopicFeedsFragment {
    @Override // com.zenmen.square.fragment.NestTopicFeedsFragment, com.zenmen.listui.list.BaseListFragment
    /* JADX INFO: renamed from: O0 */
    public yt1 c0() {
        if (this.k == 0) {
            this.k = new iw3(this.u, o());
        }
        return (yt1) this.k;
    }

    @Override // com.zenmen.square.fragment.NestTopicFeedsFragment, com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 7;
    }
}
