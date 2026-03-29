package com.bef.effectsdk;

import com.bef.effectsdk.message.MessageCenter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class GPUProcessor {
    private static Listener sListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onMessageReceived(int i, int i2, int i3, String str);
    }

    public static void destroy() {
        MessageCenter.destroy();
        sListener = null;
    }

    public static void init() {
        MessageCenter.init();
        MessageCenter.setListener(new MessageCenter.Listener() { // from class: com.bef.effectsdk.GPUProcessor.1
            @Override // com.bef.effectsdk.message.MessageCenter.Listener
            public void onMessageReceived(int i, int i2, int i3, String str) {
                if (GPUProcessor.sListener != null) {
                    GPUProcessor.sListener.onMessageReceived(i, i2, i3, str);
                }
            }
        });
    }

    public static void setListener(Listener listener) {
        sListener = listener;
    }
}
