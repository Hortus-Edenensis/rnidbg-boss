package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface fk2 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bundle f17540a;

        public Bundle a() {
            return this.f17540a;
        }

        public void b(Bundle bundle) {
            this.f17540a = bundle;
        }
    }

    Intent a(Context context, a aVar);
}
