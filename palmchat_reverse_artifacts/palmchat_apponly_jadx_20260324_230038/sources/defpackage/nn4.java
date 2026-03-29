package defpackage;

import android.content.Context;
import android.content.Intent;
import com.zenmen.palmchat.settings.PersonalInfoActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class nn4 {
    public static Intent a(Context context, int i) {
        Intent intent = new Intent(context, (Class<?>) PersonalInfoActivity.class);
        intent.putExtra("extra_from", i);
        return intent;
    }
}
