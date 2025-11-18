@echo off
echo Recreating PostgreSQL user...
"C:\Program Files\PostgreSQL\17\bin\psql.exe" -U postgres -d postgres -c "DROP USER IF EXISTS anyika;"
"C:\Program Files\PostgreSQL\17\bin\psql.exe" -U postgres -d postgres -c "CREATE USER anyika WITH PASSWORD 'anyika' LOGIN CREATEDB SUPERUSER;"
"C:\Program Files\PostgreSQL\17\bin\psql.exe" -U postgres -d postgres -c "CREATE DATABASE hr_employee_management OWNER anyika;"
echo User and database created successfully!
pause