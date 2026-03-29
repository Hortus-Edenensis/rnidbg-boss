package com.xiaomi.push;

import java.net.UnknownHostException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
final class em {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ei f11544a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f387a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m404a(Exception exc) {
        exc.getClass();
    }

    public static a b(Exception exc) {
        Throwable cause;
        m404a(exc);
        boolean z = exc instanceof fi;
        Throwable thA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            thA = exc;
            if (fiVar.a() != null) {
                thA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        int iA = fc.a(thA);
        String str = thA.getClass().getSimpleName() + ":" + message;
        if (iA != 0) {
            ei eiVarA = ei.a(ei.CONN_SUCCESS.a() + iA);
            aVar.f11544a = eiVarA;
            if (eiVarA == ei.CONN_BOSH_ERR && (cause = thA.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.f11544a = ei.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.f11544a = ei.CONN_XMPP_ERR;
        }
        ei eiVar = aVar.f11544a;
        if (eiVar == ei.CONN_TCP_ERR_OTHER || eiVar == ei.CONN_XMPP_ERR || eiVar == ei.CONN_BOSH_ERR) {
            aVar.f387a = str;
        }
        return aVar;
    }

    public static a c(Exception exc) {
        m404a(exc);
        boolean z = exc instanceof fi;
        Throwable thA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            thA = exc;
            if (fiVar.a() != null) {
                thA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        int iA = fc.a(thA);
        String str = thA.getClass().getSimpleName() + ":" + message;
        if (iA == 105) {
            aVar.f11544a = ei.BIND_TCP_READ_TIMEOUT;
        } else if (iA == 199) {
            aVar.f11544a = ei.BIND_TCP_ERR;
        } else if (iA == 499) {
            aVar.f11544a = ei.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f11544a = ei.BIND_BOSH_ITEM_NOT_FOUND;
            }
        } else if (iA == 109) {
            aVar.f11544a = ei.BIND_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.f11544a = ei.BIND_XMPP_ERR;
        } else {
            aVar.f11544a = ei.BIND_TCP_BROKEN_PIPE;
        }
        ei eiVar = aVar.f11544a;
        if (eiVar == ei.BIND_TCP_ERR || eiVar == ei.BIND_XMPP_ERR || eiVar == ei.BIND_BOSH_ERR) {
            aVar.f387a = str;
        }
        return aVar;
    }

    public static a d(Exception exc) {
        m404a(exc);
        boolean z = exc instanceof fi;
        Throwable thA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            thA = exc;
            if (fiVar.a() != null) {
                thA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        int iA = fc.a(thA);
        String str = thA.getClass().getSimpleName() + ":" + message;
        if (iA == 105) {
            aVar.f11544a = ei.CHANNEL_TCP_READTIMEOUT;
        } else if (iA == 199) {
            aVar.f11544a = ei.CHANNEL_TCP_ERR;
        } else if (iA == 499) {
            aVar.f11544a = ei.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f11544a = ei.CHANNEL_BOSH_ITEMNOTFIND;
            }
        } else if (iA == 109) {
            aVar.f11544a = ei.CHANNEL_TCP_CONNRESET;
        } else if (iA != 110) {
            aVar.f11544a = ei.CHANNEL_XMPPEXCEPTION;
        } else {
            aVar.f11544a = ei.CHANNEL_TCP_BROKEN_PIPE;
        }
        ei eiVar = aVar.f11544a;
        if (eiVar == ei.CHANNEL_TCP_ERR || eiVar == ei.CHANNEL_XMPPEXCEPTION || eiVar == ei.CHANNEL_BOSH_EXCEPTION) {
            aVar.f387a = str;
        }
        return aVar;
    }

    public static a a(Exception exc) {
        m404a(exc);
        boolean z = exc instanceof fi;
        Throwable thA = exc;
        if (z) {
            fi fiVar = (fi) exc;
            thA = exc;
            if (fiVar.a() != null) {
                thA = fiVar.a();
            }
        }
        a aVar = new a();
        String message = thA.getMessage();
        if (thA.getCause() != null) {
            message = thA.getCause().getMessage();
        }
        String str = thA.getClass().getSimpleName() + ":" + message;
        int iA = fc.a(thA);
        if (iA != 0) {
            aVar.f11544a = ei.a(ei.GSLB_REQUEST_SUCCESS.a() + iA);
        }
        if (aVar.f11544a == null) {
            aVar.f11544a = ei.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f11544a == ei.GSLB_TCP_ERR_OTHER) {
            aVar.f387a = str;
        }
        return aVar;
    }
}
