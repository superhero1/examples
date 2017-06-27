call %cd%\build.bat
IF NOT ERRORLEVEL 1 GOTO no_error
REM errorhandling, errorlevel >= 1
:no_error
java -cp %cd%\target\lib\*;%cd%\target\* org.testng.TestNG -usedefaultlisteners false testng.xml