package com.kwad.framework.filedownloader.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.framework.filedownloader.exception.PathConflictException;
import com.kwad.framework.filedownloader.y;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {

    @SuppressLint({"StaticFieldLeak"})
    private static Context atK;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        int V(long j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        com.kwad.framework.filedownloader.a.b bA(String str);
    }

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.f.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0586c {
        com.kwad.framework.filedownloader.b.a Be();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        int f(String str, String str2, boolean z);

        int g(String str, String str2, boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        com.kwad.framework.filedownloader.e.a c(File file);
    }

    public static Context Bd() {
        return atK;
    }

    public static boolean a(int i, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwad.framework.filedownloader.message.e.Ax().s(com.kwad.framework.filedownloader.message.f.a(i, file, z2));
                return true;
            }
        }
        return false;
    }

    public static void aQ(Context context) {
        atK = context;
    }

    public static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, y yVar, boolean z) {
        if (!yVar.a(cVar)) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.Ax().s(com.kwad.framework.filedownloader.message.f.a(i, cVar.AD(), cVar.getTotal(), z));
        return true;
    }

    public static boolean a(int i, long j, String str, String str2, y yVar) {
        int iP;
        if (str2 == null || str == null || (iP = yVar.p(str, i)) == 0) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.Ax().s(com.kwad.framework.filedownloader.message.f.a(i, j, new PathConflictException(iP, str, str2)));
        return true;
    }
}
