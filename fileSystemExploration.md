# Exploration of the File Systems
## Useful commands
### Searching for Directories and Files

if you ever get a "permission denied" you have to make sure that you are using adb with root access. Meaning execute `adb root` before `adb shell` or any other adb command.

**Using find command with adb:**

```
# enter robot shell
adb shell
find <enter_command_options_here>
find <enter_different_command_options_here>

# exit robot shell
exit
```

or

```
# keep using adb for every command
adb shell find <enter_command_options_here>
adb shell find <enter_different_command_options_here>
```


**Print all subdirectories of a specific depth:**

```
# find <path_of_starting_dir> -mindepth 2 -maxdepth 3 -type d
find ./system/app -mindepth 2 -maxdepth 3 -type d
```

Instead of specifing a complete path for `<path_of_starting_dir>` there are the options: 
- to look in the dir that you are currently in: `find . `
- to look in all dirs starting from the root directory: `find / `


**Looking for directories that contain a specific keyword:**

```
# find <path_of_starting_dir> -name *<keyword>*
find / -name *face*
```

**Exclude a directory that should not be searched:**

```
# find <path_of_starting_dir> -path "<uninteresting_dir>" -prune -o -name "*<keyword>*" -print
find . -path "./proc" -prune -o -name "*face*" -print
```

[StackExchange: adb command to search the filesystem](https://android.stackexchange.com/questions/20081/adb-command-to-search-the-filesystem)

[StackExchange: List subdirectories only n level deep](https://unix.stackexchange.com/questions/93323/list-subdirectories-only-n-level-deep)

### Move Directories and Files

Copy files or directories from the robot to your local machine:

```
# adb pull "<file_or_dir_name>"
adb pull "/sdcard/Folder1"
```

[StackOverflow: How do I adb pull ALL files of a folder](https://stackoverflow.com/questions/10050925/how-do-i-adb-pull-all-files-of-a-folder-present-in-sd-card)

## Analyzing Files
### Android .apk Files
Android .apk files can be analyzed/reverse engineered in a few ways.

#### Unzip:
If you are only interested into accessing the app resources (like images, videos, .xml files,...) this is the easiest option in my opinion.

Android .apk files are just fancy .zip files, so if you rename the file from `my_app.apk` to `my_app.zip`, you can just extract the contents e.g. via command line.

```
# unzip <filename>.zip -d <new_directory_for_extracted_contents>/
unzip my_app.zip -d my_app_unzipped/
```

#### Using Android Studio:

Open Android Studion, go to *Build > Analyze APK* and select the .apk file you want to analyse. This is good for looking for code pieces (you cannot see the whole code, but there are indicators on how the app is programmed)

#### Using APK Tool:

Mix of Android Studio code pieces as .smali files and accessible resource files (like images, videos, .xml files,...).

Follow this guide to install: [Apktool - Install Guide](https://apktool.org/docs/install)

```
# apktool decode <filename>.apk -o <new_directory_for_extracted_contents>
apktool decode my_app.apk -o my_app_apktool
```

[StackOverflow: How to view the contents of an Android APK file](https://stackoverflow.com/questions/3599210/how-to-view-the-contents-of-an-android-apk-file)

[StackOverflow: Extract code from .aar file Android](https://stackoverflow.com/questions/34241411/extract-code-from-aar-file-android)


## Linux

:bangbang: THE LINUX SYSTEM IS NOT ABLE TO CONNECT TO WIFI NETWORKS!!

| System Property | Value |
| --- | --- |
| Screen Size | minimum 320 x 200, current 480 x 480, maximum 8192 x 8192|
| Storage Space | 3.3Gb (total), 2.8Gb (free), 3.0Gb (available) | (command: free -h)


Python2 version 2.7.16 (Default)
Python3 version 3.7.3

pip and pip3 are not installed!

not wifi access, driver not installed?

Reboot robot: adb shell reboot
Shutdown robot: adb shell reboot -p
adb shell reboot --poweroff


### Change System Language to English (or anything else)


[https://linuxconfig.org/change-system-language-on-ubuntu-20-04-from-command-line](https://linuxconfig.org/change-system-language-on-ubuntu-20-04-from-command-line)


### Control Robot Hardware
#### Microphone

[https://stackoverflow.com/questions/56618667/how-to-control-the-volume-of-raspberry-pi-with-python-3](https://stackoverflow.com/questions/56618667/how-to-control-the-volume-of-raspberry-pi-with-python-3)

[https://wiki.ubuntuusers.de/amixer/](https://wiki.ubuntuusers.de/amixer/)

[https://unix.stackexchange.com/questions/86321/how-can-i-display-the-contents-of-a-text-file-on-the-command-line](https://unix.stackexchange.com/questions/86321/how-can-i-display-the-contents-of-a-text-file-on-the-command-line)

[https://pypi.org/project/pyalsaaudio/](https://pypi.org/project/pyalsaaudio/)

#### Speakers

#### Motors

#### Screen

