package com.bytedance.sdk.openadsdk.core.y;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class pb {
    public static final int u = com.bytedance.sdk.component.utils.q.iz(com.bytedance.sdk.openadsdk.core.dw.getContext(), "tt_shake_tag_key");
    private static final ConcurrentHashMap<ViewGroup, Object> nr = new ConcurrentHashMap<>();
    private static final Object fx = new Object();
    private static volatile boolean b = false;

    private pb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b() {
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap = nr;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        int iPn = y.pn(com.bytedance.sdk.openadsdk.core.dw.getContext());
        Iterator<ViewGroup> it = concurrentHashMap.keySet().iterator();
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = null;
        int i = Integer.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ViewGroup next = it.next();
            if (next != null) {
                Rect rect = new Rect();
                if (!next.getGlobalVisibleRect(rect)) {
                    nr.remove(next);
                } else if (com.bytedance.sdk.openadsdk.core.wq.u(next)) {
                    int i2 = iPn / 2;
                    int i3 = rect.bottom;
                    int i4 = i3 <= i2 ? i2 - i3 : Integer.MAX_VALUE;
                    int i5 = rect.top;
                    int i6 = i5 >= i2 ? i5 - i2 : Integer.MAX_VALUE;
                    if (i3 > i2 && i5 < i2) {
                        viewGroup = next;
                        break;
                    }
                    int iMin = Math.min(i6, i4);
                    if (iMin < i) {
                        viewGroup = next;
                        i = iMin;
                    } else if (iMin == i) {
                        viewGroup2 = next;
                    }
                } else {
                    nr.remove(next);
                }
            }
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup2 != null) {
            Rect rect2 = new Rect();
            viewGroup.getGlobalVisibleRect(rect2);
            Rect rect3 = new Rect();
            viewGroup2.getGlobalVisibleRect(rect3);
            if (rect2.top >= rect3.top) {
                viewGroup2 = viewGroup;
            }
        }
        int i7 = 0;
        while (true) {
            if (i7 >= viewGroup2.getChildCount()) {
                break;
            }
            Object tag = viewGroup2.getChildAt(i7).getTag(u);
            if (tag instanceof Map) {
                Object obj = ((Map) tag).get("click_listener");
                com.bytedance.sdk.openadsdk.core.nr.u uVar = obj instanceof com.bytedance.sdk.openadsdk.core.nr.u ? (com.bytedance.sdk.openadsdk.core.nr.u) obj : null;
                if (uVar != null) {
                    HashMap map = new HashMap();
                    map.put("click_type", 2);
                    com.bytedance.sdk.openadsdk.core.nr.u.fx.u uVar2 = (com.bytedance.sdk.openadsdk.core.nr.u.fx.u) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class);
                    uVar2.u(map);
                    uVar2.u();
                    uVar.onClick(viewGroup2);
                    break;
                }
                i7++;
            }
        }
        nr.clear();
        b = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void fx() {
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap = nr;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        int iPn = y.pn(com.bytedance.sdk.openadsdk.core.dw.getContext());
        Iterator<ViewGroup> it = concurrentHashMap.keySet().iterator();
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = null;
        int i = Integer.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ViewGroup next = it.next();
            if (next != null) {
                Rect rect = new Rect();
                if (!next.getGlobalVisibleRect(rect)) {
                    nr.remove(next);
                } else if (com.bytedance.sdk.openadsdk.core.wq.u(next)) {
                    int i2 = iPn / 2;
                    int i3 = rect.bottom;
                    int i4 = i3 <= i2 ? i2 - i3 : Integer.MAX_VALUE;
                    int i5 = rect.top;
                    int i6 = i5 >= i2 ? i5 - i2 : Integer.MAX_VALUE;
                    if (i3 > i2 && i5 < i2) {
                        viewGroup = next;
                        break;
                    }
                    int iMin = Math.min(i6, i4);
                    if (iMin < i) {
                        viewGroup = next;
                        i = iMin;
                    } else if (iMin == i) {
                        viewGroup2 = next;
                    }
                } else {
                    nr.remove(next);
                }
            }
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup2 != null) {
            Rect rect2 = new Rect();
            viewGroup.getGlobalVisibleRect(rect2);
            Rect rect3 = new Rect();
            viewGroup2.getGlobalVisibleRect(rect3);
            if (rect2.top >= rect3.top) {
                viewGroup2 = viewGroup;
            }
        }
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap2 = nr;
        com.bytedance.sdk.openadsdk.core.nr.fx fxVar = concurrentHashMap2.get(viewGroup2) instanceof com.bytedance.sdk.openadsdk.core.nr.fx ? (com.bytedance.sdk.openadsdk.core.nr.fx) concurrentHashMap2.get(viewGroup2) : null;
        u(viewGroup2, true);
        concurrentHashMap2.clear();
        b = false;
        if (fxVar != null) {
            fxVar.u();
        }
    }

    public static void u(WeakReference<ViewGroup> weakReference, com.bytedance.sdk.openadsdk.core.nr.fx fxVar) {
        if (weakReference == null || fxVar == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (!com.bytedance.sdk.openadsdk.core.wq.u(viewGroup)) {
            u(viewGroup, false);
            return;
        }
        nr.put(viewGroup, fxVar);
        if (b) {
            u(viewGroup, false);
            return;
        }
        synchronized (pb.class) {
            if (b) {
                u(viewGroup, false);
            } else {
                b = true;
                com.bytedance.sdk.openadsdk.core.bg.iz().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.pb.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pb.fx();
                    }
                }, 50L);
            }
        }
    }

    public static boolean u(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(u);
        if (tag instanceof Map) {
            Object obj = ((Map) tag).get("is_shake_efficient");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    private static void u(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_shake_efficient", Boolean.valueOf(z));
        int i = u;
        Object tag = viewGroup.getTag(i);
        if (tag != null) {
            try {
                if (!(tag instanceof HashMap)) {
                    return;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.nr("TTShakeChecker", th.getMessage());
                u(u, th.getMessage());
                return;
            }
        }
        viewGroup.setTag(i, map);
    }

    public static void u(final int i, final String str) {
        com.bytedance.sdk.openadsdk.core.qq.nr.fx().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.y.pb.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("shake_tag", i);
                    jSONObject.put("error_msg", str);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("stats_shake_tag_key").nr(jSONObject.toString());
            }
        }, "stats_shake_tag_key", false);
    }

    public static void u(WeakReference<ViewGroup> weakReference, float f, float f2, long j) {
        if (weakReference == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (com.bytedance.sdk.openadsdk.core.wq.u(viewGroup) && u(f, f2, j)) {
            nr.put(viewGroup, fx);
            if (b) {
                return;
            }
            synchronized (pb.class) {
                if (b) {
                    return;
                }
                b = true;
                com.bytedance.sdk.openadsdk.core.bg.iz().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.pb.3
                    @Override // java.lang.Runnable
                    public void run() {
                        pb.b();
                    }
                }, 50L);
            }
        }
    }

    private static boolean u(float f, float f2, long j) {
        if (f == -1.0f) {
            return true;
        }
        if (f < 0.0f) {
            return false;
        }
        if (f == 0.0f && f2 == 2.1474836E9f) {
            return true;
        }
        if (f2 <= f) {
            return false;
        }
        float fCurrentTimeMillis = (System.currentTimeMillis() - j) / 1000.0f;
        return fCurrentTimeMillis >= f && fCurrentTimeMillis <= f2;
    }
}
