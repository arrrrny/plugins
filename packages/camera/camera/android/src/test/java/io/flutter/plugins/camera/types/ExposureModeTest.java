// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.camera.types;

import static org.junit.Assert.assertEquals;

import io.flutter.plugins.camera.features.exposurelock.ExposureMode;
import org.junit.Test;

public class ExposureModeTest {

  @Test
  public void getValueForString_returns_correct_values() {
    assertEquals(
        "Returns ExposureMode.auto for 'auto'",
        ExposureMode.getValueForString("auto"),
        ExposureMode.auto);
    assertEquals(
        "Returns ExposureMode.locked for 'locked'",
        ExposureMode.getValueForString("locked"),
        ExposureMode.locked);
  }

  @Test
  public void getValueForString_returns_null_for_nonexistant_value() {
    assertEquals(
        "Returns null for 'nonexistant'", ExposureMode.getValueForString("nonexistant"), null);
  }

  @Test
  public void toString_returns_correct_value() {
    assertEquals("Returns 'auto' for ExposureMode.auto", ExposureMode.auto.toString(), "auto");
    assertEquals(
        "Returns 'locked' for ExposureMode.locked", ExposureMode.locked.toString(), "locked");
  }
}
