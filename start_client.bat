@echo off
set /p port=Enter port:%=%
@echo %port%
cd C:\Users\Administrator\Eclipse_JEE\MultiThreadChatClient\bin
start cmd /k java MultiThreadChatClient %port%
