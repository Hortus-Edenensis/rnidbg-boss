package defpackage;

import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class eg5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f17296a = new Object();
    public static final eg5 b = new eg5();

    public static eg5 c() {
        return b;
    }

    public String a() {
        return v4.e(c.b());
    }

    public String b() {
        ContactInfoItem contactInfoItemF = v4.f();
        return contactInfoItemF != null ? contactInfoItemF.getChatName() : "unknown";
    }
}
