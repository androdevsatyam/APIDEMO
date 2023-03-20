package com.satyam.apidemo

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import androidx.lifecycle.lifecycleScope
import com.satyam.apidemo.helpers.Global
import kotlinx.coroutines.launch


/**
 * Created by SATYAM on 20/03/23.
 * Associated with IOVRVF
 * Contact me on: satyamiovrvf@gmail.com
 */
class MyAccessibility : AccessibilityService() {
    val TAG = "MyAccessibility"

    override fun onInterrupt() {}

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.d(TAG, "onAccessibilityEvent: ${event?.eventType}")
        if (event != null) {
            if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED)
                if (event.packageName.contains("w4b"))
                    Global.makeToast(baseContext, "Bus Whatsapp Opened")
                else
                    Global.makeToast(baseContext, "Whatsapp Opened")
        }
    }
}