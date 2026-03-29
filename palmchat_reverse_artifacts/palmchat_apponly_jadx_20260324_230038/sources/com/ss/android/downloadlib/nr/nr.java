package com.ss.android.downloadlib.nr;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    public void u(@NonNull final com.ss.android.downloadad.api.u.nr nrVar, @NonNull final x xVar, int i) {
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.nr.nr.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.u(nrVar)) {
                    xVar.u(false);
                } else if (iz.u(nrVar)) {
                    iz.u(nrVar, new n() { // from class: com.ss.android.downloadlib.nr.nr.1.1
                        @Override // com.ss.android.downloadlib.nr.n
                        public void u(boolean z) {
                            xVar.u(z);
                        }
                    });
                } else {
                    xVar.u(false);
                }
            }
        }, i);
    }
}
