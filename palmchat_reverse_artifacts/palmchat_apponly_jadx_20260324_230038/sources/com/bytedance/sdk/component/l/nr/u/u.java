package com.bytedance.sdk.component.l.nr.u;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.u.nr;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements nr {
    private long u;
    private String nr = "tt_video_reward_full";
    private String fx = "tt_video_brand";
    private String b = "tt_video_splash";
    private String pn = "tt_video_default";
    private String iz = null;
    private String x = null;
    private String n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5152a = null;
    private String jk = null;
    private String t = null;

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public String b() {
        if (this.jk == null) {
            this.jk = this.t + File.separator + this.pn;
            File file = new File(this.jk);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.jk;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public String fx() {
        if (this.f5152a == null) {
            this.f5152a = this.t + File.separator + this.b;
            File file = new File(this.f5152a);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f5152a;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public String nr() {
        if (this.n == null) {
            this.n = this.t + File.separator + this.fx;
            File file = new File(this.n);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.n;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public void u(String str) {
        if (!TextUtils.isEmpty(this.t) && !this.t.equals(str)) {
            this.iz = null;
            this.x = null;
            this.n = null;
            this.f5152a = null;
            this.jk = null;
        }
        this.t = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public long nr(iz izVar) {
        return this.u;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public String u() {
        if (this.x == null) {
            this.x = this.t + File.separator + this.nr;
            File file = new File(this.x);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.x;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public boolean u(iz izVar) {
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(izVar.o(), izVar.pn());
        if (cacheInfoByFilePath != null) {
            boolean zMv = izVar.mv();
            this.u = cacheInfoByFilePath.mCacheSizeFromZero;
            int iNr = izVar.nr() > 0 ? izVar.nr() : izVar.iz();
            if (zMv) {
                iNr = (int) izVar.l();
            }
            if (cacheInfoByFilePath.mCacheSizeFromZero >= iNr) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.nr
    public void pn() {
    }
}
