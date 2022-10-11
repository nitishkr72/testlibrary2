package com.juspay.mylibrary

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.facebook.react.BuildConfig
import com.facebook.react.LifecycleState
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
//import com.facebook.react.common.LifecycleState
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader

class MyReactActivity : Activity(), DefaultHardwareBackBtnHandler {
    private lateinit var reactRootView: ReactRootView
    private lateinit var reactInstanceManager: ReactInstanceManager
    val initialProperties = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("letitbe", this.toString())
        SoLoader.init(this, false)
        reactRootView = ReactRootView(this)
      //  val packages: List<ReactPackage> = PackageList(application).packages
        // Packages that cannot be autolinked yet can be added manually here, for example:
        // packages.add(MyReactNativePackage())
        // Remember to include them in `settings.gradle` and `app/build.gradle` too.
        reactInstanceManager = ReactInstanceManager.builder()
            .setApplication(application)
            .setCurrentActivity(this)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("index")
            .addPackage(MainReactPackage())
            .addPackage(TestConnectNativePackage())
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()
        // The string here (e.g. "MyReactNativeApp") has to match
        // the string in AppRegistry.registerComponent() in index.js
        //initialProperties need to be set for props communication

        initialProperties.putString("message_from_native", intent?.extras?.get("message_from_native")?.toString())
        reactRootView?.startReactApplication(reactInstanceManager, "rnandroiddemoapp", initialProperties)
        setContentView(reactRootView)
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }
}