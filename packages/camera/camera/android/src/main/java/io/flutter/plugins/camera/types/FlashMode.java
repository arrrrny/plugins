// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.camera.types;

// Mirrors flash_mode.dart
public enum FlashMode {
  off("off"),
  auto("auto"),
  always("always"),
  torch("torch");

  private final String strValue;

  FlashMode(String strValue) {
    this.strValue = strValue;
  }

  public static FlashMode getValueForString(String modeStr) {
    for (FlashMode value : values()) {
      if (value.strValue.equals(modeStr)) return value;
    }
    return null;
  }

  @Override
  public String toString() {
    return strValue;
  }
}