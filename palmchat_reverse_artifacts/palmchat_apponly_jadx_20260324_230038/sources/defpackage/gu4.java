package defpackage;

import com.zenmen.palmchat.AppContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class gu4 {
    public static int a() {
        return 0;
    }

    public static boolean b() {
        return r75.d(AppContext.getContext(), k86.a("sp_recommend_phone_contact_visibility"), true);
    }

    public static void c(int i, boolean z) {
        r75.p(AppContext.getContext(), k86.a("sp_phone_contact_unread_count"), i);
        r75.o(AppContext.getContext(), k86.a("sp_phone_contact_unread_count_visibility"), z);
    }

    public static void d(boolean z) {
        r75.o(AppContext.getContext(), k86.a("sp_recommend_phone_contact_visibility"), z);
    }
}
