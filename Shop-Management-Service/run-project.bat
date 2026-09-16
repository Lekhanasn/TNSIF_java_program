@echo off
setlocal
cd /d "%~dp0"
if not exist pom.xml (
  echo ERROR: Open this file from the Shop_Management_Service project folder.
  pause
  exit /b 1
)
where mvn >nul 2>&1
if errorlevel 1 (
  echo Maven was not found on PATH.
  echo Install Maven or run the main class in VS Code using the Java extension.
  pause
  exit /b 1
)
call mvn spring-boot:run
pause
