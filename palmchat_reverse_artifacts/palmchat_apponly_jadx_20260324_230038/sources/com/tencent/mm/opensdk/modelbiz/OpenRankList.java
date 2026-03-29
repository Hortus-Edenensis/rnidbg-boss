package com.tencent.mm.opensdk.modelbiz;

import com.tencent.mm.opensdk.modelbase.BaseReq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class OpenRankList {

    /* JADX INFO: compiled from: SearchBox */
    public static class Req extends BaseReq {
        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 11;
        }
    }
}
