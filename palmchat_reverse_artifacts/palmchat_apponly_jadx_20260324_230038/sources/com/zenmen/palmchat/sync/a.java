package com.zenmen.palmchat.sync;

import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.MyTabOfNewVipCenterConfig;
import defpackage.az2;
import defpackage.il5;
import defpackage.iv0;
import defpackage.ts0;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MyTabOfNewVipCenterConfig f15404a;

    public a() {
        JSONObject jSONObjectE = ts0.o().E();
        if (jSONObjectE == null) {
            this.f15404a = new MyTabOfNewVipCenterConfig();
            return;
        }
        MyTabOfNewVipCenterConfig myTabOfNewVipCenterConfig = (MyTabOfNewVipCenterConfig) az2.a(jSONObjectE.toString(), MyTabOfNewVipCenterConfig.class);
        this.f15404a = myTabOfNewVipCenterConfig;
        if (myTabOfNewVipCenterConfig == null) {
            this.f15404a = new MyTabOfNewVipCenterConfig();
        }
    }

    public static boolean e() {
        MyTabOfNewVipCenterConfig myTabOfNewVipCenterConfigB = new a().b();
        return myTabOfNewVipCenterConfigB == null || myTabOfNewVipCenterConfigB.visiable == 1;
    }

    public boolean a(long j) {
        List<MyTabOfNewVipCenterConfig.RedDotConf> list;
        MyTabOfNewVipCenterConfig myTabOfNewVipCenterConfigB = new a().b();
        if (myTabOfNewVipCenterConfigB != null && (list = myTabOfNewVipCenterConfigB.reddot_period) != null && !list.isEmpty()) {
            Iterator<MyTabOfNewVipCenterConfig.RedDotConf> it = myTabOfNewVipCenterConfigB.reddot_period.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MyTabOfNewVipCenterConfig.RedDotConf next = it.next();
                if (next != null && !il5.l(next.start) && !il5.l(next.end) && next.num > 0 && iv0.c(iv0.d(j), iv0.e(next.start), iv0.e(next.end))) {
                    if (c(next.start + "_" + next.end) < next.num) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public MyTabOfNewVipCenterConfig b() {
        return this.f15404a;
    }

    public int c(String str) {
        return SPUtil.f14322a.f(SPUtil.SCENE.MYTAB, str, 0);
    }

    public void d(String str, int i) {
        SPUtil.f14322a.t(SPUtil.SCENE.MYTAB, str, Integer.valueOf(i));
    }
}
