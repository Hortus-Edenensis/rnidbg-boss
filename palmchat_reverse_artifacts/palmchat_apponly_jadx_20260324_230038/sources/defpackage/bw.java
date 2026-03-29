package defpackage;

import android.text.SpannableString;
import android.util.LruCache;
import com.zenmen.palmchat.utils.ShareLinkBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bw {
    public static bw d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LruCache<CharSequence, SpannableString> f1830a = new LruCache<>(25);
    public LruCache<CharSequence, SpannableString> b = new LruCache<>(50);
    public LruCache<String, ShareLinkBean> c = new LruCache<>(10);

    public static bw b() {
        if (d == null) {
            d = new bw();
        }
        return d;
    }

    public SpannableString a(CharSequence charSequence) {
        return this.b.get(charSequence);
    }

    public void c(CharSequence charSequence, SpannableString spannableString) {
        this.b.put(charSequence, spannableString);
    }
}
