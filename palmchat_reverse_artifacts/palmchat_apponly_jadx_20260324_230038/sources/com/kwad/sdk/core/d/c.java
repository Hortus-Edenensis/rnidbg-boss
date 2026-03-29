package com.kwad.sdk.core.d;

import android.util.Log;
import com.ksad.annotation.invoker.ForInvoker;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static boolean aIN = true;
    private static boolean aIO = com.kwad.sdk.core.d.a.oy.booleanValue();
    private static final com.kwad.sdk.core.d.a.a aIP = new b();
    private static final List<com.kwad.sdk.core.d.a.a> aIQ = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void b(com.kwad.sdk.core.d.a.a aVar);
    }

    private static String Bn() {
        int lineNumber;
        String fileName;
        if (!aIO) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            fileName = stackTrace[3].getFileName();
            lineNumber = stackTrace[3].getLineNumber();
        } else {
            lineNumber = -1;
            fileName = "unknown";
        }
        return "(" + fileName + ':' + lineNumber + ')';
    }

    @ForInvoker(methodId = "registerLogger")
    private static void Jq() {
        com.kwad.sdk.commercial.h.a.register();
    }

    private static void S(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.1
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.d(str, str2);
            }
        });
    }

    private static void T(String str, String str2) {
        if (str2 == null || str2.length() <= 4000) {
            S(str, str2);
        } else {
            S(str, str2.substring(0, 4000));
            T(str, str2.substring(4000));
        }
    }

    public static void U(final String str, String str2) {
        final String strEl = el(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.5
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.ek(str), strEl, true);
            }
        });
    }

    public static void a(com.kwad.sdk.core.d.a.a aVar) {
        List<com.kwad.sdk.core.d.a.a> list = aIQ;
        if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    public static void d(String str, String str2) {
        T(ek(str), el(str2));
    }

    public static void e(final String str, String str2) {
        final String strEl = el(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.9
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.ek(str), strEl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ek(String str) {
        return "KSAd_" + str;
    }

    private static String el(String str) {
        return str + " " + Bn();
    }

    public static void i(final String str, String str2) {
        final String strEl = el(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.6
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.i(c.ek(str), strEl);
            }
        });
    }

    public static void init(boolean z) {
        aIN = z;
        List<com.kwad.sdk.core.d.a.a> list = aIQ;
        list.clear();
        list.add(aIP);
        Jq();
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.2
                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
        if (com.kwad.sdk.core.d.a.oy.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.3
                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
    }

    public static void v(final String str, String str2) {
        final String strEl = el(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.4
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.ek(str), strEl);
            }
        });
    }

    public static void w(final String str, String str2) {
        final String strEl = el(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.7
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.ek(str), strEl);
            }
        });
    }

    public static void d(String str, Throwable th) {
        d(str, th.getMessage());
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.d.a.a aVar2 : aIQ) {
            if (aVar2 != null) {
                try {
                    aVar.b(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void e(final String str, String str2, Throwable th) {
        final String strEl = el(str2 + '\n' + Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.c.10
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.ek(str), strEl);
            }
        });
    }

    public static void w(final String str, Throwable th) {
        final String strEl = el(Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.c.8
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.ek(str), strEl, com.kwad.sdk.core.d.a.oy.booleanValue());
            }
        });
    }
}
