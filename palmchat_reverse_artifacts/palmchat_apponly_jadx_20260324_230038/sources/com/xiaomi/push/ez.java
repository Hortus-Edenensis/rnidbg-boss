package com.xiaomi.push;

import com.xiaomi.push.dp;
import com.xiaomi.push.fa;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ez implements fj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11560a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fa f426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SimpleDateFormat f429a = new SimpleDateFormat("hh:mm:ss aaa");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f425a = null;
    private a b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fd f427a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String f428a = "[Slim] ";

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ff, fk {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f430a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f431a;

        public a(boolean z) {
            this.f431a = z;
            this.f430a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fk
        /* JADX INFO: renamed from: a */
        public boolean mo264a(fo foVar) {
            return true;
        }

        @Override // com.xiaomi.push.ff
        public void a(fo foVar) {
            if (ez.f11560a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f429a.format(new Date()) + this.f430a + " PKT " + foVar.mo455a());
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f429a.format(new Date()) + this.f430a + " PKT [" + foVar.k() + "," + foVar.j() + "]");
        }

        @Override // com.xiaomi.push.ff
        public void a(er erVar) {
            if (ez.f11560a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f429a.format(new Date()) + this.f430a + erVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f429a.format(new Date()) + this.f430a + " Blob [" + erVar.m414a() + "," + erVar.a() + "," + com.xiaomi.push.service.aj.a(erVar.e()) + "]");
            }
            if (erVar == null || erVar.a() != 99999) {
                return;
            }
            String strM414a = erVar.m414a();
            er erVar2 = null;
            if (!this.f431a) {
                if ("BIND".equals(strM414a)) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("build binded result for loopback.");
                    dp.d dVar = new dp.d();
                    dVar.a(true);
                    dVar.c("login success.");
                    dVar.b("success");
                    dVar.a("success");
                    er erVar3 = new er();
                    erVar3.a(dVar.m398a(), (String) null);
                    erVar3.a((short) 2);
                    erVar3.a(99999);
                    erVar3.a("BIND", (String) null);
                    erVar3.a(erVar.e());
                    erVar3.b((String) null);
                    erVar3.c(erVar.g());
                    erVar2 = erVar3;
                } else if (!"UBND".equals(strM414a) && "SECMSG".equals(strM414a)) {
                    er erVar4 = new er();
                    erVar4.a(99999);
                    erVar4.a("SECMSG", (String) null);
                    erVar4.c(erVar.g());
                    erVar4.a(erVar.e());
                    erVar4.a(erVar.m416a());
                    erVar4.b(erVar.f());
                    erVar4.a(erVar.m419a(com.xiaomi.push.service.am.a().a(String.valueOf(99999), erVar.g()).h), (String) null);
                    erVar2 = erVar4;
                }
            }
            if (erVar2 != null) {
                for (Map.Entry<ff, fa.a> entry : ez.this.f426a.m439a().entrySet()) {
                    if (ez.this.f425a != entry.getKey()) {
                        entry.getValue().a(erVar2);
                    }
                }
            }
        }
    }

    public ez(fa faVar) {
        this.f426a = faVar;
        a();
    }

    private void a() {
        this.f425a = new a(true);
        this.b = new a(false);
        fa faVar = this.f426a;
        a aVar = this.f425a;
        faVar.a(aVar, aVar);
        fa faVar2 = this.f426a;
        a aVar2 = this.b;
        faVar2.b(aVar2, aVar2);
        this.f427a = new fd() { // from class: com.xiaomi.push.ez.1
            @Override // com.xiaomi.push.fd
            public void a(fa faVar3, int i, Exception exc) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f429a.format(new Date()) + " Connection closed (" + ez.this.f426a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.fd
            public void b(fa faVar3) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f429a.format(new Date()) + " Connection reconnected (" + ez.this.f426a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.fd
            public void a(fa faVar3, Exception exc) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f429a.format(new Date()) + " Reconnection failed due to an exception (" + ez.this.f426a.hashCode() + ")");
                exc.printStackTrace();
            }

            @Override // com.xiaomi.push.fd
            public void a(fa faVar3) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + ez.this.f429a.format(new Date()) + " Connection started (" + ez.this.f426a.hashCode() + ")");
            }
        };
    }
}
