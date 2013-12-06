YAYMan
======

**DISCLAIMER:**
User accepts all responsibility for effects this program has on user's jukebox files and/or anything else on user's computer.

## YAYMan Readme

If this is your first time using YAYMan, you should probably read through all of this information.

The latest version can be downloaded [here](http://code.google.com/p/yayman/downloads/list).

Images courtesy of http://led24.de/iconset/

### Table of
Contents

- [Using YAYMan](#using-yayman)
- [YAMJ Information](#yamj-information)
- [YAYMan Initial Setup Instructions](#yayman-initial-setup-instructions)
- [YAYMan Update Instructions](#yayman-update-instructions)
- [Note for Linux Users](#note-for-linux-users)
- [Revision History](HISTORY.md)

### Using YAYMan

To edit a field, double-click it, make your change, and then hit "enter" or "return.".
If you don't want to make the change, hit "escape" when editing. To change a video's poster or fanart, click on the displayed poster and select from the menu.
To cycle through displaying the video's poster, fanart, or banner (when applicable), hover over the art and scroll the mousewheel.
You can zoom the art be either clicking the middle mouse button and scrolling the mouse wheel or by holding shift, control, or alt and scrolling the mouse wheel.

YAYMan now has the ability for you to trigger an update to your library via a HTTP request.
You need to turn this feature on in the preferences and select the port you wish to use (1338 by default).
There is very little security built in at this point in time, so if the computer running YAYMan is exposed to the Internet, anybody who knows your computer IP and the port YAYMan is listening on can trigger an update.
To trigger an update, send a request to: http://IP:port/yayman?processLibrary

Yes, the "Genres" tab is greyed out. This is normal because genre editing hasn't been implemented in YAYMan yet.

### YAMJ Information

Some background information on how YAMJ works will help you to understand how YAYMan works, and what might be wrong if YAYMan is not working properly.

When YAMJ processes your video library, it loads settings from two different locations (actually, three or four; but we're only interested in two).
First, it loads the default settings.
The default properties file, moviejukebox-default.properties is located in the yamj/properties folder.
You will **_not_** want to edit this file.
Second, YAMJ loads your user-defined properties file.
This is the file where you specify the settings you want to change from their default values.
At minimum, you need to make sure the mjb.jukeboxRoot value is set to your jukebox output folder.
If you don't set this, then your movies will be listed but you won't be able to edit any of the information for them.

How does YAMJ know which folders to scan to find the videos for your jukebox?
You can either supply YAMJ the path to a single folder or the path to a library xml file. YAYMan uses the library xml file method.
YAYMan will allow you to create a library xml file.
Once again, you **need** this library file for YAYMan to function.
You library XML file tells YAMJ two key things. First, it tells YAMJ/YAYMan where your videos are _relative to your computer_.
Second, it tells YAMJ/YAYMan where your videos are _relative to your NMT_.
The Local Path is the first piece of information, and Player Path is the second.
Set Local Path to the folder that contains your videos as you access it from your computer.
Set the local path according to how you access the videos from your computer. Set the player path according to how your access the videos from your NMT.

Once you've supplied these things to YAMJ, it creates your movie jukebox.
Depending on your settings, this jukebox may be located any number of places.
Again, the mjb.jukeboxRoot property specifies where your jukebox is located.
YAYMan works by editing these jukebox files generated by YAMJ.
If you delete or lose the jukebox files, you'll have to process your library with YAMJ before you can edit individual video information with YAYMan.

### YAYMan Initial Setup Instructions

If you already have YAMJ installed, then you know where your YAMJ folder is for the following discussion.
If you do not already have YAMJ installed, then just create a folder wherever you want YAMJ be installed, and that is your YAMJ folder.

1. Put "YAYMan.jar"
     into your YAMJ folder (not your jukebox folder)
2. Put the below files in your YAMJ/lib folder
    - appframework-1.0.3.jar
    - cling-core-1.0.jar
    - swing-worker-1.1.jar
    - teleal-common-1.0.11.jar

3. Run YAYMan.jar (you can double-click it in Windows)
4. When prompted, tell YAYMan to download YAMJ (this should only happen if you do not already have YAMJ installed)
5. You can choose to either run the wizard or set up manually. Below are the manual setup instructions.
6. Click Edit ? Preferences
    - Make sure YAYMan is using the correct library xml file
    - Make sure YAYMan is using the correct user-defined properties file
    - If either of the above are incorrect, click on them and choose the correct file.
    - Click on your properties file, choose Edit, and verify that mjb.jukeboxRoot and mjb.detailsDirName are set properly (see below)

**Vital Variables: mjb.jukeboxRoot and mjb.detailsDirName**

In order for YAYMan to function, the mjb.detailsDirName and mjb.jukeboxRoot variables must be set properly.
If YAYMan displays your videos in the list, but won't display any of the details for any of your videos, then you haven't set one or both of these variables properly.

mjb.jukeboxRoot
is the _path_ to the folder that contains index.htm and your details folder.

mjb.detailsDirName
is the _folder name_ of the details folder inside of your jukebox root.
It contains all of the images, XML files, and html pages of your jukebox.
By default, this variable is "Jukebox".
If there is a "Jukebox" folder inside of your jukebox root, and it contains all your details files, you don't need to set this variable.

Therefore, if all of your jukebox details files are in "C:\Junk\Propaganda\yamj\data", your mjb.jukeboxRoot is "C:/Junk/Propaganda/yamj" and your mjb.detailsDirname is "data".
Note that you shouldn't enclose these values in quotes in your properties file.
Also note that you should use forward slashes (/) rather than backslashes (\).

You can set these variables from YAYMan by clicking Edit ? Preferences, clicking on your selected properties file, and then choosing Edit.
These two variables are under the "General" category.

**Running YAYMan as a Native Application**

I have created "launcher" applications for Windows and Macs which allow you to run YAYMan like a native application on each system.
You can download them [here](http://code.google.com/p/yayman/downloads/list).
To install, just place them in the same folder as YAYMan.jar.

**Setting up NMJ Conversion**

If you want use convert your YAMJ jukebox to NMJ, you'll have to download the [ConvertToNMJ utility](http://code.google.com/p/yayman/downloads/list).
This program was created by Syabas and can run all on its own.
To install it to work with YAYMan, put "com.syabas.tonmjdb-1.8.0-20101208.jar" and "metadata-extractor-2.4.0-beta-1.jar" in your YAMJ/lib folder and put "Video_Group_Name.xml" in your YAMJ/ folder.
That should do it.

### YAYMAN Update Instructions

Put "YAYMan.jar" into your YAMJ folder, replacing the old YAYMan.jar.
Also, make sure there aren't any new .jar files in the zip file's /lib/ folder to put in your YAMJ/lib/ folder.
That's it.

Alternatively, you can just run the in-program updater. It should put everything in the right spot.

### Note for Linux Users

There's currently a bug in Ubuntu's implementation of Java that will not allow you to double-click YAYMan.jar to run it.
To get around this, set the file "YAYMan.sh" to be executable and then use that to run YAYMan.
If you're running out of memory when processing your library, you may also want to use "YAYMan.sh."
