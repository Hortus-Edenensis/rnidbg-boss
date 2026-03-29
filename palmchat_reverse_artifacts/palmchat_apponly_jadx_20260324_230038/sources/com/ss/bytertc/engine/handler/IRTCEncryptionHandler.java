package com.ss.bytertc.engine.handler;

import android.annotation.SuppressLint;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"DefaultLocale"})
public interface IRTCEncryptionHandler {
    byte[] onDecryptData(byte[] bArr);

    byte[] onEncryptData(byte[] bArr);
}
