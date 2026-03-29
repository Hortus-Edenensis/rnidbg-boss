package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class vk3 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements MediaPlayer.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaPlayer.OnCompletionListener f21466a;
        public final /* synthetic */ MediaPlayer b;
        public final /* synthetic */ AssetFileDescriptor c;

        public a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer mediaPlayer, AssetFileDescriptor assetFileDescriptor) {
            this.f21466a = onCompletionListener;
            this.b = mediaPlayer;
            this.c = assetFileDescriptor;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            MediaPlayer.OnCompletionListener onCompletionListener = this.f21466a;
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

    /* JADX INFO: compiled from: SearchBox */
    public class b implements MediaPlayer.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaPlayer.OnCompletionListener f21467a;
        public final /* synthetic */ MediaPlayer b;
        public final /* synthetic */ AssetFileDescriptor c;

        public b(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer mediaPlayer, AssetFileDescriptor assetFileDescriptor) {
            this.f21467a = onCompletionListener;
            this.b = mediaPlayer;
            this.c = assetFileDescriptor;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            MediaPlayer.OnCompletionListener onCompletionListener = this.f21467a;
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

    public static boolean b() {
        try {
            AudioManager audioManager = (AudioManager) AppContext.getContext().getSystemService("audio");
            boolean zA = a();
            boolean zIsBluetoothA2dpOn = audioManager.isBluetoothA2dpOn();
            if (!zA || zIsBluetoothA2dpOn) {
                if (!audioManager.isBluetoothScoOn()) {
                    return false;
                }
                audioManager.setBluetoothScoOn(false);
                audioManager.stopBluetoothSco();
                audioManager.setMode(0);
                return false;
            }
            try {
                audioManager.setMode(0);
                audioManager.setBluetoothScoOn(true);
                audioManager.startBluetoothSco();
                audioManager.setMode(2);
                return true;
            } catch (Exception unused) {
                return true;
            }
        } catch (Exception unused2) {
            return false;
        }
    }

    public static void c(Context context, String str, boolean z, MediaPlayer.OnCompletionListener onCompletionListener) {
        AssetFileDescriptor assetFileDescriptorOpenFd;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType((z || b()) ? 0 : 3);
        mediaPlayer.setLooping(false);
        try {
            assetFileDescriptorOpenFd = context.getAssets().openFd(str);
        } catch (Exception e) {
            e = e;
            assetFileDescriptorOpenFd = null;
        }
        try {
            mediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
            mediaPlayer.setOnCompletionListener(new a(onCompletionListener, mediaPlayer, assetFileDescriptorOpenFd));
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e2) {
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

    public static void d(Context context, String str, boolean z, MediaPlayer.OnCompletionListener onCompletionListener) {
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
            mediaPlayer.setOnCompletionListener(new b(onCompletionListener, mediaPlayer, assetFileDescriptorOpenFd));
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
