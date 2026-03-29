package com.bytedance.sdk.component.n.nr.nr.u;

import com.bytedance.sdk.component.n.nr.nr.nr;
import com.bytedance.sdk.component.n.u.b;
import com.bytedance.sdk.component.n.u.n;
import com.bytedance.sdk.component.n.u.pn;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private StringBuffer u = new StringBuffer();
    private AtomicLong nr = new AtomicLong(0);
    private AtomicLong fx = new AtomicLong(0);
    private AtomicLong b = new AtomicLong(0);
    private AtomicLong pn = new AtomicLong(0);
    private AtomicLong iz = new AtomicLong(0);
    private AtomicLong x = new AtomicLong(0);
    private AtomicLong n = new AtomicLong(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicLong f5157a = new AtomicLong(0);
    private AtomicLong jk = new AtomicLong(0);
    private AtomicLong t = new AtomicLong(0);
    private AtomicLong l = new AtomicLong(0);
    private AtomicLong mv = new AtomicLong(0);
    private AtomicLong s = new AtomicLong(0);
    private AtomicLong k = new AtomicLong(0);
    private AtomicLong my = new AtomicLong(0);
    private AtomicLong o = new AtomicLong(0);
    private AtomicLong sx = new AtomicLong(0);
    private AtomicLong bg = new AtomicLong(0);
    private AtomicLong bq = new AtomicLong(0);
    private AtomicLong dw = new AtomicLong(0);
    private AtomicLong c = new AtomicLong(0);
    private AtomicLong q = new AtomicLong(0);
    private AtomicLong qq = new AtomicLong(0);

    public AtomicLong a() {
        return this.fx;
    }

    public AtomicLong b() {
        return this.dw;
    }

    public AtomicLong bg() {
        return this.s;
    }

    public AtomicLong bq() {
        return this.k;
    }

    public AtomicLong c() {
        return this.o;
    }

    public AtomicLong dw() {
        return this.my;
    }

    public AtomicLong fx() {
        return this.c;
    }

    public synchronized void iz() {
        mv().set(0L);
        dw().set(0L);
        c().set(0L);
        bq().set(0L);
        qq().set(0L);
        q().set(0L);
        bg().set(0L);
        sx().set(0L);
        my().set(0L);
        l().set(0L);
        s().set(0L);
        o().set(0L);
        k().set(0L);
        jk().set(0L);
        n().set(0L);
        a().set(0L);
        x().set(0L);
        t().set(0L);
        b().set(0L);
        fx().set(0L);
        nr().set(0L);
        u().set(0L);
        try {
            if (this.u.length() != 0) {
                this.u.setLength(0);
            }
        } catch (Exception unused) {
        }
    }

    public AtomicLong jk() {
        return this.t;
    }

    public AtomicLong k() {
        return this.x;
    }

    public StringBuffer kj() {
        return this.u;
    }

    public AtomicLong l() {
        return this.nr;
    }

    public AtomicLong mv() {
        return this.b;
    }

    public AtomicLong my() {
        return this.n;
    }

    public AtomicLong n() {
        return this.pn;
    }

    public AtomicLong nr() {
        return this.q;
    }

    public AtomicLong o() {
        return this.jk;
    }

    public AtomicLong pn() {
        return this.mv;
    }

    public AtomicLong q() {
        return this.sx;
    }

    public AtomicLong qq() {
        return this.bg;
    }

    public AtomicLong s() {
        return this.iz;
    }

    public AtomicLong sx() {
        return this.l;
    }

    public AtomicLong t() {
        return this.bq;
    }

    public AtomicLong u() {
        return this.qq;
    }

    public AtomicLong x() {
        return this.f5157a;
    }

    public synchronized void u(long j) {
        this.nr.getAndAdd(j);
        this.fx.incrementAndGet();
    }

    public JSONObject u(long j, pn pnVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            long j2 = a().get();
            long j3 = 1;
            jSONObject.put("create_save_cost_ts_avg", (l().get() * 1.0f) / (j2 == 0 ? 1L : j2));
            jSONObject.put("save_success_count", j2);
            long j4 = n().get();
            jSONObject.put("save_upload_cost_ts_avg", (mv().get() * 1.0f) / (j4 == 0 ? 1L : j4));
            jSONObject.put("will_send_count", j4);
            jSONObject.put("sdk_event_index", j);
            jSONObject.put("sdk_send_success_count", this.mv.get());
            jSONObject.put("all_delete_count", s().get());
            jSONObject.put("success_delete_count", k().get());
            jSONObject.put("invalid_delete_count", my().get());
            jSONObject.put("will_save_count", o().get());
            jSONObject.put("did_send_count", jk().get());
            jSONObject.put("send_success_valid_count", sx().get());
            long j5 = x().get();
            jSONObject.put("send_success_invalid_count", bg().get());
            jSONObject.put("send_fail_count", j5);
            jSONObject.put("before_save_count", t().get());
            jSONObject.put("success_tm", b().get());
            jSONObject.put("queue_timeout_tm", fx().get());
            jSONObject.put("after_upload_tm", nr().get());
            jSONObject.put("quit_tm", u().get());
            long j6 = dw().get();
            long j7 = c().get();
            jSONObject.put("success_request_cost_ts_avg", (q().get() * 1.0f) / (j6 == 0 ? 1L : j6));
            float f = qq().get() * 1.0f;
            if (j7 != 0) {
                j3 = j7;
            }
            jSONObject.put("fail_request_cost_ts_avg", f / j3);
            jSONObject.put("request_count", bq().get());
            jSONObject.put("request_success_count", j6);
            jSONObject.put("request_fail_count", j7);
            jSONObject.put("is_multi_process", pnVar.t());
            jSONObject.put("app_start_time", nr.fx);
            jSONObject.put("app_first_time", nr.b);
            jSONObject.put("fail_code_list", this.u.toString());
            b bVarB = pnVar.b();
            if (bVarB != null) {
                jSONObject.put("is_debug", bVarB.fx());
                n nVarS = bVarB.s();
                if (nVarS != null) {
                    jSONObject.put("is_plugin", nVarS.n());
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
