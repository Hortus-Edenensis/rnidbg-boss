package com.ss.bytertc.engine.handler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IRTCASREngineEventHandler {

    /* JADX INFO: compiled from: SearchBox */
    public enum RTCASRErrorCode {
        NETWORK_INTERRUPTED(-1),
        ALREADY_STARTED(-2),
        TOKEN_EMPTY(-3),
        SIGNATURE_KEY_EMPTY(-4),
        USERID_NULL(-5),
        APPID_NULL(-6),
        CLUSTER_NULL(-7),
        OPERATION_DENIED(-8);

        private int value;

        RTCASRErrorCode(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }
    }

    void onError(int i, String str);

    void onMessage(String str);

    void onSuccess();
}
