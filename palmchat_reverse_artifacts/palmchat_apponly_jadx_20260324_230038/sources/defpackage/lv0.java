package defpackage;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.lxvoip.vertc.R$id;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class lv0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.OnClickListener f19081a;
    public final long b;

    public lv0(@NonNull View.OnClickListener onClickListener, long j) {
        this.f19081a = onClickListener;
        this.b = j;
    }

    public static lv0 a(View.OnClickListener onClickListener) {
        return new lv0(onClickListener, 500L);
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"LongLogTag"})
    public final void onClick(@NonNull View view) {
        int i = R$id.view_click_last_ts;
        Object tag = view.getTag(i);
        long jLongValue = tag instanceof Long ? ((Long) tag).longValue() : 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - jLongValue < this.b) {
            return;
        }
        view.setTag(i, Long.valueOf(jElapsedRealtime));
        this.f19081a.onClick(view);
    }
}
