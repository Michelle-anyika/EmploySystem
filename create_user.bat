@echo off
echo Creating PostgreSQL user and database...
"C:\Program Files\PostgreSQL\17\bin\psql.exe" -U postgres -d postgres -c "CREATE USER anyika WITH PASSWORD 'anyika' CREATEDB SUPERUSER;"
"C:\Program Files\PostgreSQL\17\bin\psql.exe" -U postgres -d postgres -c "CREATE DATABASE hr_employee_management OWNER anyika;"
echo Done!
pause