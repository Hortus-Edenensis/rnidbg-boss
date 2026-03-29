package com.zenmen.media.camera;

import android.media.AudioRecord;
import android.os.Process;
import android.util.Log;
import com.zenmen.palmchat.media.AudioController;
import defpackage.fd6;
import defpackage.g13;
import defpackage.x86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AudioRecordClient extends g13 {
    protected int m_in_buf_size;
    protected byte[] m_in_bytes;
    protected AudioRecord m_in_rec;
    protected boolean m_keep_running;
    protected boolean m_recording_thread_running = false;
    protected String TAG = "AudioRecordClient";
    private CollectionControl mControl = null;

    public void free() {
        synchronized (this) {
            this.m_keep_running = false;
        }
        try {
            waitRecordThreadExit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.m_in_bytes = null;
    }

    public boolean init(int i, int i2) {
        int i3 = i2 == 1 ? 16 : 12;
        int minBufferSize = AudioRecord.getMinBufferSize(i, i3, 2);
        if (x86.b().equals("GiONEE V183")) {
            minBufferSize *= i2;
        }
        try {
            this.m_in_rec = new AudioRecord(1, i, i3, 2, minBufferSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.m_in_rec == null) {
            AudioController.b0().Z().i(new fd6());
            return false;
        }
        this.m_keep_running = true;
        int i4 = i2 * 2048;
        this.m_in_buf_size = i4;
        this.m_in_bytes = new byte[i4];
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(-19);
        Log.e(this.TAG, " run:" + this.m_keep_running);
        this.m_recording_thread_running = true;
        try {
            int i = this.m_in_buf_size;
            AudioRecord audioRecord = this.m_in_rec;
            if (audioRecord == null) {
                return;
            }
            try {
                audioRecord.startRecording();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            while (true) {
                if (!this.m_keep_running) {
                    break;
                }
                int i2 = this.m_in_rec.read(this.m_in_bytes, 0, i);
                if (i2 > 0) {
                    CollectionControl collectionControl = this.mControl;
                    if (collectionControl != null) {
                        collectionControl.feedAudioData(this.m_in_bytes, i2);
                    }
                } else if (i2 < 0) {
                    AudioController.b0().Z().i(new fd6());
                    break;
                }
            }
            try {
                this.m_in_rec.stop();
                this.m_in_rec.release();
                this.m_in_rec = null;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
            this.m_in_bytes = null;
        } catch (Exception e3) {
            Log.e(this.TAG, " -- audio record exception! --");
            e3.printStackTrace();
            AudioRecord audioRecord2 = this.m_in_rec;
            if (audioRecord2 != null) {
                audioRecord2.stop();
                this.m_in_rec.release();
            }
        }
        this.m_recording_thread_running = false;
    }

    public void setControlObj(CollectionControl collectionControl) {
        this.mControl = collectionControl;
    }

    public void waitRecordThreadExit() throws InterruptedException {
        for (int i = 0; this.m_recording_thread_running && i < 10; i++) {
            Thread.sleep(50L);
        }
    }
}
