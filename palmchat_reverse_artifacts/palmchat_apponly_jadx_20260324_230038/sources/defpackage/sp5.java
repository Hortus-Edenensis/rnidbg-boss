package defpackage;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import com.baidu.platform.comapi.map.MapController;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.model.AdnName;
import defpackage.e0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010,\u001a\u00020\u0001¢\u0006\u0004\b-\u0010.J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0017J\b\u0010\t\u001a\u00020\u0004H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0018R\u0014\u0010,\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lsp5;", "Landroid/content/ClipData$Item;", "Landroid/content/Context;", "context", "", "coerceToHtmlText", "", "coerceToStyledText", "getHtmlText", "toString", "Landroid/content/Intent;", "getIntent", "Landroid/net/Uri;", "getUri", "getText", "coerceToText", "", AdnName.OTHER, "", "equals", "", "hashCode", "Lcd0;", "a", "Lcd0;", "_coerceToHtmlText", t.l, "_coerceToStyledText", "Lsw;", "c", "Lsw;", "_getHtmlText", "d", "_toString", "e", "_getIntent", "f", "_getUri", "g", "_getText", "h", "_coerceToText", "i", "Landroid/content/ClipData$Item;", MapController.ITEM_LAYER_TAG, "<init>", "(Landroid/content/ClipData$Item;)V", "zx-permission_release"}, k = 1, mv = {1, 4, 0})
public final class sp5 extends ClipData.Item {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public cd0<String> _coerceToHtmlText;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public cd0<CharSequence> _coerceToStyledText;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public sw<String> _getHtmlText;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public sw<String> _toString;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public sw<Intent> _getIntent;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public sw<Uri> _getUri;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public sw<CharSequence> _getText;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public cd0<CharSequence> _coerceToText;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final ClipData.Item item;

    public sp5(ClipData.Item item) {
        super(item.getIntent());
        this.item = item;
        this._coerceToHtmlText = new cd0<>();
        this._coerceToStyledText = new cd0<>();
        this._getHtmlText = new sw<>(null, 1, null);
        this._toString = new sw<>(null, 1, null);
        this._getIntent = new sw<>(null, 1, null);
        this._getUri = new sw<>(null, 1, null);
        this._getText = new sw<>(null, 1, null);
        this._coerceToText = new cd0<>();
    }

    @Override // android.content.ClipData.Item
    @RequiresApi(16)
    public String coerceToHtmlText(Context context) {
        if (this._coerceToHtmlText.a(context)) {
            this._coerceToHtmlText.c(this.item.coerceToHtmlText(context), context);
            e0.Companion companion = e0.INSTANCE;
            companion.a(companion.b(), "ClipData.Item.coerceToHtmlText");
        } else {
            e0.Companion companion2 = e0.INSTANCE;
            companion2.a(companion2.c(), "ClipData.Item.coerceToHtmlText");
        }
        return this._coerceToHtmlText.b();
    }

    @Override // android.content.ClipData.Item
    @RequiresApi(16)
    public CharSequence coerceToStyledText(Context context) {
        if (this._coerceToStyledText.a(context)) {
            this._coerceToStyledText.c(this.item.coerceToStyledText(context), context);
            e0.Companion companion = e0.INSTANCE;
            companion.a(companion.b(), "ClipData.Item.coerceToStyledText");
        } else {
            e0.Companion companion2 = e0.INSTANCE;
            companion2.a(companion2.c(), "ClipData.Item.coerceToStyledText");
        }
        return this._coerceToStyledText.b();
    }

    @Override // android.content.ClipData.Item
    public CharSequence coerceToText(Context context) {
        if (this._coerceToText.a(context)) {
            this._coerceToText.c(this.item.coerceToText(context), context);
            e0.Companion companion = e0.INSTANCE;
            companion.a(companion.b(), "ClipData.Item.coerceToText");
        } else {
            e0.Companion companion2 = e0.INSTANCE;
            companion2.a(companion2.c(), "ClipData.Item.coerceToText");
        }
        return this._coerceToText.b();
    }

    public boolean equals(Object other) {
        return this.item.equals(other);
    }

    @Override // android.content.ClipData.Item
    @RequiresApi(16)
    public String getHtmlText() {
        if (this._getHtmlText.f()) {
            this._getHtmlText.e(this.item.getHtmlText());
            e0.Companion companion = e0.INSTANCE;
            companion.a(companion.b(), "ClipData.Item.getHtmlText");
        } else {
            e0.Companion companion2 = e0.INSTANCE;
            companion2.a(companion2.c(), "ClipData.Item.getHtmlText");
        }
        return this._getHtmlText.i();
    }

    @Override // android.content.ClipData.Item
    public Intent getIntent() {
        if (this._getIntent.f()) {
            this._getIntent.e(this.item.getIntent());
            e0.Companion companion = e0.INSTANCE;
            companion.a(companion.b(), "ClipData.Item.getIntent");
        } else {
            e0.Companion companion2 = e0.INSTANCE;
            companion2.a(companion2.c(), "ClipData.Item.getIntent");
        }
        return this._getIntent.i();
    }

    @Override // android.content.ClipData.Item
    public CharSequence getText() {
        if (this._getText.f()) {
            this._getText.e(this.item.getText());
            e0.Companion companion = e0.INSTANCE;
            companion.a(companion.b(), "ClipData.Item.getText");
        } else {
            e0.Companion companion2 = e0.INSTANCE;
            companion2.a(companion2.c(), "ClipData.Item.getText");
        }
        return this._getText.i();
    }

    @Override // android.content.ClipData.Item
    public Uri getUri() {
        if (this._getUri.f()) {
            this._getUri.e(this.item.getUri());
            e0.Companion companion = e0.INSTANCE;
            companion.a(companion.b(), "ClipData.Item.getUri");
        } else {
            e0.Companion companion2 = e0.INSTANCE;
            companion2.a(companion2.c(), "ClipData.Item.getUri");
        }
        return this._getUri.i();
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    @Override // android.content.ClipData.Item
    public String toString() {
        if (this._toString.f()) {
            this._toString.e(this.item.toString());
            e0.Companion companion = e0.INSTANCE;
            companion.a(companion.b(), "ClipData.Item.toString");
        } else {
            e0.Companion companion2 = e0.INSTANCE;
            companion2.a(companion2.c(), "ClipData.Item.toString");
        }
        String strI = this._toString.i();
        if (strI == null) {
            Intrinsics.throwNpe();
        }
        return strI;
    }
}
