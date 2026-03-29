package com.heytap.msp.mobad.api.listener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IInitListener {
    public static final IInitListener NONE = new IInitListener() { // from class: com.heytap.msp.mobad.api.listener.IInitListener.1
        private static final String TAG = "IInitListener";

        @Override // com.heytap.msp.mobad.api.listener.IInitListener
        public void onSuccess() {
        }

        @Override // com.heytap.msp.mobad.api.listener.IInitListener
        public void onFailed(String str) {
        }
    };

    void onFailed(String str);

    void onSuccess();
}
