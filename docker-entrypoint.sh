#!/bin/bash
set -e

# Start the MySQL service
mysqld --user=mysql --datadir=/var/lib/mysql --socket=/var/run/mysqld/mysqld.sock --skip-networking &
mysql_pid=$!

# Wait for MySQL to become available
until mysqladmin ping -h127.0.0.1 -P3306 --silent; do
  echo "Waiting for MySQL to become available..."
  sleep 1
done

# Create the databases
mysql -h127.0.0.1 -P3306 -uroot -piDRBT@007 -e "CREATE DATABASE IF NOT EXISTS users_info;"
mysql -h127.0.0.1 -P3306 -uroot -piDRBT@007 -e "CREATE DATABASE IF NOT EXISTS accounts_info;"

# Stop the MySQL service
mysqladmin -h127.0.0.1 -P3306 -uroot -piDRBT@007 shutdown

# Wait for MySQL to stop
while kill -0 "$mysql_pid" 2>/dev/null; do
  sleep 1
done

exec "$@"
