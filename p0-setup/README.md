# Setting up Git in Eclipse Java

For this course, we will be using git to host all the project files, rather than 
the CVS system you may have used for cmsc132. 
Ideally, this should be an easier way to check out projects and discussion exercises.  
To set up your Eclipse environmenet for this purpose, follow the steps in this guide.

## Video
  
There is now a video you can watch which will go through most of the processes here. 
It can be found:
![Video] (https://drive.google.com/file/d/13ONRg4x6onNo3cs34jdRb5UHOr6KnlJu/view?usp=sharing "video")

## Adding the Repository to Eclipse

The first thing we have to do is add the public repo to our Eclipse environment.  
First, open Eclipse, and go to Window > Show View > Other... > Git > Git Repositories, and click Open.  
A window called "Git Repositories" should show up somewhere in your IDE.

![Repo View](.doc/view.png)  
![Repo View](.doc/view2.png)  

Click "Clone a Git repository" (or click this button: ![Clone Button](.doc/clone_button.jpg)), 
and enter "https://github.com/anwarmamat/cmsc132summer21" as the URI.  
The Host and Repository path boxes should be automatically filled out for you, but if not, just fill them out as shown in the next image.  
Set the protocol to http, and leave everything else blank.
Click Next, you should see one thing checked (master).  
If master is not already checked then please check it, and click Next again.  
Fill out the Directory box according to where you want the projects to be downloaded to.  
By default this will be some folder called "git", so you'll probably want to change it to be in your usual workspace (if it's not already).  
Importantly, this folder must either be empty or not exist, so add one directory after your workspace.  
For example, if my workspace is at `C:/Users/cliff/workspace`, I could put `C:/Users/cliff/workspace/cmsc132`, which would create a folder called `cmsc132` in my workspace.  
This can be called whatever you want.  Then UNcheck "Import all existing Eclipse projects after clone finishes", and then click Finish.

![Git View](.doc/git_pane_empty.jpg)  
![Git View](.doc/git.png)  
![Git View](.doc/git2.png)  
![Git View](.doc/git3.png)  

You should see the repository added in the "Git Repositories" pane in Eclipse.  
Expand it and then expand the "Working Tree".  
This is where the projects will be listed (in the following image there are no projects yet, we'll get to downloading projects next).

![Repo Added](.doc/workingTree.png)  

## Downloading New Projects

When a Project is released, you'll have to import it.  First, update the repository by right-clicking it and selecting "Pull".

![Pull](.doc/pull.png)

You'll get a popup like this one, which you can safely close:

![Pull Window](.doc/gitpull.png)  

Then, you will see the new project loaded into the Working Tree:

![New Project](.doc/workingTree2.png)  

## Importing New Projects

Right click the project (P0.Setup in this example) and click "Import Projects...".  
Simply click Finish in the popup window and the project will be imported into your Package Explorer.  

![Import View](.doc/import.png)  
![Import View](.doc/import2.png)  

You should now be able to work on the project  

![Project View](.doc/done.png)

## Submitting Projects

YOu can zip the file using eclipse and upload this zip file. To eport as a zip 
file, you can select the project, click file->export. A popup window should appear
asking how you want to export the project. Click general->archieve file. Then you
should check the project folder as seen in the below images. Then take note of where
you exported it. Then you can hit finish. Make sure all the settings look like the one
in the photo below. 

Then when you are ready to submit a project, go to gradescope and click the 132 class.
Then click on the relevant assignment and submit the files which you modified.
Make sure the names of all the files needed are shown. 
Then, after you submit, the autograder will run. If everything compiled correctly, 
then you should get a score back from gradescope.

![Export](.doc/eclipse1.png)  
![Export](.doc/eclipse2.png)  
![Export](.doc/eclipse3.png)  
![Gradescope](.doc/gradescope.png)  
![Gradescope](.doc/gradescope2.png)  
![Gradescope](.doc/gradescope3.png)  
![Gradescope](.doc/gradescope4.png)  
![Gradescope](.doc/gradescope5.png)  
