HOW TO GET THE PROJECT:

1. Follow in Git @lopezruizjavier
2. Fork & star demo-gwt-spring
3. Clone forked project

HOW TO UPDATE MY REPO FROM THE ORIGINAL REPO

1. git remote add upstream https://github.com/lopezruizjavier/demo-gwt-spring.git
2. git pull upstream master

CARE IF YOU HAVE ALREADY MADE CHANGES TO YOUR LOCAL REPO!!

HOW TO COMPILE:

mvn eclipse:eclipse

mvn clean install

HOW TO IMPORT THE PROJECT:

1. Import existing Maven Project
2. Maven > Disable Maven Nature
3. New Run Configuration (Goal: gwt:run)

SMARTGWT LGPL: goo.gl/o9TqS8

Install SmartGWT libraries into local repository:

mvn install:install-file -Dfile=C:\Users\Javier\smartgwt.jar -DgroupId=com.smartgwt 
    -DartifactId=smartgwt -Dversion=5.0 -Dpackaging=jar -DlocalRepositoryPath=C:\Users\Javier\.m2\repository
    
mvn install:install-file -Dfile=C:\Users\Javier\smartgwt-skins.jar -DgroupId=com.smartgwt 
    -DartifactId=smartgwt-skins -Dversion=5.0 -Dpackaging=jar -DlocalRepositoryPath=C:\Users\Javier\.m2\repository
