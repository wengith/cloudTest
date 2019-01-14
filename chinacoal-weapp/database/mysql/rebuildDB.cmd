@echo off
set USER=root
set PASSWORD=admin
set SERVER_IP=localhost
set PORT=3306
set SCHEMA=platform_devdb
set TEMP_FILE=tempsql.tmp
echo --------�ؽ����ݿ�%SCHEMA%@%SERVER_IP%������������ݣ�������Ǳ������ݿ�Ļ�����Ӱ�����ˣ�ȷ��Ҫ����ô����Ctrl+Cȡ��----------------
pause
echo --------�ؽ����ݿ�%SCHEMA%��ʼ(������Ҫ�����ӣ������ĵȴ�)----------------
echo drop database IF EXISTS %SCHEMA%;> %TEMP_FILE% 
echo create database %SCHEMA% DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;>> %TEMP_FILE%
echo use %SCHEMA%;>> %TEMP_FILE%
type dropSql.sql>> %TEMP_FILE%
type createSql.sql>> %TEMP_FILE%
type data\main.sql>> %TEMP_FILE%
mysql -h %SERVER_IP% -P %PORT% -u %USER% -p%PASSWORD% < %TEMP_FILE% 

del %TEMP_FILE%
echo --------�������ݿ⣨�ṹ+���ݣ����--------
:Finish_Work
pause