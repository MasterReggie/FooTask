CREATE DATABASE IF NOT EXISTS Source1;
use Source1;
CREATE TABLE IF NOT EXISTS Foo (id INT AUTO_INCREMENT, val INT, PRIMARY KEY(id));

CREATE DATABASE IF NOT EXISTS Source2;
use Source2;
CREATE TABLE IF NOT EXISTS Foo (id INT AUTO_INCREMENT, val INT, PRIMARY KEY(id));

CREATE DATABASE IF NOT EXISTS Source3;
use Source3;
CREATE TABLE IF NOT EXISTS Foo (id INT AUTO_INCREMENT, val INT, PRIMARY KEY(id));

CREATE DATABASE IF NOT EXISTS Source4;
use Source4;
CREATE TABLE IF NOT EXISTS Foo (id INT AUTO_INCREMENT, val INT, PRIMARY KEY(id));

CREATE DATABASE IF NOT EXISTS Source5;
use Source5;
CREATE TABLE IF NOT EXISTS Foo (id INT AUTO_INCREMENT, val INT, PRIMARY KEY(id));



CREATE DATABASE IF NOT EXISTS Target;
use Target;
CREATE TABLE IF NOT EXISTS Stat (id INT AUTO_INCREMENT, source VARCHAR(10), sum INT, PRIMARY KEY(id));