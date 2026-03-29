package com.kwad.sdk.core;

import android.util.Pair;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e {
    private static final b aBi = new b(100);
    private static final a aBj = new a(10, 0);
    private static List<c> aBk = new ArrayList(50);
    private static final List<List<c>> aBl = new ArrayList();
    private static final List<Map<String, Double>> aBm = new ArrayList();
    private static c aBn;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends b {
        public /* synthetic */ a(int i, byte b) {
            this(10);
        }

        @Override // com.kwad.sdk.core.e.b
        public final char Gh() {
            return ',';
        }

        public final List<String> Gi() {
            return new ArrayList(this.aBp);
        }

        @Override // com.kwad.sdk.core.e.b
        public final boolean l(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            if (this.aBp.size() >= this.aBo) {
                this.aBp.poll();
            }
            return this.aBp.offer((String) obj);
        }

        private a(int i) {
            super(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public final int aBo;
        public final Queue<String> aBp = new LinkedList();

        public b(int i) {
            this.aBo = i;
        }

        public char Gh() {
            return '|';
        }

        public final void clear() {
            this.aBp.clear();
        }

        public boolean l(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            if (this.aBp.size() >= this.aBo) {
                this.aBp.poll();
            }
            HashMap map = new HashMap();
            c cVar = (c) obj;
            double dGj = cVar.Gj();
            double dGk = cVar.Gk();
            map.put("x", Double.valueOf(dGj));
            map.put("y", Double.valueOf(dGk));
            e.aBm.add(map);
            return this.aBp.offer(dGj + "_" + dGk);
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.aBp.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(Gh());
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {
        private int action;
        private double x;
        private double y;

        public c(MotionEvent motionEvent) {
            this.x = motionEvent.getX();
            this.y = motionEvent.getY();
            this.action = motionEvent.getAction();
        }

        private int getAction() {
            return this.action;
        }

        public final double Gj() {
            return this.x;
        }

        public final double Gk() {
            return this.y;
        }

        public final boolean a(c cVar) {
            return this.x == cVar.Gj() && this.y == cVar.Gk() && this.action == cVar.getAction();
        }
    }

    public static Pair<List<String>, Double> Gd() {
        Iterator<List<c>> it = aBl.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            Iterator<c> it2 = it.next().iterator();
            while (it2.hasNext()) {
                aBi.l(it2.next());
            }
            List<Map<String, Double>> list = aBm;
            double dY = y(list);
            if (dY > d) {
                d = dY;
            }
            list.clear();
            a aVar = aBj;
            b bVar = aBi;
            aVar.l(bVar.toString());
            bVar.clear();
        }
        return new Pair<>(Ge(), Double.valueOf(d));
    }

    private static List<String> Ge() {
        List<String> listGi = aBj.Gi();
        Gg();
        Gf();
        return listGi;
    }

    private static void Gf() {
        aBm.clear();
        aBl.clear();
        aBk.clear();
    }

    private static void Gg() {
        aBj.clear();
        aBi.clear();
    }

    private static void a(MotionEvent motionEvent, boolean z) {
        c cVar = new c(motionEvent);
        c cVar2 = aBn;
        if (cVar2 == null || !cVar2.a(cVar)) {
            aBk.add(cVar);
            aBn = cVar;
            if (z) {
                if (aBk.size() > 3 && aBk.size() < 100) {
                    aBl.add(aBk);
                }
                aBk = new ArrayList(50);
                aBn = null;
            }
        }
    }

    public static void f(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3 && action != 4) {
                        return;
                    }
                }
            }
            a(motionEvent, true);
            return;
        }
        a(motionEvent, false);
    }

    private static double y(List<Map<String, Double>> list) {
        double d = 0.0d;
        try {
            ArrayList arrayList = new ArrayList(list.size());
            ArrayList arrayList2 = new ArrayList(list.size());
            ArrayList arrayList3 = new ArrayList(list.size());
            ArrayList arrayList4 = new ArrayList(list.size());
            a(list, arrayList, arrayList2, arrayList3, arrayList4);
            int i = 1;
            for (int i2 = 1; i < list.size() - i2; i2 = 1) {
                int i3 = i;
                double dAbs = Math.abs((((Double) arrayList.get(i)).doubleValue() * ((Double) arrayList4.get(i)).doubleValue()) - (((Double) arrayList2.get(i)).doubleValue() * ((Double) arrayList3.get(i)).doubleValue())) / Math.pow(Math.pow(((Double) arrayList.get(i)).doubleValue(), 2.0d) + Math.pow(((Double) arrayList2.get(i)).doubleValue(), 2.0d), 1.5d);
                if (dAbs > d) {
                    d = dAbs;
                }
                i = i3 + 1;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return d;
    }

    private static void a(List<Map<String, Double>> list, List<Double> list2, List<Double> list3, List<Double> list4, List<Double> list5) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list2.add(Double.valueOf(0.0d));
            list3.add(Double.valueOf(0.0d));
            list4.add(Double.valueOf(0.0d));
            list5.add(Double.valueOf(0.0d));
        }
        int i2 = 1;
        while (i2 < size - 1) {
            int i3 = i2 + 1;
            double dDoubleValue = list.get(i3).get("x").doubleValue();
            int i4 = i2 - 1;
            double dDoubleValue2 = list.get(i4).get("x").doubleValue();
            double dDoubleValue3 = list.get(i3).get("y").doubleValue();
            double dDoubleValue4 = list.get(i4).get("y").doubleValue();
            double dDoubleValue5 = list.get(i2).get("x").doubleValue();
            double dDoubleValue6 = list.get(i2).get("y").doubleValue();
            list2.set(i2, Double.valueOf((dDoubleValue - dDoubleValue2) / 2.0d));
            list3.set(i2, Double.valueOf((dDoubleValue3 - dDoubleValue4) / 2.0d));
            list4.set(i2, Double.valueOf((dDoubleValue - (dDoubleValue5 * 2.0d)) + dDoubleValue2));
            list5.set(i2, Double.valueOf((dDoubleValue3 - (dDoubleValue6 * 2.0d)) + dDoubleValue4));
            i2 = i3;
        }
    }
}
