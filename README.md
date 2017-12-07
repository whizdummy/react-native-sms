
# react-native-sms
Cross-platform SMS messaging functionality built for iOS, Android and Windows.

## Getting started

1) Open **package.json** and insert it manually:
`"react-native-sms": "file:./<directory>/react-native-sms"` where **<directory>** is where the library is located.
2) `$ npm install react-native-sms`

### Mostly automatic installation

`$ react-native link react-native-sms`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-sms` and add `RNSms.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNSms.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNSmsPackage;` to the imports at the top of the file
  - Add `new RNSmsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-sms'
  	project(':react-native-sms').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-sms/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-sms')
  	```

#### Windows (Soon, if needed)
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNSms.sln` in `node_modules/react-native-sms/windows/RNSms.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Sms.RNSms;` to the usings at the top of the file
  - Add `new RNSmsPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNSms from './<directory>/react-native-sms';

RNSms.sendMessage(['09396531608'], 'Your Message');
```

## Todo
* Callbacks (if needed)