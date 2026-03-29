package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.b;
import com.bytedance.adsdk.lottie.bq;
import com.bytedance.adsdk.lottie.dw;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.u;
import com.bytedance.sdk.openadsdk.core.ugeno.jk;
import com.cdo.oaps.ad.OapsKey;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends nr {
    private boolean gb;
    private View gl;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.u$5, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass5 implements b {
        public AnonymousClass5() {
        }

        @Override // com.bytedance.adsdk.lottie.b
        public Bitmap u(final a aVar) {
            final String strU;
            if (aVar == null) {
                return null;
            }
            String strS = aVar.s();
            String strMv = aVar.mv();
            String strB = aVar.b();
            if (!TextUtils.isEmpty(strB) && strB.startsWith("${") && "image:".equals(strS)) {
                strU = com.bytedance.adsdk.ugeno.b.nr.u(strB, ((fx) u.this).b);
            } else if (!TextUtils.isEmpty(strS) && TextUtils.isEmpty(strMv)) {
                strU = com.bytedance.adsdk.ugeno.b.nr.u(strS, ((fx) u.this).b);
            } else if (!TextUtils.isEmpty(strMv) && TextUtils.isEmpty(strS)) {
                strU = com.bytedance.adsdk.ugeno.b.nr.u(strMv, ((fx) u.this).b);
            } else if (TextUtils.isEmpty(strMv) || TextUtils.isEmpty(strS)) {
                strU = null;
            } else {
                strU = com.bytedance.adsdk.ugeno.b.nr.u(strS, ((fx) u.this).b) + com.bytedance.adsdk.ugeno.b.nr.u(strMv, ((fx) u.this).b);
            }
            if (TextUtils.isEmpty(strU)) {
                return null;
            }
            Bitmap bitmap = ((nr) u.this).ki.get(strU);
            if (bitmap != null) {
                return bitmap;
            }
            Integer num = ((nr) u.this).hs.get(strU);
            if (num == null || num.intValue() == 2) {
                ((nr) u.this).hs.put(strU, 1);
            } else if (num.intValue() == 1) {
                return null;
            }
            com.bytedance.adsdk.ugeno.b.u().nr().u(((fx) u.this).f5034a, strU, new u.InterfaceC0173u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.u.5.1
                @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
                public void u(Bitmap bitmap2) {
                    if (bitmap2 == null) {
                        ((nr) u.this).hs.put(strU, 2);
                        return;
                    }
                    final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, aVar.u(), aVar.nr(), false);
                    ((nr) u.this).ki.put(strU, bitmapCreateScaledBitmap);
                    ((nr) u.this).hs.remove(strU);
                    n.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.u.5.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((UgenLottieView) ((fx) u.this).pn).u(aVar.l(), bitmapCreateScaledBitmap);
                        }
                    });
                }
            });
            return ((nr) u.this).ki.get(strU);
        }
    }

    public u(Context context) {
        super(context);
        this.gb = false;
    }

    private void ay() {
        my myVar = new my();
        myVar.u(21);
        myVar.u(this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            jSONObject.put("uttieUrl", ((nr) this).u);
            myVar.u(jSONObject);
            this.i.u(myVar, this, this);
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.nr
    public void n() {
        T t = this.pn;
        if (t == 0 || ((UgenLottieView) t).getVisibility() != 0) {
            return;
        }
        ((UgenLottieView) this.pn).setImageAssetDelegate(new AnonymousClass5());
        ((UgenLottieView) this.pn).u();
        ay();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.nr, com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x */
    public UgenLottieView u() {
        UgenLottieView ugenLottieViewU = super.u();
        ugenLottieViewU.setTextDelegate(new bq(ugenLottieViewU) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.u.1
            @Override // com.bytedance.adsdk.lottie.bq
            public String u(String str) {
                return com.bytedance.adsdk.ugeno.b.nr.u(str, ((fx) u.this).b);
            }
        });
        ugenLottieViewU.setViewDelegate(new dw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.u.2
            @Override // com.bytedance.adsdk.lottie.dw
            public View u(String str, Map<String, Object> map) {
                if (!"view:".equals(str) || map == null || map.isEmpty()) {
                    return null;
                }
                if (!u.this.gb) {
                    u.this.gb = true;
                    u.this.u(map);
                }
                return u.this.gl;
            }
        });
        ugenLottieViewU.setLottieClicklistener(new LottieAnimationView.nr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.u.3
            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.nr
            public void u(String str, JSONArray jSONArray) {
                my myVar = new my();
                myVar.u(1);
                myVar.u(u.this);
                if (jSONArray != null && jSONArray.length() > 0) {
                    u.this.u(myVar, jSONArray);
                }
                if (((fx) u.this).i != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("lottieEvent", true);
                        jSONObject.put("uttieUrl", ((nr) u.this).u);
                        if (TextUtils.equals("CSJCLOSE", str)) {
                            jSONObject.put("type", "close");
                        } else if (TextUtils.equals("clickEvent", str)) {
                            jSONObject.put("type", "clickEvent");
                        }
                        myVar.u(jSONObject);
                        sx sxVar = ((fx) u.this).i;
                        u uVar = u.this;
                        sxVar.u(myVar, uVar, uVar);
                    } catch (JSONException unused) {
                    }
                }
            }
        });
        ugenLottieViewU.setLottieAnimListener(new LottieAnimationView.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.u.4
            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.u
            public void nr(Map<String, Object> map) {
                u.this.u(map, 20);
            }

            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.u
            public void u(Map<String, Object> map) {
                u.this.u(map, 19);
            }
        });
        return ugenLottieViewU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Map<String, Object> map, int i) {
        my myVar = new my();
        myVar.u(i);
        myVar.u(this);
        if (map != null) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                u(myVar, (JSONArray) obj);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            if (map != null) {
                Object obj2 = map.get("duration");
                if (obj2 instanceof Long) {
                    jSONObject.put("duration", obj2);
                    jSONObject.put("uttieUrl", ((nr) this).u);
                }
            }
            myVar.u(jSONObject);
            this.i.u(myVar, this, this);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(my myVar, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(OapsKey.KEY_VERID);
                    if (!TextUtils.isEmpty(strOptString)) {
                        int iOptInt = jSONObjectOptJSONObject.optInt(LiveConfigKey.HIGH, 0);
                        fx fxVarU = u(myVar.u(), strOptString);
                        if (fxVarU != null) {
                            fxVarU.nr(iOptInt == 0 ? 0 : 8);
                            View viewA = fxVarU.a();
                            if (viewA instanceof UgenLottieView) {
                                UgenLottieView ugenLottieView = (UgenLottieView) viewA;
                                if (iOptInt == 0) {
                                    ugenLottieView.u();
                                    ay();
                                } else {
                                    ugenLottieView.iz();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fx u(fx fxVar, String str) {
        if (fxVar == null) {
            return null;
        }
        while (fxVar.rh() != null) {
            fxVar = fxVar.rh();
        }
        return fxVar.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Map<String, Object> map) {
        Object obj = map.get("ugen_url");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("ugen_md5");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("ugen_v");
        final String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("ugen_w");
        final int iIntValue = obj4 instanceof Integer ? ((Integer) obj4).intValue() : 0;
        Object obj5 = map.get("ugen_h");
        final int iIntValue2 = obj5 instanceof Integer ? ((Integer) obj5).intValue() : 0;
        if (iIntValue <= 0 || iIntValue2 <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        jk.u(str, str2, new com.bytedance.sdk.openadsdk.core.ugeno.fx() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.u.6
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.fx
            public void u() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.fx
            public void u(String str4) {
                try {
                    u.this.u(new JSONObject(str4), iIntValue, iIntValue2, str3);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(JSONObject jSONObject, int i, int i2, String str) {
        fx<View> fxVarU;
        k kVar = new k(this.nr);
        if (str.startsWith("2")) {
            fxVarU = kVar.u(jSONObject);
            kVar.nr(this.b);
        } else {
            fxVarU = str.startsWith("3") ? kVar.u(jSONObject, this.b, (JSONObject) null) : null;
        }
        if (fxVarU != null) {
            this.gl = fxVarU.a();
        }
    }
}
