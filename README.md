# Rux Robot Test Documentation
Documentation of what I tried out with and can find out about Rux Robot by LeTianPai.

# Switching from Android to Linux Debian
Based on [Android/Linux Debian Dual System Switching Tutorial](https://global.letianpai.com/all/?p=1675&v=8528837ceeea) and [Flashing Tutorial â Full ROOT Version](https://global.letianpai.com/all/?p=1680&v=8528837ceeea) by LeTianPai.

## Prepare ADB Tools (for macOS)
### 1. Install Android Studio
### 2. Find where Android SDK is installed
for me it was this directory:
```/Users/<user_name>/Library/Android/sdk```

[*StackOverflow:* Finding Android SDK on Mac and adding to PATH](https://stackoverflow.com/questions/34532063/finding-android-sdk-on-mac-and-adding-to-path)

### 3. Check if adb command is working
```
cd ~/Library/Android/sdk/platform-tools/
adb devices
```

If there's a `command not found` error `adb` is not in your PATH yet, where the shell looks for executables. 
[*StackOverflow:* Not able to access adb in OS X through Terminal, "command not found"](https://stackoverflow.com/questions/7609270/not-able-to-access-adb-in-os-x-through-terminal-command-not-found)

**Add ADB tools to your PATH:**
1. open shell profile (`.bash_profile` in my case) `open -e  $HOME/.bash_profile`
2. add PATH to the end of the file and save
   ```
   export ANDROID_HOME="$HOME/Library/Android/sdk/"
   export PATH="$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools:$PATH"
   ```
3. run `source ~/.bash_profile`
4. open new tab and test abd command again
