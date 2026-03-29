package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.BoringLayout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.amap.api.col.p0002sl.hb;
import com.kuaishou.weapon.p0.t;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b=\u0010>R>\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR>\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r`\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR>\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR>\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0016`\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0007\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR>\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a`\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR>\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f`\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0006\u0010\t\"\u0004\b \u0010\u000bR\u009e\u0001\u0010*\u001a~\u0012\u0004\u0012\u00020\u0003\u00124\u00122\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00040\"0\u0002j>\u0012\u0004\u0012\u00020\u0003\u00124\u00122\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00040\"`\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b)\u0010\u000bR>\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+`\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u000bR>\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020/0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020/`\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u001b\u0010\t\"\u0004\b0\u0010\u000bRó\u0001\u00106\u001aÒ\u0001\u0012\u0004\u0012\u00020\u0003\u0012^\u0012\\\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0004020\u0002jh\u0012\u0004\u0012\u00020\u0003\u0012^\u0012\\\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110'¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u000402`\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b5\u0010\u000bR\"\u0010<\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b7\u00109\"\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lz05;", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "d", "()Ljava/util/HashMap;", "setDynamicHidden$com_opensource_svgaplayer", "(Ljava/util/HashMap;)V", "dynamicHidden", "Landroid/graphics/Bitmap;", t.l, "f", "setDynamicImage$com_opensource_svgaplayer", "dynamicImage", "c", "h", "setDynamicText$com_opensource_svgaplayer", "dynamicText", "Landroid/text/TextPaint;", "i", "setDynamicTextPaint$com_opensource_svgaplayer", "dynamicTextPaint", "Landroid/text/StaticLayout;", "e", "g", "setDynamicStaticLayoutText$com_opensource_svgaplayer", "dynamicStaticLayoutText", "Landroid/text/BoringLayout;", "setDynamicBoringLayoutText$com_opensource_svgaplayer", "dynamicBoringLayoutText", "Lkotlin/Function2;", "Landroid/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "", "frameIndex", "setDynamicDrawer$com_opensource_svgaplayer", "dynamicDrawer", "", hb.j, "setMClickMap$com_opensource_svgaplayer", "mClickMap", "Lvk2;", "setDynamicIClickArea$com_opensource_svgaplayer", "dynamicIClickArea", "Lkotlin/Function4;", "width", "height", "setDynamicDrawerSized$com_opensource_svgaplayer", "dynamicDrawerSized", t.f7496a, "Z", "()Z", "l", "(Z)V", "isTextDirty", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class z05 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public HashMap<String, Boolean> dynamicHidden = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public HashMap<String, Bitmap> dynamicImage = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public HashMap<String, String> dynamicText = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public HashMap<String, TextPaint> dynamicTextPaint = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public HashMap<String, StaticLayout> dynamicStaticLayoutText = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public HashMap<String, BoringLayout> dynamicBoringLayoutText = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public HashMap<String, Function2<Canvas, Integer, Boolean>> dynamicDrawer = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public HashMap<String, int[]> mClickMap = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public HashMap<String, vk2> dynamicIClickArea = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> dynamicDrawerSized = new HashMap<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public boolean isTextDirty;

    public final HashMap<String, BoringLayout> a() {
        return this.dynamicBoringLayoutText;
    }

    public final HashMap<String, Function2<Canvas, Integer, Boolean>> b() {
        return this.dynamicDrawer;
    }

    public final HashMap<String, Function4<Canvas, Integer, Integer, Integer, Boolean>> c() {
        return this.dynamicDrawerSized;
    }

    public final HashMap<String, Boolean> d() {
        return this.dynamicHidden;
    }

    public final HashMap<String, vk2> e() {
        return this.dynamicIClickArea;
    }

    public final HashMap<String, Bitmap> f() {
        return this.dynamicImage;
    }

    public final HashMap<String, StaticLayout> g() {
        return this.dynamicStaticLayoutText;
    }

    public final HashMap<String, String> h() {
        return this.dynamicText;
    }

    public final HashMap<String, TextPaint> i() {
        return this.dynamicTextPaint;
    }

    public final HashMap<String, int[]> j() {
        return this.mClickMap;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getIsTextDirty() {
        return this.isTextDirty;
    }

    public final void l(boolean z) {
        this.isTextDirty = z;
    }
}
