package com.ss.android.downloadlib.addownload;

import android.os.SystemClock;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class mv {
    private static final String u = "mv";

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        private static mv u = new mv();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements Runnable {
        private final com.ss.android.downloadad.api.u.nr nr;

        public u(com.ss.android.downloadad.api.u.nr nrVar) {
            this.nr = nrVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.nr.jk(true);
                mv.this.nr(this.nr);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.nr.jk(false);
                throw th;
            }
            this.nr.jk(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(com.ss.android.downloadad.api.u.nr nrVar) {
        JSONObject jSONObject = new JSONObject();
        int iU = com.ss.android.downloadlib.x.pn.u(nrVar);
        int iNr = com.ss.android.downloadlib.x.pn.nr(nrVar);
        if (com.ss.android.downloadlib.x.pn.pn(nrVar) && com.ss.android.downloadlib.x.pn.b(nrVar)) {
            com.ss.android.downloadlib.x.l.u().u(u, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            u(nrVar, iU, iNr, jSONObject);
        } else {
            com.ss.android.downloadlib.x.l.u().u(u, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            nr(nrVar, 15, 20000, jSONObject);
        }
    }

    private mv() {
    }

    public static mv u() {
        return nr.u;
    }

    public void u(com.ss.android.downloadad.api.u.nr nrVar) {
        com.ss.android.downloadlib.x.l.u().u(u, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.ss.android.downloadlib.pn.u().fx(new u(nrVar));
    }

    private void u(com.ss.android.downloadad.api.u.nr nrVar, int i, int i2, JSONObject jSONObject) {
        int iIz;
        if (nrVar.jp() == 4) {
            iIz = l.a().optInt("market_install_finish_check_time", 600);
        } else {
            iIz = com.ss.android.downloadlib.x.pn.iz(nrVar);
        }
        int i3 = ((iIz * 1000) / 20000) + 1;
        com.ss.android.downloadlib.x.l lVarU = com.ss.android.downloadlib.x.l.u();
        String str = u;
        lVarU.u(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:".concat(String.valueOf(i3)));
        if (nr(nrVar, i3, 20000, jSONObject)) {
            return;
        }
        if (((long) iIz) * 1000 < com.ss.android.downloadlib.x.pn.x(nrVar)) {
            com.ss.android.downloadlib.x.l.u().u(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
            if (nr(nrVar, i, i2, jSONObject)) {
                return;
            }
            com.ss.android.downloadlib.x.l.u().u(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
            return;
        }
        com.ss.android.downloadlib.x.l.u().u(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
    }

    private boolean nr(com.ss.android.downloadad.api.u.nr nrVar, int i, int i2, JSONObject jSONObject) {
        com.ss.android.downloadlib.x.l.u().u(u, "realListenInstallFinishEvent", "开始轮询检测,轮询时间间隔为" + i2 + ",轮询次数为" + i);
        long j = (long) i2;
        SystemClock.sleep(j);
        while (i > 0) {
            if (com.ss.android.downloadlib.x.mv.nr(nrVar)) {
                com.ss.android.downloadlib.u.u().u(nrVar.pn());
                com.ss.android.downloadlib.x.l.u().u(u, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为".concat(String.valueOf(i)));
                return true;
            }
            i--;
            if (i == 0) {
                return false;
            }
            SystemClock.sleep(j);
        }
        return false;
    }
}
