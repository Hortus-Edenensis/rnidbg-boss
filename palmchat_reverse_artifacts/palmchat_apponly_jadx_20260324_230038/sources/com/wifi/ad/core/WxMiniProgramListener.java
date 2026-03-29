package com.wifi.ad.core;

import com.cdo.oaps.ad.OapsWrapper;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/wifi/ad/core/WxMiniProgramListener;", "", "onLaunchWechatMinProgram", "", "userName", "", OapsWrapper.KEY_PATH, "core_release"}, k = 1, mv = {1, 1, 16})
public interface WxMiniProgramListener {
    boolean onLaunchWechatMinProgram(String userName, String path);
}
