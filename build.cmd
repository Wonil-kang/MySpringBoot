@echo off
echo ====================================
echo Building MySpringBoot Application...
echo ====================================
echo.

call mvnw.cmd clean package -DskipTests

if %errorlevel% == 0 (
    echo.
    echo ====================================
    echo Build Success!
    echo JAR file: target\MySpringBoot-0.0.2-SNAPSHOT.jar
    echo ====================================
) else (
    echo.
    echo ====================================
    echo Build Failed!
    echo ====================================
)

pause
