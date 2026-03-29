package com.beizi.ad.internal.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.beizi.ad.internal.c;
import com.beizi.ad.internal.e.h;
import com.beizi.ad.internal.e.l;
import com.beizi.ad.internal.e.n;
import com.beizi.ad.internal.e.s;
import com.beizi.ad.internal.f;
import com.beizi.ad.model.f;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f4349a;
    private static Map<String, LinkedList<b>> c = new HashMap();
    private static Context d;
    private String b = "KEY_AD_CACHE_CONTENT_";

    /* JADX INFO: renamed from: com.beizi.ad.internal.a.a$6, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4356a;

        static {
            int[] iArr = new int[f.values().length];
            f4356a = iArr;
            try {
                iArr[f.NEW_SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4356a[f.NATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4356a[f.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4356a[f.REWARDEDVIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h.a((Context) null).a(str, false, new h.a() { // from class: com.beizi.ad.internal.a.a.4
            @Override // com.beizi.ad.internal.e.h.a
            public void a() {
            }

            @Override // com.beizi.ad.internal.e.h.a
            public void a(Bitmap bitmap) {
            }
        });
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        s.a().a(d, str, false, new s.a() { // from class: com.beizi.ad.internal.a.a.5
            @Override // com.beizi.ad.internal.e.s.a
            public void a() {
            }

            @Override // com.beizi.ad.internal.e.s.a
            public void a(String str2) {
            }
        });
    }

    public void b() {
        com.beizi.ad.lance.a.h.g(d);
    }

    public static synchronized a a() {
        if (f4349a == null) {
            synchronized (a.class) {
                d = c.a().c();
                f4349a = new a();
            }
        }
        return f4349a;
    }

    public b b(String str) {
        b bVarPollLast;
        try {
            LinkedList<b> linkedList = c.containsKey(str) ? c.get(str) : null;
            if (linkedList == null || linkedList.isEmpty()) {
                List<b> listA = a(str);
                if (listA != null && !listA.isEmpty()) {
                    LinkedList<b> linkedList2 = new LinkedList<>(listA);
                    c.put(str, linkedList2);
                    linkedList = linkedList2;
                }
                return null;
            }
            if (linkedList.isEmpty() || (bVarPollLast = linkedList.pollLast()) == null) {
                return null;
            }
            if (bVarPollLast.c() < System.currentTimeMillis()) {
                return null;
            }
            return bVarPollLast;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<b> a(String str) {
        try {
            String strA = l.a(d, this.b + str);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            String strB = com.beizi.ad.lance.a.b.b(strA);
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(strB);
            if (jSONArray.length() < 1) {
                return null;
            }
            ArrayList arrayList = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    long jOptLong = jSONObjectOptJSONObject.has("expireTime") ? jSONObjectOptJSONObject.optLong("expireTime") : 0L;
                    if (jOptLong >= System.currentTimeMillis()) {
                        b bVar = new b();
                        bVar.b(jOptLong);
                        if (jSONObjectOptJSONObject.has("spaceId")) {
                            bVar.a(jSONObjectOptJSONObject.optString("spaceId"));
                        }
                        if (jSONObjectOptJSONObject.has("cacheTime")) {
                            bVar.a(jSONObjectOptJSONObject.optLong("cacheTime"));
                        }
                        if (jSONObjectOptJSONObject.has("requestId")) {
                            bVar.b(jSONObjectOptJSONObject.optString("requestId"));
                        }
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(bVar);
                    }
                }
            }
            Collections.sort(arrayList, new Comparator<b>() { // from class: com.beizi.ad.internal.a.a.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(b bVar2, b bVar3) {
                    return bVar2.b() > bVar3.b() ? 1 : -1;
                }
            });
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized void b(final EventBean eventBean, final int i, final com.beizi.ad.model.b bVar, final f fVar) {
        if (i < 1) {
            return;
        }
        com.beizi.ad.lance.a.c.b().d().execute(new Runnable() { // from class: com.beizi.ad.internal.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                final String strA;
                for (int i2 = 0; i2 < i; i2++) {
                    try {
                        String strA2 = n.a();
                        EventBean eventBean2 = eventBean;
                        if (eventBean2 != null) {
                            eventBean2.setReqId(strA2);
                            eventBean.setEventCode("255.300");
                            a.this.a(eventBean);
                        }
                        final String strA3 = n.a();
                        com.beizi.ad.model.b bVar2 = new com.beizi.ad.model.b();
                        bVar2.b(strA3);
                        bVar2.a(true);
                        com.beizi.ad.model.b bVar3 = bVar;
                        if (bVar3 != null) {
                            strA = bVar3.a();
                            bVar2.a(strA);
                            bVar2.a(bVar.d());
                        } else {
                            strA = null;
                        }
                        new com.beizi.ad.v2.e.b().a(bVar2, new com.beizi.ad.v2.e.a() { // from class: com.beizi.ad.internal.a.a.3.1
                            @Override // com.beizi.ad.v2.e.a
                            public void a(int i3) {
                            }

                            @Override // com.beizi.ad.v2.e.a
                            public void a(String str) {
                                try {
                                    com.beizi.ad.internal.d.a aVar = new com.beizi.ad.internal.d.a(str, null, fVar);
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    a.this.a(aVar, str, strA3, strA, fVar);
                                    if (eventBean != null) {
                                        if (aVar.d()) {
                                            EventBean eventBeanM43clone = eventBean.m43clone();
                                            eventBeanM43clone.setEventCode("255.400");
                                            a.this.a(eventBeanM43clone);
                                        } else {
                                            EventBean eventBeanM43clone2 = eventBean.m43clone();
                                            eventBeanM43clone2.setEventCode("255.500");
                                            eventBeanM43clone2.setErrorCode("3");
                                            a.this.a(eventBeanM43clone2);
                                        }
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public synchronized void a(EventBean eventBean, int i, com.beizi.ad.model.b bVar, f fVar) {
        List<b> listA;
        int size;
        if (i >= 1) {
            if (bVar != null) {
                try {
                    String strA = bVar.a();
                    LinkedList<b> linkedList = c.containsKey(strA) ? c.get(strA) : null;
                    if ((linkedList == null || linkedList.isEmpty()) && (listA = a(strA)) != null && listA.size() > 0) {
                        linkedList = new LinkedList<>(listA);
                        c.put(strA, linkedList);
                    }
                    size = (linkedList == null || linkedList.size() <= 0) ? 0 : linkedList.size();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i >= 1 && size < i) {
                    b(eventBean, i - size, bVar, fVar);
                }
            }
        }
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            System.currentTimeMillis();
            com.beizi.ad.lance.a.h.b(d, bVar.a(), bVar.d());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(b bVar, int i, int i2) {
        if (bVar == null) {
            return;
        }
        try {
            if (bVar.c() >= System.currentTimeMillis() && i == 1) {
                String strA = bVar.a();
                LinkedList<b> linkedList = c.containsKey(strA) ? c.get(strA) : null;
                if (linkedList == null || linkedList.isEmpty()) {
                    linkedList = new LinkedList<>();
                }
                linkedList.add(bVar);
                Collections.sort(linkedList, new Comparator<b>() { // from class: com.beizi.ad.internal.a.a.2
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(b bVar2, b bVar3) {
                        return bVar2.b() > bVar3.b() ? 1 : -1;
                    }
                });
                if (linkedList.size() > i2) {
                    linkedList.removeFirst();
                }
                if (a(linkedList, strA)) {
                    c.put(strA, linkedList);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public com.beizi.ad.internal.d.a a(b bVar, f fVar) {
        if (bVar == null) {
            return null;
        }
        try {
            String strA = bVar.a();
            String strA2 = com.beizi.ad.lance.a.h.a(d, strA, bVar.d());
            if (TextUtils.isEmpty(strA2)) {
                return null;
            }
            com.beizi.ad.internal.d.a aVar = new com.beizi.ad.internal.d.a(strA2, null, fVar);
            if (!aVar.d()) {
                return null;
            }
            LinkedList<b> linkedList = c.containsKey(strA) ? c.get(strA) : null;
            if (linkedList != null && !linkedList.isEmpty()) {
                a(linkedList, strA);
            } else {
                l.c(d, this.b + strA);
            }
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(com.beizi.ad.internal.d.a aVar, String str, String str2, String str3, f fVar) {
        int iG;
        try {
            if (aVar.d() && (iG = aVar.G()) > 0 && com.beizi.ad.lance.a.h.a(d, str3, str2, str)) {
                b bVar = new b();
                long jCurrentTimeMillis = System.currentTimeMillis();
                bVar.a(jCurrentTimeMillis);
                bVar.b(jCurrentTimeMillis + ((long) (iG * 1000)));
                bVar.b(str2);
                bVar.a(str3);
                LinkedList<b> linkedList = c.containsKey(str3) ? c.get(str3) : null;
                if (linkedList == null || linkedList.isEmpty()) {
                    linkedList = new LinkedList<>();
                }
                linkedList.add(bVar);
                a(linkedList, str3);
                c.put(str3, linkedList);
                int i = AnonymousClass6.f4356a[fVar.ordinal()];
                if (i == 1) {
                    String strD = aVar.D();
                    if (aVar.E() == f.EnumC0131f.RENDER_PIC) {
                        c(strD);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    c(((com.beizi.ad.internal.c.a) aVar.a()).b());
                    return;
                }
                if (i != 3) {
                    if (i == 4 && aVar.y()) {
                        String strX = aVar.x();
                        String strI = aVar.I();
                        if (!TextUtils.isEmpty(strX)) {
                            d(strX);
                        }
                        if (TextUtils.isEmpty(strI)) {
                            return;
                        }
                        c(strI);
                        return;
                    }
                    return;
                }
                boolean zY = aVar.y();
                String strW = aVar.w();
                String strX2 = aVar.x();
                if (zY) {
                    d(strX2);
                } else {
                    c(strW);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(LinkedList<b> linkedList, String str) {
        if (linkedList != null) {
            try {
                if (!linkedList.isEmpty()) {
                    String strA = com.beizi.ad.lance.a.b.a(linkedList.toString());
                    if (TextUtils.isEmpty(strA)) {
                        return false;
                    }
                    l.a(d, this.b + str, strA);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(EventBean eventBean) {
        EventCar.getInstance(d).goRoad(eventBean);
    }
}
