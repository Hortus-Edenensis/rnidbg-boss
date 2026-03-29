package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.adsdk.ugeno.fx.c;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.z;
import com.bytedance.sdk.openadsdk.core.nativeexpress.bg;
import com.bytedance.sdk.openadsdk.core.ugeno.express.nr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iz f5379a;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.b b;
    private boolean iz;
    private final com.bytedance.sdk.openadsdk.core.z.u n;
    private View pn;
    private int x;

    public b(bc bcVar, boolean z, u uVar) {
        super(bcVar, uVar);
        this.iz = false;
        this.x = 2;
        this.f5379a = new iz() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.b.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void b() {
                if (z.u() && b.this.n != null) {
                    b.this.n.u(b.this.u);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void fx() {
                b.this.iz = false;
                if (b.this.pn != null) {
                    b.this.pn.setVisibility(8);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void nr() {
                b.this.iz = true;
                b.this.pn();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void pn() {
                b.this.iz();
                if (b.this.n != null) {
                    b.this.n.fx();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void u() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void u(boolean z2) {
            }
        };
        this.n = new com.bytedance.sdk.openadsdk.core.z.u(bcVar);
        this.fx = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.nr
    public int u() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz() {
        View view = this.pn;
        if (view != null) {
            view.setVisibility(4);
            this.pn.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.pn == null) {
                        return;
                    }
                    if (b.this.pn instanceof ViewGroup) {
                        ((ViewGroup) b.this.pn).removeAllViews();
                    }
                    ViewParent parent = b.this.pn.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(b.this.pn);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pn() {
        View view = this.pn;
        if (view == null || !this.iz) {
            return;
        }
        view.setVisibility(0);
    }

    public void b() {
        this.pn = null;
        com.bytedance.sdk.openadsdk.core.ugeno.express.b bVar = this.b;
        if (bVar != null) {
            bVar.u((iz) null);
            this.b.t();
        }
    }

    public boolean fx() {
        return z.u(this.u);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.nr
    public iz nr() {
        return this.f5379a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.nr
    public boolean u(int i, int i2) {
        return z.iz(this.u).u(i, i2);
    }

    public void u(final ViewGroup viewGroup, final View view, final boolean z) {
        String strB = z.iz(this.u).b();
        String strPn = z.iz(this.u).pn();
        this.x = z.iz(this.u).u();
        com.bytedance.sdk.openadsdk.core.ugeno.jk.u(strPn, strB, new com.bytedance.sdk.openadsdk.core.ugeno.fx() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.b.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.fx
            public void u(String str) {
                try {
                    b bVar = b.this;
                    a.u(bVar.u, true, bVar.u(), 0);
                    b.this.u(new JSONObject(str), viewGroup, view, z);
                } catch (JSONException unused) {
                    b bVar2 = b.this;
                    a.u(bVar2.u, false, bVar2.u(), 3);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.fx
            public void u() {
                b bVar = b.this;
                a.u(bVar.u, false, bVar.u(), 4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final JSONObject jSONObject, final ViewGroup viewGroup, final View view, final boolean z) {
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.b.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectU;
                b bVar = b.this;
                if (bVar.u == null) {
                    return;
                }
                if (bVar.x == 3) {
                    JSONObject jSONObjectU2 = com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(view);
                    b bVar2 = b.this;
                    jSONObjectU = com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(bVar2.u, jSONObjectU2, jSONObject, bVar2.fx, null);
                } else {
                    jSONObjectU = jSONObject;
                }
                nr.u uVar = new nr.u();
                b bVar3 = b.this;
                uVar.pn(com.bytedance.sdk.openadsdk.core.ugeno.jk.u(bVar3.u, viewGroup, bVar3.fx));
                uVar.u(jSONObjectU);
                uVar.u((c) new bg());
                int height = viewGroup.getHeight();
                int width = viewGroup.getWidth();
                uVar.nr(height);
                uVar.u(width);
                uVar.u(com.bytedance.sdk.openadsdk.core.n.o().pn());
                uVar.jk(b.this.u.n());
                uVar.b(dw.nr().jk());
                com.bytedance.sdk.openadsdk.core.ugeno.express.nr nrVarU = uVar.u();
                if (b.this.x == 3) {
                    b.this.b = new com.bytedance.sdk.openadsdk.core.ugeno.express.iz(dw.getContext(), b.this.u, nrVarU, viewGroup);
                } else {
                    b.this.b = new com.bytedance.sdk.openadsdk.core.ugeno.express.b(dw.getContext(), b.this.u, nrVarU, viewGroup);
                }
                b.this.b.u(b.this.f5379a);
                b.this.b.u(new com.bytedance.sdk.component.adexpress.nr.n() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.b.3.1
                    @Override // com.bytedance.sdk.component.adexpress.nr.n
                    public void u(View view2, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
                        b.this.nr.u(view2, i, fxVar);
                    }

                    @Override // com.bytedance.sdk.component.adexpress.nr.n
                    public void u(View view2, int i, com.bytedance.sdk.component.adexpress.fx fxVar, int i2) {
                        b.this.nr.u(view2, i, fxVar);
                    }
                });
                b.this.b.u(new x() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.b.3.2
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.x
                    public void u() {
                        if (b.this.pn != null) {
                            b.this.pn.setVisibility(8);
                            try {
                                if (b.this.pn.getParent() != null) {
                                    ((ViewGroup) b.this.pn.getParent()).removeView(b.this.pn);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        if (b.this.n != null) {
                            b.this.n.fx();
                        }
                    }
                });
                b bVar4 = b.this;
                a.nr(bVar4.u, bVar4.u());
                b.this.b.u(new com.bytedance.sdk.component.adexpress.nr.x() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.b.3.3
                    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
                    @Override // com.bytedance.sdk.component.adexpress.nr.x
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void u(View view2, s sVar) {
                        View childAt;
                        b bVar5 = b.this;
                        a.u(bVar5.u, true, bVar5.u(), (Map<String, Object>) null);
                        boolean z2 = false;
                        if (view2 == null) {
                            b bVar6 = b.this;
                            a.u(bVar6.u, false, bVar6.u(), 200, (Map<String, Object>) null);
                            return;
                        }
                        b.this.pn = view2;
                        b.this.pn.setVisibility(8);
                        if ((b.this.pn instanceof ViewGroup) && ((ViewGroup) b.this.pn).getChildCount() > 0) {
                            View childAt2 = ((ViewGroup) b.this.pn).getChildAt(0);
                            if ((b.this.b instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.iz) && childAt2 != null) {
                                ViewGroup viewGroup2 = (ViewGroup) childAt2;
                                if (viewGroup2.getChildCount() > 0 && (childAt = viewGroup2.getChildAt(0)) != null && childAt.getVisibility() == 8) {
                                }
                            } else if (childAt2 != null && childAt2.getVisibility() == 8) {
                                z2 = true;
                            }
                        }
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        b bVar7 = b.this;
                        ViewGroup viewGroup3 = viewGroup;
                        View view3 = view;
                        View view4 = bVar7.pn;
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        bVar7.u(viewGroup3, view3, view4, z, !z2, b.this.b.b(), b.this.n);
                        b.this.pn();
                    }

                    @Override // com.bytedance.sdk.component.adexpress.nr.x
                    public void u(int i, String str) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        b.this.nr.u(viewGroup);
                        HashMap map = new HashMap();
                        map.put("ugen_error_code", Integer.valueOf(i));
                        b bVar5 = b.this;
                        a.u(bVar5.u, false, bVar5.u(), (Map<String, Object>) map);
                    }
                });
            }
        });
    }

    public void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar) {
        this.n.u(nrVar);
    }
}
