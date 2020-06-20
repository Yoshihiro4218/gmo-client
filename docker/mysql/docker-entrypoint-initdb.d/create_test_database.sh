#!/bin/sh

echo "CREATE DATABASE IF NOT EXISTS \`gmo_localtest\` ;" | "${mysql[@]}"
echo "GRANT ALL ON \`gmo_localtest\`.* TO '"$MYSQL_USER"'@'%' ;" | "${mysql[@]}"
echo 'FLUSH PRIVILEGES ;' | "${mysql[@]}"