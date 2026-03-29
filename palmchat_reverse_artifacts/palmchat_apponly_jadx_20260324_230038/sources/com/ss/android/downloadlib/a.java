package com.ss.android.downloadlib;

import com.ss.android.downloadlib.x.l;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.appdownloader.fx.my;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    private static boolean nr = false;
    private static final String u = "a";

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static a u = new a();
    }

    public static a u() {
        return u.u;
    }

    private a() {
    }

    public void u(com.ss.android.downloadlib.addownload.nr.pn pnVar, final com.ss.android.downloadad.api.u.nr nrVar) {
        if (!com.ss.android.downloadlib.x.pn.fx(nrVar)) {
            l.u().u(u, "checkMarketInstallFinishEvent", "开关未开启, 不使用动态广播监听能力");
            return;
        }
        if (nrVar == null) {
            l.u().nr(u, "checkMarketInstallFinishEvent", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (nrVar.eh()) {
            l.u().nr(u, "checkMarketInstallFinishEvent", "正在监听中,不重复监听");
            return;
        }
        try {
            l lVarU = l.u();
            String str = u;
            lVarU.u(str, "checkMarketInstallFinishEvent", "针对商店直投广告,开始检测安装完成事件");
            if (com.ss.android.downloadlib.x.pn.b(nrVar)) {
                l.u().u(str, "checkMarketInstallFinishEvent", "开始进行动态广播监听");
                int iOptInt = com.ss.android.downloadlib.addownload.l.a().optInt("market_install_finish_check_time", 600);
                if (nrVar.za() == 0 || System.currentTimeMillis() - nrVar.za() > ((long) iOptInt) * 1000) {
                    nrVar.jk(System.currentTimeMillis());
                    u(iOptInt, new my() { // from class: com.ss.android.downloadlib.a.1
                        @Override // com.ss.android.socialbase.appdownloader.fx.my
                        public void nr() {
                            l.u().u(a.u, "checkMarketInstallFinishEvent", "广播监听时间结束,主动解除了广播监听");
                            if (!mv.nr(nrVar)) {
                                l.u().u(a.u, "checkMarketInstallFinishEvent", "监听结束依然没有完成安装");
                            }
                            nrVar.jk(false);
                            com.ss.android.downloadlib.addownload.nr.iz.u().u(nrVar);
                        }

                        @Override // com.ss.android.socialbase.appdownloader.fx.my
                        public void u() {
                            l.u().u(a.u, "checkMarketInstallFinishEvent", "注册广播监听成功,注册耗时" + (System.currentTimeMillis() - nrVar.za()));
                            nrVar.jk(true);
                            com.ss.android.downloadlib.addownload.nr.iz.u().u(nrVar);
                        }
                    });
                } else {
                    l.u().u(str, "checkMarketInstallFinishEvent", "目前仍在广播监听的生效期内,不进行重复注册");
                }
            }
            if (com.ss.android.downloadlib.x.pn.pn(nrVar)) {
                l.u().u(str, "checkMarketInstallFinishEvent", "开启轮询线程能力,作为容灾手段");
                com.ss.android.downloadlib.addownload.mv.u().u(nrVar);
            }
            com.ss.android.downloadlib.addownload.nr.a.u().u(nrVar);
        } catch (Exception unused) {
            com.ss.android.downloadlib.pn.fx.u().u(false, "监听商店场景安装完成事件发生异常");
        }
    }

    public void u(final com.ss.android.downloadad.api.u.nr nrVar) {
        if (!com.ss.android.downloadlib.x.pn.fx(nrVar)) {
            l.u().u(u, "checkMarketInstallFinishEventForReboot", "线程轮询总开关未开启,因此不执行兜底逻辑");
            return;
        }
        if (nrVar == null) {
            l.u().nr(u, "checkMarketInstallFinishEventForReboot", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (nrVar.pn.get() && System.currentTimeMillis() - nrVar.za() > 30000) {
            l.u().u(u, "checkMarketInstallFinishEventForReboot", "兜底过一次了,不进行重复兜底");
            return;
        }
        if (com.ss.android.downloadlib.x.pn.b(nrVar)) {
            long jOptInt = ((long) com.ss.android.downloadlib.addownload.l.a().optInt("market_install_finish_check_time", 600)) * 1000;
            if (System.currentTimeMillis() - nrVar.za() >= jOptInt) {
                l.u().u(u, "checkMarketInstallFinishEventForReboot", "当前时间距离首次检测时间超出了广播生效期,不再执行兜底策略");
            } else {
                u((int) (((nrVar.za() + jOptInt) - System.currentTimeMillis()) / 1000), new my() { // from class: com.ss.android.downloadlib.a.2
                    @Override // com.ss.android.socialbase.appdownloader.fx.my
                    public void nr() {
                        l.u().u(a.u, "checkMarketInstallFinishEventForReboot", "兜底监听执行完毕,解除广播监听");
                        if (!mv.nr(nrVar)) {
                            l.u().u(a.u, "checkMarketInstallFinishEventForReboot", "监听结束依然没有完成安装");
                        }
                        nrVar.pn.compareAndSet(true, false);
                        nrVar.jk(false);
                        com.ss.android.downloadlib.addownload.nr.a.u().u(nrVar);
                    }

                    @Override // com.ss.android.socialbase.appdownloader.fx.my
                    public void u() {
                        l.u().u(a.u, "checkMarketInstallFinishEventForReboot", "进程被杀,重新注册广播监听成功,正式执行冷启兜底逻辑");
                        nrVar.pn.compareAndSet(false, true);
                        com.ss.android.downloadlib.addownload.nr.a.u().u(nrVar);
                    }
                });
            }
        }
    }

    public void u(int i, my myVar) {
        l.u().u(u, "registerMarketInstallFinishBroadcast", "动态广播监听的持续时间为:".concat(String.valueOf(i)));
        if (!nr) {
            com.ss.android.socialbase.appdownloader.b.t().u(myVar);
            nr = true;
        }
        com.ss.android.socialbase.appdownloader.b.t().u(i);
    }
}
