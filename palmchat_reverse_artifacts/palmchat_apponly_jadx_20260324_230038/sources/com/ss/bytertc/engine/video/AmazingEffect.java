package com.ss.bytertc.engine.video;

import android.util.Log;
import com.ss.bytertc.engine.NativeAmazingEffectFunctions;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AmazingEffect extends IAmazingEffect {
    private static final String TAG = "AmazingEffect";
    private static boolean mLibraryLoaded = false;
    private static final String sSoLibraryName = "volcenginertc";
    private long mNativeAmazingEffect;

    static {
        try {
            System.loadLibrary("effect");
            System.loadLibrary("volcenginertc");
            mLibraryLoaded = true;
            Log.i(TAG, "Loading library: effect");
        } catch (UnsatisfiedLinkError e) {
            mLibraryLoaded = false;
            Log.e(TAG, "Failed to load native library: effect", e);
        }
    }

    public AmazingEffect(long j) {
        this.mNativeAmazingEffect = j;
        LogUtil.i(TAG, "create amazing effect");
    }

    private boolean amazingEffectInvalid() {
        return this.mNativeAmazingEffect == 0;
    }

    public static String getEffectSDKVersion() {
        return !mLibraryLoaded ? "unkonw" : NativeAmazingEffectFunctions.nativeGetEffectSDKVersion();
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int appendEffectNodes(List<String> list) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, appendEffectNodes failed.");
            return -1006;
        }
        if (list == null) {
            LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
            return -1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return NativeAmazingEffectFunctions.nativeAppendAmazingEffectNodes(this.mNativeAmazingEffect, strArr);
    }

    public void dispose() {
        LogUtil.i(TAG, "dispose amazing effect");
        this.mNativeAmazingEffect = 0L;
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int removeEffectNodes(List<String> list) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, removeEffectNodes failed.");
            return -1006;
        }
        if (list == null) {
            LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
            return -1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return NativeAmazingEffectFunctions.nativeRemoveAmazingEffectNodes(this.mNativeAmazingEffect, strArr);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int replaceEffectNodes(List<String> list, List<String> list2) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, removeEffectNodes failed.");
            return -1006;
        }
        if (list == null || list2 == null) {
            LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
            return -1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        String[] strArr2 = new String[list2.size()];
        list2.toArray(strArr2);
        return NativeAmazingEffectFunctions.nativeReplaceAmazingEffectNodes(this.mNativeAmazingEffect, strArr, strArr2);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int setAlgoModelResourceFinder(IRtcResourceFinder iRtcResourceFinder) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, setAlgoModelResourceFinder failed.");
            return -1006;
        }
        EffectResourceFinderAdapter.sFinder = iRtcResourceFinder;
        return 0;
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int setEffectNodes(List<String> list) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, setEffectNodes failed.");
            return -1006;
        }
        if (list == null) {
            LogUtil.e(TAG, "param invalid, appendEffectNodes failed.");
            return -1;
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return NativeAmazingEffectFunctions.nativeSetAmazingEffectNodes(this.mNativeAmazingEffect, strArr);
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public void setVirtualBackgroundFilePath(String str, int i) {
        if (amazingEffectInvalid()) {
            LogUtil.e(TAG, "invalid, updateEffectNode failed.");
        } else {
            NativeAmazingEffectFunctions.nativeSetVirtualBackgroundFilePath(this.mNativeAmazingEffect, str, i);
        }
    }

    @Override // com.ss.bytertc.engine.video.IAmazingEffect
    public int updateEffectNode(String str, String str2, float f) {
        if (!amazingEffectInvalid()) {
            return NativeAmazingEffectFunctions.nativeUpdateAmazingEffectNode(this.mNativeAmazingEffect, str, str2, f);
        }
        LogUtil.e(TAG, "invalid, updateEffectNode failed.");
        return -1006;
    }
}
