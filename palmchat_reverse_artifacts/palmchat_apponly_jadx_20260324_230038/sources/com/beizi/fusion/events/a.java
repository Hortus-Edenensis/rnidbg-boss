package com.beizi.fusion.events;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SparseArray<String> f4653a = new SparseArray<>();
    public static SparseArray<String> b = new SparseArray<>();
    public static SparseArray<String> c = new SparseArray<>();
    public static SparseArray<String> d = new SparseArray<>();
    public static SparseArray<String> e = new SparseArray<>();
    public static SparseArray<String> f = new SparseArray<>();
    public static SparseArray<String> g = new SparseArray<>();
    public static SparseArray<String> h = new SparseArray<>();
    public static SparseArray<String> i = new SparseArray<>();
    public static SparseArray<String> j = new SparseArray<>();
    public static SparseArray<String> k = new SparseArray<>();
    private HashMap<String, Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean>> l = new HashMap<>();
    private HashMap<String, EventBean> m = new HashMap<>();
    private EventBean n;

    /* JADX INFO: renamed from: com.beizi.fusion.events.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0139a extends l {
        public C0139a() {
            super();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends l {
        public b() {
            super();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends l {
        public c() {
            super();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends l {
        public d() {
            super();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends l {
        public e() {
            super();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends l {
        public f() {
            super();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends l {
        public g() {
            super();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends l {
        public h() {
            super();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends l {
        public i() {
            super();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends l {
        public j() {
            super();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends l {
        public k() {
            super();
        }
    }

    static {
        f4653a.put(1, "100.000");
        f4653a.put(2, "100.200");
        b.put(-1, "210.400");
        b.put(-2, "210.999");
        b.put(1, "200.001");
        b.put(2, "210.100");
        b.put(3, "210.200");
        b.put(4, "210.401");
        b.put(5, "210.402");
        b.put(6, "210.403");
        b.put(7, "210.404");
        c.put(-1, "220.400");
        c.put(-2, "220.999");
        c.put(1, "220.000");
        c.put(2, "200.000");
        c.put(3, "220.401");
        c.put(4, "220.402");
        c.put(5, "220.403");
        c.put(6, "220.404");
        d.put(-1, "230.400");
        d.put(-2, "230.999");
        d.put(1, "230.000");
        d.put(2, "230.200");
        d.put(3, "230.401");
        d.put(4, "230.402");
        e.put(-1, "245.400");
        e.put(-2, "245.999");
        e.put(1, "240.000");
        e.put(2, "245.000");
        e.put(3, "245.200");
        e.put(4, "245.401");
        e.put(5, "245.402");
        e.put(6, "245.403");
        e.put(7, "245.404");
        e.put(8, "245.300");
        e.put(9, "240.100");
        e.put(10, "245.405");
        f.put(-1, "249.400");
        f.put(-2, "249.999");
        f.put(1, "248.000");
        f.put(2, "249.000");
        f.put(3, "248.401");
        f.put(4, "248.402");
        f.put(5, "249.401");
        f.put(6, "249.402");
        g.put(-1, "280.600");
        g.put(1, "250.100");
        g.put(2, "250.200");
        g.put(16, "250.401");
        g.put(3, "255.200");
        g.put(4, "280.200");
        g.put(5, "280.280");
        g.put(6, "280.300");
        g.put(12, "280.350");
        g.put(7, "290.300");
        g.put(17, "290.301");
        g.put(8, "280.400");
        g.put(9, "280.450");
        g.put(11, "280.500");
        g.put(13, "280.301");
        g.put(14, "280.302");
        g.put(15, "280.303");
        g.put(18, "250.000");
        g.put(19, "250.400");
        g.put(20, "280.000");
        g.put(21, "250.500");
        g.put(22, "290.500");
        h.put(1, "280.210");
        h.put(-2, "280.249");
        h.put(2, "280.220");
        h.put(3, "280.250");
        h.put(4, "280.241");
        h.put(5, "280.240");
        h.put(6, "280.242");
        h.put(7, "280.243");
        h.put(8, "280.260");
        h.put(9, "280.270");
        i.put(1, "280.261");
        i.put(2, "280.262");
        i.put(3, "280.263");
        i.put(4, "280.264");
        k.put(1, "212.000");
        k.put(2, "212.400");
        k.put(3, "212.401");
        k.put(4, "212.999");
        k.put(5, "214.000");
        k.put(6, "214.200");
        k.put(7, "216.200");
        k.put(8, "216.401");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EventBean b(String str) {
        EventBean eventBean = this.n;
        if (eventBean == null || str == null) {
            return null;
        }
        try {
            EventBean eventBeanM43clone = eventBean.m43clone();
            eventBeanM43clone.setEventCode(str);
            eventBeanM43clone.setEventTime(String.valueOf(System.currentTimeMillis()));
            return eventBeanM43clone;
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean> c(String str) {
        if (this.l.containsKey(str)) {
            return this.l.get(str);
        }
        return null;
    }

    public static String a(l lVar) {
        if (lVar instanceof i) {
            return f4653a.get(lVar.a());
        }
        if (lVar instanceof h) {
            return b.get(lVar.a());
        }
        if (lVar instanceof k) {
            return c.get(lVar.a());
        }
        if (lVar instanceof g) {
            return d.get(lVar.a());
        }
        return lVar instanceof j ? j.get(lVar.a()) : "0";
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends Observable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4665a = 0;
        private Map<String, Integer> c = new HashMap();

        public l() {
        }

        public void a(int i) {
            if (this.f4665a != i) {
                this.f4665a = i;
                EventBean eventBeanB = a.this.b(a.a(this));
                setChanged();
                notifyObservers(eventBeanB);
            }
        }

        public int a() {
            return this.f4665a;
        }

        public void a(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Map<String, Integer> map = this.c;
            if (((map == null || !map.containsKey(str)) ? 0 : this.c.get(str).intValue()) != i || i == 17) {
                this.c.put(str, Integer.valueOf(i));
                String strA = a.a(str, this);
                aa.b("BeiZis", "changeStatus channel = " + str + ",eventCode = " + strA);
                EventBean eventBeanA = a.this.a(str, strA);
                if ("290.300".equalsIgnoreCase(strA)) {
                    aa.b("BeiZis", "eventBean = " + eventBeanA);
                }
                setChanged();
                notifyObservers(eventBeanA);
            }
        }

        public int a(String str) {
            Map<String, Integer> map;
            if (TextUtils.isEmpty(str) || (map = this.c) == null || !map.containsKey(str)) {
                return 0;
            }
            return this.c.get(str).intValue();
        }
    }

    public static String a(String str, l lVar) {
        if (lVar instanceof d) {
            return e.get(lVar.a(str));
        }
        if (lVar instanceof e) {
            return f.get(lVar.a(str));
        }
        if (lVar instanceof f) {
            return g.get(lVar.a(str));
        }
        if (lVar instanceof c) {
            return h.get(lVar.a(str));
        }
        if (lVar instanceof b) {
            return i.get(lVar.a(str));
        }
        return lVar instanceof C0139a ? k.get(lVar.a(str)) : "0";
    }

    public void a(EventBean eventBean) {
        this.n = eventBean;
    }

    public EventBean a(String str) {
        if (this.m.containsKey(str)) {
            try {
                EventBean eventBean = this.m.get(str);
                if (eventBean != null) {
                    EventBean eventBeanM43clone = eventBean.m43clone();
                    this.m.put(str, eventBeanM43clone);
                    return eventBeanM43clone;
                }
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
        } else {
            EventBean eventBean2 = this.n;
            if (eventBean2 != null) {
                try {
                    EventBean eventBeanM43clone2 = eventBean2.m43clone();
                    this.m.put(str, eventBeanM43clone2);
                    return eventBeanM43clone2;
                } catch (CloneNotSupportedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        EventBean eventBean3 = new EventBean(com.beizi.fusion.c.b.b, "", "", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "");
        this.m.put(str, eventBean3);
        return eventBean3;
    }

    public void a(String str, EventBean eventBean) {
        if (TextUtils.isEmpty(str) || eventBean == null) {
            return;
        }
        this.m.put(str, eventBean);
    }

    public void a(AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean) {
        Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean> pair = new Pair<>(buyerBean, forwardBean);
        if (buyerBean == null || TextUtils.isEmpty(buyerBean.getBuyerSpaceUuId())) {
            return;
        }
        this.l.put(buyerBean.getBuyerSpaceUuId(), pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EventBean a(String str, String str2) {
        Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean> pairC = c(str);
        StringBuilder sb = new StringBuilder();
        sb.append("getChannelEventBean eventCode = ");
        sb.append(str2);
        sb.append(",channelData == null ");
        sb.append(pairC == null);
        aa.b("BeiZis", sb.toString());
        if (pairC != null) {
            AdSpacesBean.BuyerBean buyerBean = (AdSpacesBean.BuyerBean) pairC.first;
            AdSpacesBean.ForwardBean forwardBean = (AdSpacesBean.ForwardBean) pairC.second;
            EventBean eventBeanA = a(str);
            if (eventBeanA == null || buyerBean == null || forwardBean == null) {
                return eventBeanA;
            }
            eventBeanA.setEventCode(str2);
            eventBeanA.setEventTime(String.valueOf(System.currentTimeMillis()));
            a(eventBeanA, str, buyerBean, forwardBean);
            this.m.put(str, eventBeanA);
            return eventBeanA;
        }
        aa.c("BeiZis", "getChannelEventBean eventCode = " + str2 + ",but channelData is null !!!");
        return null;
    }

    private static void a(EventBean eventBean, String str, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean) {
        if (eventBean == null) {
            return;
        }
        eventBean.setBuyerId(String.valueOf(com.beizi.fusion.e.b.a(buyerBean.getId())));
        eventBean.setBuyerAppId(buyerBean.getAppId());
        eventBean.setBuyerSpaceId(buyerBean.getSpaceId());
        eventBean.setChannelFilterSsid(buyerBean.getFilterSsid());
        eventBean.setRenderViewSsid(buyerBean.getRenderViewSsid());
        eventBean.setBeiZiPrice(String.valueOf(buyerBean.getAvgPrice()));
        eventBean.setBeiZiBaseId(com.beizi.fusion.e.b.b(forwardBean.getBaseId()));
        if (!"BPDI".equalsIgnoreCase(buyerBean.getBidType()) && !"C2S".equalsIgnoreCase(buyerBean.getBidType()) && !"S2S".equalsIgnoreCase(buyerBean.getBidType())) {
            eventBean.setBeiZiSrcType(0);
        } else {
            eventBean.setBeiZiSrcType(1);
            if (buyerBean.getBidPrice() > 0.0d) {
                eventBean.setBidPrice(String.valueOf(buyerBean.getBidPrice()));
            } else {
                eventBean.setBidPrice("0");
            }
        }
        if (forwardBean != null) {
            eventBean.setForwardId(forwardBean.getForwardId());
            eventBean.setParentId(forwardBean.getParentForwardId());
            eventBean.setLevel(forwardBean.getLevel());
            eventBean.setBuyerSpaceUuId(forwardBean.getBuyerSpaceUuId());
        }
    }
}
