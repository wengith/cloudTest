@echo off
set USER=root
set PASSWORD=admin
set SERVER_IP=localhost
set PORT=3306
set SCHEMA=platform_devdb
set TEMP_FILE=tempsql.tmp
echo --------重建数据库%SCHEMA%@%SERVER_IP%将清空所有数据，如果不是本机数据库的话，会影响他人，确认要继续么，按Ctrl+C取消----------------
pause
echo --------重建数据库%SCHEMA%开始(可能需要几分钟，请耐心等待)----------------
echo drop database IF EXISTS %SCHEMA%;> %TEMP_FILE% 
echo create database %SCHEMA% DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;>> %TEMP_FILE%
echo use %SCHEMA%;>> %TEMP_FILE%
type dropSql.sql>> %TEMP_FILE%
type createSql.sql>> %TEMP_FILE%
type data\main.sql>> %TEMP_FILE%
mysql -h %SERVER_IP% -P %PORT% -u %USER% -p%PASSWORD% < %TEMP_FILE% 

del %TEMP_FILE%
echo --------重置数据库（结构+数据）完毕--------
:Finish_Work
pause