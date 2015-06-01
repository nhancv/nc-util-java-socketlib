@echo off
set /p port=Enter port:%=%
@echo %port%
cd C:\Users\Administrator\Eclipse_JEE\MultiThreadChatServerSync\bin
start cmd /k java MultiThreadChatServerSync %port%
