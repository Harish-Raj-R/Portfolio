@echo off
title Harish Raj R - Full Stack Portfolio Launcher
echo ========================================================
echo   Launching Harish Raj R - Full Stack Portfolio
echo   Spring Boot 3 (Java 21) + Angular 19 (Node v22)
echo ========================================================
echo.

echo [1/2] Starting Spring Boot Backend on port 8080...
start "Portfolio Backend (Spring Boot)" cmd /k "cd /d %~dp0backend && mvn spring-boot:run"

timeout /t 3 /nobreak >nul

echo [2/2] Starting Angular Frontend on port 4200...
start "Portfolio Frontend (Angular)" cmd /k "cd /d %~dp0frontend && npm start"

echo.
echo ========================================================
echo   Services are booting up!
echo   • Frontend: http://localhost:4200
echo   • Backend:  http://localhost:8080/api/portfolio/overview
echo ========================================================
