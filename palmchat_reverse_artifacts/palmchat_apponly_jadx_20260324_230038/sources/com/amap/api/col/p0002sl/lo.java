package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class lo {
    private File b;
    private Handler d;
    private String e;
    private boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<ln> f2975a = new LinkedList<>();
    private boolean c = false;
    private Runnable g = new Runnable() { // from class: com.amap.api.col.2sl.lo.1
        @Override // java.lang.Runnable
        public final void run() {
            if (lo.this.c) {
                return;
            }
            if (lo.this.f) {
                lo.this.b();
                lo.d(lo.this);
            }
            if (lo.this.d != null) {
                lo.this.d.postDelayed(lo.this.g, 60000L);
            }
        }
    };

    public lo(Context context, Handler handler) {
        this.e = null;
        this.d = handler;
        String path = context.getFilesDir().getPath();
        if (this.e == null) {
            this.e = mm.l(context);
        }
        try {
            this.b = new File(path, "hisloc");
        } catch (Throwable th) {
            ku.a(th);
        }
        a();
        Handler handler2 = this.d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.g);
            this.d.postDelayed(this.g, 60000L);
        }
    }

    public static /* synthetic */ boolean d(lo loVar) {
        loVar.f = false;
        return false;
    }

    public final void a(boolean z) {
        if (!z) {
            this.g.run();
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacks(this.g);
        }
        this.c = true;
    }

    public final void b(ln lnVar) {
        a(lnVar, 12);
    }

    public final void c(ln lnVar) {
        if (this.f2975a.size() > 0) {
            int i = lnVar.f2974a;
            if (i != 6 && i != 5) {
                if (this.f2975a.contains(lnVar)) {
                    return;
                }
                if (this.f2975a.size() >= 10) {
                    this.f2975a.removeFirst();
                }
                this.f2975a.add(lnVar);
                this.f = true;
                return;
            }
            ln last = this.f2975a.getLast();
            if (last.c == lnVar.c && last.b == lnVar.b && last.e == lnVar.e) {
                return;
            }
            if (this.f2975a.size() >= 10) {
                this.f2975a.removeFirst();
            }
            this.f2975a.add(lnVar);
            this.f = true;
        }
    }

    private static boolean b(ArrayList<ll> arrayList, ArrayList<kr> arrayList2) {
        return arrayList == null || arrayList.size() <= 0 || arrayList2 == null || arrayList2.size() <= 0 || (((long) arrayList.size()) < 4 && ((long) arrayList2.size()) < 20);
    }

    public final void a(ln lnVar) {
        a(lnVar, 1);
    }

    private void a(ln lnVar, int i) {
        if (lnVar == null) {
            return;
        }
        ln lnVar2 = null;
        ln lnVar3 = null;
        int i2 = 0;
        for (ln lnVar4 : this.f2975a) {
            if (lnVar4.f2974a == i) {
                if (lnVar3 == null) {
                    lnVar3 = lnVar4;
                }
                i2++;
                lnVar2 = lnVar4;
            }
        }
        if (lnVar2 == null || lnVar.d - lnVar2.d >= 20000 || mm.a(new double[]{lnVar.b, lnVar.c, lnVar2.b, lnVar2.c}) >= 20.0f) {
            if (i2 >= 5) {
                this.f2975a.remove(lnVar3);
            }
            if (this.f2975a.size() >= 10) {
                this.f2975a.removeFirst();
            }
            this.f2975a.add(lnVar);
            this.f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        StringBuilder sb = new StringBuilder();
        Iterator<ln> it = this.f2975a.iterator();
        while (it.hasNext()) {
            try {
                sb.append(fw.b(lt.a(it.next().a().getBytes("UTF-8"), this.e)) + "\n");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        mm.a(this.b, string);
    }

    public final List<ln> a(ArrayList<ll> arrayList, ArrayList<kr> arrayList2) {
        if (!b(arrayList, arrayList2)) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        for (ln lnVar : this.f2975a) {
            if (jCurrentTimeMillis - lnVar.d < 21600000000L) {
                arrayList3.add(lnVar);
                i++;
            }
            if (i == 10) {
                break;
            }
        }
        return arrayList3;
    }

    private void a() {
        LinkedList<ln> linkedList = this.f2975a;
        if (linkedList == null || linkedList.size() <= 0) {
            Iterator<String> it = mm.a(this.b).iterator();
            while (it.hasNext()) {
                try {
                    String str = new String(lt.b(fw.b(it.next()), this.e), "UTF-8");
                    ln lnVar = new ln();
                    lnVar.a(new JSONObject(str));
                    this.f2975a.add(lnVar);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
