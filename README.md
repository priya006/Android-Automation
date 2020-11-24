# Android Automation

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