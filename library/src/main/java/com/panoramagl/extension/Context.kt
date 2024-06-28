package com.panoramagl.extension

import android.content.Context
import android.hardware.display.DisplayManager
import android.view.Display
import android.view.Surface
import com.panoramagl.ios.enumerations.UIDeviceOrientation

internal fun Context?.getUIDeviceOrientation() : UIDeviceOrientation?{
    val displayManager = (this?.getSystemService(Context.DISPLAY_SERVICE) as? DisplayManager) ?: return null
    val rotation = displayManager.getDisplay(Display.DEFAULT_DISPLAY).rotation
    return when (rotation){
        Surface.ROTATION_0 -> UIDeviceOrientation.UIDeviceOrientationPortrait
        Surface.ROTATION_90 -> UIDeviceOrientation.UIDeviceOrientationLandscapeLeft
        Surface.ROTATION_180 -> UIDeviceOrientation.UIDeviceOrientationPortraitUpsideDown
        Surface.ROTATION_270 -> UIDeviceOrientation.UIDeviceOrientationLandscapeRight
        else -> null
    }
}