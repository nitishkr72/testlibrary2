package com.juspay.mylibrary

import android.content.Intent
import android.util.Log
//import com.example.rnandroiddemoapp.SecondActivity
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class TestConnectNativeModule internal constructor(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
  override fun getName(): String {
    Log.d("letitbe", this.toString())
    return "TestConnectNative"
  }

  @ReactMethod
  fun sendMessageToNative(rnMessage: String?) {
    Log.d("This log is from java", rnMessage ?: "")
  }

  @ReactMethod
  fun sendCallbackToNative(rnCallback: Callback) {
    rnCallback.invoke("A greeting from java")
  }

  @ReactMethod
  fun finishActivity() {
    currentActivity?.finish()
  }

//  @ReactMethod
//  fun goToSecondActivity() {
//    Log.d("letitbe", this.toString())
//    val intent = Intent(currentActivity, SecondActivity::class.java)
//    currentActivity?.startActivity(intent)
//  }

  companion object

}
