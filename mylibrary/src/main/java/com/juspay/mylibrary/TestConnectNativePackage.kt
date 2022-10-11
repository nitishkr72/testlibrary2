package com.juspay.mylibrary

import android.util.Log
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import java.util.*

class TestConnectNativePackage : ReactPackage {
    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        return emptyList()
    }

    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        Log.d("letitbe", this.toString())
        val modules: MutableList<NativeModule> = ArrayList()
        modules.add(TestConnectNativeModule(reactContext))
        return modules
    }
}