package com.bytedance.sdk.openadsdk.upie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.sdk.component.b.nr.fx;
import com.bytedance.sdk.component.iz.c;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.x.b;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static volatile nr b;
    private static final String nr;
    private static final String u;
    private final fx fx = new b.u().u("lottie_tpl_info").u(com.bytedance.sdk.component.adexpress.u.u.u.u().fx().getContext()).u(1).u(com.bytedance.sdk.component.adexpress.u.u.u.u().fx().l()).u();

    /* JADX INFO: compiled from: SearchBox */
    public interface u<T> {
        void u(int i, String str);

        void u(T t);
    }

    static {
        StringBuilder sb = new StringBuilder("tt_derive");
        String str = File.separator;
        sb.append(str);
        sb.append("lottie");
        sb.append(str);
        sb.append("audio");
        u = sb.toString();
        nr = "tt_derive" + str + "lottie" + str + "anim_img";
    }

    private nr() {
    }

    public void nr(String str, final u<Bitmap> uVar) {
        c cVarPn = com.bytedance.sdk.component.adexpress.u.u.u.u().pn();
        if (cVarPn != null) {
            cVarPn.from(str).config(Bitmap.Config.ARGB_4444).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.nr.3
                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str2, Throwable th) {
                    u uVar2 = uVar;
                    if (uVar2 != null) {
                        uVar2.u(i, "load ad pic fail: ".concat(String.valueOf(str2)));
                    }
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my<Bitmap> myVar) {
                    u uVar2;
                    try {
                        Bitmap result = myVar.getResult();
                        if (result == null || (uVar2 = uVar) == null) {
                            return;
                        }
                        uVar2.u(result);
                    } catch (Throwable unused) {
                    }
                }
            }, 4);
        } else if (uVar != null) {
            uVar.u(-1, "imageCenter is null");
        }
    }

    public static nr u() {
        if (b == null) {
            synchronized (nr.class) {
                if (b == null) {
                    b = new nr();
                }
            }
        }
        return b;
    }

    public void u(Context context, com.bytedance.sdk.openadsdk.upie.u uVar) {
        if (uVar != null) {
            String strFx = uVar.fx();
            if (!TextUtils.isEmpty(strFx)) {
                nr(strFx, null);
            }
            String strU = uVar.u();
            if (TextUtils.isEmpty(strU) || !TextUtils.isEmpty(u(strU))) {
                return;
            }
            u(strU, (u<String>) null);
        }
    }

    public void u(final String str, final u<String> uVar) {
        com.bytedance.sdk.component.a.nr.fx fxVarPn = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().pn();
        if (fxVarPn == null) {
            return;
        }
        fxVarPn.u(str);
        fxVarPn.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.sdk.openadsdk.upie.nr.1
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                String strPn;
                boolean z = false;
                if (nrVar != null) {
                    try {
                        if (nrVar.a() && (strPn = nrVar.pn()) != null) {
                            try {
                                new JSONObject(strPn).optString("v");
                                nr.this.u(str, strPn);
                                u uVar2 = uVar;
                                if (uVar2 != null) {
                                    uVar2.u(strPn);
                                    return;
                                }
                                return;
                            } catch (JSONException e) {
                                if (uVar != null) {
                                    String message = e.getMessage();
                                    if (message != null && message.length() > 100) {
                                        message = message.substring(0, 100);
                                    }
                                    uVar.u(10006, "lottieJsonUrl加载失败0, " + message);
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        u uVar3 = uVar;
                        if (uVar3 != null) {
                            uVar3.u(10001, "lottieJsonUrl加载失败2, " + th.getMessage());
                            return;
                        }
                        return;
                    }
                }
                u uVar4 = uVar;
                if (uVar4 != null) {
                    StringBuilder sb = new StringBuilder("lottieJsonUrl加载失败1, response is not null:");
                    sb.append(nrVar != null);
                    sb.append(", isSuccess:");
                    if (nrVar != null && nrVar.a()) {
                        z = true;
                    }
                    sb.append(z);
                    uVar4.u(10001, sb.toString());
                }
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                u uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.u(10001, "lottieJsonUrl加载失败3, " + iOException.getMessage());
                }
            }
        });
    }

    public void u(Context context, String str, final u<Bitmap> uVar) {
        c cVarPn = com.bytedance.sdk.component.adexpress.u.u.u.u().pn();
        if (cVarPn != null) {
            cVarPn.from(str).cacheDir(u(context)).config(Bitmap.Config.ARGB_4444).type(2).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.nr.2
                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str2, Throwable th) {
                    u uVar2 = uVar;
                    if (uVar2 != null) {
                        uVar2.u(i, "load lottie pic fail: ".concat(String.valueOf(str2)));
                    }
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my<Bitmap> myVar) {
                    u uVar2;
                    try {
                        Bitmap result = myVar.getResult();
                        if (result == null || (uVar2 = uVar) == null) {
                            return;
                        }
                        uVar2.u(result);
                    } catch (Throwable unused) {
                    }
                }
            }, 4);
        } else if (uVar != null) {
            uVar.u(-1, "imageCenter is null");
        }
    }

    public String u(String str) {
        String strNr = x.nr(str);
        if (TextUtils.isEmpty(strNr)) {
            return null;
        }
        return this.fx.get(strNr, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, String str2) {
        String strNr = x.nr(str);
        if (TextUtils.isEmpty(strNr)) {
            return;
        }
        this.fx.put(strNr, str2);
    }

    public String u(Context context) {
        return n.u(context, com.bytedance.sdk.component.adexpress.u.u.u.u().fx().l(), nr).getAbsolutePath();
    }
}
