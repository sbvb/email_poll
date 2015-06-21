////////////////////////////////////////////////////
// as mysql root, create user email_poll
////////////////////////////////////////////////////

mysql -u root -p (root_pwd)
// DROP USER 'user_email_poll'@'localhost';
CREATE DATABASE db_email_poll;
// drop DATABASE db_email_poll;
CREATE USER 'user_email_poll'@'localhost' IDENTIFIED BY 'emailpwd';
GRANT ALL ON db_email_poll.* TO 'user_email_poll'@'localhost';
flush privileges;


////////////////////////////////////////////////////
// (re)start database
////////////////////////////////////////////////////

sudo /etc/init.d/mysql restart

////////////////////////////////////////////////////
// login to mysql as user_email_poll
////////////////////////////////////////////////////

mysql -u user_email_poll -p (emailpwd)
connect db_email_poll;
show tables;
drop database db_email_poll;
source /home/sbvb/Dropbox/projects/email_poll/email_poll_git/data_model/mysql_creation.sql;

////////////////////////////////////////////////////
// add some data to database
////////////////////////////////////////////////////




