@echo off
echo Changing postgres user password...
"C:\Program Files\PostgreSQL\17\bin\psql.exe" -U postgres -d postgres -c "ALTER USER postgres PASSWORD 'anyika';"
echo Postgres password changed to 'anyika'
pause