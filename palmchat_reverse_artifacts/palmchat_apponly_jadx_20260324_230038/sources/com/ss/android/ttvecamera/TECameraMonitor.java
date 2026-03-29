package com.ss.android.ttvecamera;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECameraMonitor {
    public static final String TE_PREVIEW_CAMERA_RESOLUTION = "te_preview_camera_resolution";
    public static final String TE_RECORD_CAMERA2_CREATE_SESSION_COST = "te_record_camera2_create_session_cost";
    public static final String TE_RECORD_CAMERA2_CREATE_SESSION_RET = "te_record_camera2_create_session_ret";
    public static final String TE_RECORD_CAMERA_1_START_PREVIEW_COST = "te_record_camera1_start_preview_cost";
    public static final String TE_RECORD_CAMERA_1_STOP_PREVIEW_COST = "te_record_camera1_stop_preview_cost";
    public static final String TE_RECORD_CAMERA_2_CLOSE_SESSION_COST = "te_record_camera2_close_session_cost";
    public static final String TE_RECORD_CAMERA_2_SET_REPEATING_REQUEST_COST = "te_record_camera2_set_repeating_request_cost";
    public static final String TE_RECORD_CAMERA_CLOSE_COST = "te_record_camera_close_cost";
    public static final String TE_RECORD_CAMERA_CLOSE_IN_MAIN_THREAD = "te_record_camera_close_in_main_thread";
    public static final String TE_RECORD_CAMERA_COLLECT_CAPBILITIES_COST = "te_record_camera_collect_capbilities_cost";
    public static final String TE_RECORD_CAMERA_DEPTH_CAPACITY = "te_record_camera_depth_capacity";
    public static final String TE_RECORD_CAMERA_DIRECTION = "te_record_camera_direction";
    public static final String TE_RECORD_CAMERA_ERR_RET = "te_record_camera_err_ret";
    public static final String TE_RECORD_CAMERA_FRAME_RATE = "te_record_camera_frame_rate";
    public static final String TE_RECORD_CAMERA_FRONT_BACK_MULTICAM_COMBOS = "te_record_camera_front_back_multicam_combos";
    public static final String TE_RECORD_CAMERA_HARDWARE_LEVEL = "te_record_camera_hardware_level";
    public static final String TE_RECORD_CAMERA_HIGH_SPEED_VIDEO_FPS_RANGE = "te_record_camera_high_speed_video_fps_range";
    public static final String TE_RECORD_CAMERA_IS_SUPPORT_ARCORE = "te_record_camera_is_support_arcore";
    public static final String TE_RECORD_CAMERA_LOGICAL_MULTI_CAMERA_CAPACITY = "te_record_camera_logical_multi_camera_capacity";
    public static final String TE_RECORD_CAMERA_MANUAL_3A_CAPACITY = "te_record_camera_manual_3a_capability";
    public static final String TE_RECORD_CAMERA_MAX_FPS = "te_record_camera_max_fps";
    public static final String TE_RECORD_CAMERA_MAX_LAG_TASK_COST = "te_record_camera_max_lag_task_cost";
    public static final String TE_RECORD_CAMERA_OPEN_COST = "te_record_camera_open_cost";
    public static final String TE_RECORD_CAMERA_OPEN_INFO = "te_record_camera_open_info";
    public static final String TE_RECORD_CAMERA_OPEN_RET = "te_record_camera_open_ret";
    public static final String TE_RECORD_CAMERA_PREVIEW_FIRST_FRAME_COST = "te_record_camera_preview_first_frame_cost";
    public static final String TE_RECORD_CAMERA_PREVIEW_RET = "te_record_camera_preview_ret";
    public static final String TE_RECORD_CAMERA_PUSH_CLOSE_TASK_TIME = "te_record_camera_push_close_task_time";
    public static final String TE_RECORD_CAMERA_PUSH_OPEN_TASK_TIME = "te_record_camera_push_open_task_time";
    public static final String TE_RECORD_CAMERA_SIZE = "te_record_camera_size";
    public static final String TE_RECORD_CAMERA_STABILIZATION = "te_record_camera_stabilization";
    public static final String TE_RECORD_CAMERA_START = "te_record_camera_task_time_out_count";
    public static final String TE_RECORD_CAMERA_SUPPORT_APERTURES = "te_record_camera_support_apertures";
    public static final String TE_RECORD_CAMERA_SUPPORT_EXTENSIONS = "te_record_camera_support_extensions";
    public static final String TE_RECORD_CAMERA_SUPPORT_FPS_RANGE = "te_record_camera_support_fps_range";
    public static final String TE_RECORD_CAMERA_SUPPORT_PREVIEW_SIZE = "te_record_camera_support_preview_size";
    public static final String TE_RECORD_CAMERA_TASK_TIME_OUT_COUNT = "te_record_camera_task_time_out_count";
    public static final String TE_RECORD_CAMERA_TYPE = "te_record_camera_type";
    public static final String TE_RECORD_SEND_CAPTURE_COMMAND_COST = "te_record_send_capture_command_cost";
    private static volatile IMonitor mMonitor;

    /* JADX INFO: compiled from: SearchBox */
    public interface IMonitor {
        void perfDouble(String str, double d);

        void perfLong(String str, long j);

        void perfRational(String str, float f, float f2);

        void perfString(String str, String str2);
    }

    public static void perfDouble(String str, double d) {
        if (mMonitor != null) {
            mMonitor.perfDouble(str, d);
        }
    }

    public static void perfLong(String str, long j) {
        if (mMonitor != null) {
            mMonitor.perfLong(str, j);
        }
    }

    public static void perfRational(String str, float f, float f2) {
        if (mMonitor != null) {
            mMonitor.perfRational(str, f, f2);
        }
    }

    public static void perfString(String str, String str2) {
        if (mMonitor != null) {
            mMonitor.perfString(str, str2);
        }
    }

    public static void register(IMonitor iMonitor) {
        mMonitor = iMonitor;
    }
}
