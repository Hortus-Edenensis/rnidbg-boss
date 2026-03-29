package com.tencent.turingfd.sdk.ams.ad;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.ams.ad.Berry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.const, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cconst extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Nectarine f10754a;
    public final List<Orion> b;

    public Cconst(Looper looper, Nectarine nectarine) {
        super(looper);
        this.b = new ArrayList();
        this.f10754a = nectarine;
    }

    public final void a() {
        for (Orion orion : this.b) {
            orion.getClass();
            synchronized (Orion.i) {
                int i = Orion.j;
                if (i < 200) {
                    Orion.j = i + 1;
                    orion.f10730a = Orion.k;
                    Orion.k = orion;
                }
            }
        }
        this.b.clear();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        Durian durian = null;
        if (i == 1) {
            Object obj = message.obj;
            if (obj instanceof String) {
                ((Berry.Cdo) this.f10754a).a(new Cfinal((String) obj, 3, null));
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        Object obj2 = message.obj;
        if (obj2 instanceof Orion) {
            Orion orion = (Orion) obj2;
            String str = orion.b;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!this.b.isEmpty() && !this.b.get(0).b.equals(orion.b)) {
                a();
            }
            int i2 = orion.c;
            if (i2 == 0) {
                a();
                this.b.add(orion);
                return;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    this.b.isEmpty();
                    this.b.add(orion);
                    return;
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    a();
                    return;
                }
            }
            if (this.b.isEmpty()) {
                return;
            }
            this.b.add(orion);
            List<Orion> list = this.b;
            ArrayList<Orion> arrayList = new ArrayList();
            if (list.size() <= 8) {
                arrayList.addAll(list);
            } else {
                Orion orion2 = list.get(0);
                Orion orion3 = list.get(list.size() - 1);
                list.remove(orion2);
                list.remove(orion3);
                int iCeil = (int) Math.ceil(list.size() / 6);
                arrayList.add(orion2);
                for (int i3 = 1; i3 < list.size(); i3 += iCeil) {
                    arrayList.add(list.get(i3));
                }
                arrayList.add(orion3);
            }
            if (!arrayList.isEmpty()) {
                Orion orion4 = (Orion) arrayList.get(0);
                Durian durian2 = new Durian();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = orion4.h;
                durian2.b = (int) (jCurrentTimeMillis - j);
                durian2.f10693a = j;
                ArrayList<Fig> arrayList2 = new ArrayList<>();
                for (Orion orion5 : arrayList) {
                    Fig fig = new Fig();
                    int i4 = orion5.c;
                    if (i4 == 0) {
                        fig.f10694a = 1;
                    } else if (i4 == 1) {
                        fig.f10694a = 3;
                    } else if (i4 == 2) {
                        fig.f10694a = 2;
                    } else if (i4 != 3) {
                        fig.f10694a = 0;
                    } else {
                        fig.f10694a = 4;
                    }
                    fig.d = orion5.f;
                    fig.e = orion5.g;
                    arrayList2.add(fig);
                }
                durian2.c = arrayList2;
                durian = durian2;
            }
            if (durian == null) {
                return;
            }
            if (orion.d <= 0) {
                durian.d |= 1;
            }
            if (orion.e == 0) {
                durian.d |= 2;
            }
            if (durian.d != 0) {
                ((Berry.Cdo) this.f10754a).a(new Cfinal(str, 2, durian));
            } else {
                ((Berry.Cdo) this.f10754a).a(new Cfinal(str, 1, durian));
            }
            a();
        }
    }
}
