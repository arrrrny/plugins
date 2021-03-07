package io.flutter.plugins.camera.features.exposurelock;

import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import io.flutter.plugins.camera.CameraProperties;
import io.flutter.plugins.camera.features.CameraFeature;
import io.flutter.plugins.camera.types.ExposureMode;

/**
 * Exposure lock controls whether or not exposure mode is currenty locked or automatically metering.
 */
public class ExposureLock implements CameraFeature<ExposureMode> {
  private boolean isSupported;
  private ExposureMode currentSetting = ExposureMode.auto;

  @Override
  public ExposureMode getValue() {
    return currentSetting;
  }

  @Override
  public void setValue(ExposureMode value) {
    this.currentSetting = value;
  }

  // Available on all devices.
  @Override
  public boolean isSupported(CameraProperties cameraProperties) {
    return true;
  }

  @Override
  public void updateBuilder(CaptureRequest.Builder requestBuilder) {
    Log.i("Camera", "updateExposureMode");

    // Don't try to set if the current camera doesn't support it.
    if (!isSupported) {
      return;
    }

    switch (currentSetting) {
      case locked:
        requestBuilder.set(CaptureRequest.CONTROL_AE_LOCK, true);
        break;
      case auto:
      default:
        requestBuilder.set(CaptureRequest.CONTROL_AE_LOCK, false);
        break;
    }
  }
}
