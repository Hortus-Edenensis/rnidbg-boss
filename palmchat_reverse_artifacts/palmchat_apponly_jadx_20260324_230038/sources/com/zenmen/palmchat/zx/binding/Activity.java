package com.zenmen.palmchat.zx.binding;

import android.os.Bundle;
import android.view.LayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/zenmen/palmchat/zx/binding/Activity;", "BINDING_T", "Lcom/zenmen/palmchat/zx/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onDestroy", "s", "Ljava/lang/Object;", "_binding", "zx-framework_release"}, k = 1, mv = {1, 4, 0})
public abstract class Activity<BINDING_T> extends com.zenmen.palmchat.zx.Activity {

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public BINDING_T _binding;

    @Override // com.zenmen.palmchat.zx.Activity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkExpressionValueIsNotNull(layoutInflater, "layoutInflater");
        throw null;
    }

    @Override // com.zenmen.palmchat.zx.Activity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}
