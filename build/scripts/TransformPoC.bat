@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  TransformPoC startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and TRANSFORM_PO_C_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\TransformPoC-1.0-SNAPSHOT.jar;%APP_HOME%\lib\http-builder-0.7.1.jar;%APP_HOME%\lib\jackson-core-2.2.2.jar;%APP_HOME%\lib\jackson-annotations-2.2.2.jar;%APP_HOME%\lib\jackson-databind-2.2.2.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.2.2.jar;%APP_HOME%\lib\jackson-datatype-joda-2.2.2.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.jar;%APP_HOME%\lib\cucumber-groovy-1.2.4.jar;%APP_HOME%\lib\cucumber-reporting-0.4.0.jar;%APP_HOME%\lib\totallylazy-1.20.jar;%APP_HOME%\lib\groovy-all-2.4.6.jar;%APP_HOME%\lib\httpclient-4.2.1.jar;%APP_HOME%\lib\json-lib-2.3-jdk15.jar;%APP_HOME%\lib\nekohtml-1.9.16.jar;%APP_HOME%\lib\xml-resolver-1.2.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.2.2.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.2.2.jar;%APP_HOME%\lib\cucumber-core-1.2.4.jar;%APP_HOME%\lib\cucumber-jvm-deps-1.0.5.jar;%APP_HOME%\lib\gherkin-2.12.2.jar;%APP_HOME%\lib\gson-2.3.1.jar;%APP_HOME%\lib\velocity-1.7.jar;%APP_HOME%\lib\velocity-tools-1.4.jar;%APP_HOME%\lib\commons-lang3-3.4.jar;%APP_HOME%\lib\commons-io-2.4.jar;%APP_HOME%\lib\maven-gpg-plugin-1.6.jar;%APP_HOME%\lib\jsoup-1.8.3.jar;%APP_HOME%\lib\httpcore-4.2.1.jar;%APP_HOME%\lib\commons-logging-1.1.1.jar;%APP_HOME%\lib\commons-codec-1.6.jar;%APP_HOME%\lib\commons-beanutils-1.8.0.jar;%APP_HOME%\lib\commons-collections-3.2.1.jar;%APP_HOME%\lib\commons-lang-2.4.jar;%APP_HOME%\lib\ezmorph-1.0.6.jar;%APP_HOME%\lib\xercesImpl-2.9.1.jar;%APP_HOME%\lib\cucumber-html-0.2.3.jar;%APP_HOME%\lib\maven-plugin-api-2.2.1.jar;%APP_HOME%\lib\maven-project-2.2.1.jar;%APP_HOME%\lib\maven-artifact-2.2.1.jar;%APP_HOME%\lib\maven-repository-metadata-2.2.1.jar;%APP_HOME%\lib\maven-model-2.2.1.jar;%APP_HOME%\lib\plexus-utils-3.0.20.jar;%APP_HOME%\lib\plexus-sec-dispatcher-1.4.jar;%APP_HOME%\lib\xml-apis-1.3.04.jar;%APP_HOME%\lib\maven-settings-2.2.1.jar;%APP_HOME%\lib\maven-profile-2.2.1.jar;%APP_HOME%\lib\maven-artifact-manager-2.2.1.jar;%APP_HOME%\lib\maven-plugin-registry-2.2.1.jar;%APP_HOME%\lib\plexus-interpolation-1.11.jar;%APP_HOME%\lib\plexus-container-default-1.0-alpha-9-stable-1.jar;%APP_HOME%\lib\plexus-cipher-1.4.jar;%APP_HOME%\lib\wagon-provider-api-1.0-beta-6.jar;%APP_HOME%\lib\backport-util-concurrent-3.1.jar;%APP_HOME%\lib\junit-3.8.1.jar;%APP_HOME%\lib\classworlds-1.1-alpha-2.jar;%APP_HOME%\lib\joda-time-2.8.2.jar

@rem Execute TransformPoC
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %TRANSFORM_PO_C_OPTS%  -classpath "%CLASSPATH%" com.transform.helper.ReportingClass %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable TRANSFORM_PO_C_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%TRANSFORM_PO_C_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
