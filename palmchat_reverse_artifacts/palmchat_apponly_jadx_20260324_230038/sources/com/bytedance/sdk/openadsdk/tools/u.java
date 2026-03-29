package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.openadsdk.core.bc.u.u;
import com.bytedance.sdk.openadsdk.gi.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements u.InterfaceC0238u {
    private nr nr = new nr();
    private final u.InterfaceC0238u u;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.tools.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0316u {
        void u(String str, String str2);
    }

    public u(u.InterfaceC0238u interfaceC0238u) {
        this.u = interfaceC0238u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
    public void b(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.u.b(str, str2);
        } else {
            u(str, str2, new InterfaceC0316u() { // from class: com.bytedance.sdk.openadsdk.tools.u.4
                @Override // com.bytedance.sdk.openadsdk.tools.u.InterfaceC0316u
                public void u(String str3, String str4) {
                    u.this.u.b(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
    public void fx(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.u.fx(str, str2);
        } else {
            u(str, str2, new InterfaceC0316u() { // from class: com.bytedance.sdk.openadsdk.tools.u.3
                @Override // com.bytedance.sdk.openadsdk.tools.u.InterfaceC0316u
                public void u(String str3, String str4) {
                    u.this.u.fx(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
    public void nr(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.u.nr(str, str2);
        } else {
            u(str, str2, new InterfaceC0316u() { // from class: com.bytedance.sdk.openadsdk.tools.u.2
                @Override // com.bytedance.sdk.openadsdk.tools.u.InterfaceC0316u
                public void u(String str3, String str4) {
                    u.this.u.nr(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
    public void u(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.u.u(str, str2);
        } else {
            u(str, str2, new InterfaceC0316u() { // from class: com.bytedance.sdk.openadsdk.tools.u.1
                @Override // com.bytedance.sdk.openadsdk.tools.u.InterfaceC0316u
                public void u(String str3, String str4) {
                    u.this.u.u(str3, str4);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class nr {
        private nr() {
        }

        public void u(String str, String str2, InterfaceC0316u interfaceC0316u) {
            String hexString = Integer.toHexString(str2.hashCode());
            int i = 0;
            while (i < str2.length()) {
                int iMin = Math.min(i + 4096, str2.length());
                interfaceC0316u.u(u(str, hexString, i, iMin), str2.substring(i, iMin));
                i = iMin;
            }
        }

        private String u(String str, String str2, int i, int i2) {
            return str + "_" + i + "_" + i2 + "_" + str2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
    public void u(String str, String str2, Throwable th) {
        this.u.u(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
    public void u(String str, Throwable th) {
        this.u.u(str, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bc.u.u.InterfaceC0238u
    public void u() {
        this.u.u();
    }

    private void u(final String str, final String str2, final InterfaceC0316u interfaceC0316u) {
        try {
            if (x.u()) {
                x.nr(new a("log-big-str") { // from class: com.bytedance.sdk.openadsdk.tools.u.5
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.nr.u(str, str2, interfaceC0316u);
                    }
                });
            } else {
                this.nr.u(str, str2, interfaceC0316u);
            }
        } catch (Throwable unused) {
        }
    }
}
