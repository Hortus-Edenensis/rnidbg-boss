package defpackage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class hc2 {
    @NonNull
    public static lc2 a(@NonNull Context context) {
        return (lc2) Glide.with(context);
    }

    @NonNull
    public static lc2 b(@NonNull FragmentActivity fragmentActivity) {
        return (lc2) Glide.with(fragmentActivity);
    }
}
