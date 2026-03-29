package com.vivo.push.restructure.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qiniu.android.collect.ReportItem;
import com.qq.gdt.action.ActionUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.t;
import com.vivo.push.util.u;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f11268a;
    private com.vivo.push.restructure.request.a.a c;
    private InsideNotificationItem e;
    private UnvarnishedMessage f;
    private String b = "";
    private String d = "";

    public b(Intent intent) {
        this.f11268a = intent;
    }

    private boolean n() {
        return j() == 4;
    }

    private boolean o() {
        return j() == 3;
    }

    private InsideNotificationItem p() {
        Exception e;
        InsideNotificationItem insideNotificationItemA;
        String stringExtra;
        InsideNotificationItem insideNotificationItem = this.e;
        if (insideNotificationItem != null) {
            return insideNotificationItem;
        }
        Intent intent = this.f11268a;
        InsideNotificationItem insideNotificationItem2 = null;
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra("notification_v1");
            } catch (Exception e2) {
                e = e2;
                insideNotificationItemA = null;
            }
            if (stringExtra != null) {
                insideNotificationItemA = u.a(stringExtra);
                if (insideNotificationItemA != null) {
                    try {
                        insideNotificationItemA.setMsgId(Long.parseLong(a()));
                    } catch (Exception e3) {
                        e = e3;
                        t.a("ReceivedMessageImpl", "getNotificationMessage " + e.getMessage());
                    }
                }
                insideNotificationItem2 = insideNotificationItemA;
            }
        }
        this.e = insideNotificationItem2;
        return insideNotificationItem2;
    }

    private UnvarnishedMessage q() {
        UnvarnishedMessage unvarnishedMessage = this.f;
        if (unvarnishedMessage != null) {
            return unvarnishedMessage;
        }
        Intent intent = this.f11268a;
        UnvarnishedMessage unvarnishedMessage2 = null;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("msg_v1");
                if (!TextUtils.isEmpty(stringExtra)) {
                    UnvarnishedMessage unvarnishedMessage3 = new UnvarnishedMessage(stringExtra);
                    try {
                        unvarnishedMessage3.setMsgId(Long.parseLong(a()));
                        unvarnishedMessage2 = unvarnishedMessage3;
                    } catch (Exception e) {
                        e = e;
                        unvarnishedMessage2 = unvarnishedMessage3;
                        t.a("ReceivedMessageImpl", "getTransmissionMessage " + e.getMessage());
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        this.f = unvarnishedMessage2;
        return unvarnishedMessage2;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String a() {
        Bundle extras;
        Intent intent = this.f11268a;
        long j = (intent == null || (extras = intent.getExtras()) == null) ? 0L : extras.getLong("notify_id", 0L);
        return j != 0 ? String.valueOf(j) : "";
    }

    @Override // com.vivo.push.restructure.a.a
    public final Intent b() {
        return this.f11268a;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String c() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = this.f11268a.getStringExtra(ReportItem.RequestKeyRequestId);
        }
        return this.b;
    }

    @Override // com.vivo.push.restructure.a.a
    public final long d() {
        Intent intent = this.f11268a;
        if (intent != null) {
            return intent.getLongExtra("ipc_start_time", 0L);
        }
        return 0L;
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean e() {
        Intent intent = this.f11268a;
        if (intent != null) {
            return intent.getBooleanExtra("core_support_monitor", false);
        }
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean f() {
        Bundle extras;
        Intent intent = this.f11268a;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        return extras.getBoolean("client_collect_node", false);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean g() {
        com.vivo.push.restructure.request.a.a aVarH = h();
        return aVarH != null && aVarH.a() == 2018;
    }

    @Override // com.vivo.push.restructure.a.a
    public final com.vivo.push.restructure.request.a.a h() {
        String stringExtra;
        com.vivo.push.restructure.request.a.a.a aVar;
        if (this.c == null && (stringExtra = this.f11268a.getStringExtra("cf_content")) != null) {
            try {
                aVar = new com.vivo.push.restructure.request.a.a.a(stringExtra);
            } catch (JSONException unused) {
                aVar = null;
            }
            if (aVar != null) {
                this.c = com.vivo.push.restructure.request.a.a.f11274a.a(aVar);
            }
        }
        return this.c;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String i() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = this.f11268a.getStringExtra("content");
        }
        return this.d;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int j() {
        Intent intent = this.f11268a;
        if (intent == null) {
            return -1;
        }
        int intExtra = intent.getIntExtra(com.heytap.mcssdk.constant.b.y, -1);
        return intExtra < 0 ? this.f11268a.getIntExtra(ActionUtils.METHOD, -1) : intExtra;
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean k() {
        return j() == 5;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int l() {
        if (this.f11268a == null) {
            return 0;
        }
        if (n() && p() != null) {
            return p().getTargetType();
        }
        if (!o() || q() == null) {
            return 0;
        }
        return q().getTargetType();
    }

    @Override // com.vivo.push.restructure.a.a
    public final String m() {
        return this.f11268a == null ? "" : (!n() || p() == null) ? (!o() || q() == null) ? "" : q().getTragetContent() : p().getTargetContent();
    }
}
