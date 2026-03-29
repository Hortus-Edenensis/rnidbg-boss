package defpackage;

import android.text.SpannableString;
import android.util.LruCache;
import com.zenmen.palmchat.utils.ShareLinkBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cw {
    public static cw d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LruCache<CharSequence, SpannableString> f16928a = new LruCache<>(25);
    public LruCache<CharSequence, SpannableString> b = new LruCache<>(50);
    public LruCache<String, ShareLinkBean> c = new LruCache<>(10);

    public static cw b() {
        if (d == null) {
            d = new cw();
        }
        return d;
    }

    public void a() {
        this.c.evictAll();
    }

    public SpannableString c(CharSequence charSequence) {
        return this.f16928a.get(charSequence);
    }

    public ShareLinkBean d(String str) {
        return this.c.get(str);
    }

    public void e(CharSequence charSequence, SpannableString spannableString) {
        this.f16928a.put(charSequence, spannableString);
    }

    public void f(String str, ShareLinkBean shareLinkBean) {
        this.c.put(str, shareLinkBean);
    }
}
