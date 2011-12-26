<?php
	include_once("database.php");
	
	$username = $_REQUEST['username'];
	$id_event = $_REQUEST['id_event'];
	$total = $_REQUEST['total'];
	$price = $_REQUEST['price'];
	$deposit = $_REQUEST['deposit'];

   	$string = "insert into buy (username, id_event, total, price) values ('$username','$id_event', '$total', '$price')";
   	mysql_query($string);
	$stringSet = "UPDATE user SET deposit = '$deposit' WHERE username = '$username'";
   	mysql_query($stringSet);

	mysql_close();

?>