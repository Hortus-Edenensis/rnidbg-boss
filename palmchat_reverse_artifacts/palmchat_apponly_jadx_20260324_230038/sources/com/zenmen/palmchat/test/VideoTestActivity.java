package com.zenmen.palmchat.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.zenmen.media.player.MagicVideoView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.video.recorder.CameraView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VideoTestActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Button f15569a;
    public CameraView b;
    public MagicVideoView c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoTestActivity.this.b.isRecording()) {
                VideoTestActivity.this.b.stopRecord();
                VideoTestActivity.this.f15569a.setText("开始录制");
            } else {
                VideoTestActivity.this.b.startRecord();
                VideoTestActivity.this.f15569a.setText("停止录制");
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_test);
        setTitle("测试视频录制");
        this.b = (CameraView) findViewById(R.id.camera_view);
        Button button = (Button) findViewById(R.id.start_record_btn);
        this.f15569a = button;
        button.setOnClickListener(new a());
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.b.stopRecord();
        this.b.stopPreview();
        this.f15569a.setText("开始录制");
        this.c.stop();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.b.startPreview();
    }
}
