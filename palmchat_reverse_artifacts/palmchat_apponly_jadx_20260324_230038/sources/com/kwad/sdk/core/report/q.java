package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class q extends d {
    private static volatile q aMC;
    private o aMD;

    private q(Context context) {
        super(new p(context, p.NT));
        this.aMD = new i();
    }

    public static q bM(Context context) {
        if (aMC == null) {
            synchronized (q.class) {
                if (aMC == null) {
                    aMC = new q(context);
                }
            }
        }
        return aMC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized n f(@NonNull Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dx()) {
            return this.aMD.aa(string2, string);
        }
        return this.aMD.aa(string2, string);
    }

    @Override // com.kwad.sdk.core.report.d
    public final String Kh() {
        return "ksad_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String[] Ki() {
        return new String[]{"aLog", "actionId"};
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "ReportActionDBManager";
    }
}
