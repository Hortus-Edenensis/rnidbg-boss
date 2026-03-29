package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.l;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class lv implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ys1 f19080a;

    @Nullable
    public os1 b;

    @Nullable
    public ps1 c;

    public lv(ys1 ys1Var) {
        this.f19080a = ys1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    @Override // com.google.android.exoplayer2.source.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ru0 ru0Var, Uri uri, Map<String, List<String>> map, long j, long j2, qs1 qs1Var) throws IOException {
        e51 e51Var = new e51(ru0Var, j, j2);
        this.c = e51Var;
        if (this.b != null) {
            return;
        }
        os1[] os1VarArrCreateExtractors = this.f19080a.createExtractors(uri, map);
        if (os1VarArrCreateExtractors.length == 1) {
            this.b = os1VarArrCreateExtractors[0];
        } else {
            int length = os1VarArrCreateExtractors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                os1 os1Var = os1VarArrCreateExtractors[i];
                try {
                } catch (EOFException unused) {
                    if (this.b != null || e51Var.getPosition() == j) {
                    }
                } catch (Throwable th) {
                    vh.g(this.b != null || e51Var.getPosition() == j);
                    e51Var.resetPeekPosition();
                    throw th;
                }
                if (os1Var.d(e51Var)) {
                    this.b = os1Var;
                    vh.g(true);
                    e51Var.resetPeekPosition();
                    break;
                } else {
                    boolean z = this.b != null || e51Var.getPosition() == j;
                    vh.g(z);
                    e51Var.resetPeekPosition();
                    i++;
                }
                vh.g(z);
                e51Var.resetPeekPosition();
                i++;
            }
            if (this.b == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + g86.L(os1VarArrCreateExtractors) + ") could read the stream.", (Uri) vh.e(uri));
            }
        }
        this.b.b(qs1Var);
    }

    @Override // com.google.android.exoplayer2.source.l
    public int b(vk4 vk4Var) throws IOException {
        return ((os1) vh.e(this.b)).c((ps1) vh.e(this.c), vk4Var);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void disableSeekingOnMp3Streams() {
        os1 os1Var = this.b;
        if (os1Var instanceof or3) {
            ((or3) os1Var).i();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public long getCurrentInputPosition() {
        ps1 ps1Var = this.c;
        if (ps1Var != null) {
            return ps1Var.getPosition();
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void release() {
        os1 os1Var = this.b;
        if (os1Var != null) {
            os1Var.release();
            this.b = null;
        }
        this.c = null;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void seek(long j, long j2) {
        ((os1) vh.e(this.b)).seek(j, j2);
    }
}
