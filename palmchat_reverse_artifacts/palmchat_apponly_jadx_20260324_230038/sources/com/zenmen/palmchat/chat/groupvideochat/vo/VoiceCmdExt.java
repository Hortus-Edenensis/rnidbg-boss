package com.zenmen.palmchat.chat.groupvideochat.vo;

import android.text.TextUtils;
import defpackage.az2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class VoiceCmdExt {
    public VoiceCmd voiceCmd;

    public static VoiceCmdExt parseFromExt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (VoiceCmdExt) az2.a(str, VoiceCmdExt.class);
    }
}
