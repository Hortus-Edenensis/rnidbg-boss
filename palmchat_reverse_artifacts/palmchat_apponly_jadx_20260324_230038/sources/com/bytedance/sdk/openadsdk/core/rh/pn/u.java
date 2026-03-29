package com.bytedance.sdk.openadsdk.core.rh.pn;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.nr.fx;
import com.bytedance.sdk.openadsdk.ats.b;
import com.bytedance.sdk.openadsdk.core.rh.nr;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements nr {
    private static volatile u u;

    public static u u() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public String nr() {
        return "ugen_render";
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public String u(String str) {
        int i = b.u(nr()).get(str, 0);
        return (i == 0 && (str.equals("h5_render_success") || str.equals("h5_render_fail") || str.equals("native_render_success") || str.equals("native_render_fail"))) ? "0" : String.valueOf(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rh.nr
    public void u(String str, String str2) {
        fx fxVarU = b.u(nr());
        synchronized (fxVarU) {
            if (str.equals("h5_render_success") || str.equals("h5_render_fail")) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(fxVarU.get("key_h5_render_result_list", new HashSet()));
                if (linkedHashSet.size() >= 100) {
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        if (TextUtils.isEmpty(str3)) {
                            it.remove();
                        } else {
                            if ((System.currentTimeMillis() - Long.parseLong(str3.substring(0, str3.length() - 1))) / 3600000.0d <= 168.0d && linkedHashSet.size() < 100) {
                                break;
                            }
                            it.remove();
                            if (str3.endsWith("0")) {
                                fxVarU.put("h5_render_success", fxVarU.get("h5_render_success", 0) - 1);
                            } else if (str3.endsWith("1")) {
                                fxVarU.put("h5_render_fail", fxVarU.get("h5_render_fail", 0) - 1);
                            }
                        }
                    }
                }
                if (str.equals("h5_render_success")) {
                    fxVarU.put("h5_render_success", fxVarU.get("h5_render_success", 0) + 1);
                } else {
                    fxVarU.put("h5_render_fail", fxVarU.get("h5_render_fail", 0) + 1);
                }
                linkedHashSet.add(str2);
                fxVarU.put("key_h5_render_result_list", new HashSet(new ArrayList(linkedHashSet)));
            }
            if (str.equals("native_render_success") || str.equals("native_render_fail")) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(fxVarU.get("native_key_render_result_list", new HashSet()));
                if (linkedHashSet2.size() >= 100) {
                    Iterator it2 = linkedHashSet2.iterator();
                    while (it2.hasNext()) {
                        String str4 = (String) it2.next();
                        if (TextUtils.isEmpty(str4)) {
                            it2.remove();
                        } else {
                            if ((System.currentTimeMillis() - Long.parseLong(str4.substring(0, str4.length() - 1))) / 3600000.0d <= 168.0d && linkedHashSet2.size() < 100) {
                                break;
                            }
                            it2.remove();
                            if (str4.endsWith("0")) {
                                fxVarU.put("native_render_success", fxVarU.get("native_render_success", 0) - 1);
                            } else if (str4.endsWith("1")) {
                                fxVarU.put("native_render_fail", fxVarU.get("native_render_fail", 0) - 1);
                            }
                        }
                    }
                }
                if (str.equals("native_render_success")) {
                    fxVarU.put("native_render_success", fxVarU.get("native_render_success", 0) + 1);
                } else {
                    fxVarU.put("native_render_fail", fxVarU.get("native_render_fail", 0) + 1);
                }
                linkedHashSet2.add(str2);
                fxVarU.put("native_key_render_result_list", new HashSet(new ArrayList(linkedHashSet2)));
            }
        }
    }
}
