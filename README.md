## Expense Tracker

Download PHP from https://windows.php.net/download#php-8.2

Download Sqlite3 from https://www.sqlite.org/download.html

Set global path for all of this.

### Execute following commands in Expense-Tracker folder
```
sqite3 datbase.sqlite
CREATE TABLE history (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, note TEXT NOT NULL, cost INTEGER NOT NULL);
```

### Run this command in terminal to start PHP server in Expense-Tracker folder
```
php -S localhost:8080
```
### Open this link in Chrome
```
localhost:8080/index.php
```
![Screenshot 2024-01-10 223325](https://github.com/deep-govindvira/Expense-Tracker/assets/126332769/75ba7c70-f0ab-4e6d-9b86-2d8262d488ba)
