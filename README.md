# Android Automation Using Espresso Framework

##### Table of Contents
-----------------------
[How to Create Simple Android Application in Android Studio](https://github.com/priya006/Android-Automation/#how-to-create-simple-android-application-in-android-studio)  
[How To Record Espresso Test with UI Recorder](https://github.com/priya006/Android-Automation/#how-to-record-espresso-test-with-ui-recorder) 
[How to Generate Test Reports](https://github.com/priya006/Android-Automation/#how-to-generate-test-reports)
[How to Find Elements using UI Automator
](https://github.com/priya006/Android-Automation/#how-to-find-elements-using-ui-automator)
[How to Run Espresso Test in BrowserStack
](https://github.com/priya006/Android-Automation/#how-to-run-espresso-test-in-browserstack)
[Run Tests in Parallel using BrowserStack in multiple devices[Compatibility Testing]
](https://github.com/priya006/Android-Automation/#run-tests-in-parallel-using-browserstack-in-multiple-devicescompatibility-testing)
[How to take Screenshot in BrowserStack using SpoonFramework
](https://github.com/priya006/Android-Automation/#how-to-take-screenshot-in-browserstack-using-spoonframework)
[Take Screenshot using SpoonFramework
](https://github.com/priya006/Android-Automation/#take-screenshot-using-spoonframework)
[How to look into Device logs
](https://github.com/priya006/Android-Automation/#how-to-look-into-device-logs)
[Important Places to look into Android Project
](https://github.com/priya006/Android-Automation/#important-places-to-look-into-android-project)

## How to Create Simple Android Application in Android Studio
-------------------------------------------------------------
1. In Android Studio IDE click File > New > New Project and select Bottom Navigation Activity
2. Name the project and select a programming language

Cheer! You have created an Android app  Template:)

## How To Record Espresso Test with UI Recorder
-----------------------------------------------
1. Android Studio > Run > Record Espresso Test
2. In the Android emulator open the app to be tested and record all actions and assertions
![UI_TestRecorder](https://github.com/priya006/Android_Autmation/blob/master/UI_Test_Recorder.png)
3. Save and a Test Class file generated

## How to Generate Test Reports
---------------------------------
1. Run the execute in command line using the command `./gradlew connectedAndroidTest`
2. Test reports could be found in the location `path_to_your_project/module_name/build/outputs/androidTest-results/connected/`
![XML_TestReport](https://github.com/priya006/Android_Autmation/blob/master/XML_Test_Report.png)

## How to Find Elements using UI Automator
-------------------------------------------
1. cd to $ANDROID_HOME/tools/bin
2. Open the app to be tested in emulator
3. Run the command ./uiautomatorviewer  from terminal
4. UI Automator viewer appears
![UIAutomatorViewer](https://github.com/priya006/Android_Autmation/blob/master/%20UI_Automator_Viewer.png)
![Viewhiererchy](https://github.com/priya006/Android_Automation/blob/master/View_hiererchy.png)

Note: resource_id and text are the most common type of locators
Tip: Element could also be located from navigate to `res` folder on the left side, open up a `menu` folder and select `bottom_nav_menu.xml`

## How to Run Espresso Test in BrowserStack
-------------------------------------------
1. Create a user account in [browserstack](https://www.browserstack.com/users/sign_in)
2. Copy the `username` and `access key`
3. Upload your app in browser stack. `app_url` will be received
```
curl -u "<UserName>":<AccessKey>" \
-X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/app" \
-F "file=@<pathtoapp-debug.apk>"
```
4.Upload test suite to browserstack
```
curl -u "<UserName>:<AccessKey>" \
-X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/test-suite" \
-F "file=@<pathtoapp-debug-androidTest.apk>"
```
5.Execute the test in browser stack. With the Selected device from browser stack.
```
curl -u "<UserName>:<AccessKey>" \
-X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/build" \
-d '{"app": "<app_url>", "testSuite": "<test_url>", "devices": ["Google Pixel 3-9.0"]}' \
-H "Content-Type: application/json"
```
6.Monitor the test results in [Browser Stack App Automate](https://app-automate.browserstack.com/dashboard/v2)
![BrowserStackDashboard](https://github.com/priya006/Android-Automation/blob/master/BrowserStack_Dashboard.png)

## Run Tests in Parallel using BrowserStack in multiple devices[Compatibility Testing]
------------------------------------------------------------------------------------
**Assumptions:** Please follow the above mentioned Step 1 to Step 4

1. Execute the test by firing the following curl command

```
curl -u "<UserName>:<AccessKey>" \
-X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/build" \
-d '{"devices": ["Google Pixel 3-9.0", "Samsung Galaxy S10e-9.0"], "app": "<app_url>", "testSuite": "<test_url>"}' \
-H "Content-Type: application/json"
```
2. Monitor the results in [Browser Stack App Automate](https://app-automate.browserstack.com/dashboard/v2)
![BrowserStackDashboard](https://github.com/priya006/Android-Automation/blob/master/CompatibilityTesting.png)

## How to take Screenshot in BrowserStack using SpoonFramework
--------------------------------------------------------------
1.Add the line `Spoon.screenshot(ActivityName, tagName);` in test
2.Add `"enableSpoonFramework": true` to the `curl` command
```
 curl -u "<UserName>:<AccessKey>" \
-X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/build" \
-d '{"enableSpoonFramework": true, "devices": ["Google Pixel 3-9.0", "Samsung Galaxy S10e-9.0"], "app": "<app_url>", "testSuite": "<test_url>"}' \
-H "Content-Type: application/json"
```

## Take Screenshot using SpoonFramework
--------------------------------------
1. Add spoon to gradle project. In `/app/build.gradle` add the line
`androidTestImplementation 'com.squareup.spoon:spoon-client:1.3.2'`

2. Add below permission lines to `AndroidManifest.xml`
```
 <uses-permission
        android:name="android.permission.WRITE_EXTERNAL_STORAGE"
        tools:remove="android:maxSdkVersion" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 ```

3.Turn on App permission in Pixel API 27 (Emulator).

`Settings > Search with the keyword Permission > Click App Permissions > Select the App under test > Select  Permissions > Toggle Storage ON`
![Storage](https://github.com/priya006/Android-Automation/blob/master/Storage_ON_API27_Pixel.png)

## How to look into Device logs
-------------------------------
Device logs are system logs specific to your application generated by Android logcat.

1.Fire the curl command and monitor [Browser Stack App Automate](https://app-automate.browserstack.com/dashboard/v2)
```
curl -u "<UserName>:<AccessKey>" \
-X POST "https://api-cloud.browserstack.com/app-automate/espresso/v2/build" \
-d '{"deviceLogs": true, "devices": ["Google Pixel 3-9.0", "Samsung Galaxy S10e-9.0"], "app": "<app_url>", "testSuite": "<test_url>"}' \
-H "Content-Type: application/json"
```
2. Click the Test method > Device logs > Click the hyperlink View Raw Device logs
![Device_Logs](https://github.com/priya006/Android-Automation/blob/master/Device_Logs.png)

## Important Places to look into Android Project
-----------------------------------------------
   - AndroidManifest.xml
   - app/build.gradle
   - app/src/main/res/activity_main.xml
   - Source code lives in `Android_APP/app/src/main/java`
   - Espresso Test could be found  `Android_APP/app/src/androidTest/java`
