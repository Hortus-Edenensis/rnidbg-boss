package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lu05;", "Lt05;", "", "data", "Landroid/graphics/BitmapFactory$Options;", "ops", "Landroid/graphics/Bitmap;", "c", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class u05 extends t05<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u05 f21110a = new u05();

    @Override // defpackage.t05
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Bitmap b(String data, BitmapFactory.Options ops) {
        return BitmapFactory.decodeFile(data, ops);
    }
}
