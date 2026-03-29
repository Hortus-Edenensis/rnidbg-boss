package com.baidu.platform.comapi.map.c0.e;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.c0.a;
import com.baidu.platform.comapi.map.c0.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a.C0104a f4197a;
    public a.C0104a b;
    public a.C0104a c;
    public MotionEvent d;
    private a f;
    public d e = new d();
    private boolean g = false;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        boolean a(b bVar);

        boolean a(b bVar, MotionEvent motionEvent);

        boolean b(b bVar);
    }

    public b(a aVar) {
        this.f = aVar;
    }

    private void a() {
        this.e.b();
        this.f4197a = null;
        this.b = null;
        this.c = null;
        this.g = true;
        this.f.b(this);
    }

    private void c(MotionEvent motionEvent) {
        a.C0104a c0104aA = a.C0104a.a(motionEvent);
        a.C0104a c0104a = this.c;
        if (c0104a == null) {
            c0104a = c0104aA;
        }
        this.b = c0104a;
        this.c = c0104aA;
        if (this.f4197a == null) {
            this.f4197a = c0104aA;
        }
    }

    public void b(MotionEvent motionEvent) {
        this.d = motionEvent;
        int action = motionEvent.getAction();
        if (action == 2) {
            if (this.g) {
                a(motionEvent);
                return;
            } else {
                if (motionEvent.getPointerCount() == 2) {
                    a();
                    return;
                }
                return;
            }
        }
        if (action != 6) {
            if (action == 261) {
                if (this.g) {
                    return;
                }
                a();
                return;
            } else if (action != 262) {
                return;
            }
        }
        if (this.g) {
            b();
        }
    }

    private void a(MotionEvent motionEvent) {
        this.e.a(motionEvent);
        Pair<a.d, a.d> pairC = this.e.c();
        if (motionEvent.getPointerCount() == 2) {
            if (Math.abs(((a.d) pairC.first).f4189a) > 0.0d || Math.abs(((a.d) pairC.first).b) > 0.0d || Math.abs(((a.d) pairC.second).f4189a) > 0.0d || Math.abs(((a.d) pairC.second).b) > 0.0d) {
                c(motionEvent);
                this.f.a(this, motionEvent);
            }
        }
    }

    private void b() {
        this.e.a();
        this.g = false;
        this.f.a(this);
    }
}
