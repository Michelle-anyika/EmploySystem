# PowerShell script to setup PostgreSQL user
# Run this as Administrator

Write-Host "Restarting PostgreSQL service..."
Stop-Service -Name "postgresql-x64-17" -Force
Start-Service -Name "postgresql-x64-17"

Write-Host "Waiting for PostgreSQL to start..."
Start-Sleep -Seconds 5

Write-Host "Creating user and database..."
& "C:\Program Files\PostgreSQL\17\bin\psql.exe" -U postgres -d postgres -c "CREATE USER anyika WITH PASSWORD 'anyika' CREATEDB SUPERUSER;"
& "C:\Program Files\PostgreSQL\17\bin\psql.exe" -U postgres -d postgres -c "CREATE DATABASE hr_employee_management OWNER anyika;"

Write-Host "User 'anyika' and database 'hr_employee_management' created successfully!"
Write-Host "Press any key to continue..."
Read-Host