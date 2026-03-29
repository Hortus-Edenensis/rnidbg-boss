package com.zenmen.palmchat.teenagersmode;

import android.database.ContentObserver;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import defpackage.ch;
import defpackage.dx5;
import defpackage.iq5;
import defpackage.k86;
import defpackage.yt5;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class TeenagersModeManager {
    public static TeenagersModeManager f;
    public yt5 b;
    public Response.Listener<JSONObject> c;
    public Response.ErrorListener d;
    public com.zenmen.palmchat.teenagersmode.a e = new com.zenmen.palmchat.teenagersmode.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15413a = SPUtil.f14322a.f(SPUtil.SCENE.APP_COMMON, k86.A(), 0);

    /* JADX INFO: compiled from: SearchBox */
    public enum SmallVideoMode {
        ATTENTION(0),
        NOT_ACCESS(1),
        ALL(2);

        private int value;

        SmallVideoMode(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public static SmallVideoMode valueOf(int i) {
            return i != 0 ? i != 1 ? ALL : NOT_ACCESS : ATTENTION;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15414a;
        public final /* synthetic */ d b;

        public a(int i, d dVar) {
            this.f15414a = i;
            this.b = dVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.optInt("resultCode", -1) != 0) {
                this.b.onFail();
                return;
            }
            TeenagersModeManager.this.f(this.f15414a);
            iq5.j(false, new String[0]);
            this.b.onSuccess();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f15415a;

        public b(d dVar) {
            this.f15415a = dVar;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f15415a.onFail();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {
        public static int a(int i, int i2) {
            int i3 = i & i2;
            return i2 != 15 ? i2 != 240 ? i3 : i3 >> 4 : i3 >> 0;
        }

        public static int b(int i, int i2, int i3) {
            int i4;
            int i5 = i & (~i3);
            if (i3 == 15) {
                i4 = i2 << 0;
            } else {
                if (i3 != 240) {
                    return i5;
                }
                i4 = i2 << 4;
            }
            return i5 | i4;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void onFail();

        void onSuccess();
    }

    public static TeenagersModeManager a() {
        if (f == null) {
            synchronized (TeenagersModeManager.class) {
                if (f == null) {
                    f = new TeenagersModeManager();
                }
            }
        }
        return f;
    }

    public SmallVideoMode b() {
        return SmallVideoMode.valueOf(c.a(this.f15413a, 240));
    }

    public com.zenmen.palmchat.teenagersmode.a c() {
        return this.e;
    }

    public boolean d() {
        return c.a(this.f15413a, 15) == 1;
    }

    public void e() {
        this.f15413a = 0;
    }

    public void f(int i) {
        if (this.f15413a != i) {
            this.f15413a = i;
            SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.A(), Integer.valueOf(i));
            AppContext.getContext().getContentResolver().notifyChange(dx5.f17178a, (ContentObserver) null, false);
            ch.s().h0();
        }
    }

    public final void g(int i, d dVar) {
        this.c = new a(i, dVar);
        this.d = new b(dVar);
        yt5 yt5Var = new yt5();
        this.b = yt5Var;
        yt5Var.n(i, this.c, this.d);
    }

    public void h(SmallVideoMode smallVideoMode, d dVar) {
        g(c.b(this.f15413a, smallVideoMode.value, 240), dVar);
    }

    public void i(boolean z, d dVar) {
        g(c.b(c.b(this.f15413a, z ? 1 : 0, 15), (z ? SmallVideoMode.NOT_ACCESS : SmallVideoMode.ALL).value, 240), dVar);
    }
}
