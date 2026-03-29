package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class wk3 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements MediaPlayer.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaPlayer.OnCompletionListener f21738a;
        public final /* synthetic */ MediaPlayer b;
        public final /* synthetic */ AssetFileDescriptor c;

        public a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer mediaPlayer, AssetFileDescriptor assetFileDescriptor) {
            this.f21738a = onCompletionListener;
            this.b = mediaPlayer;
            this.c = assetFileDescriptor;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            MediaPlayer.OnCompletionListener onCompletionListener = this.f21738a;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(mediaPlayer);
            }
            this.b.release();
            try {
                this.c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            int profileConnectionState = defaultAdapter.getProfileConnectionState(2);
            int profileConnectionState2 = defaultAdapter.getProfileConnectionState(1);
            int profileConnectionState3 = defaultAdapter.getProfileConnectionState(3);
            if (profileConnectionState != 2) {
                profileConnectionState = profileConnectionState2 == 2 ? profileConnectionState2 : profileConnectionState3 == 2 ? profileConnectionState3 : -1;
            }
            if (profileConnectionState != -1) {
                return true;
            }
        }
        return false;
    }

    public static void b(Context context, String str, boolean z, MediaPlayer.OnCompletionListener onCompletionListener) {
        AssetFileDescriptor assetFileDescriptorOpenFd;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(z ? 0 : 3);
        mediaPlayer.setLooping(false);
        try {
            assetFileDescriptorOpenFd = context.getAssets().openFd(str);
        } catch (IOException e) {
            e = e;
            assetFileDescriptorOpenFd = null;
        }
        try {
            mediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
            mediaPlayer.setOnCompletionListener(new a(onCompletionListener, mediaPlayer, assetFileDescriptorOpenFd));
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e2) {
            e = e2;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(null);
            }
            e.printStackTrace();
            mediaPlayer.stop();
            mediaPlayer.release();
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
