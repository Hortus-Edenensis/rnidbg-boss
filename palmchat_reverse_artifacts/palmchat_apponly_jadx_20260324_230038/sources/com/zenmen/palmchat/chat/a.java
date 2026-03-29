package com.zenmen.palmchat.chat;

import android.os.RemoteException;
import androidx.media3.common.C;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ir5;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public ChatterActivity e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12723a = 0;
    public long b = 0;
    public boolean c = false;
    public String d = null;
    public boolean f = false;
    public long g = 0;
    public int h = 0;

    public a(ChatterActivity chatterActivity) {
        this.e = chatterActivity;
    }

    public void a(String str, int i) {
        LogUtil.i("ChatInputStatusHelper", "changeStatusOnReceiveCMD from=" + str + "status=" + i);
        if (str != null && str.equals(this.d) && this.c) {
            this.f12723a = i;
            i();
            if (i == 0) {
                this.e.C3().removeMessages(1003);
                return;
            }
            if (i == 1) {
                this.e.C3().removeMessages(1003);
                this.e.C3().sendEmptyMessageDelayed(1003, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
            } else if (i == 2) {
                this.e.C3().removeMessages(1003);
                this.e.C3().sendEmptyMessageDelayed(1003, 60000L);
            }
        }
    }

    public void b(boolean z, String str) {
        this.c = z;
        this.d = str;
        LogUtil.i("ChatInputStatusHelper", "init enable = " + z + "contactUid = " + str);
    }

    public void c() {
        LogUtil.i("ChatInputStatusHelper", "onActivityPause ");
        f(0);
    }

    public void d(boolean z) {
        LogUtil.i("ChatInputStatusHelper", "onTextingStatusChange start=" + z);
        f(z ? 1 : 0);
    }

    public void e(boolean z) {
        LogUtil.i("ChatInputStatusHelper", "onVoiceRecordingStatusChange isRecording=" + z);
        f(z ? 2 : 0);
    }

    public final void f(int i) {
        LogUtil.i("ChatInputStatusHelper", "sendInputStatusMsg type=" + i);
        if (this.c && this.f) {
            if (i == 0) {
                MessageVo messageVoBuildInputStatusMessage = MessageVo.buildInputStatusMessage(this.d, i);
                if (this.e.getMessagingServiceInterface() != null) {
                    LogUtil.i("ChatInputStatusHelper", "sendInputStatusMsg imp type=" + i);
                    try {
                        this.e.getMessagingServiceInterface().r(messageVoBuildInputStatusMessage);
                        this.h = 0;
                        return;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            if (ir5.b() - this.b > 5000 || this.h != i) {
                this.b = ir5.b();
                MessageVo messageVoBuildInputStatusMessage2 = MessageVo.buildInputStatusMessage(this.d, i);
                if (this.e.getMessagingServiceInterface() != null) {
                    LogUtil.i("ChatInputStatusHelper", "sendInputStatusMsg imp type=" + i);
                    try {
                        this.e.getMessagingServiceInterface().r(messageVoBuildInputStatusMessage2);
                        this.h = i;
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void g() {
        this.h = 0;
    }

    public void h(ArrayList<MessageVo> arrayList) {
        long j;
        if (this.c) {
            int size = arrayList.size() - 1;
            while (true) {
                if (size <= 0) {
                    j = 0;
                    break;
                }
                MessageVo messageVo = arrayList.get(size);
                if (!messageVo.isSend && messageVo.mimeType != 10000) {
                    j = messageVo.time;
                    break;
                }
                size--;
            }
            if (Math.abs(ir5.b() - j) > 1800000) {
                this.f = false;
            } else {
                this.f |= ir5.b() - j < 10000;
            }
            if (this.g < j) {
                a(this.d, 0);
                this.g = j;
            }
            LogUtil.i("ChatInputStatusHelper", "updateStatusOnReceiveMsg needSendInputStatusMsg=" + this.f);
        }
    }

    public final void i() {
        LogUtil.i("ChatInputStatusHelper", "updateTitle currentStatus=" + this.f12723a);
        int i = this.f12723a;
        if (i == 0) {
            this.e.l5(null);
            return;
        }
        if (i == 1) {
            ChatterActivity chatterActivity = this.e;
            chatterActivity.l5(chatterActivity.getString(R.string.string_chat_sending_text));
        } else if (i == 2) {
            ChatterActivity chatterActivity2 = this.e;
            chatterActivity2.l5(chatterActivity2.getString(R.string.string_chat_sending_voice));
        }
    }
}
