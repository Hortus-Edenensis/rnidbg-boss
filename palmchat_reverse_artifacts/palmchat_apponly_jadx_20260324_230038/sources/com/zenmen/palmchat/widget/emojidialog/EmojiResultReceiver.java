package com.zenmen.palmchat.widget.emojidialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class EmojiResultReceiver extends ResultReceiver {

    @Nullable
    private a receiver;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public EmojiResultReceiver(Handler handler) {
        super(handler);
    }

    public void setReceiver(a aVar) {
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
    }
}
