package com.vivo.push.sdk;

import android.content.Intent;
import android.os.Message;
import com.vivo.push.ab;
import com.vivo.push.util.g;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class a extends ab {
    private static a c;
    private String d = "";

    private a() {
    }

    public static synchronized a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public final String b() {
        return this.d;
    }

    @Override // com.vivo.push.ab
    public final void b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent != null && this.f11192a != null) {
            com.vivo.push.restructure.a.b bVar = new com.vivo.push.restructure.a.b(intent);
            try {
                t.d("CommandWorker", "received msg : ".concat(String.valueOf(bVar.a())));
                g.a().execute(new b(this, bVar));
                return;
            } catch (Exception e) {
                t.a("CommandWorker", "handle message err : " + e.getMessage());
                return;
            }
        }
        t.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f11192a);
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(Intent intent) {
        if (intent != null && this.f11192a != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            a(messageObtain);
        } else {
            t.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f11192a);
        }
    }
}
