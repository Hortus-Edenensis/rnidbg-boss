package com.ss.bytertc.engine.data;

import com.bytedance.realx.base.CalledByNative;
import com.huawei.openalliance.ad.constant.ai;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ForwardStreamStateInfo {
    public ForwardStreamError error;
    public String roomId;
    public ForwardStreamState state;

    /* JADX INFO: compiled from: SearchBox */
    public enum ForwardStreamError {
        FORWARD_STREAM_ERROR_OK(0),
        FORWARD_STREAM_ERROR_INVALID_ARGUMENT(1201),
        FORWARD_STREAM_ERROR_INVALID_TOKEN(1202),
        FORWARD_STREAM_ERROR_RESPONSE(1203),
        FORWARD_STREAM_ERROR_REMOTE_KICKED(ai.aj),
        FORWARD_STREAM_ERROR_NOT_SUPPORT(1205);

        private int value;

        ForwardStreamError(int i) {
            this.value = i;
        }

        public static ForwardStreamError fromId(int i) {
            for (ForwardStreamError forwardStreamError : values()) {
                if (forwardStreamError.value() == i) {
                    return forwardStreamError;
                }
            }
            return null;
        }

        public int value() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum ForwardStreamState {
        FORWARD_STREAM_STATE_IDLE(0),
        FORWARD_STREAM_STATE_SUCCESS(1),
        FORWARD_STREAM_STATE_FAILURE(2);

        private int value;

        ForwardStreamState(int i) {
            this.value = i;
        }

        public static ForwardStreamState fromId(int i) {
            for (ForwardStreamState forwardStreamState : values()) {
                if (forwardStreamState.value() == i) {
                    return forwardStreamState;
                }
            }
            return null;
        }

        public int value() {
            return this.value;
        }
    }

    public ForwardStreamStateInfo(String str, ForwardStreamState forwardStreamState, ForwardStreamError forwardStreamError) {
        this.roomId = str;
        this.state = forwardStreamState;
        this.error = forwardStreamError;
    }

    @CalledByNative
    private static ForwardStreamStateInfo create(String str, int i, int i2) {
        return new ForwardStreamStateInfo(str, ForwardStreamState.fromId(i), ForwardStreamError.fromId(i2));
    }
}
