# interactive-data-visualization


# Building from Source Code

## Step 0: Prerequisites
* Download and install sbt (version >= 0.13)
    * On a Mac OS:
        * Using either Homebrew or Macports third party libraries, 
            * Homebrew
                ```bash
                brew install sbt
                ```
            * or Macports
                ```
                port install sbt
                ```
             ** Note: Third-party packages may not provide the latest version. Please make sure to report any issues with these packages to the relevant maintainers.
    * On a Linux Debian-based Distro, such as Ubuntu **
        ```
        echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
        sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
        sudo apt-get update
        sudo apt-get install sbt
         ```
    * On a Linux Ret Hat-Enterprise distro and other RPM-based distributions
        ```
        curl https://bintray.com/sbt/rpm/rpm | sudo tee /etc/yum.repos.d/bintray-sbt-rpm.repo
        sudo yum install sbt
        ```
    * On Gentoo, using ebuilds
        ```
        emerge dev-java/sbt
        ```
* Download and install Node.js
    * On a Linux Debian-based Distro, such as Ubuntu
        ```
        # Installs Node.js 9
        curl -sL https://deb.nodesource.com/setup_9.x | sudo -E bash -
        sudo apt-get install -y nodejs
        
        # Optionally to compile and install native addons from npm you may also need to install build tools:
        sudo apt-get install -y build-essential
        ```
    * On a Mac OS:
        * Using either Homebrew or Macports third party libraries, 
            * Using NVM, then brew
                ```
                brew install nvm
                nvm install node 9
                ```
            * or Macports
                ```
                port install nodejs9
                ```
# Step 1: Setup

* ScalaJS
  1. Add ScalaJS to the SBT build and enable the plugin build    
        ```
        # Create a folder for the sbt project
        mkdir project
        
        # Add the Scala.js sbt plugin to the build
        echo 'addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.22")' >> project/plugins.sbt
        
        # Specify the sbt version 
        echo 'sbt.version = 1.1.1' >> project/build.properties
        
        ```
        
    2. Create a file named `build.sbt`(in the project root directory) and paste the following content:
        ```
        enablePlugins(ScalaJSPlugin)
        
        name := "Interactive Data Visualization" 
        scalaVersion := "2.12.4" // or any other Scala version >= 2.10.2
        
        // This is an application with a main method
        scalaJSUseMainModuleInitializer := true
        ```
* ScalaDOM
    1. Add library dependencies to the `build.sbt` file
        ```
        libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"
        ```
* jQuery
    1. Add library dependencies to the `build.sbt` file
        ```
        libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.1"
        ```